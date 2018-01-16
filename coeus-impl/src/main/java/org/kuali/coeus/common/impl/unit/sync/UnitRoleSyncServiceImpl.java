/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit.sync;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.common.framework.person.attr.PersonAppointment;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.sync.*;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.membership.MemberType;
import org.kuali.rice.kim.api.common.delegate.DelegateMember;
import org.kuali.rice.kim.api.common.delegate.DelegateType;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.kim.api.permission.Permission;
import org.kuali.rice.kim.api.responsibility.Responsibility;
import org.kuali.rice.kim.api.role.Role;
import org.kuali.rice.kim.api.role.RoleMember;
import org.kuali.rice.kim.api.role.RoleMembership;
import org.kuali.rice.kim.api.role.RoleResponsibility;
import org.kuali.rice.kim.impl.identity.employment.EntityEmploymentBo;
import org.kuali.rice.kim.impl.role.RoleBo;
import org.kuali.rice.kim.impl.role.RoleMemberAttributeDataBo;
import org.kuali.rice.kim.impl.role.RoleMemberBo;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.*;
import static org.kuali.rice.core.api.criteria.PredicateFactory.*;

@Component("unitRoleSyncService")
public class UnitRoleSyncServiceImpl implements UnitRoleSyncService {

    private static final String ACTIVE = "active";
    private static final String PRIMARY = "primary";
    private static final String PRIMARY_DEPARTMENT_CODE = "primaryDepartmentCode";
    private static final String ID = "id";
    private static final Collection<String> KIM_CACHE_NAMES =
            Stream.of(Role.Cache.NAME, Permission.Cache.NAME, Responsibility.Cache.NAME, RoleMembership.Cache.NAME, RoleMember.Cache.NAME, DelegateMember.Cache.NAME, RoleResponsibility.Cache.NAME, DelegateType.Cache.NAME)
                    .collect(Collectors.toList());

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("globalCacheManager")
    private CacheManager globalCacheManager;

    @Autowired
    @Qualifier("identityService")
    private IdentityService identityService;

    @Autowired
    @Qualifier("unitService")
    private UnitService unitService;

    @Override
    public void syncPersonUnitInfoToRoles() {
        syncPersonUnitInfoToRoles(getBusinessObjectService().findMatching(UnitRoleSync.class, Collections.singletonMap(ACTIVE, true)));
    }

    void syncPersonUnitInfoToRoles(Collection<UnitRoleSync> unitRoleSyncs) {
        final Set<String> activeUnits = unitService.getUnits()
                .stream()
                .filter(Unit::isActive)
                .map(Unit::getUnitNumber)
                .collect(Collectors.toSet());

        unitRoleSyncs
                .stream()
                .filter(UnitRoleSync::isActive)
                .forEach(unitRoleSync -> {
                    final Map<String, Set<String>> personUnits = unitRoleSync.getSourceUnitInfos()
                            .stream()
                            .map(sourceUnit -> SourceUnit.fromCode(sourceUnit.getSourceUnitCode()))
                            .map(sourceUnit -> {
                                if (SourceUnit.PERSON_APPOINTMENTS.equals(sourceUnit)) {
                                    return findPersonAppointmentUnits(activeUnits);
                                } else if (SourceUnit.PERSON_PRIMARY_DEPARTMENTS.equals(sourceUnit)) {
                                    return findPersonEmploymentUnits(activeUnits, true);
                                } else if (SourceUnit.PERSON_SECONDARY_DEPARTMENTS.equals(sourceUnit)) {
                                    return findPersonEmploymentUnits(activeUnits, false);
                                } else {
                                    throw new RuntimeException(sourceUnit + " not supported");
                                }
                            })
                            .flatMap(map -> map.entrySet().stream())
                            .collect(entriesToMapWithMergedSet());

                    createMemberships(personUnits, unitRoleSync.getTargetRoleInfos(), SyncBehavior.fromCode(unitRoleSync.getSyncBehaviorCode()));
                    clearKimCache();
                });
    }

    private Map<String, Set<String>> findPersonAppointmentUnits(Set<String> activeUnits) {
        return getBusinessObjectService().findAll(PersonAppointment.class)
                .stream()
                .filter(appt -> StringUtils.isNotBlank(appt.getUnitNumber()))
                .filter(appt -> activeUnits.contains(appt.getUnitNumber()))
                .collect(Collectors.groupingBy(PersonAppointment::getPersonId, Collectors.mapping(PersonAppointment::getUnitNumber, Collectors.toSet())));
    }


    private Map<String, Set<String>> findPersonEmploymentUnits(Set<String> activeUnits, boolean primary) {
        return getDataObjectService().findMatching(EntityEmploymentBo.class, QueryByCriteria.Builder.fromPredicates(
                equal(ACTIVE, true),
                equal(PRIMARY, primary),
                isNotNull(PRIMARY_DEPARTMENT_CODE))).getResults()
                .stream()
                .filter(emp -> StringUtils.isNotBlank(emp.getPrimaryDepartmentCode()))
                .filter(emp -> activeUnits.contains(emp.getPrimaryDepartmentCode()))
                .flatMap(emp -> {
                    final List<Principal> principals = identityService.getPrincipalsByEntityId(emp.getEntityId());
                    return (principals != null ? principals.stream() : Stream.<Principal>empty())
                        .filter(Principal::isActive)
                        .map(Principal::getPrincipalId)
                            .map(principalId -> entry(principalId, emp.getPrimaryDepartmentCode()));
                })
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));
    }

    private void createMemberships(Map<String, Set<String>> personUnits, List<TargetRoleInfo> targetRoleInfos, SyncBehavior syncBehavior) {
        targetRoleInfos.forEach(targetRole -> {
            final RoleBo role = dataObjectService.findUnique(RoleBo.class, QueryByCriteria.Builder.fromPredicates(
                    equal(ID, targetRole.getRoleId()),
                    equal(ACTIVE, true)));

            if (role != null) {
                if (SyncBehavior.DELETE_ALL_ADD.equals(syncBehavior)) {
                    findMatchingPrincipalRoleMembers(role.getMembers()).forEach(dataObjectService::delete);
                    personUnits.forEach((personId, unitNumbers) -> unitNumbers.forEach(unitNumber -> {
                        dataObjectService.save(createRoleMember(role.getId(), role.getKimTypeId(), personId, unitNumber, targetRole.isDescends()));
                    }));
                } else if (SyncBehavior.IGNORE_EXISTING.equals(syncBehavior)) {
                    personUnits.forEach((personId, unitNumbers) -> unitNumbers.forEach(unitNumber -> {
                        if (findMatchingPrincipalRoleMembers(role.getMembers(), unitNumber, personId).isEmpty()) {
                            dataObjectService.save(createRoleMember(role.getId(), role.getKimTypeId(), personId, unitNumber, targetRole.isDescends()));
                        }
                    }));
                } else if (SyncBehavior.DELETE_READD.equals(syncBehavior)) {
                    personUnits.forEach((personId, unitNumbers) -> unitNumbers.forEach(unitNumber -> {
                        findMatchingPrincipalRoleMembers(role.getMembers(), unitNumber, personId).forEach(dataObjectService::delete);
                        dataObjectService.save(createRoleMember(role.getId(), role.getKimTypeId(), personId, unitNumber, targetRole.isDescends()));
                    }));
                } else {
                    throw new RuntimeException(syncBehavior + " not supported");
                }
            }
        });
    }

    private List<RoleMemberBo> findMatchingPrincipalRoleMembers(List<RoleMemberBo> roleMembers, String unitNumber, String personId) {
        return roleMembers
                .stream()
                .filter(member -> MemberType.PRINCIPAL.equals(member.getType()))
                .filter(member -> member.getMemberId().equals(personId))
                .filter(member -> StringUtils.equals(member.getAttributes().get(KcKimAttributes.UNIT_NUMBER), unitNumber))
                .collect(Collectors.toList());
    }

    private List<RoleMemberBo> findMatchingPrincipalRoleMembers(List<RoleMemberBo> roleMembers) {
        return roleMembers
                .stream()
                .filter(member -> MemberType.PRINCIPAL.equals(member.getType()))
                .collect(Collectors.toList());
    }

    private RoleMemberBo createRoleMember(String roleId, String kimTypeId, String principalId, String unitNumber, boolean descends) {
        final RoleMemberBo roleMember = new RoleMemberBo();

        roleMember.setRoleId(roleId);
        roleMember.setMemberId(principalId);
        roleMember.setType(MemberType.PRINCIPAL);

        roleMember.setAttributeDetails(isUnitHierarchyType(kimTypeId) ? createUnitHierarchyQual(unitNumber, descends) : createUnitQual(unitNumber));

        return roleMember;
    }

    private boolean isUnitHierarchyType(String kimTypeId) {
        return UnitRoleConstants.UNIT_HIERARCHY_TYPE.equals(kimTypeId);
    }

    private List<RoleMemberAttributeDataBo> createUnitQual(String unitNumber) {
        final RoleMemberAttributeDataBo unitQualifier = new RoleMemberAttributeDataBo();
        unitQualifier.setKimTypeId(UnitRoleConstants.UNIT_TYPE);
        unitQualifier.setKimAttributeId(UnitRoleConstants.UNIT_ATTR_DEFINITION);
        unitQualifier.setAttributeValue(unitNumber);
        return Stream.of(unitQualifier).collect(Collectors.toList());
    }

    private List<RoleMemberAttributeDataBo> createUnitHierarchyQual(String unitNumber, boolean subunits) {
        final RoleMemberAttributeDataBo unitQualifier = new RoleMemberAttributeDataBo();
        unitQualifier.setKimTypeId(UnitRoleConstants.UNIT_HIERARCHY_TYPE);
        unitQualifier.setKimAttributeId(UnitRoleConstants.UNIT_ATTR_DEFINITION);
        unitQualifier.setAttributeValue(unitNumber);

        final RoleMemberAttributeDataBo subunitsQualifier = new RoleMemberAttributeDataBo();
        subunitsQualifier.setKimTypeId(UnitRoleConstants.UNIT_HIERARCHY_TYPE);
        subunitsQualifier.setKimAttributeId(UnitRoleConstants.SUBUNIT_ATTR_DEFINITION);
        subunitsQualifier.setAttributeValue(subunits ? Constants.YES_FLAG : Constants.NO_FLAG);

        return Stream.of(unitQualifier, subunitsQualifier).collect(Collectors.toList());
    }

    private void clearKimCache() {
        KIM_CACHE_NAMES.stream()
                .map(name -> getGlobalCacheManager().getCache(name))
                .filter(Objects::nonNull)
                .forEach(Cache::clear);
    }

    private Collector<Map.Entry<String, Set<String>>, ?, Map<String, Set<String>>> entriesToMapWithMergedSet() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (v1, v2) -> Stream.concat(v1.stream(), v2.stream())
                        .collect(Collectors.toSet()), HashMap::new);
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }

    public CacheManager getGlobalCacheManager() {
        return globalCacheManager;
    }

    public void setGlobalCacheManager(CacheManager globalCacheManager) {
        this.globalCacheManager = globalCacheManager;
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    public UnitService getUnitService() {
        return unitService;
    }

    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
}
