/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rules;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.rule.event.DeleteCommitteeMemberEventBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeMembershipServiceBase;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * 
 * This class is to implement business rule for deleting committee member.
 */
public abstract class DeleteCommitteeMemberRuleBase extends KcTransactionalDocumentRuleBase implements KcBusinessRule<DeleteCommitteeMemberEventBase> {
    
    private static final String ID = "document.committeeList[0].committeeMemberships[";
    private static final String AS_REVIEWER = "as the person is a reviewer of the protocol";
    private static final String AS_ATTENDANCE = "as the person has attended a schedule meeting";
    private CommitteeMembershipServiceBase committeeMembershipService;
    /**
     * If member is assigned as a reviewer or as attendance of a meeting, then member can not be deleted.
     * @see org.kuali.coeus.sys.framework.rule.KcBusinessRule#processRules(org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension)
     */
    @Override
    public boolean processRules(DeleteCommitteeMemberEventBase event) {

        boolean rulePassed = true;
        int i = 0;
        for (CommitteeMembershipBase member : event.getCommitteeMemberships()) {
            if (member.isDelete() && getCommitteeMembershipService().isMemberAssignedToReviewer(member,
                    ((CommitteeDocumentBase) event.getDocument()).getCommittee().getCommitteeId())) {
                reportError(ID + i + "].delete", KeyConstants.ERROR_COMMITTEEMEMBER_DELETE, AS_REVIEWER);
                rulePassed = false;
            }
            if (member.isDelete() && getCommitteeMembershipService().isMemberAttendedMeeting(member,
                    ((CommitteeDocumentBase) event.getDocument()).getCommittee().getCommitteeId())) {
                reportError(ID + i + "].delete", KeyConstants.ERROR_COMMITTEEMEMBER_DELETE, AS_ATTENDANCE);
                rulePassed = false;
            }
            i++;
        }
        return rulePassed;
    }

    private CommitteeMembershipServiceBase getCommitteeMembershipService() {
        if (committeeMembershipService == null) {
            committeeMembershipService = KcServiceLocator.getService(getCommitteeMembershipServiceClassHook());
        }
        return committeeMembershipService;
    }

    protected abstract Class<? extends CommitteeMembershipServiceBase> getCommitteeMembershipServiceClassHook();
    

}
