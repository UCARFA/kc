/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.copy;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * The Copy Proposal Rule validates copying of a proposal.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface CopyProposalRule extends BusinessRule {
    
    /**
     * Validates the copying of a proposal.  Before a proposal can be copied,
     * we must verify that it can be copied.  This includes verification against
     * the Copy criteria, e.g. if the user wants to copy attachments but doesn't
     * the necessary permissions to do so, we must prevent the copy.
     * 
     * @param document the original proposal development document
     * @param criteria the user-specified criteria
     * @return true if the copy request is valid; otherwise false
     */
    public boolean processCopyProposalBusinessRules(ProposalDevelopmentDocument document, 
                                                    ProposalCopyCriteria criteria);
}
