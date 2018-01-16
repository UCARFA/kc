/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.workflow;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.workflow.LastActionService;
import org.kuali.rice.kew.api.action.ActionTaken;
import org.kuali.rice.kew.api.document.WorkflowDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component("lastActionService")
public class LastActionServiceImpl implements LastActionService {

    private static final String KR_PRINCIPAL_ID = "1";

    @Autowired
    @Qualifier("kewWorkflowDocumentService")
    private WorkflowDocumentService workflowDocumentService;

    @Override
    public ActionTaken findLastUserActionTaken(String routeHeaderId) {
        if (StringUtils.isBlank(routeHeaderId)) {
            return null;
        }

        final List<ActionTaken> actionsTaken = workflowDocumentService.getActionsTaken(routeHeaderId);

        if (actionsTaken != null) {
            return actionsTaken.stream()
                    .filter(actionTaken -> actionTaken != null)
                    .filter(actionTaken -> !actionTaken.getPrincipalId().equals(KR_PRINCIPAL_ID))
                    .sorted(Comparator.comparing(ActionTaken::getActionDate).reversed())
                    .findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public String findLastUserActionTakenPrincipalId(String routeHeaderId) {
        final ActionTaken at = findLastUserActionTaken(routeHeaderId);

        return at != null ? at.getPrincipalId() : null;
    }

    public WorkflowDocumentService getWorkflowDocumentService() {
        return workflowDocumentService;
    }

    public void setWorkflowDocumentService(WorkflowDocumentService workflowDocumentService) {
        this.workflowDocumentService = workflowDocumentService;
    }
}
