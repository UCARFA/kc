/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rpt.cust;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;


public class CustReportType extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer reportTypeCode; 
    private String reportTypeDesc; 
    
    public CustReportType() { 

    }


    /**
     * Gets the reportTypeCode attribute. 
     * @return Returns the reportTypeCode.
     */
    public Integer getReportTypeCode() {
        return reportTypeCode;
    }

    /**
     * Sets the reportTypeCode attribute value.
     * @param reportTypeCode The reportTypeCode to set.
     */
    public void setReportTypeCode(Integer reportTypeCode) {
        this.reportTypeCode = reportTypeCode;
    }

    /**
     * Gets the reportTypeDesc attribute. 
     * @return Returns the reportTypeDesc.
     */
    public String getReportTypeDesc() {
        return reportTypeDesc;
    }

    /**
     * Sets the reportTypeDesc attribute value.
     * @param reportTypeDesc The reportTypeDesc to set.
     */
    public void setReportTypeDesc(String reportTypeDesc) {
        this.reportTypeDesc = reportTypeDesc;
    }
}
