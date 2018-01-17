/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.print;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class BudgetPrintForm extends KcPersistableBusinessObjectBase {

    private String budgetReportId;

    private String budgetReportName;

    private Boolean selectToPrint;
    
    private Boolean selectToComment;

    /**
     * Gets the budgetReportId attribute. 
     * @return Returns the budgetReportId.
     */
    public String getBudgetReportId() {
        return budgetReportId;
    }

    /**
     * Sets the budgetReportId attribute value.
     * @param budgetReportId The budgetReportId to set.
     */
    public void setBudgetReportId(String budgetReportId) {
        this.budgetReportId = budgetReportId;
    }

    /**
     * Gets the budgetReportName attribute. 
     * @return Returns the budgetReportName.
     */
    public String getBudgetReportName() {
        return budgetReportName;
    }

    /**
     * Sets the budgetReportName attribute value.
     * @param budgetReportName The budgetReportName to set.
     */
    public void setBudgetReportName(String budgetReportName) {
        this.budgetReportName = budgetReportName;
    }

    public Boolean getSelectToPrint() {
        return selectToPrint;
    }

    public void setSelectToPrint(Boolean selectToPrint) {
        this.selectToPrint = selectToPrint;
    }

	public Boolean getSelectToComment() {
		return selectToComment;
	}

	public void setSelectToComment(Boolean selectToComment) {
		this.selectToComment = selectToComment;
	}
}
