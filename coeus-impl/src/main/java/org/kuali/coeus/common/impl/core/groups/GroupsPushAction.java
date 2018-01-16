/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.core.groups;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.common.framework.core.groups.GroupsPushService;
import org.kuali.coeus.common.framework.core.groups.GroupsPushStatus;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.RiceConstants;
import org.kuali.rice.kns.question.ConfirmationQuestion;
import org.kuali.rice.kns.web.struts.action.KualiAction;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GroupsPushAction extends KualiAction {
    private static final String PUSH_MESSAGE_KEY = "info.group.bulk.push.complete";
    private static final String GROUPS_SERVICE_BULK_PUSH = "GroupServiceBulkPush";

    private transient GroupsPushService groupsPushService;
	private transient GlobalVariableService globalVariableService;

    public ActionForward pushAll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        final String question = request.getParameter(KRADConstants.QUESTION_INST_ATTRIBUTE_NAME);
        if (question == null) {
            return this.performQuestionWithoutInput(mapping, form, request, response, GROUPS_SERVICE_BULK_PUSH, "Are you sure you want to push all units to the core groups service", KRADConstants.CONFIRMATION_QUESTION, KRADConstants.MAPPING_CANCEL, "");
        } else if (GROUPS_SERVICE_BULK_PUSH.equals(question)) {
            final String buttonClicked = request.getParameter(KRADConstants.QUESTION_CLICKED_BUTTON);
            if (ConfirmationQuestion.YES.equals(buttonClicked)) {
            	GroupsPushStatus status = getGroupsPushService().pushAllGroups();
                getGlobalVariableService().getMessageList().add(PUSH_MESSAGE_KEY, Integer.toString(status.getNumberOfUnits()),
                        Integer.toString(status.getCategoriesAdded()), Integer.toString(status.getCategoriesUpdated()),
                        Integer.toString(status.getGroupsAdded()), Integer.toString(status.getGroupsUpdated()));
            }
        }

        return mapping.findForward(RiceConstants.MAPPING_BASIC);
    }

    public GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }

        return globalVariableService;
    }

    public void setGlobalVariableService(GlobalVariableService globalVariableService) {
        this.globalVariableService = globalVariableService;
    }
    
    public GroupsPushService getGroupsPushService() {
    	if (groupsPushService == null) {
    		groupsPushService = KcServiceLocator.getService(GroupsPushService.class);
    	}
		return groupsPushService;
	}

	public void setGroupsPushService(GroupsPushService groupsPushService) {
		this.groupsPushService = groupsPushService;
	}

}
