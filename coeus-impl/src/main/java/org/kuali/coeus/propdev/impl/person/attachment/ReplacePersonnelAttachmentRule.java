/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.attachment;

public interface ReplacePersonnelAttachmentRule extends AddPersonnelAttachmentRule {

    /**
     * Rule invoked upon replacing a personnel attachment to a
     * <code>{@link org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument}</code>

     * @param event The <code>{@link ReplacePersonnelAttachmentEvent}</code> that triggered this rule to run.
     * @return true if the business rules pass, false otherwise.
     */
    public boolean processReplacePersonnelAttachmentBusinessRules(ReplacePersonnelAttachmentEvent event);
}
