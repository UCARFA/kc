/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.attachment;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.krad.rules.rule.event.DocumentEvent;
/**
 * Event triggered when a personnel attachment state is modified on a 
 * <code>{@link ProposalDevelopmentDocument}</code>
 *
 */
public interface PersonnelAttachmentEvent extends DocumentEvent {
    
    /**
     * @return <code>{@link ProposalPersonBiography}</code> that triggered this event.
     */
    public ProposalPersonBiography getProposalPersonBiography();


}
