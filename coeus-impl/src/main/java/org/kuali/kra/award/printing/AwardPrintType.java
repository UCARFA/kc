/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.printing;

/**
 * This class represents different types of reports for award Printing
 */
public enum AwardPrintType {

	AWARD_DELTA_REPORT("awardDeltaReport"), AWARD_NOTICE_REPORT(
			"awardNoticeReport"), AWARD_TEMPLATE("awardTemplate"), AWARD_BUDGET_HIERARCHY(
			"awardBudgetHierarchy"), AWARD_BUDGET_HISTORY_TRANSACTION(
			"awardBudgetHistoryTransaction"),MONEY_AND_END_DATES_HISTORY("moneyAndEndDatesHistory");
	private final String awardPrintType;

	AwardPrintType(String awardPrintType) {
		this.awardPrintType = awardPrintType;
	}

	/**
	 * This method will return the report name,Which ever called.
	 * 
	 * @return report name
	 */
	public String getAwardPrintType() {
		return awardPrintType;
	}
}
