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
package org.kuali.kra.award.home.fundingproposal;

import org.kuali.coeus.common.framework.fiscalyear.FiscalYearMonthService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.commitments.AwardFandaRate;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardCommentFactory;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalFandA;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalUnrecoveredFandA;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class FandARatesDataFeedCommand extends ProposalDataFeedCommandBase {
    private static final String UNRECOVERED_FANDA_COMMENT_PATTERN = "Added Unrecovered F & A from Proposal Number %s";
    private static final String FANDA_COMMENT_PATTERN = "Added F & A from Proposal Number %s";

    private FiscalYearMonthService fiscalYearMonthService;
    
    /**
     * Constructs a FandARatesDataFeedCommand
     * @param award
     * @param proposal
     */
    public FandARatesDataFeedCommand(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        super(award, proposal, mergeType);
    }
   
    @Override
    void performDataFeed() {
        if (mergeType != FundingProposalMergeType.NOCHANGE) {
            int copyCount = 0;
            if (!isLifecyleRatesFlowthruEnabled()) {
                List<InstitutionalProposalUnrecoveredFandA> fAndAs = proposal.getInstitutionalProposalUnrecoveredFandAs();
                for (InstitutionalProposalUnrecoveredFandA ipUnrecoveredFandA : fAndAs) {
                    award.add(copyUnrecoveredFandA(ipUnrecoveredFandA));
                    copyCount++;
                }
                if (copyCount > 0) {
                    addFandARateComment(proposal);
                }
            } else {
                award.setAwardFandaRate(new ArrayList<>());
                List<InstitutionalProposalFandA> fAndAs = proposal.getInstitutionalProposalFandAs();
                for (InstitutionalProposalFandA ipFandA : fAndAs) {
                    award.add(copyFandA(ipFandA));
                    copyCount++;
                }
                if (copyCount > 0) {
                    String newComment = String.format(FANDA_COMMENT_PATTERN, proposal.getProposalNumber());
                    appendComments(findOrCreateCommentOfSpecifiedType(new AwardCommentFactory().createFandaRateComment()), newComment);                }
            }
        }
    }


    protected boolean isLifecyleRatesFlowthruEnabled() {
        return getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_INSITUTIONAL_PROPOSAL,
                ParameterConstants.ALL_COMPONENT,
                Constants.ENABLE_LIFECYCLE_RATES_FLOWTHRU);
    }

    private void addFandARateComment(InstitutionalProposal proposal) {
        String newComment = String.format(UNRECOVERED_FANDA_COMMENT_PATTERN, proposal.getProposalNumber());
        appendComments(findOrCreateCommentOfSpecifiedType(new AwardCommentFactory().createFandaRateComment()), newComment);
    }

    private String convertOnCampusBooleanToString(boolean onCampusFlag) {
        return onCampusFlag ? Constants.ON_CAMUS_FLAG : Constants.OFF_CAMUS_FLAG;
    }

    protected ParameterService getParameterService() {
        return KcServiceLocator.getService(ParameterService.class);
    }

    private AwardFandaRate copyUnrecoveredFandA(InstitutionalProposalUnrecoveredFandA ipUnrecoveredFandA) {
        AwardFandaRate awardFandA = new AwardFandaRate();
        awardFandA.setApplicableFandaRate(ipUnrecoveredFandA.getApplicableIndirectcostRate());
        awardFandA.setFandaRateTypeCode(ipUnrecoveredFandA.getIndirectcostRateTypeCode()==null?null:ipUnrecoveredFandA.getIndirectcostRateTypeCode().toString());
        awardFandA.setFiscalYear(ipUnrecoveredFandA.getFiscalYear());
        awardFandA.setOnCampusFlag(convertOnCampusBooleanToString(ipUnrecoveredFandA.getOnCampusFlag()));
        awardFandA.setSourceAccount(ipUnrecoveredFandA.getSourceAccount());
        awardFandA.setUnderrecoveryOfIndirectCost(ipUnrecoveredFandA.getAmount());
        Integer fy = Integer.parseInt(ipUnrecoveredFandA.getFiscalYear());
        awardFandA.setStartDate(new Date(this.getFiscalYearMonthService().getFiscalYearStartDate(fy).getTimeInMillis()));
        awardFandA.setEndDate(new Date(this.getFiscalYearMonthService().getFiscalYearEndDate(fy).getTimeInMillis()));
        return awardFandA;
    }

    private AwardFandaRate copyFandA(InstitutionalProposalFandA ipFandA) {
        AwardFandaRate awardFandA = new AwardFandaRate();
        awardFandA.setFiscalYear(ipFandA.getFiscalYear());
        awardFandA.setApplicableFandaRate(ipFandA.getApplicableRate());
        awardFandA.setFandaRateTypeCode(ipFandA.getRateTypeCode());
        awardFandA.setOnCampusFlag(convertOnCampusBooleanToString(ipFandA.getOnOffCampusFlag()));
        awardFandA.setStartDate(ipFandA.getStartDate());
        awardFandA.setUnderrecoveryOfIndirectCost(ipFandA.getAmount());
        return awardFandA;
    }
    
    protected FiscalYearMonthService getFiscalYearMonthService() {
        if (this.fiscalYearMonthService == null) {
            this.fiscalYearMonthService = KcServiceLocator.getService(FiscalYearMonthService.class);
        }
        return this.fiscalYearMonthService;
    }
    
}
