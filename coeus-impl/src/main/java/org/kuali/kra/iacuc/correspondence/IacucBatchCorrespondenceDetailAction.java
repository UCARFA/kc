/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.correspondence;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.protocol.correspondence.*;

public class IacucBatchCorrespondenceDetailAction extends BatchCorrespondenceDetailActionBase {

    @Override
    protected BatchCorrespondenceDetailFormBase getNewBatchCorrespondenceDetailFormInstanceHook() {
        return new IacucBatchCorrespondenceDetailForm();
    }

    @Override
    protected BatchCorrespondenceDetailBase getNewBatchCorrespondenceDetailInstanceHook() {
        return new IacucBatchCorrespondenceDetail();
    }

    @Override
    protected String getViewBatchCorrespondenceDetailPermissionNameHook() {
        return PermissionConstants.VIEW_IACUC_BATCH_CORRESPONDENCE_DETAIL;
    }

    @Override
    protected String getModifyBatchCorrespondenceDetailPermissionNameHook() {
        return PermissionConstants.MODIFY_IACUC_BATCH_CORRESPONDENCE_DETAIL;
    }

    @Override
    protected Class<? extends BatchCorrespondenceBase> getBatchCorrespondenceClassHook() {
        return IacucBatchCorrespondence.class;
    }

    @Override
    protected BatchCorrespondenceDetailRuleBase getNewInstanceOfBatchCorrespondenceDetailRuleHook() {
        return new IacucBatchCorrespondenceDetailRule();
    }

    @Override
    protected Class<? extends BatchCorrespondenceDetailService> getBatchCorrespondenceDetailServiceClassHook() {
        return IacucBatchCorrespondenceDetailService.class; 
    }

    @Override
    protected Class<? extends BatchCorrespondenceDetailAuthorizationService> getBatchCorrespondenceDetailAuthorizationServiceClassHook() {
        return IacucBatchCorrespondenceDetailAuthorizationService.class;
    }

}
