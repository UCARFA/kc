/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.award;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.coeus.common.impl.unit.UnitHierarchyRoleTypeServiceImpl;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.contacts.AwardPersonUnit;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardService;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.api.role.RoleMembership;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class AwardAllUnitAdministratorDerivedRoleTypeServiceImplTest {

    private static final String UNIT_ADMIN_DEAN = "1";
    private static final String UNIT_ADMIN_DEPT_HEAD = "2";

    private static final String BOTTOM_DEAN = "BOTTOM-DEAN";
    private static final String LOW_DEAN = "LOW-DEAN";
    private static final String LOW_DEPT_HEAD = "LOW-DEPT-HEAD";
    private static final String MID_DEAN = "MID-DEAN";
    private static final String TOP_DEAN = "TOP-DEAN";
    private static final String TOP_DEPT_HEAD = "TOP-DEPT-HEAD";

    private static final String BOTTOM_UNIT_NUMBER = "BOTTOM-UNIT";
    private static final String LOW_UNIT_NUMBER = "LOW-UNIT";
    private static final String MID_UNIT_NUMBER = "MID-UNIT";
    private static final String TOP_UNIT_NUMBER = "TOP-UNIT";

    private static final String TEST_NAMESPACE = "KC-TEST";
    private static final String TEST_ROLE_NAME = "Test Unit Admin Derived Role";

    private static final Map<String, List<UnitAdministrator>> TEST_UNIT_ADMINS = getTestUnitAdmins();
    private static final List<Unit> TEST_UNIT_HIERARCHY = getTestHierarchy();

    @Mock
    private AwardService awardService;

    @Mock
    private UnitService unitService;

    @InjectMocks
    private AwardAllUnitAdministratorDerivedRoleTypeServiceImpl unitAdminRoleTypeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(awardService.getAward(anyLong())).thenReturn(award(LOW_UNIT_NUMBER));
        when(unitService.retrieveUnitAdministratorsByUnitNumber(anyString())).thenAnswer(invocation -> {
            String unitNumber = invocation.getArgument(0);
            return TEST_UNIT_ADMINS.get(unitNumber);
        });
        when(unitService.getUnitHierarchyForUnit(anyString())).thenAnswer(invocation -> {
            String inputUnit = invocation.getArgument(0);
            for (int i = 0; i < TEST_UNIT_HIERARCHY.size(); i++) {
                if (TEST_UNIT_HIERARCHY.get(i).getUnitNumber().equals(inputUnit)) {
                    return TEST_UNIT_HIERARCHY.subList(0, i + 1);
                }
            }
            return null;
        });
    }

    @Test
    public void testGetRoleMembersFiltersBasedOnSubQualifier() {
        Map<String, String> qualifiers = new HashMap<>();
        qualifiers.put(KcKimAttributes.AWARD, "123");

        List<RoleMembership> members = unitAdminRoleTypeService.getRoleMembersFromDerivedRole(TEST_NAMESPACE, TEST_ROLE_NAME, qualifiers);
        assertEquals(2, members.size());

        qualifiers.put(KcKimAttributes.SUB_QUALIFIER, UNIT_ADMIN_DEPT_HEAD);
        members = unitAdminRoleTypeService.getRoleMembersFromDerivedRole(TEST_NAMESPACE, TEST_ROLE_NAME, qualifiers);
        assertEquals(1, members.size());
        assertEquals(LOW_DEPT_HEAD, members.get(0).getMemberId());
    }

    @Test
    public void testGetRoleMembersAscendsHierarchyIfSubunitsIsTrue() {
        Map<String, String> qualifiers = new HashMap<>();
        qualifiers.put(KcKimAttributes.AWARD, "123");
        qualifiers.put(KcKimAttributes.SUB_QUALIFIER, UNIT_ADMIN_DEAN);
        qualifiers.put(KcKimAttributes.SUBUNITS, UnitHierarchyRoleTypeServiceImpl.DESCENDS_HIERARCHY_Y);

        List<RoleMembership> members = unitAdminRoleTypeService.getRoleMembersFromDerivedRole(TEST_NAMESPACE, TEST_ROLE_NAME, qualifiers);
        assertEquals(3, members.size());
        assertTrue(members.stream().anyMatch(member -> member.getMemberId().equals(LOW_DEAN)));
        assertTrue(members.stream().anyMatch(member -> member.getMemberId().equals(MID_DEAN)));
        assertTrue(members.stream().anyMatch(member -> member.getMemberId().equals(TOP_DEAN)));
        assertTrue(members.stream().noneMatch(member -> member.getMemberId().equals(LOW_DEPT_HEAD)));
        assertTrue(members.stream().noneMatch(member -> member.getMemberId().equals(TOP_DEPT_HEAD)));
    }

    @Test
    public void testGetRoleMembersDoesNotAscendIfSubunitsIsFalse() {
        Map<String, String> qualifiers = new HashMap<>();
        qualifiers.put(KcKimAttributes.AWARD, "123");
        qualifiers.put(KcKimAttributes.SUB_QUALIFIER, UNIT_ADMIN_DEPT_HEAD);
        qualifiers.put(KcKimAttributes.SUBUNITS, UnitHierarchyRoleTypeServiceImpl.DESCENDS_HIERARCHY_N);

        List<RoleMembership> members = unitAdminRoleTypeService.getRoleMembersFromDerivedRole(TEST_NAMESPACE, TEST_ROLE_NAME, qualifiers);
        assertEquals(1, members.size());
        assertEquals(LOW_DEPT_HEAD, members.get(0).getMemberId());
    }

    private static List<Unit> getTestHierarchy() {
        List<Unit> hierarchy = new ArrayList<>();
        Unit top = unit(TOP_UNIT_NUMBER, null);
        Unit mid = unit(MID_UNIT_NUMBER, top);
        Unit low = unit(LOW_UNIT_NUMBER, mid);
        Unit bottom = unit(BOTTOM_UNIT_NUMBER, low);
        hierarchy.add(top);
        hierarchy.add(mid);
        hierarchy.add(low);
        hierarchy.add(bottom);
        return hierarchy;
    }

    private static Unit unit(String unitNumber, Unit parentUnit) {
        Unit unit = new Unit();
        unit.setUnitNumber(unitNumber);
        if (parentUnit != null) {
            unit.setParentUnitNumber(parentUnit.getUnitNumber());
            unit.setParentUnit(parentUnit);
        }
        return unit;
    }

    private static Map<String, List<UnitAdministrator>> getTestUnitAdmins() {
        Map<String, List<UnitAdministrator>> unitAdmins = new HashMap<>();
        unitAdmins.put(BOTTOM_UNIT_NUMBER, Collections.singletonList(
                unitAdministrator(BOTTOM_UNIT_NUMBER, UNIT_ADMIN_DEAN, BOTTOM_DEAN)));
        unitAdmins.put(LOW_UNIT_NUMBER, Arrays.asList(
                unitAdministrator(LOW_UNIT_NUMBER, UNIT_ADMIN_DEAN, LOW_DEAN),
                unitAdministrator(LOW_UNIT_NUMBER, UNIT_ADMIN_DEPT_HEAD, LOW_DEPT_HEAD)));
        unitAdmins.put(MID_UNIT_NUMBER, Collections.singletonList(
                unitAdministrator(MID_UNIT_NUMBER, UNIT_ADMIN_DEAN, MID_DEAN)));
        unitAdmins.put(TOP_UNIT_NUMBER, Arrays.asList(
                unitAdministrator(TOP_UNIT_NUMBER, UNIT_ADMIN_DEAN, TOP_DEAN),
                unitAdministrator(TOP_UNIT_NUMBER, UNIT_ADMIN_DEPT_HEAD, TOP_DEPT_HEAD)));
        return unitAdmins;
    }

    private static UnitAdministrator unitAdministrator(String unitNumber, String unitAdminTypeCode, String personId) {
        UnitAdministrator unitAdministrator = new UnitAdministrator();
        unitAdministrator.setUnitNumber(unitNumber);
        unitAdministrator.setUnitAdministratorTypeCode(unitAdminTypeCode);
        unitAdministrator.setPersonId(personId);
        return unitAdministrator;
    }

    private Award award(String... unitNumbers) {
        Award award = new Award();
        AwardPerson person = new AwardPerson();
        Arrays.stream(unitNumbers).forEach(unitNumber -> {
            person.add(new AwardPersonUnit() {
                @Override
                public String getUnitNumber() {
                    return unitNumber;
                }
            });
        });
        award.add(person);
        return award;
    }

}
