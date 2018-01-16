/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment.institute;

public interface ReplaceInstituteAttachmentRule extends AddInstituteAttachmentRule {

    /**
     * Rule invoked upon replacing an institute attachment within a
     * <code>{@link org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument}</code>

     * @param event The <code>{@link ReplaceInstituteAttachmentEvent}</code> that triggered this rule to run.
     * @return true if the business rules pass, false otherwise.
     */
    public boolean processReplaceInstituteAttachmentBusinessRules(ReplaceInstituteAttachmentEvent event);
    
}
