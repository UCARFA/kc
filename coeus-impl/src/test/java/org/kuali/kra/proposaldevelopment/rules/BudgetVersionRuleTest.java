/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.rules;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.budget.core.ProposalAddBudgetVersionEvent;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetVersionRule;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.impl.gv.GlobalVariableServiceImpl;
import org.kuali.rice.kew.api.exception.WorkflowException;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @see org.kuali.coeus.common.budget.framework.version.BudgetVersionRule
 */
public class BudgetVersionRuleTest {
    private static final String VERSION_NAME = "test version";
    private static final String DEFAULT_BUD_VER_NAME = "Default Budget Name";

    private DevelopmentProposal proposal;
    private ProposalBudgetVersionRule versionRule;

    @Before
    public void setUp() throws Exception {
        proposal = new DevelopmentProposal();
        proposal.setBudgets(new ArrayList<ProposalDevelopmentBudgetExt>());
        proposal.setRequestedStartDateInitial(new java.sql.Date(new Date().getDate()));
        proposal.setRequestedEndDateInitial(new java.sql.Date(new Date().getDate()));
        versionRule = new ProposalBudgetVersionRule();
        versionRule.setGlobalVariableService(new GlobalVariableServiceImpl());
    }
        
    @Test
    public void testExistingBudgetVersion() throws WorkflowException {
        addNewBudgetVersion(proposal, VERSION_NAME);
        
        boolean ruleStatus = versionRule.processAddBudgetVersion(new ProposalAddBudgetVersionEvent("addBudgetDto", proposal, VERSION_NAME));
        assertFalse(ruleStatus);
    }

    @Test
    public void testNewBudgetVersion() throws WorkflowException {
        boolean ruleStatus = versionRule.processAddBudgetVersion(new ProposalAddBudgetVersionEvent("addBudgetDto", proposal, VERSION_NAME));

        assertTrue(ruleStatus);
    }

    /**
     * Test a good case. 
     *  
     * @throws Exception
     */
    @Test
    public void testOK() throws Exception {
        assertTrue(versionRule.processAddBudgetVersion(new ProposalAddBudgetVersionEvent("addBudgetDto", proposal, DEFAULT_BUD_VER_NAME)));
    }
    
    /**
     * 
     * This method tests the Null Name field (a.k.a. documentDescription/newBudgetVersionName) negative case.
     * @throws Exception
     */
    @Test
    public void testNegativeNullName() throws Exception {
        assertFalse(versionRule.processAddBudgetVersion(new ProposalAddBudgetVersionEvent("addBudgetDto", proposal, null)));
    }
    
    /**
     * 
     * This method tests the empty Name field (a.k.a. documentDescription/newBudgetVersionName) negative case.
     * @throws Exception
     */
    @Test
    public void testNegativeEmptyName() throws Exception {
        assertFalse(versionRule.processAddBudgetVersion(new ProposalAddBudgetVersionEvent("addBudgetDto", proposal, "")));
    }
    
    /**
     * Adds a fake {@link org.kuali.coeus.common.budget.framework.version.BudgetVersionOverview} with <code>name</code> to the given {@link ProposalDevelopmentDocument}
     *
     * @param document document to add {@link org.kuali.coeus.common.budget.framework.version.BudgetVersionOverview} to
     * @param name of the {@link org.kuali.coeus.common.budget.framework.version.BudgetVersionOverview} to add
     */
    public void addNewBudgetVersion(DevelopmentProposal proposal, String name) {
    	ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
    	budget.setName(name);
        proposal.getBudgets().add(budget);
    }
}

