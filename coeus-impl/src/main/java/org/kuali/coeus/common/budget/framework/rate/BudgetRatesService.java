/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.rate;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface BudgetRatesService {
    void getBudgetRates(List<RateClassType> rateClassTypes, Budget budget);

    /**
     * Searches for persisted {@link RateClass} instances based on the given <code>rateClassType</code>
     *
     * @param rateClassType to use for retrieving {@link RateClass} instances
     * @return a List of {@link RateClass} instances
     */
    Collection<RateClass> getBudgetRateClasses(String rateClassType);

    /**
     * Retrieves {@link RateClass} instances as a {@link Map} keyed from the <code>rateTypeCode</code>. This makes it easy for
     * classes (particularly in the UI) to grab {@link RateClass} information via rateTypeCode
     *
     * @param rateClassType to use for {@link RateClass} instances to be retrieved
     * @return a {@link Map} keyed on rateTypeCode containing {@link RateClass} instances
     */
    Map<String, RateClass> getBudgetRateClassMap(String rateClassType);

    void resetBudgetRatesForRateClassType(String rateClassType, Budget budget);
    void syncBudgetRatesForRateClassType(String rateClassType, Budget budget);
    
    void syncBudgetRateCollectionsToExistingRates(List<RateClassType> rateClassTypes, Budget budget);
    void syncAllBudgetRates(Budget budget);
    void resetAllBudgetRates(Budget budget);
    void viewLocation(String viewLocation, Integer budgetPeriod, Budget budget);

    void populateInstituteRates(Budget budget);

    boolean performSyncFlag(Budget budget);
    void syncParentDocumentRates(Budget budget);
    
    ScaleTwoDecimal getUnitFormulatedCost(String unitNumber,String formulatedType);

    /**
     *
     * This method returns the saved Proposal Rates collection.
     */

    Collection<BudgetRate> getSavedBudgetRates(Budget budget);

    /**
     *
     * This method check if activity type changed, then display confirmation message on 'open' budget version.
     */
    boolean checkActivityTypeChange(Budget budget);

    /**
     *
     * This method checks if activity type changed, then display confirmation message on 'open' budget version.
     */
    boolean checkActivityTypeChange(Collection<BudgetRate> allPropRates, String proposalActivityTypeCode);

    boolean isVacation(String rateClassTypeCode);

    boolean isEmployeeBenefit(String rateClassTypeCode);

    boolean isLabAllocationSalary(String rateClassTypeCode);

    boolean isVacationOnLabAllocation(String rateClassCode, String rateTypeCode);

    boolean isEmployeeBenefitOnLabAllocation(String rateClassCode, String rateTypeCode);

    boolean isOverhead(String rateClassTypeCode);
    
    /**
     * Get the effective salary start date for the budget. 
     * @return the earliest effective date for all persons listed on the budget or null if none exist
     */
    Date getBudgetPersonSalaryEffectiveDate(Budget budget);

    }
