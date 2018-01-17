/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.web.struts.action;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.committee.impl.rule.event.DeleteCommitteeMemberEventBase;
import org.kuali.coeus.common.committee.impl.rules.CommitteeDocumentRuleBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeMembershipServiceBase;
import org.kuali.coeus.common.committee.impl.web.struts.action.CommitteeMembershipActionBase;
import org.kuali.kra.bo.ResearchAreaBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.rule.event.DeleteCommitteeMemberEvent;
import org.kuali.kra.committee.rules.CommitteeDocumentRule;
import org.kuali.kra.committee.service.CommitteeMembershipService;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.irb.ResearchArea;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * The CommitteeMembershipAction corresponds to the Members tab (web page).  It is
 * responsible for handling all user requests from that tab (web page).
 */
public class CommitteeMembershipAction extends CommitteeMembershipActionBase {

    @Override
    protected CommitteeMembershipBase getNewCommitteeMembershipInstanceHook() {
        return new CommitteeMembership();
    }

    @Override
    protected DeleteCommitteeMemberEventBase getNewDeleteCommitteeMemberEventInstanceHook(String errorPathPrefix,
            Document document, List<CommitteeMembershipBase> committeeMemberships, org.kuali.coeus.common.committee.impl.rule.event.CommitteeMemberEventBase.ErrorType type) {
        
        return new DeleteCommitteeMemberEvent(errorPathPrefix, document, (List)committeeMemberships, type);
    }

    @Override
    protected Class<? extends ResearchAreaBase> getResearchAreaBOClassHook() {
        return ResearchArea.class;
    }

    @Override
    protected CommitteeDocumentRuleBase getNewCommitteeDocumentRuleInstanceHook() {
        return new CommitteeDocumentRule();
    }

    @Override
    protected Class<? extends CommitteeMembershipServiceBase> getCommitteeMembershipServiceClassHook() {
        return CommitteeMembershipService.class;
    }

    @Override
    protected CommitteeTaskBase getNewCommitteeTaskInstanceHook(String taskName, CommitteeBase committee) {
        // creating an anonymous class to avoid task hierarchy issues
        return new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, taskName, (Committee) committee) {};
    }

    @Override
    protected String getCommitteeDocumentTypeSimpleNameHook() {
        return "CommitteeDocument";
    }
}
