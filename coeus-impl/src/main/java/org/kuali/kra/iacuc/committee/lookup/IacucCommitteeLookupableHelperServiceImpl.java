/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.lookup;

import org.kuali.rice.krad.util.KRADConstants;

import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.coeus.common.committee.impl.lookup.CommitteeLookupableHelperServiceImplBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeMembership;
import org.kuali.kra.infrastructure.PermissionConstants;

public class IacucCommitteeLookupableHelperServiceImpl extends CommitteeLookupableHelperServiceImplBase<IacucCommittee> {


    private static final String DOCHANDLER_LINK = "%s/%s?methodToCall=docHandler&docId=%s&command=displayDocSearchView";

    private static final long serialVersionUID = -1230794939567685359L;

    @Override
    protected String getCommitteeTypeCodeHook() {
        return CommitteeType.IACUC_TYPE_CODE;
    }

    @Override
    protected String getCommitteeMembershipFullyQualifiedClassNameHook() {
        return IacucCommitteeMembership.class.getName();
    }

    @Override
    protected String getHtmlAction() {
        return "iacucCommitteeCommittee.do";
    }

    @Override
    protected String getCustomResumeEditUrl(final String editCommitteeDocId) {
        final String workflowUrl = getKualiConfigurationService().getPropertyValueAsString(KRADConstants.APPLICATION_URL_KEY);
        return String.format(DOCHANDLER_LINK, workflowUrl, getHtmlAction(), editCommitteeDocId);
    }

    @Override
    protected String getDocumentTypeName() {
        return "CommonCommitteeDocument";
    }

    @Override
    protected String getViewCommitteePermissionNameHook() {
        return PermissionConstants.VIEW_IACUC_COMMITTEE;
    }

    @Override
    protected String getModifyCommitteePermissionNameHook() {
        return PermissionConstants.MODIFY_IACUC_COMMITTEE;
    }

    @Override
    protected Class<IacucCommittee> getCommitteeBOClassHook() {
        return IacucCommittee.class;
    }


}
