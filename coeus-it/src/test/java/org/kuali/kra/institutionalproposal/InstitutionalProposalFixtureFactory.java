/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.institutionalproposal;

import org.kuali.coeus.common.framework.person.PropAwardPersonRole;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPersonCreditSplit;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPersonUnit;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPersonUnitCreditSplit;
import org.kuali.kra.institutionalproposal.customdata.InstitutionalProposalCustomData;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.List;

public class InstitutionalProposalFixtureFactory {

    private static final String UNIVERSITY_UNIT_NUMBER = "000001";
    private static final String NIH_SPONSOR_CODE = "000340";
    private static final Long BILLING_ELEMENT_ATTRIBUTE_ID = 1L;
    private static final Long GRAD_STUDENT_COUNT_ATTRIBUTE_ID = 4L;

    public static InstitutionalProposal createInstitutionalProposalFixture() {
        return createInstitutionalProposalFixture(GlobalVariables.getUserSession().getPrincipalId());
    }

    public static InstitutionalProposal createInstitutionalProposalFixture(String piPrincipalId) {
        InstitutionalProposal institutionalProposal = new InstitutionalProposal();
        institutionalProposal.setProposalNumber(InstitutionalProposal.PROPOSAL_NUMBER_TEST_DEFAULT_STRING);
        institutionalProposal.setSubcontractFlag(false);
        institutionalProposal.setSponsorCode(NIH_SPONSOR_CODE);
        institutionalProposal.setProposalTypeCode(1);
        institutionalProposal.setTitle("Test");
        institutionalProposal.setStatusCode(ProposalStatus.PENDING);
        institutionalProposal.setActivityTypeCode("1");

        InstitutionalProposalPerson pi = new InstitutionalProposalPerson();
        pi.setPersonId(piPrincipalId);
        pi.setContactRoleCode(PropAwardPersonRole.PI_CODE);
        institutionalProposal.add(pi);
        addCreditSplit(pi, "0");
        addCreditSplit(pi, "1");
        addCreditSplit(pi, "2");
        addCreditSplit(pi, "3");

        InstitutionalProposalPersonUnit unit = new InstitutionalProposalPersonUnit();
        unit.setUnitNumber(UNIVERSITY_UNIT_NUMBER);
        unit.setLeadUnit(true);
        pi.add(unit);
        addCreditSplit(unit, "0");
        addCreditSplit(unit, "1");
        addCreditSplit(unit, "2");
        addCreditSplit(unit, "3");

        List<InstitutionalProposalCustomData> customDatas = new ArrayList<>();
        InstitutionalProposalCustomData customData = new InstitutionalProposalCustomData();
        customData.setCustomAttributeId(BILLING_ELEMENT_ATTRIBUTE_ID);
        customData.setValue("1");
        customDatas.add(customData);

        InstitutionalProposalCustomData customData2 = new InstitutionalProposalCustomData();
        customData.setCustomAttributeId(GRAD_STUDENT_COUNT_ATTRIBUTE_ID);
        customData.setValue("1");
        customDatas.add(customData2);
        institutionalProposal.setInstitutionalProposalCustomDataList(customDatas);

        return institutionalProposal;
    }

    private static void addCreditSplit(InstitutionalProposalPerson person, String typeCode) {
        InstitutionalProposalPersonCreditSplit creditSplit = new InstitutionalProposalPersonCreditSplit();
        creditSplit.setInvCreditTypeCode(typeCode);
        creditSplit.setCredit(ScaleTwoDecimal.ONE_HUNDRED);
        person.add(creditSplit);
    }

    private static void addCreditSplit(InstitutionalProposalPersonUnit unit, String typeCode) {
        InstitutionalProposalPersonUnitCreditSplit creditSplit = new InstitutionalProposalPersonUnitCreditSplit();
        creditSplit.setInvCreditTypeCode(typeCode);
        creditSplit.setCredit(ScaleTwoDecimal.ONE_HUNDRED);
        unit.add(creditSplit);
    }

}
