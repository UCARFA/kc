/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.printing;

/**
 * This class represents different parameters of reports for Award Printing
 */
public enum AwardPrintParameters {
		ADDRESS_LIST("addressList"), 
		FOREIGN_TRAVEL("foreignTravel"), 
		REPORTING("reporting"), CLOSEOUT("closeout"), 
		FUNDING_SUMMARY("fundingSummary"), 
		SPECIAL_REVIEW("specialReview"), 
		COMMENTS("comments"), 
		HIERARCHY_INFO("hierarchyInfo"), 
		SUBCONTRACT("subcontract"), 
		COST_SHARING("costSharing"), 
		KEYWORDS("keywords"), 
		TECHNICAL_REPORTING("technicalReporting"), 
		EQUIPMENT("equipment"), 
		OTHER_DATA("otherData"), 
		TERMS("terms"), 
		FA_COST("fACost"), 
		PAYMENT("payment"), 
		FLOW_THRU("flowThru"), 
		PROPOSAL_DUE("proposalDue"), 
		INDIRECT_COST("indirectCost"), 
		SCIENCE_CODE("scienceCode"), 
		SIGNATURE_REQUIRED("signatureRequired"), 
		SEQUENCE_NUMBER("sequenceNumber"), 
		TRANSACTION_ID("transactionId"), 
		TRANSACTION_ID_INDEX("transactionIdIndex");
		
	private final String awardPrintParameter;

	AwardPrintParameters(String awardPrintParameter) {
		this.awardPrintParameter = awardPrintParameter;
	}

	public String getAwardPrintParameter() {
		return awardPrintParameter;
	}

}
