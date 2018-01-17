/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.web.struts.authorization;

import org.apache.struts.action.ActionForm;
import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.framework.auth.task.WebTaskFactoryBase;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.authorization.AwardTask;
import org.kuali.kra.infrastructure.TaskGroupName;

import javax.servlet.http.HttpServletRequest;

/**
 * The Proposal Task Factory will create a Proposal Task with its
 * task name and the proposal development document contained within
 * the form.
 */
public class AwardTaskFactory extends WebTaskFactoryBase {

    @Override
    public Task createTask(ActionForm form, HttpServletRequest request) {
        AwardForm awardForm = (AwardForm) form;
        return new AwardTask(getTaskName(), awardForm.getAwardDocument().getAward());
    }


    @Override
    public String getTaskGroupName() {
        return TaskGroupName.AWARD;
    }
}
