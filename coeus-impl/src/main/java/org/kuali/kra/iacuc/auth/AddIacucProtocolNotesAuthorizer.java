/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.amendrenew.IacucProtocolModule;


/**
 * The Add Protocol Notes Authorizer determines if a user has the right
 * to create protocol notes
 */
public class AddIacucProtocolNotesAuthorizer extends ModifyIacucAmendmentAuthorizer {

    protected AddIacucProtocolNotesAuthorizer() {
        super(IacucProtocolModule.ADD_MODIFY_ATTACHMENTS);
    }

}
