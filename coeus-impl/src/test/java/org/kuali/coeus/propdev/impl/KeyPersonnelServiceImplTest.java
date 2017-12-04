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
package org.kuali.coeus.propdev.impl;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.ReadablePeriod;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.budget.framework.personnel.AppointmentType;
import org.kuali.coeus.common.framework.person.*;
import org.kuali.coeus.common.framework.person.attr.KcPersonExtendedAttributes;
import org.kuali.coeus.common.framework.person.attr.PersonAppointment;
import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.person.KeyPersonnelServiceImpl;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.person.ProposalPersonUnit;
import org.kuali.coeus.propdev.impl.person.creditsplit.ProposalCreditSplitListDto;
import org.kuali.coeus.propdev.impl.person.creditsplit.ProposalPersonCreditSplit;
import org.kuali.coeus.propdev.impl.person.creditsplit.ProposalUnitCreditSplit;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.identity.affiliation.EntityAffiliation;
import org.kuali.rice.kim.api.identity.affiliation.EntityAffiliationType;
import org.kuali.rice.kim.api.identity.employment.EntityEmployment;
import org.kuali.rice.kim.api.identity.employment.EntityEmploymentContract;
import org.kuali.rice.kim.api.identity.entity.Entity;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.LegacyAppFrameworkAdapterService;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@PrepareForTest(KNSServiceLocator.class)
@RunWith(PowerMockRunner.class)
public class KeyPersonnelServiceImplTest {

    public static final String BOB = "BOB";
    public static final String FINANCIAL = "FINANCIAL";
    public static final String RECOGNITION = "RECOGNITION";
    public static final String RESPONSIBILITY = "RESPONSIBILITY";
    public static final String SPACE = "SPACE";

    private static final String PRIMARY_UNIT = "IN-CARD";

    private static final String FACULTY_AFFILIATION_CODE = "FACULTY";
    private static final String STUDENT_AFFILIATION_CODE = "STUDENT";
    private static final String STAFF_AFFILIATION_CODE = "STAFF";
    private static final String OTHER_AFFILIATION_CODE = "OTHER";

    private static final String SUMMER_APPOINTMENT_TYPE_CODE = "1";
    private static final String WINTER_APPOINTMENT_TYPE_CODE = "2";
    private static final String RESEARCH_CENTER_APPOINTMENT_TYPE_CODE = "5";

    private PropAwardPersonRoleService propAwardPersonRoleService;

    private BusinessObjectService businessObjectService;
    private KeyPersonnelServiceImpl keyPersonnelService;

    private ProposalPerson proposalPerson;
    private List<InvestigatorCreditType> investigatorCreditTypes;
    private List<String> units;
    private List<EntityEmployment.Builder> empInfos;
    private List<PersonAppointment> appointments;

    @Before
    public void setup() {
        keyPersonnelService = new KeyPersonnelServiceImpl();

        proposalPerson = new ProposalPerson();
        proposalPerson.setFullName(BOB);

        proposalPerson.getCreditSplits().add(createPersonCreditSplit(FINANCIAL, 100));
        proposalPerson.getCreditSplits().add(createPersonCreditSplit(RECOGNITION, 100));
        proposalPerson.getCreditSplits().add(createPersonCreditSplit(RESPONSIBILITY, 100));

        ProposalPersonUnit unit = new ProposalPersonUnit();
        unit.setUnit(new Unit());
        unit.getUnit().setUnitNumber("1");
        unit.getUnit().setUnitName("UNIT1");

        unit.getCreditSplits().add(createUnitCreditSplit(FINANCIAL, 0));
        unit.getCreditSplits().add(createUnitCreditSplit(RECOGNITION, 20));
        unit.getCreditSplits().add(createUnitCreditSplit(RESPONSIBILITY, 60));

        ProposalPersonUnit unit2 = new ProposalPersonUnit();
        unit2.setUnit(new Unit());
        unit2.getUnit().setUnitNumber("2");
        unit2.getUnit().setUnitName("UNIT2");

        unit2.getCreditSplits().add(createUnitCreditSplit(FINANCIAL, 50));
        unit2.getCreditSplits().add(createUnitCreditSplit(RECOGNITION, 20));
        unit2.getCreditSplits().add(createUnitCreditSplit(RESPONSIBILITY, 0));

        proposalPerson.getUnits().add(unit);
        proposalPerson.getUnits().add(unit2);

        investigatorCreditTypes = new ArrayList() {{
            add(new InvestigatorCreditType(FINANCIAL, FINANCIAL));
            add(new InvestigatorCreditType(RECOGNITION, RECOGNITION));
            add(new InvestigatorCreditType(RESPONSIBILITY, RESPONSIBILITY));
            add(new InvestigatorCreditType(SPACE,SPACE));
        }};

        propAwardPersonRoleService = mock(PropAwardPersonRoleService.class);
        ReflectionTestUtils.setField(keyPersonnelService, "propAwardPersonRoleService", propAwardPersonRoleService);

        units = Arrays.asList("IN-IN", "IN-CARD", "IN-PED", "IN-DENT", "BL-BL", "BL-RUGS", "BL-CHEM", "TEST");
        businessObjectService = mock(BusinessObjectService.class);
        when(businessObjectService.findMatching(eq(InvestigatorCreditType.class), anyMap())).thenReturn(investigatorCreditTypes);
        mockBusinessObjectServiceMatchingUnits(businessObjectService);
        keyPersonnelService.setBusinessObjectService(businessObjectService);

        PowerMockito.mockStatic(KNSServiceLocator.class);
        when(KNSServiceLocator.getLegacyAppFrameworkAdapterService()).thenReturn(mock(LegacyAppFrameworkAdapterService.class));

        empInfos = Arrays.asList(
                employment(PRIMARY_UNIT, FACULTY_AFFILIATION_CODE, true),
                employment("BL-BL", FACULTY_AFFILIATION_CODE, false),
                employment("IN-DENT", FACULTY_AFFILIATION_CODE, false)
        );
        appointments = Arrays.asList(
                appointment("BL-RUGS", SUMMER_APPOINTMENT_TYPE_CODE),
                appointment("TEST", SUMMER_APPOINTMENT_TYPE_CODE)
        );
    }


    protected ProposalPersonCreditSplit createPersonCreditSplit(String financial, int value) {
        ProposalPersonCreditSplit creditSplit = new ProposalPersonCreditSplit();
        creditSplit.setCredit(new ScaleTwoDecimal(value));
        creditSplit.setInvCreditTypeCode(financial);
        return creditSplit;
    }

    protected ProposalUnitCreditSplit createUnitCreditSplit(String financial, int value) {
        ProposalUnitCreditSplit creditSplit = new ProposalUnitCreditSplit();
        creditSplit.setCredit(new ScaleTwoDecimal(value));
        creditSplit.setInvCreditTypeCode(financial);
        return creditSplit;
    }

    protected void verifyCreditSplitListDto(ProposalCreditSplitListDto proposalCreditSplitListDto, String bob, int... value) {
        assertEquals(bob, proposalCreditSplitListDto.getDescription());
        for (int i = 0; i < value.length; i++) {
            assertEquals(proposalCreditSplitListDto.getDescription() + " " + proposalCreditSplitListDto.getCreditSplits().get(i).getInvCreditTypeCode() + " credit split is wrong",new ScaleTwoDecimal(value[i]), proposalCreditSplitListDto.getCreditSplits().get(i).getCredit());
        }
    }

    @Test
    public void test_createCreditSplitListItems() {
        List<ProposalPerson> proposalPersons = new ArrayList<>();
        proposalPersons.add(proposalPerson);
        List<ProposalCreditSplitListDto> creditSplitListDtos = keyPersonnelService.createCreditSplitListDtos(proposalPersons);
        assertEquals(5,creditSplitListDtos.size());
        verifyCreditSplitListDto(creditSplitListDtos.get(0), BOB, 100, 100, 100);
        verifyCreditSplitListDto(creditSplitListDtos.get(1),"1 - UNIT1",0,20,60);
        verifyCreditSplitListDto(creditSplitListDtos.get(2),"2 - UNIT2",50,20,0);
        verifyCreditSplitListDto(creditSplitListDtos.get(3),"Unit Total:",50,40,60);
        verifyCreditSplitListDto(creditSplitListDtos.get(4), "Investigator Total:", 100, 100, 100);
    }

    @Test
    public void test_handleNewCreditTypes() {
        List<ProposalPerson> proposalPersons = new ArrayList<>();
        proposalPersons.add(proposalPerson);
        keyPersonnelService.handleNewCreditTypes(proposalPersons, investigatorCreditTypes);
        assertEquals(4, proposalPerson.getCreditSplits().size());
        assertEquals(true, proposalPerson.getCreditSplits().stream().anyMatch(split -> split.getInvCreditTypeCode().equals(SPACE)));
    }

    private PropAwardPersonRole createPropAwardPersonRole(String roleCode, UnitPopulationBehavior unitPopulationBehavior, String... specifiedCodes) {
        PropAwardPersonRole propAwardPersonRole = new PropAwardPersonRole();
        propAwardPersonRole.setCode(roleCode);
        propAwardPersonRole.setAutoPopulateUnitsCode(unitPopulationBehavior.getCode());
        if (specifiedCodes.length > 0) {
            propAwardPersonRole.setSelectedUnitSources(String.join(PropAwardPersonRole.UNIT_SOURCE_SEPARATOR, specifiedCodes));
        }
        return propAwardPersonRole;
    }

    private ProposalPerson createProposalPerson(String roleCode, List<EntityEmployment.Builder> empInfos, List<PersonAppointment> appointments) {
        ProposalPerson proposalPerson = new ProposalPerson();
        proposalPerson.setPersonId("dummyId");
        proposalPerson.setProposalPersonRoleId(roleCode);
        proposalPerson.setHomeUnit(empInfos.stream()
                .filter(empInfo -> empInfo.isActive() && empInfo.isPrimary())
                .map(EntityEmploymentContract::getPrimaryDepartmentCode)
                .findFirst().orElse(""));

        KcPerson person = new KcPerson();
        KcPersonExtendedAttributes attributes = new KcPersonExtendedAttributes();
        attributes.setPersonAppointments(appointments);
        BusinessObjectService boService = mock(BusinessObjectService.class);
        when(boService.findByPrimaryKey(eq(KcPersonExtendedAttributes.class), anyMap())).thenReturn(attributes);
        mockBusinessObjectServiceMatchingUnits(boService);
        person.setBusinessObjectService(boService);

        Entity.Builder entityBuilder = Entity.Builder.create();
        entityBuilder.setEmploymentInformation(empInfos);
        IdentityService identityService = mock(IdentityService.class);
        when(identityService.getEntityByPrincipalId(any())).thenReturn(entityBuilder.build());
        person.setIdentityService(identityService);

        KcPersonService kcPersonService = mock(KcPersonService.class);
        when(kcPersonService.getKcPersonByPersonId(any())).thenReturn(person);
        proposalPerson.setKcPersonService(kcPersonService);

        proposalPerson.getPerson().refresh();
        return proposalPerson;
    }

    private PersonAppointment appointment(String unitNumber, String appointmentTypeCode) {
        return appointment(unitNumber, appointmentTypeCode, null, null);
    }

    private PersonAppointment appointment(String unitNumber, String appointmentTypeCode, Date startDate, Date endDate) {
        PersonAppointment appointment = new PersonAppointment();
        appointment.setUnitNumber(unitNumber);
        appointment.setStartDate(startDate);
        appointment.setEndDate(endDate);
        AppointmentType appointmentType = new AppointmentType();
        appointmentType.setAppointmentTypeCode(appointmentTypeCode);
        appointment.setAppointmentType(appointmentType);
        return appointment;
    }

    private EntityEmployment.Builder employment(String unitNumber, String affiliationTypeCode, boolean isPrimary) {
        return employment(unitNumber, affiliationTypeCode, isPrimary, true);
    }

    private EntityEmployment.Builder employment(String unitNumber, String affiliationTypeCode, boolean isPrimary, boolean isActive) {
        EntityEmployment.Builder employment = EntityEmployment.Builder.create();
        employment.setPrimaryDepartmentCode(unitNumber);
        employment.setPrimary(isPrimary);
        employment.setActive(isActive);
        EntityAffiliation.Builder affiliation = EntityAffiliation.Builder.create();
        affiliation.setAffiliationType(EntityAffiliationType.Builder.create(affiliationTypeCode));
        employment.setEntityAffiliation(affiliation);
        return employment;
    }

    private Unit unit(String unitNumber) {
        Unit unit = new Unit();
        unit.setUnitNumber(unitNumber);
        return unit;
    }

    private void mockBusinessObjectServiceMatchingUnits(BusinessObjectService boService) {
        when(boService.findMatching(eq(Unit.class), anyMap())).thenAnswer(invocation -> {
            Map<String, Object> criteria = invocation.getArgument(1);
            Object unitObj = criteria.get("unitNumber");
            List<String> unitList = unitObj instanceof List ? (List<String>) unitObj : Collections.singletonList((String) unitObj);
            return unitList.stream()
                    .filter(units::contains)
                    .map(this::unit)
                    .collect(Collectors.toList());
        });
    }

    private void mockPropAwardPersonRoles(PropAwardPersonRole... roles) {
        when(propAwardPersonRoleService.getRolesByHierarchy(any())).thenReturn(Arrays.asList(roles));
    }

    @Test
    public void test_noUnitsPopulationBehavior() {
        mockPropAwardPersonRoles(createPropAwardPersonRole(PropAwardPersonRole.KEY_PERSON_CODE, UnitPopulationBehavior.NONE));
        ProposalPerson proposalPerson = createProposalPerson(PropAwardPersonRole.KEY_PERSON_CODE, empInfos, appointments);
        keyPersonnelService.populatePersonUnits(mock(DevelopmentProposal.class), proposalPerson);
        assertTrue(proposalPerson.getUnits().isEmpty());
    }

    @Test
    public void test_primaryUnitPopulationBehavior() {
        mockPropAwardPersonRoles(createPropAwardPersonRole(PropAwardPersonRole.PI_CODE, UnitPopulationBehavior.PRIMARY));
        ProposalPerson proposalPerson = createProposalPerson(PropAwardPersonRole.PI_CODE, empInfos, appointments);
        keyPersonnelService.populatePersonUnits(mock(DevelopmentProposal.class), proposalPerson);
        assertEquals(1, proposalPerson.getUnits().size());
        assertEquals(PRIMARY_UNIT, proposalPerson.getUnits().get(0).getUnit().getUnitNumber());
    }

    @Test
    public void test_allUnitsPopulationBehavior() {
        mockPropAwardPersonRoles(createPropAwardPersonRole(PropAwardPersonRole.MULTI_PI_CODE, UnitPopulationBehavior.ALL));
        ProposalPerson proposalPerson = createProposalPerson(PropAwardPersonRole.MULTI_PI_CODE, empInfos, appointments);
        keyPersonnelService.populatePersonUnits(mock(DevelopmentProposal.class), proposalPerson);
        assertEquals(5, proposalPerson.getUnits().size());
        assertProposalPersonHasUnits(proposalPerson, PRIMARY_UNIT, "BL-BL", "IN-DENT", "BL-RUGS", "TEST");
    }

    @Test
    public void test_selectedUnitsPopulationBehavior() {
        String[] selectedCodes = new String[] { SUMMER_APPOINTMENT_TYPE_CODE, WINTER_APPOINTMENT_TYPE_CODE, STAFF_AFFILIATION_CODE, FACULTY_AFFILIATION_CODE, OTHER_AFFILIATION_CODE };
        mockPropAwardPersonRoles(createPropAwardPersonRole(PropAwardPersonRole.KEY_PERSON_CODE, UnitPopulationBehavior.SELECTED, selectedCodes));
        List<EntityEmployment.Builder> employments = Arrays.asList(
                employment(PRIMARY_UNIT, FACULTY_AFFILIATION_CODE, true),
                employment("IN-DENT", STAFF_AFFILIATION_CODE, false),
                employment("TEST", STUDENT_AFFILIATION_CODE, false)
        );
        List<PersonAppointment> appointments = Arrays.asList(
                appointment("BL-CHEM", SUMMER_APPOINTMENT_TYPE_CODE),
                appointment("BL-RUGS", RESEARCH_CENTER_APPOINTMENT_TYPE_CODE)
        );
        ProposalPerson proposalPerson = createProposalPerson(PropAwardPersonRole.KEY_PERSON_CODE, employments, appointments);
        keyPersonnelService.populatePersonUnits(mock(DevelopmentProposal.class), proposalPerson);
        assertEquals(3, proposalPerson.getUnits().size());
        assertProposalPersonHasUnits(proposalPerson, PRIMARY_UNIT, "IN-DENT", "BL-CHEM");
    }

    @Test
    public void test_multipleUnitsPopulationRespectsActiveFlags() {
        String[] selectedCodes = new String[] { SUMMER_APPOINTMENT_TYPE_CODE, WINTER_APPOINTMENT_TYPE_CODE, FACULTY_AFFILIATION_CODE, STAFF_AFFILIATION_CODE };
        mockPropAwardPersonRoles(createPropAwardPersonRole(PropAwardPersonRole.KEY_PERSON_CODE, UnitPopulationBehavior.ALL, selectedCodes));
        List<EntityEmployment.Builder> employments = Arrays.asList(
                employment(PRIMARY_UNIT, FACULTY_AFFILIATION_CODE, true),
                employment("BL-RUGS", STAFF_AFFILIATION_CODE, false, false),
                employment("TEST", FACULTY_AFFILIATION_CODE, false, false)
        );
        List<PersonAppointment> appointments = Arrays.asList(
                appointment("IN-PED", SUMMER_APPOINTMENT_TYPE_CODE, timeOffset(Months.months(2)), null),
                appointment("IN-CARD", WINTER_APPOINTMENT_TYPE_CODE, null, timeOffset(Months.months(-2))),
                appointment("IN-IN", SUMMER_APPOINTMENT_TYPE_CODE, timeOffset(Months.months(-5)), timeOffset(Months.months(3))),
                appointment("IN-DENT", SUMMER_APPOINTMENT_TYPE_CODE, timeOffset(Months.months(-7)), timeOffset(Months.months(-4)))
        );
        ProposalPerson proposalPerson = createProposalPerson(PropAwardPersonRole.KEY_PERSON_CODE, employments, appointments);
        keyPersonnelService.populatePersonUnits(mock(DevelopmentProposal.class), proposalPerson);
        assertEquals(2, proposalPerson.getUnits().size());
        assertProposalPersonHasUnits(proposalPerson, PRIMARY_UNIT, "IN-IN");
    }

    @Test
    public void test_selectedUnitsPopulationPreservesHomeUnit() {
        mockPropAwardPersonRoles(createPropAwardPersonRole(PropAwardPersonRole.KEY_PERSON_CODE, UnitPopulationBehavior.SELECTED, FACULTY_AFFILIATION_CODE));
        List<EntityEmployment.Builder> employments = Arrays.asList(
                employment(PRIMARY_UNIT, STAFF_AFFILIATION_CODE, true),
                employment("BL-BL", FACULTY_AFFILIATION_CODE, false)
        );
        ProposalPerson proposalPerson = createProposalPerson(PropAwardPersonRole.KEY_PERSON_CODE, employments, Collections.emptyList());
        keyPersonnelService.populatePersonUnits(mock(DevelopmentProposal.class), proposalPerson);
        assertEquals(2, proposalPerson.getUnits().size());
        assertProposalPersonHasUnits(proposalPerson, PRIMARY_UNIT, "BL-BL");
    }

    @Test
    public void test_primaryUnitPopulationFiltersEmptyUnits() {
        mockPropAwardPersonRoles(createPropAwardPersonRole(PropAwardPersonRole.PI_CODE, UnitPopulationBehavior.PRIMARY, FACULTY_AFFILIATION_CODE));
        ProposalPerson proposalPerson = createProposalPerson(PropAwardPersonRole.PI_CODE, Collections.emptyList(), Collections.emptyList());
        keyPersonnelService.populatePersonUnits(mock(DevelopmentProposal.class), proposalPerson);
        assertTrue(proposalPerson.getUnits().isEmpty());
    }

    private void assertProposalPersonHasUnits(ProposalPerson person, String... units) {
        assertTrue(person.getUnits().stream()
                .map(ProposalPersonUnit::getUnit)
                .map(Unit::getUnitNumber)
                .allMatch(unitNumber -> Arrays.asList(units).contains(unitNumber)));
    }

    private Date timeOffset(ReadablePeriod offset) {
        return new Date(DateTime.now().plus(offset).getMillis());
    }
}
