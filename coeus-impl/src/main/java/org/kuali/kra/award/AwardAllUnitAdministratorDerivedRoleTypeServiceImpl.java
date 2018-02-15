/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministrator;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministratorDerivedRoleTypeService;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.contacts.AwardPersonUnit;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardService;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.framework.role.RoleTypeService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kuali.coeus.common.impl.unit.UnitHierarchyRoleTypeServiceImpl.*;

public class AwardAllUnitAdministratorDerivedRoleTypeServiceImpl extends AbstractUnitAdministratorDerivedRoleTypeService
        implements RoleTypeService {

    private UnitService unitService;
    private AwardService awardService;

    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
    
    protected UnitService getUnitService() {
        return unitService;
    }
    
    @Override
    public List<? extends AbstractUnitAdministrator> getUnitAdministrators(Map<String, String> qualifiers) {
        String awardIdStr = qualifiers.get(KcKimAttributes.AWARD);
        boolean ascendsHierarchy = shouldAscendHierarchy(qualifiers);
        List<UnitAdministrator> result = new ArrayList<UnitAdministrator>();
        if (StringUtils.isNotBlank(awardIdStr) && awardIdStr.matches("\\d+")) {
            Long awardId = Long.valueOf(awardIdStr);
            Award award = getAwardService().getAward(awardId);
            HashSet<String> units = new HashSet<String>();
            for (AwardPerson person : award.getProjectPersons()) {
                units.addAll(getUnitsForPerson(person, ascendsHierarchy));
            }
        
            for (String unit : units) {
                if (StringUtils.isNotBlank(unit)) {
                    result.addAll(unitService.retrieveUnitAdministratorsByUnitNumber(unit));
                }
            }
        }   
        return result;
    }

    protected Set<String> getUnitsForPerson(AwardPerson person, boolean ascendsHierarchy) {
        return person.getUnits().stream()
                .map(AwardPersonUnit::getUnitNumber).distinct()
                .flatMap(unitNumber -> {
                    if (ascendsHierarchy) {
                        return unitService.getUnitHierarchyForUnit(unitNumber).stream().map(Unit::getUnitNumber);
                    } else {
                        return Stream.of(unitNumber);
                    }
                })
                .collect(Collectors.toSet());
    }

    protected boolean shouldAscendHierarchy(Map<String, String> qualifiers) {
        String subunitsString = qualifiers.getOrDefault(KcKimAttributes.SUBUNITS, DESCENDS_HIERARCHY_N);
        if (DESCENDS_HIERARCHY_Y.equals(subunitsString) || DESCENDS_HIERARCHY_YES.equals(subunitsString)) {
            return true;
        }
        return false;
    }

    protected AwardService getAwardService() {
        return awardService;
    }

    public void setAwardService(AwardService awardService) {
        this.awardService = awardService;
    }


}
