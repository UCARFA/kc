/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.print;

import java.util.List;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.impl.print.BudgetPrintForm;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;

public interface BudgetPrintService {
	
	/**
	 * Populates the various forms that are part of Budget on UI
	 * @param budget
	 */
    public void populateBudgetPrintForms(Budget budget);
    
    /**
     * Generates the report specified and returns the bytes
     * 
     * @param budget {@link Budget}
     * @param selectedBudgetPrintFormId form to print
     * @return {@link AttachmentDataSource} bytes of the generated form
     */
    public AttachmentDataSource readBudgetPrintStream(Budget budget, String selectedBudgetPrintFormId);
    
    /**
     * Generates the selected reports and returns the bytes
     * 
     * @param budget {@link Budget}
     * @param budgetPrintForms {@link BudgetPrintForm} selected forms to print
     * @param reportName report to be generated
     * @return {@link AttachmentDataSource} bytes of the generated form
     */
    public AttachmentDataSource readBudgetSelectedPrintStreams(Budget budget, List<BudgetPrintForm> budgetPrintForms, String reportName);
}
