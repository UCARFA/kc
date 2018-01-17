/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.coi.notesandattachments.FinancialEntityAttachmentRule;
import org.kuali.kra.coi.notesandattachments.attachments.FinancialEntityAttachment;

/**
 * 
 * This class is and event class when save FE
 */
public class AddFinancialEntityAttachmentEvent  extends KcDocumentEventBaseExtension {
    private FinancialEntityAttachment attachment;

    /**
     * 
     * Constructs a SaveFinancialEntityEvent.java.
     * @param propertyName
     * @param personFinIntDisclosure
     */
    public AddFinancialEntityAttachmentEvent(String prefixPath, FinancialEntityAttachment attachment) {
        super("Add Financial Entity Attachment", prefixPath, null);
        this.attachment = attachment;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new FinancialEntityAttachmentRule();
    }

    public FinancialEntityAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(FinancialEntityAttachment attachment) {
        this.attachment = attachment;
    }

}
