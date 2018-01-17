/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.web.struts.action;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.committee.impl.rules.CommitteeDocumentRuleBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.coeus.common.committee.impl.web.struts.action.CommitteeCommitteeActionBase;
import org.kuali.kra.bo.ResearchAreaBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.rules.CommitteeDocumentRule;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.irb.ResearchArea;

/**
 * The CommitteeCommitteeAction corresponds to the Committee tab (web page).  It is
 * responsible for handling all user requests from that tab (web page).
 */
public class CommitteeCommitteeAction extends CommitteeCommitteeActionBase {

    @Override
    protected Class<? extends ResearchAreaBase> getResearchAreaBOClassHook() {
        return ResearchArea.class;
    }

    @Override
    protected CommitteeDocumentRuleBase getNewCommitteeDocumentRuleInstanceHook() {
        return new CommitteeDocumentRule();
    }

    @Override
    protected CommitteeTaskBase getNewCommitteeTaskInstanceHook(String taskName, CommitteeBase committee) {
        // creating an anonymous class to avoid task hierarchy issues
        return new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, taskName, (Committee) committee) {};
    }

    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceBOClassHook() {
        return CommitteeService.class;
    }

    @Override
    protected String getCommitteeDocumentTypeSimpleNameHook() {
        return "CommitteeDocument";
    }

}
