/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.document.authorizer;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;

/**
 * The CommitteeBase Action Authorizer checks to see if the user has 
 * permission to perform committee actions. 
 */
public abstract class CommitteeActionAuthorizerBase extends CommitteeAuthorizerBase {
    
    private CommitteeServiceBase committeeService;

    @Override
    public boolean isAuthorized(String userId, CommitteeTaskBase task) {
        CommitteeBase committee = task.getCommittee();
        return StringUtils.equals(committee.getCommitteeDocument().getDocumentHeader().getWorkflowDocument().getStatus().getLabel(), "FINAL")
                && committee.getCommitteeId() != null
                && committeeService.getCommitteeById(committee.getCommitteeId()).getId().equals(committee.getId())
                && hasPermission(userId, committee, getPermissionNameForPerformCommitteeActionsCodeHook());
    }
    
    protected abstract String getPermissionNameForPerformCommitteeActionsCodeHook();
    
    /**
     * Set the CommitteeBase Service.  Usually injected by the Spring Framework.
     * @param committeeService
     */
    public void setCommitteeService(CommitteeServiceBase committeeService) {
        this.committeeService = committeeService;
    }

}
