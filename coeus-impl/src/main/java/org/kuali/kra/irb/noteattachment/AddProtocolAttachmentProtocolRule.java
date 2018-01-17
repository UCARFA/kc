/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * Contains rules for adding {@link ProtocolAttachmentProtocol ProtocolAttachmentProtocol}.
 */
interface AddProtocolAttachmentProtocolRule extends BusinessRule {

    /**
     * Executes the rules for adding a new {@link ProtocolAttachmentProtocol ProtocolAttachmentProtocol}.
     * @param event the add event.
     * @return if validation passes.
     */
    boolean processAddProtocolAttachmentProtocolRules(AddProtocolAttachmentProtocolEvent event);
}
