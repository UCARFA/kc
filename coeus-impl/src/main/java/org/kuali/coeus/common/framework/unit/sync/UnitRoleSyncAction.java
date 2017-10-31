/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.common.framework.unit.sync;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.RiceConstants;
import org.kuali.rice.kns.question.ConfirmationQuestion;
import org.kuali.rice.kns.web.struts.action.KualiAction;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnitRoleSyncAction extends KualiAction {
    private static final String SYNC_MESSAGE_KEY = "info.unit.role.sync.complete";
    private static final String UNIT_ROLE_SYNC = "UnitRoleSync";

    private transient UnitRoleSyncService unitRoleSyncService;
    private transient GlobalVariableService globalVariableService;

    public ActionForward syncAll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        final String question = request.getParameter(KRADConstants.QUESTION_INST_ATTRIBUTE_NAME);
        if (question == null) {
            return this.performQuestionWithoutInput(mapping, form, request, response, UNIT_ROLE_SYNC, "Are you sure you want to execute the unit role sync process", KRADConstants.CONFIRMATION_QUESTION, KRADConstants.MAPPING_CANCEL, "");
        } else if (UNIT_ROLE_SYNC.equals(question)) {
            final String buttonClicked = request.getParameter(KRADConstants.QUESTION_CLICKED_BUTTON);
            if (ConfirmationQuestion.YES.equals(buttonClicked)) {
                getUnitRoleSyncService().syncPersonUnitInfoToRoles();
                getGlobalVariableService().getMessageList().add(SYNC_MESSAGE_KEY);
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

    public UnitRoleSyncService getUnitRoleSyncService() {
        if (unitRoleSyncService == null) {
            unitRoleSyncService = KcServiceLocator.getService(UnitRoleSyncService.class);
        }
        return unitRoleSyncService;
    }

    public void setUnitRoleSyncService(UnitRoleSyncService unitRoleSyncService) {
        this.unitRoleSyncService = unitRoleSyncService;
    }
}
