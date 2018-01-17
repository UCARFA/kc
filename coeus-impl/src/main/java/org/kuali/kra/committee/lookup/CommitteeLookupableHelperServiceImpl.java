/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.lookup;

import org.kuali.rice.krad.util.KRADConstants;

import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.coeus.common.committee.impl.lookup.CommitteeLookupableHelperServiceImplBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * 
 * This class is for committee lookup.
 */
public class CommitteeLookupableHelperServiceImpl extends CommitteeLookupableHelperServiceImplBase<Committee> {

    private static final String DOCHANDLER_LINK = "%s/DocHandler.do?command=displayDocSearchView&docId=%s";

    private static final long serialVersionUID = -3249634640550089590L;

    @Override
    protected String getCommitteeTypeCodeHook() {
        return CommitteeType.IRB_TYPE_CODE;
    }

    @Override
    protected String getCommitteeMembershipFullyQualifiedClassNameHook() {
        return CommitteeMembership.class.getName();
    }

    @Override
    protected String getHtmlAction() {
        return "committeeCommittee.do";
    }

    @Override
    protected String getCustomResumeEditUrl(final String editCommitteeDocId) {
        final String workflowUrl = getKualiConfigurationService().getPropertyValueAsString(KRADConstants.WORKFLOW_URL_KEY);
        return String.format(DOCHANDLER_LINK, workflowUrl, editCommitteeDocId);
    }


    @Override
    protected String getDocumentTypeName() {
        return "CommitteeDocument";
    }

    @Override
    protected String getViewCommitteePermissionNameHook() {
        return PermissionConstants.VIEW_COMMITTEE;
    }

    @Override
    protected String getModifyCommitteePermissionNameHook() {
        return PermissionConstants.MODIFY_COMMITTEE;
    }

    @Override
    protected Class<Committee> getCommitteeBOClassHook() {
        return Committee.class;
    }
}
