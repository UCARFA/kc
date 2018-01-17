/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.rice.krad.rules.rule.BusinessRule;

public interface AddProtocolAttachmentPersonnelRule extends BusinessRule {

    /**
     * 
     * This method evaluates to true if ProtocolAttachmentPersonnelBase object satisfy required fields and business rules.
     * @param addProtocolAttachmentPersonnelEvent
     * @return boolean true for valid object and false otherwise.
     */
    boolean processAddProtocolAttachmentPersonnelRules(AddProtocolAttachmentPersonnelEvent addProtocolAttachmentPersonnelEvent);
}
