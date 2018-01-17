/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.award.commitments.AwardFandaRate;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.IndirectcostRateType;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalUnrecoveredFandA;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import static org.junit.Assert.*;
public class FandARatesDataFeedCommandTest extends BaseDataFeedCommandTest {

    private IndirectcostRateType idcRateType;
    private InstitutionalProposalUnrecoveredFandA ipFandA1;
    private InstitutionalProposalUnrecoveredFandA ipFandA2;
    private AwardFandaRate awardFandA;
    
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        idcRateType = new IndirectcostRateType();
        idcRateType.setIndirectcostRateTypeCode(1);
        ipFandA1 = createIPFandA("2010");
        ipFandA2 = createIPFandA("2011");
        awardFandA = createAwardFandA("2010");
        proposal.add(ipFandA1);
        proposal.add(ipFandA2);
    }
    
    @Test
    public void testAddRates() {
        FandARatesDataFeedCommand command = new FandARatesDataFeedCommand(award, proposal, FundingProposalMergeType.NEWAWARD);
        command.performDataFeed();
        assertTrue(award.getAwardFandaRate().size() == proposal.getInstitutionalProposalUnrecoveredFandAs().size());
        assertTrue(containsRate(award, ipFandA1));
        assertTrue(containsRate(award, ipFandA2));
    }
    
    @Test
    public void testMergeRates() {
        FandARatesDataFeedCommand command = new FandARatesDataFeedCommand(award, proposal, FundingProposalMergeType.MERGE);
        award.add(awardFandA);
        command.performDataFeed();
        assertTrue(award.getAwardFandaRate().size() == proposal.getInstitutionalProposalUnrecoveredFandAs().size()+1);
        assertTrue(containsRate(award, ipFandA1));
        assertTrue(containsRate(award, ipFandA2));
    }
    
    protected InstitutionalProposalUnrecoveredFandA createIPFandA(String fiscalYear) {
        InstitutionalProposalUnrecoveredFandA retval = new InstitutionalProposalUnrecoveredFandA();
        retval.setFiscalYear(fiscalYear);
        retval.setIndirectcostRateType(idcRateType);
        retval.setApplicableIndirectcostRate(new ScaleTwoDecimal(0.01));
        retval.setOnCampusFlag(true);
        retval.setSourceAccount("abc123");
        retval.setUnderrecoveryOfIndirectcost(new ScaleTwoDecimal(10.50));
        return retval;
    }
    
    protected AwardFandaRate createAwardFandA(String fiscalYear) {
        AwardFandaRate retval = new AwardFandaRate();
        retval.setApplicableFandaRate(new ScaleTwoDecimal(0.02));
        retval.setFandaRateTypeCode(idcRateType.getIndirectcostRateTypeCode()==null?null:idcRateType.getIndirectcostRateTypeCode().toString());
        retval.setFiscalYear(fiscalYear);
        retval.setOnCampusFlag("N");
        retval.setSourceAccount("abc123");
        retval.setUnderrecoveryOfIndirectCost(new ScaleTwoDecimal(21.00));
        return retval;
    }
    
    protected boolean containsRate(Award award, InstitutionalProposalUnrecoveredFandA ipRate) {
        for (AwardFandaRate rate : award.getAwardFandaRate()) {
            if (StringUtils.equals(rate.getFiscalYear(), ipRate.getFiscalYear())
                    && StringUtils.equals(rate.getSourceAccount(), ipRate.getSourceAccount())
                    && rate.getUnderrecoveryOfIndirectCost().equals(ipRate.getUnderrecoveryOfIndirectcost())) {
                return true;
            }
        }
        return false;
    }
}
