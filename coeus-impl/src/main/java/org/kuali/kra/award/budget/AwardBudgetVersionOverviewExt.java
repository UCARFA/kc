/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.common.budget.framework.summary.BudgetSummaryService;
import org.kuali.coeus.common.budget.framework.version.BudgetVersionOverview;

import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;


public class AwardBudgetVersionOverviewExt extends BudgetVersionOverview {


    private static final long serialVersionUID = -8402075117207933626L;

    private String awardBudgetStatusCode;

    private String awardBudgetTypeCode;

    private ScaleTwoDecimal obligatedAmount;

    private AwardBudgetStatus awardBudgetStatus;

    private AwardBudgetType awardBudgetType;

    private String description;

    private String budgetInitiator;

    public AwardBudgetVersionOverviewExt() {
        super();
    }

    public String getAwardBudgetStatusCode() {
        return awardBudgetStatusCode;
    }

    public void setAwardBudgetStatusCode(String awardBudgetStatusCode) {
        this.awardBudgetStatusCode = awardBudgetStatusCode;
    }

    public String getAwardBudgetTypeCode() {
        return awardBudgetTypeCode;
    }

    public void setAwardBudgetTypeCode(String awardBudgetTypeCode) {
        this.awardBudgetTypeCode = awardBudgetTypeCode;
    }

    public AwardBudgetStatus getAwardBudgetStatus() {
        return awardBudgetStatus;
    }

    public void setAwardBudgetStatus(AwardBudgetStatus awardBudgetStatus) {
        this.awardBudgetStatus = awardBudgetStatus;
    }

    public AwardBudgetType getAwardBudgetType() {
        return awardBudgetType;
    }

    public void setAwardBudgetType(AwardBudgetType awardBudgetType) {
        this.awardBudgetType = awardBudgetType;
    }

    /**
     * Gets the obligatedAmount attribute. 
     * @return Returns the obligatedAmount.
     */
    public ScaleTwoDecimal getObligatedAmount() {
        return obligatedAmount;
    }

    /**
     * Sets the obligatedChangeAmount attribute value.
     * @param obligatedChangeAmount The obligatedChangeAmount to set.
     */
    public void setObligatedAmount(ScaleTwoDecimal obligatedChangeAmount) {
        this.obligatedAmount = obligatedChangeAmount;
    }

    public String getOnOffCampusFlagDescription() {
        return getBudgetSummaryService().getOnOffCampusFlagDescription(getOnOffCampusFlag());
    }

    public BudgetSummaryService getBudgetSummaryService() {
        return getService(BudgetSummaryService.class);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBudgetInitiator() {
        return budgetInitiator;
    }

    public void setBudgetInitiator(String budgetInitiator) {
        this.budgetInitiator = budgetInitiator;
    }
}
