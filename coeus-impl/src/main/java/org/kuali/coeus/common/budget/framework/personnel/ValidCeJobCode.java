/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.budget.framework.core.CostElement;

public class ValidCeJobCode extends KcPersistableBusinessObjectBase {

    private String costElement;

    private String jobCode;

    private JobCode jobCodeReference;

    private CostElement costElementReference;

    public String getCostElement() {
        return costElement;
    }

    public void setCostElement(String costElement) {
        this.costElement = costElement;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    /**
     * Gets the jobCodeReference attribute. 
     * @return Returns the jobCodeReference.
     */
    public JobCode getJobCodeReference() {
        return jobCodeReference;
    }

    /**
     * Sets the jobCodeReference attribute value.
     * @param jobCodeReference The jobCodeReference to set.
     */
    public void setJobCodeReference(JobCode jobCodeReference) {
        this.jobCodeReference = jobCodeReference;
    }

    /**
     * Gets the costElementReference attribute. 
     * @return Returns the costElementReference.
     */
    public CostElement getCostElementReference() {
        return costElementReference;
    }

    /**
     * Sets the costElementReference attribute value.
     * @param costElementReference The costElementReference to set.
     */
    public void setCostElementReference(CostElement costElementReference) {
        this.costElementReference = costElementReference;
    }
}
