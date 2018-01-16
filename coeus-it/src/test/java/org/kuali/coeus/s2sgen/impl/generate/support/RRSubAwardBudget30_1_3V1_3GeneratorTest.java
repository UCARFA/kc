/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;


public class RRSubAwardBudget30_1_3V1_3GeneratorTest extends RRSubAwardBudgetBaseGeneratorTest {

	@Override
	protected String getFormGeneratorName() {
		return RRSubAwardBudget30_1_3V1_3Generator.class.getSimpleName();
	}

	@Override
	protected String getBudgetFormGeneratorName() {
		return RRBudgetV1_3Generator.class.getSimpleName();
	}

	@Override
	protected String getBudgetJustificationNarrativeType() {
		return "7";
	}


}
