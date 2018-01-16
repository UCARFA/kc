/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notesandattachments;

import org.kuali.kra.coi.notesandattachments.attachments.CoiDisclosureAttachment;


public class AddCoiDisclosureAttachmentRuleImpl implements AddCoiDisclosureAttachmentRule{
    private final CoiDisclosureAttachmentRuleHelper helper = new CoiDisclosureAttachmentRuleHelper();


    @Override
    public boolean processAddCoiDisclosureAttachmentRules(AddCoiDisclosureAttachmentEvent event) {
        final CoiDisclosureAttachment newCoiDisclosureAttachment = event.getNewCoiDisclosureAttachment();
        
        boolean valid = helper.validPrimitiveFields(newCoiDisclosureAttachment);
      //  valid &= helper.validDescriptionWhenRequired(newCoiDisclosureAttachment);
        valid &= helper.validFile(newCoiDisclosureAttachment);
        
        return valid;
    }

}
