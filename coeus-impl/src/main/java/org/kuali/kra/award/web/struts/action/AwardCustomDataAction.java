/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.common.impl.custom.CustomDataRule;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.common.framework.custom.SaveCustomDataEvent;
import org.kuali.rice.kns.web.struts.form.KualiDocumentFormBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This class represents the Struts Action for Custom Data page(AwardCustomData.jsp)
 */
public class AwardCustomDataAction extends AwardAction {   
    
    
    private static final String CUSTOM_ATTRIBUTE_NAME = "AwardCustomDataAttribute";
    
    
    /**
     * 
     * @see org.kuali.core.web.struts.action.KualiDocumentActionBase#reload(
     * org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, 
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings("all")
    public ActionForward reload(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception { 
        AwardForm awardForm = (AwardForm) form;
        super.reload(mapping, form, request, response);
        awardForm.getCustomDataHelper().prepareCustomData();
        return mapping.findForward(Constants.MAPPING_AWARD_CUSTOM_DATA_PAGE);
    }
    
    /**
     * There is the additional logic in save for custom data.  there is not add functionality in the custom data tab, so the form custom data
     * is being added to the award on save.
     * @see org.kuali.coeus.sys.framework.controller.KcTransactionalDocumentActionBase#save(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        AwardForm awardForm = (AwardForm) form;
        //have to do the custom data validation here, separate from the document save, as invalid default values could cause the
        //document to be unusable.
        if (new CustomDataRule().processRules(new SaveCustomDataEvent(awardForm.getAwardDocument()))) {
            return super.save(mapping, form, request, response);   
        } else {
            return mapping.findForward(Constants.MAPPING_BASIC);
        }
    }
    
    @Override
    public void postDocumentSave(KualiDocumentFormBase form) throws Exception {
        super.postDocumentSave(form);
        AwardForm awardForm = (AwardForm) form;
        awardForm.getCustomDataHelper().setCustomAttributeContent(awardForm.getAwardDocument().getDocumentNumber(), CUSTOM_ATTRIBUTE_NAME);
    }
}
