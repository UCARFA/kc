/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.bo;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.kra.iacuc.committee.document.CommonCommitteeDocument;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;

public class IacucCommittee extends CommitteeBase<IacucCommittee, CommonCommitteeDocument, IacucCommitteeSchedule> {


    private static final long serialVersionUID = 2031629954610125464L;

    @Override
    protected String getProtocolCommitteeTypeCodehook() {
        return CommitteeType.IACUC_TYPE_CODE;
    }

    @Override
    protected String getProtocolReviewerRoleHook() {
        return RoleConstants.IACUC_PROTOCOL_REVIEWER;
    }

    @Override
    protected String getAdminRoleHook() {
        return RoleConstants.IACUC_ADMINISTRATOR;
    }

    @Override
    protected String getModuleNamespaceCodeHook() {
        return Constants.MODULE_NAMESPACE_IACUC;
    }

    @Override
    protected IacucCommittee getThisHook() {
        return this;
    }

}
