/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.print;

import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.kra.printing.schema.BudgetSalaryDocument;
import org.kuali.kra.printing.schema.BudgetSalaryDocument.BudgetSalary;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class generates XML that conforms with the XSD related to Budget Summary
 * total Report. The data for XML is derived from {@link org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase}
 * and {@link Map} of details passed to the class.
 * 
 * @author
 * 
 */
@Component("budgetSummaryTotalXmlStream")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BudgetSummaryTotalXmlStream extends BudgetBaseSalaryStream {
	private static final String BUDGET_SUMMARY_TOTAL = "Budget Summary Total";

	/**
	 * This method generates XML for Budget summary total Report. It uses data
	 * passed in {@link org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase} for populating the XML nodes. The
	 * XMl once generated is returned as {@link XmlObject}
	 *
     *
	 * @param printableBusinessObject
	 *            using which XML is generated
	 * @param reportParameters
	 *            parameters related to XML generation
	 * @return {@link XmlObject} representing the XML
	 */
	@Override
    public Map<String, XmlObject> generateXmlStream(
			KcPersistableBusinessObjectBase printableBusinessObject, Map<String, Object> reportParameters) {
		Map<String, XmlObject> xmlObjectList = new LinkedHashMap<String, XmlObject>();
		this.budget = (Budget) printableBusinessObject;
		BudgetSalaryDocument budgetSalaryDocument = BudgetSalaryDocument.Factory
				.newInstance();
		if (budget != null) {
			BudgetSalary budgetSalary = getBudgetSalary();
			budgetSalaryDocument.setBudgetSalary(budgetSalary);
			xmlObjectList.put(BUDGET_SUMMARY_TOTAL, budgetSalaryDocument);
		}
		return xmlObjectList;
	}

	/*
	 * This method set the values to budget salary attributes and return the
	 * budget salary type
	 */
	private BudgetSalary getBudgetSalary() {
		BudgetSalary budgetSalary = getBudgetSalaryTypeXmlObject();
		budgetSalary.setHeaderTitle(BUDGET_SUMMARY_TOTAL);
		budgetSalary.setSalaryArray(getBudgetTotalAndSummarySalaryTypes(true));
		return budgetSalary;
	}
}
