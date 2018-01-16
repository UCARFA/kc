/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.person.creditsplit;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreditSplitCustomColumnsCollectionTest {
    public static final String FINANCIAL = "FINANCIAL";
    public static final String RECOGNITION = "RECOGNITION";
    public static final String RESPONSIBILITY = "RESPONSIBILITY";
    public static final String SPACE = "SPACE";
    public static final String BOB = "BOB";

    CreditSplitCustomColumnsCollection creditSplitCustomColumnsCollection = new CreditSplitCustomColumnsCollection();
    List<InvestigatorCreditType> investigatorCreditTypes;
    private ProposalPerson proposalPerson;

    @Before
    public void setup() {
        proposalPerson = new ProposalPerson();
        proposalPerson.setFullName(BOB);

        proposalPerson.getCreditSplits().add(createPersonCreditSplit(FINANCIAL, 100));
        proposalPerson.getCreditSplits().add(createPersonCreditSplit(RECOGNITION, 100));
        proposalPerson.getCreditSplits().add(createPersonCreditSplit(RESPONSIBILITY, 100));

        investigatorCreditTypes = new ArrayList() {{
            add(new InvestigatorCreditType(FINANCIAL, FINANCIAL));
            add(new InvestigatorCreditType(RECOGNITION, RECOGNITION));
            add(new InvestigatorCreditType(RESPONSIBILITY, RESPONSIBILITY));
            add(new InvestigatorCreditType(SPACE,SPACE));
        }};
    }

    protected ProposalPersonCreditSplit createPersonCreditSplit(String financial, int value) {
        ProposalPersonCreditSplit creditSplit = new ProposalPersonCreditSplit();
        creditSplit.setCredit(new ScaleTwoDecimal(value));
        creditSplit.setInvCreditTypeCode(financial);
        return creditSplit;
    }

    @Test
    public void test_filterColumns_notSubmitted() {
        List<ProposalPerson> proposalPersons = new ArrayList<>();
        proposalPersons.add(proposalPerson);
        List<InvestigatorCreditType> result = creditSplitCustomColumnsCollection.filterColumns(investigatorCreditTypes, proposalPersons, false);
        assertEquals(4, result.size());
    }

    @Test
    public void test_filterColumns_submitted() {
        List<ProposalPerson> proposalPersons = new ArrayList<>();
        proposalPersons.add(proposalPerson);
        List<InvestigatorCreditType> result = creditSplitCustomColumnsCollection.filterColumns(investigatorCreditTypes, proposalPersons, true);
        assertEquals(3, result.size());
        assertEquals(false, result.stream().anyMatch(creditType -> creditType.getCode().equals(SPACE)));
    }
}
