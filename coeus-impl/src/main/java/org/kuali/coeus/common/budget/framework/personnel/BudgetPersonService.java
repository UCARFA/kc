/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import java.util.List;

import org.kuali.coeus.common.budget.api.personnel.BudgetPersonContract;
import org.kuali.coeus.common.budget.api.personnel.BudgetPersonnelDetailsContract;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.framework.rolodex.PersonRolodex;
import org.kuali.coeus.propdev.api.person.ProposalPersonContract;

/**
 * Budget Person Service interface
 */
public interface BudgetPersonService {
    
    /**
     * Populate each Budget Person's system default data, where it is not already populated.
     * 
     * @param budget
     */
    public void populateBudgetPersonDefaultDataIfEmpty(Budget budget);
    
    /**
     * This method will synchronize BudgetPersons with ProposalPersons.  New proposal persons will
     * be copied in.
     * 
     * @param budget
     */
    public void synchBudgetPersonsToProposal(Budget budget);

    /**
     * Adds a new budget person and adds default info. If the budget person is an employee/person
     * then will also create a budget person for each applicable appointment that person has
     * @param budget
     * @param budgetPerson
     */
    public void addBudgetPerson(Budget budget, BudgetPerson budgetPerson);

    /**
     *
     * This method compares a proposal person with budget person. It checks
     * whether the proposal person is from PERSON or ROLODEX and matches the
     * respective person ID with the person in {@link BudgetPersonnelDetails}
     *
     * @param proposalPerson -
     *            key person from proposal
     * @param budgetPersonnelDetails
     *            person from BudgetPersonnelDetails
     * @return true if persons match, false otherwise
     */
    public boolean proposalPersonEqualsBudgetPerson(
            ProposalPersonContract proposalPerson,
            BudgetPersonnelDetailsContract budgetPersonnelDetails);


    public void refreshBudgetPerson(BudgetPerson budgetPerson);
    
    /**
     * This method is to get budget person details
     * @param budget
     * @param budgetPerson
     * @return
     */
    public PersonRolodex getBudgetPersonRolodex(Budget budget, BudgetPersonContract budgetPerson);
    
    /**
     * This method returns the applicable Object Codes (Cost Elements) for a given Budget Person 
     * based on his Job Code
     * @param budget
     * @param personSequenceNumber
     * @return List of Cost Elements
     */
    public List<ValidCeJobCode> getApplicableCostElements(Budget budget, String personSequenceNumber);
    
    /**
     * 
     * This method returns the applicable Object Codes (Cost Elements) for a given Budget Person, converted to string separated by ",".
     * @param budgetId
     * @param personSequenceNumber
     * @param budgetCategoryTypeCode
     * @return List of Cost Elements
     */
    public String getApplicableCostElementsForAjaxCall(Long budgetId, String personSequenceNumber, String budgetCategoryTypeCode);    

}
