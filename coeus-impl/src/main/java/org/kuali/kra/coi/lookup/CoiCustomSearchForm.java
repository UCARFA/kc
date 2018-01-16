/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup;

import org.kuali.rice.kns.web.struts.form.KualiForm;

public class CoiCustomSearchForm extends KualiForm {

    private static final long serialVersionUID = 8609723442875002645L;
    
    private CustomAdminSearchHelper customAdminSearchHelper;
    private boolean canQuickApprove;
    
    public CoiCustomSearchForm() {
        customAdminSearchHelper = new CustomAdminSearchHelper();
    }

    public CustomAdminSearchHelper getCustomAdminSearchHelper() {
        return customAdminSearchHelper;
    }

    public void setCustomAdminSearchHelper(CustomAdminSearchHelper customAdminSearchHelper) {
        this.customAdminSearchHelper = customAdminSearchHelper;
    }

    public boolean isCanQuickApprove() {
        return canQuickApprove;
    }

    public void setCanQuickApprove(boolean canQuickApprove) {
        this.canQuickApprove = canQuickApprove;
    }
}
