/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class SubAwardCostType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;
    private String costTypeCode;
    private String costTypeDescription;
    public String getCostTypeCode() {
        return costTypeCode;
    }
    public void setCostTypeCode(String costTypeCode) {
        this.costTypeCode = costTypeCode;
    }
    public String getCostTypeDescription() {
        return costTypeDescription;
    }
    public void setCostTypeDescription(String costTypeDescription) {
        this.costTypeDescription = costTypeDescription;
    }
    
}
