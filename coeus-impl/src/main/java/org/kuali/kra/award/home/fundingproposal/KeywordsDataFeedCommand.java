/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.kuali.coeus.common.framework.keyword.ScienceKeyword;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.keywords.AwardScienceKeyword;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalScienceKeyword;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class KeywordsDataFeedCommand extends ProposalDataFeedCommandBase {
    
    public KeywordsDataFeedCommand(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        super(award, proposal, mergeType);
    }
    

    @Override
    void performDataFeed() {
        if (mergeType != FundingProposalMergeType.NOCHANGE) {
            Collection <InstitutionalProposalScienceKeyword> results =null;
            if(!proposal.getProposalNumber().equals(InstitutionalProposal.PROPOSAL_NUMBER_TEST_DEFAULT_STRING)){
            Map<String, String> criteria = new HashMap<String, String>();
            criteria.put(InstitutionalProposal.PROPOSAL_NUMBER_PROPERTY_STRING, proposal.getProposalNumber());
            results = KcServiceLocator.getService(BusinessObjectService.class).findMatching(InstitutionalProposalScienceKeyword.class, criteria);
            }else{
                results=proposal.getInstitutionalProposalScienceKeywords();    
            }
            if(results!=null){
                for(InstitutionalProposalScienceKeyword ipKeyword: results) {
                    boolean duplicateFound = false;
                    for(AwardScienceKeyword awardKeyword: award.getKeywords()) {
                        if(isIdentical(awardKeyword, ipKeyword)) {
                            duplicateFound = true;
                            break;
                        }                
                    }
                    if(!duplicateFound) {
                        award.addKeyword(copyScienceKeyword(ipKeyword));
                    }
                }
            }
           
        }
    }

    private boolean isIdentical(AwardScienceKeyword awardKeyword, InstitutionalProposalScienceKeyword ipKeyword) {
        return awardKeyword.getScienceKeywordCode().equals(ipKeyword.getScienceKeywordCode());
    }
    
    private ScienceKeyword copyScienceKeyword(InstitutionalProposalScienceKeyword ipKeyWord) {
        ScienceKeyword keyword = ipKeyWord.getScienceKeyword();
        if(keyword == null) {
            keyword = new ScienceKeyword();
            keyword.setCode(ipKeyWord.getScienceKeywordCode());
            keyword.setDescription(ipKeyWord.getScienceKeywordDescription());
        }
        
        return keyword;
    }
    
}
