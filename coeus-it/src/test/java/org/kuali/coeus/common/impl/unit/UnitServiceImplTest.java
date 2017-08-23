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
package org.kuali.coeus.common.impl.unit;

import org.junit.Test;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
public class UnitServiceImplTest extends KcIntegrationTestBase {

    private static final String UNIVERSITY_UNIT_NUMBER = "000001";
    private static final String CARDIOLOGY_UNIT_NUMBER = "IN-CARD";
    private static final String BLOOMINGTON_UNIT_NUMBER_PROPER_CASE = "BL-BL";
    private static final String BLOOMINGTON_UNIT_NUMBER_CASE_CHANGED = "bL-Bl";

    @Test
    public void testGetUnitName() {
        String retrievedName = KcServiceLocator.getService(UnitService.class).getUnitName(UNIVERSITY_UNIT_NUMBER);
        assertEquals("University", retrievedName);
    }

    @Test
    public void testGetUnitCaseInsensitive() {
        Unit unit1 = KcServiceLocator.getService(UnitService.class).getUnitCaseInsensitive(BLOOMINGTON_UNIT_NUMBER_CASE_CHANGED);
        Unit unit2 = KcServiceLocator.getService(UnitService.class).getUnitCaseInsensitive(BLOOMINGTON_UNIT_NUMBER_PROPER_CASE);
        assertNotNull(unit1);
        assertNotNull(unit2);
        assertEquals(unit1, unit2);
    }

    @Test
    public void testGetUnit() {
        Unit unit = KcServiceLocator.getService(UnitService.class).getUnit(CARDIOLOGY_UNIT_NUMBER);
        assertEquals("CARDIOLOGY", unit.getUnitName());
    }

    @Test
    public void testGetAllSubUnitsCardiology() {
        List<Unit> units = KcServiceLocator.getService(UnitService.class).getAllSubUnits(CARDIOLOGY_UNIT_NUMBER);
        assertEquals(1, units.size());
    }

    @Test
    public void testGetAllSubUnitsTop() {
        List<Unit> units = KcServiceLocator.getService(UnitService.class).getAllSubUnits("000001");
        assertEquals(12, units.size());
    }

    @Test
    public void testGetTopUnit() {
        Unit unit = KcServiceLocator.getService(UnitService.class).getTopUnit();
        assertEquals(UNIVERSITY_UNIT_NUMBER, unit.getUnitNumber());
    }

    @Test
    public void testRetrieveUnitAdministratorsByUnitNumber() {
        List<UnitAdministrator> admins = KcServiceLocator.getService(UnitService.class).retrieveUnitAdministratorsByUnitNumber(UNIVERSITY_UNIT_NUMBER);
        for (UnitAdministrator admin : admins) {
            if ("10000000001".equals(admin.getPersonId())) {
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }

    @Test
    public void testGetMaxUnitTreeDepth() {
        int retVal = KcServiceLocator.getService(UnitService.class).getMaxUnitTreeDepth();
        assertTrue(retVal>1);
    }
    
    @Test
    public void testGetUnitHierarchyForUnit() {
        List<Unit> units = KcServiceLocator.getService(UnitService.class).getUnitHierarchyForUnit("IN-PERS");
        assertEquals(6, units.size());
    }
    
    @Test
    public void testGetUnitHierarchyForUnit2() {
        List<Unit> units = KcServiceLocator.getService(UnitService.class).getUnitHierarchyForUnit("000001");
        assertEquals(1, units.size());
    }
    
    @Test
    public void testGetUnitHierarchyForUnit3() {
        List<Unit> units = KcServiceLocator.getService(UnitService.class).getUnitHierarchyForUnit("xyz");
        assertEquals(0, units.size());
    }

}
