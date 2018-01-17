/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.proposal.framework.report;

import org.kuali.kra.common.web.struts.form.ReportHelperBean;
import org.kuali.kra.common.web.struts.form.ReportHelperBeanContainer;
import org.kuali.rice.kns.web.struts.form.KualiForm;

public class CurrentOrPendingReportForm extends KualiForm implements ReportHelperBeanContainer{
    
    private ReportHelperBean reportHelperBean;
    
    public CurrentOrPendingReportForm(){
        super();
        reportHelperBean = new ReportHelperBean();
    }
    
    public void setReportHelperBean(ReportHelperBean reportHelperBean) {
        this.reportHelperBean = reportHelperBean;
    }

    @Override
    public ReportHelperBean getReportHelperBean() {
         return reportHelperBean;
    }

}
