/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.impl.unit.sync;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.common.framework.person.attr.PersonAppointment;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.sync.*;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.membership.MemberType;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.kim.api.role.RoleService;
import org.kuali.rice.kim.impl.identity.employment.EntityEmploymentBo;
import org.kuali.rice.kim.impl.role.RoleBo;
import org.kuali.rice.kim.impl.role.RoleMemberBo;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kuali.coeus.sys.framework.util.CollectionUtils.*;
import static org.kuali.rice.core.api.criteria.PredicateFactory.*;

@Component("unitRoleSyncService")
public class UnitRoleSyncServiceImpl implements UnitRoleSyncService {

    private static final String Y = "Y";
    private static final String N = "N";
    private static final String ACTIVE = "active";
    private static final String PRIMARY = "primary";
    private static final String PRIMARY_DEPARTMENT_CODE = "primaryDepartmentCode";
    private static final String ID = "id";

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

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
                });
    }

    private Map<String, Set<String>> findPersonAppointmentUnits(Set<String> activeUnits) {
        return getBusinessObjectService().findAll(PersonAppointment.class)
                .stream()
                .filter(appt -> StringUtils.isNotBlank(appt.getUnitNumber()))
                .filter(appt -> activeUnits.contains(appt.getUnitNumber()))
                .map(appt -> entry(appt.getPersonId(), appt.getUnitNumber()))
                .collect(entriesToMapWithSet());
    }


    private Map<String, Set<String>> findPersonEmploymentUnits(Set<String> activeUnits, boolean primary) {
        return getDataObjectService().findMatching(EntityEmploymentBo.class, QueryByCriteria.Builder.fromPredicates(
                equal(ACTIVE, true),
                equal(PRIMARY, primary),
                isNotNull(PRIMARY_DEPARTMENT_CODE))).getResults()
                .stream()
                .filter(emp -> StringUtils.isNotBlank(emp.getPrimaryDepartmentCode()))
                .filter(emp -> activeUnits.contains(emp.getPrimaryDepartmentCode()))
                .flatMap(emp -> identityService.getPrincipalsByEmployeeId(emp.getEntityId())
                        .stream()
                        .filter(Principal::isActive)
                        .map(Principal::getPrincipalId)
                        .map(principalId -> entry(principalId, emp.getPrimaryDepartmentCode())))
                .collect(entriesToMapWithSet());
    }

    private void createMemberships(Map<String, Set<String>> personUnits, List<TargetRoleInfo> targetRoleInfos, SyncBehavior syncBehavior) {
        targetRoleInfos.forEach(targetRole -> {
            final RoleBo role = dataObjectService.findUnique(RoleBo.class, QueryByCriteria.Builder.fromPredicates(
                    equal(ID, targetRole.getRoleId()),
                    equal(ACTIVE, true)));

            if (role != null) {
                if (SyncBehavior.DELETE_ALL_ADD.equals(syncBehavior)) {
                    final List<RoleMemberBo> roleMembers = findMatchingPrincipalRoleMembers(role.getMembers());
                    roleMembers.forEach(roleMember -> roleService.removePrincipalFromRole(roleMember.getMemberId(), role.getNamespaceCode(), role.getName(), roleMember.getAttributes()));
                    personUnits.forEach((personId, unitNumbers) -> unitNumbers.forEach(unitNumber -> {
                        final Map<String, String> qualifications = isUnitHierarchyType(role.getKimTypeId()) ?
                                createUnitHierarchyQual(unitNumber, targetRole.isDescends()) : createUnitQual(unitNumber);
                        roleService.assignPrincipalToRole(personId, role.getNamespaceCode(), role.getName(), qualifications);
                    }));
                } else if (SyncBehavior.IGNORE_EXISTING.equals(syncBehavior)) {
                    personUnits.forEach((personId, unitNumbers) -> unitNumbers.forEach(unitNumber -> {
                        final List<RoleMemberBo> roleMembers = findMatchingPrincipalRoleMembers(role.getMembers(), unitNumber, personId);
                        if (roleMembers.isEmpty()) {
                            final Map<String, String> qualifications = isUnitHierarchyType(role.getKimTypeId()) ?
                                    createUnitHierarchyQual(unitNumber, targetRole.isDescends()) : createUnitQual(unitNumber);
                            roleService.assignPrincipalToRole(personId, role.getNamespaceCode(), role.getName(), qualifications);
                        }
                    }));
                } else if (SyncBehavior.DELETE_READD.equals(syncBehavior)) {
                    personUnits.forEach((personId, unitNumbers) -> unitNumbers.forEach(unitNumber -> {
                        final List<RoleMemberBo> roleMembers = findMatchingPrincipalRoleMembers(role.getMembers(), unitNumber, personId);
                        roleMembers.forEach(roleMember -> roleService.removePrincipalFromRole(personId, role.getNamespaceCode(), role.getName(), roleMember.getAttributes()));
                        final Map<String, String> qualifications = isUnitHierarchyType(role.getKimTypeId()) ?
                                createUnitHierarchyQual(unitNumber, targetRole.isDescends()) : createUnitQual(unitNumber);
                        roleService.assignPrincipalToRole(personId, role.getNamespaceCode(), role.getName(), qualifications);
                    }));
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

    private boolean isUnitHierarchyType(String kimTypeId) {
        return UnitRoleConstants.UNIT_HIERARCHY_TYPE.equals(kimTypeId);
    }

    private Map<String, String> createUnitQual(String unitNumber) {
        final Map<String, String> qualifications = new HashMap<>();
        qualifications.put(KcKimAttributes.UNIT_NUMBER, unitNumber);
        return qualifications;
    }

    private Map<String, String> createUnitHierarchyQual(String unitNumber, boolean subunits) {
        final Map<String, String> qualifications = new HashMap<>();
        qualifications.put(KcKimAttributes.UNIT_NUMBER, unitNumber);
        qualifications.put(KcKimAttributes.SUBUNITS, subunits ? Y : N);
        return qualifications;
    }

    public static <K, U> Collector<Map.Entry<K, U>, ?, Map<K, Set<U>>> entriesToMapWithSet() {
        return Collectors.toMap(Map.Entry::getKey, entry -> Stream.of(entry.getValue()).collect(Collectors.toSet()),
                (v1, v2) -> Stream.concat(v1.stream(), v2.stream()).collect(Collectors.toSet()), HashMap::new);
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

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
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
