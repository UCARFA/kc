/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.document.authorizer;

import org.kuali.coeus.common.committee.impl.document.authorizer.ModifyCommitteeAuthorizerBase;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;

public class IacucModifyCommitteeAuthorizer extends ModifyCommitteeAuthorizerBase {

    @Override
    protected String getPermissionNameForModifyCommitteeHook() {
        return PermissionConstants.MODIFY_IACUC_COMMITTEE;
    }

    @Override
    protected String getModuleNamespaceCodeHook() {
        return Constants.MODULE_NAMESPACE_IACUC;
    }

    @Override
    protected String getPermissionNameForAddCommiteeHook() {
        return PermissionConstants.ADD_IACUC_COMMITTEE;
    }

}
