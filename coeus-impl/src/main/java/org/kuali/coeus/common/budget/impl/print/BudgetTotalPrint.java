/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.print;

import org.kuali.coeus.common.budget.framework.print.BudgetPrintType;
import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.stream.xml.XmlStream;
import org.kuali.coeus.common.framework.print.util.PrintingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the implementation for printing Budget Total Report. It
 * generates XML that conforms with Salary Report XSD, fetches XSL style-sheets
 * applicable to this XML, returns XML and XSL for any consumer that would use
 * this XML and XSls for any purpose like report generation, PDF streaming etc.
 * 
 */
@Component("budgetTotalPrint")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BudgetTotalPrint extends AbstractPrint {

    @Autowired
    @Qualifier("budgetTotalXmlStream")
    @Override
    public void setXmlStream(XmlStream budgetTotalXmlStream) {
        super.setXmlStream(budgetTotalXmlStream);
    }

    /**
	 * This method fetches the XSL style-sheets required for transforming the
	 * generated XML into PDF.
	 * 
	 * @return {@link ArrayList}} of {@link Source} XSLs
	 */
	@Override
    public List<Source> getXSLTemplates() {
		List<Source> sourceList = PrintingUtils
				.getXSLTforReport(BudgetPrintType.BUDGET_TOTAL_REPORT
						.getBudgetPrintType());
		return sourceList;
	}

}
