/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardComment;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

/**
 * This class is the base class for all InstitutionalProposal-to-Award data feed command classes 
 */
abstract class ProposalDataFeedCommandBase {
    Award award;
    InstitutionalProposal proposal;
    FundingProposalMergeType mergeType;
    
    ProposalDataFeedCommandBase(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        this.award = award;
        this.proposal = proposal;
        this.mergeType = mergeType;
    }

    /**
     * @param comment
     * @param newComments
     */
    void appendComments(AwardComment comment, String newComments) {
        if (!StringUtils.isEmpty(newComments)) {
            String comments = comment.getComments();
            comment.setComments(StringUtils.isEmpty(comments) ? newComments : String.format("%s\n%s", comments, newComments));
        }
    }
    
    /**
     * This method finds an AwardComment of a specified type, or creates a new one of that type using the template
     * @param template
     * @return
     */
    AwardComment findOrCreateCommentOfSpecifiedType(AwardComment template) {
        AwardComment comment = award.findCommentOfSpecifiedType(template);
        if(comment == null) {
            comment = template;
            award.add(comment);
        }
        return comment;
    }

    /**
     * This method performs the data feed
     */
    abstract void performDataFeed();
}
