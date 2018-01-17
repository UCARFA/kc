/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notesandattachments;

import org.kuali.kra.coi.notesandattachments.notes.CoiDisclosureNotepad;

public class AddCoiDisclosureNotepadRuleImpl implements AddCoiDisclosureNotepadRule {

    private final CoiDisclosureNotepadRuleHelper notesHelper = new CoiDisclosureNotepadRuleHelper();
    @Override
    public boolean processAddCoiDisclosureNotepadRules(AddCoiDisclosureNotepadEvent event) {
        final CoiDisclosureNotepad newProtocolNotepad = event.getNewCoiDisclosureNotepad();
        
        boolean valid = this.notesHelper.validPrimitiveFields(newProtocolNotepad);
               
        return valid;
    }

}
