/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.protocol.ProtocolFormBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IacucProtocolMedusaAction extends IacucProtocolAction {
    @Override
    public ActionForward docHandler(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.docHandler(mapping, form, request, response);
        ProtocolFormBase protocolForm = (ProtocolFormBase) form;
        protocolForm.getMedusaBean().setMedusaViewRadio("0");
        protocolForm.getMedusaBean().setModuleName("iacuc");
        protocolForm.getMedusaBean().setModuleIdentifier(protocolForm.getProtocolDocument().getProtocol().getProtocolId());
        protocolForm.getMedusaBean().generateParentNodes();
        return mapping.findForward("basic");
    }
    
    public ActionForward refreshView(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {   
        return mapping.findForward("basic");
    }
}
