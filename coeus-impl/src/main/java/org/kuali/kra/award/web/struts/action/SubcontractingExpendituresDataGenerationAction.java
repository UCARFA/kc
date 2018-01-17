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
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.subcontracting.reporting.SubcontractingExpenditureAmountsInDateRangeRule;
import org.kuali.kra.award.subcontracting.reporting.SubcontractingExpenditureCategoryService;
import org.kuali.kra.award.subcontracting.reporting.SubcontractingExpendituresDataGenerationForm;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.util.KNSGlobalVariables;
import org.kuali.rice.kns.web.struts.action.KualiAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@SuppressWarnings("deprecation")
public class SubcontractingExpendituresDataGenerationAction  extends KualiAction {
    
    
    // invoked only on the initial visit from the portal, all subsequent calls will be to other methods
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward(Constants.MAPPING_BASIC);        
    }
    
    public ActionForward regenerateExpenditureDataForAllDates(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        getExpenditureCategoryServiceImpl().populateAllAvailableCategoryExpenses();
        // add the successful regeneration message for display 
        KNSGlobalVariables.getMessageList().add(KeyConstants.EXPENDITURE_DATA_REGENERATED_ALL_DATES);
        return mapping.findForward(Constants.MAPPING_BASIC);
    }
    
    public ActionForward regenerateExpenditureDataInDateRange(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubcontractingExpendituresDataGenerationForm expendituresDataGenerationForm = (SubcontractingExpendituresDataGenerationForm) form;
        Date rangeStartDate = expendituresDataGenerationForm.getRangeStartDate();
        Date rangeEndDate = expendituresDataGenerationForm.getRangeEndDate();
        if( (new SubcontractingExpenditureAmountsInDateRangeRule()).validateDateRange(rangeStartDate, rangeEndDate) ) {
            getExpenditureCategoryServiceImpl().populateCategoryExpensesInDateRange(rangeStartDate, rangeEndDate);
            // add the successful regeneration message for display 
            KNSGlobalVariables.getMessageList().add(KeyConstants.EXPENDITURE_DATA_REGENERATED_IN_RANGE, new String[]{rangeStartDate.toString(), rangeEndDate.toString()});
        }
        return mapping.findForward(Constants.MAPPING_BASIC);
    }
    
    private SubcontractingExpenditureCategoryService getExpenditureCategoryServiceImpl() {
        return KcServiceLocator.getService(SubcontractingExpenditureCategoryService.class);
    } 
    

}
