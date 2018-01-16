/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.bo;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;

/**
 * Represents a single committee within an institution.
 */
@SuppressWarnings("serial")
public class Committee extends CommitteeBase<Committee, CommitteeDocument, CommitteeSchedule> {

    @Override
    protected String getProtocolCommitteeTypeCodehook() {
        return CommitteeType.IRB_TYPE_CODE;
    }

    @Override
    protected Committee getThisHook() {
        return this;
    }

    @Override
    protected String getProtocolReviewerRoleHook() {
        return RoleConstants.IRB_REVIEWER;
    }

    @Override
    protected String getAdminRoleHook() {
        return RoleConstants.IRB_ADMINISTRATOR;
    }

    @Override
    protected String getModuleNamespaceCodeHook() {
        return Constants.MODULE_NAMESPACE_IRB;
    }

}
