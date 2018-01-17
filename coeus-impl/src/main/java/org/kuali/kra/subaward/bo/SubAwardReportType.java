/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;


public class SubAwardReportType extends KcPersistableBusinessObjectBase {

    private Integer subAwardReportTypeCode;
    
    private String description;

    private Integer sortId;

    public Integer getSubAwardReportTypeCode() {
        return subAwardReportTypeCode;
    }

    public void setSubAwardReportTypeCode(Integer subAwardReportTypeCode) {
        this.subAwardReportTypeCode = subAwardReportTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets the sortId attribute. 
     * @return Returns the sortId.
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * Sets the sortId attribute value.
     * @param sortId The sortId to set.
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
    

}
