/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.document.authorization;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeDocumentAuthorizerBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.infrastructure.TaskName;

/**
 * This class is the Committee Document Authorizer.  It determines the edit modes and
 * document actions for all committee documents.
 */
public class CommitteeDocumentAuthorizer extends CommitteeDocumentAuthorizerBase {


    private static final long serialVersionUID = 6464453088283772104L;

    @Override
    protected String getAddCommitteeTaskNameHook() {
        return TaskName.ADD_COMMITTEE;
    }

    @Override
    protected CommitteeTaskBase getNewCommitteeTaskInstanceHook(String taskName, CommitteeBase committee) {
        return new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, taskName, (Committee) committee) {};
    }

    @Override
    protected String getPermissionNameForModifyCommitteeHook() {
        return PermissionConstants.MODIFY_COMMITTEE;
    }

}
