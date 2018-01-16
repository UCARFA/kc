/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.kns.web.struts.action.KualiAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This class for UnitHierarchy
 */
public class UnitHierarchyAction extends KualiAction {
    //nothing needed here yet
    
    public ActionForward expandAllUnitHierarchy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UnitHierarchyForm unitForm = (UnitHierarchyForm) form;
        unitForm.setDisplayWholeTree(true);
        unitForm.resetUnits();
        return mapping.findForward(Constants.MAPPING_BASIC);
        
    }
    
    public ActionForward collapseAllUnitHierarchy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UnitHierarchyForm unitForm = (UnitHierarchyForm) form;
        unitForm.setDisplayWholeTree(false);
        unitForm.resetUnits();
        return mapping.findForward(Constants.MAPPING_BASIC);
        
    }
}
