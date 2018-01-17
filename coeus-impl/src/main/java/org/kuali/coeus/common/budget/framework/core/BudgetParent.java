/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.common.framework.type.ActivityType;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.coeus.common.framework.rolodex.PersonRolodex;

import java.sql.Date;
import java.util.List;


public interface BudgetParent {
    String getBudgetStatus();
    void setBudgetStatus(String budgetStatus);
    String getActivityTypeCode();
    Date getRequestedStartDateInitial();
    Date getRequestedEndDateInitial();
    ActivityType getActivityType();
    String getUnitNumber();
    Unit getUnit();
    List<? extends PersonRolodex> getPersonRolodexList();
    ContactRole getProposalNonEmployeeRole(Integer rolodexId);
    PersonRolodex getProposalEmployee(String personId);
    PersonRolodex getProposalNonEmployee(Integer rolodexId);
    ContactRole getProposalEmployeeRole(String personId);
    String getHierarchyStatus();
    String getDefaultBudgetStatusParameter();
    boolean isParentInHierarchyComplete();
    
    String getParentNumber();
    String getParentTitle();
    String getParentPIName();
    String getOwnedByUnitNumber();
    Integer getParentInvestigatorFlag(String personId, Integer flag);
    String  getParentTypeName();
	boolean isProposalBudget();
	
	BudgetParentDocument<? extends BudgetParent> getDocument();
	List<? extends Budget> getBudgets();
	Budget getNewBudget();
	Integer getNextBudgetVersionNumber();
	
}
