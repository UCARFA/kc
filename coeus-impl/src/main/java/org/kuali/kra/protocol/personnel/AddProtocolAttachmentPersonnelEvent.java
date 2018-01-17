/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentPersonnelBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AddProtocolAttachmentPersonnelEvent extends ProtocolAttachmentPersonnelEventBase {

    protected AddProtocolAttachmentPersonnelEvent(String errorPathPrefix, Document document,
            ProtocolAttachmentPersonnelBase protocolAttachmentPersonnel, int personIndex) {
        super("adding ProtocolAttachmentPeronnel to document " + getDocumentId(document), errorPathPrefix, document,
                protocolAttachmentPersonnel, personIndex);
    }

    @Override
    public Class getRuleInterfaceClass() {
        return AddProtocolAttachmentPersonnelRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProtocolAttachmentPersonnelRule) rule).processAddProtocolAttachmentPersonnelRules(this);
    }

}
