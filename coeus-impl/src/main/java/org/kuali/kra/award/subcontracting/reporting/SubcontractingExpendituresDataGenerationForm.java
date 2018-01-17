/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.subcontracting.reporting;

import org.kuali.rice.kns.web.struts.form.KualiForm;

import java.sql.Date;

@SuppressWarnings("deprecation")
public class SubcontractingExpendituresDataGenerationForm extends KualiForm {  


    private static final long serialVersionUID = 6069838251546593746L;
    
    private Date rangeStartDate;
    private Date rangeEndDate;
    
    public SubcontractingExpendituresDataGenerationForm() {
        super();
    }
    
    public void setRangeStartDate(Date rangeStartDate) {
        this.rangeStartDate = rangeStartDate;
    }


    public Date getRangeStartDate() {
        return rangeStartDate;
    }


    public void setRangeEndDate(Date rangeEndDate) {
        this.rangeEndDate = rangeEndDate;
    }


    public Date getRangeEndDate() {
        return rangeEndDate;
    }

}
