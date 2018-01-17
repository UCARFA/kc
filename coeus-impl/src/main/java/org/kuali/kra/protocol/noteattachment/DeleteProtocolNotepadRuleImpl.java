/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

/**
 * Implementation of {@link DeleteProtocolNotepadRule DeleteProtocolNotepadRule}.
 * @see DeleteProtocolNotepadRule for details
 */
public class DeleteProtocolNotepadRuleImpl implements DeleteProtocolNotepadRule {

    @Override
    public boolean processDeleteProtocolNotepadRules(DeleteProtocolNotepadEvent event) {
        //TODO: Might have to do some more authorizing here...
        return true;
    }
}
