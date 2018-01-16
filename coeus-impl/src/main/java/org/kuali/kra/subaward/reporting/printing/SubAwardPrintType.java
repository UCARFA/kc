/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.subaward.reporting.printing;

/**
 * This class represents different types of reports for Negotiation Activity
 * Printing
 */
public enum SubAwardPrintType {
	SUB_AWARD_SF_294_PRINT_TYPE("SF294"),
	SUB_AWARD_SF_295_PRINT_TYPE("SF295"),
	SUB_AWARD_FDP_TEMPLATE("fdpAgreement"),
	SUB_AWARD_FDP_MODIFICATION("fdpModification");
	

	private final String subAwardPrintType;

	SubAwardPrintType(String subAwardPrintType) {
		this.subAwardPrintType = subAwardPrintType;
	}

	public String getSubAwardPrintType() {
		return subAwardPrintType;
	}
}
