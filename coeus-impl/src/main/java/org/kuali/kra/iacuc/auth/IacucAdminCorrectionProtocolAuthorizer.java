/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.protocol.auth.AdminCorrectionProtocolAuthorizerBase;

public class IacucAdminCorrectionProtocolAuthorizer extends AdminCorrectionProtocolAuthorizerBase {

    @Override
    protected String getActionTypeAdminCorrectionHook() {
        return IacucProtocolActionType.ADMINISTRATIVE_CORRECTION;
    }

    @Override
    protected String getPermissionMaintainProtocolSubmissionHook() {
        return PermissionConstants.MAINTAIN_IACUC_PROTOCOL_SUBMISSIONS;
    }

}
