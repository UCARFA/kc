/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.kra.irb.actions.amendrenew.ProtocolModule;

/**
 * The Modify Protocol Permissions Authorizer checks to see if the user has 
 * permission to maintain protocol access, i.e. assign Users to Protocol Roles.
 */
public class ModifyProtocolPermissionsAuthorizer extends ModifyAmendmentAuthorizer {

    public ModifyProtocolPermissionsAuthorizer() {
        super(ProtocolModule.PROTOCOL_PERMISSIONS);
    }
}
