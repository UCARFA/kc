/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

public final class AwardConstants {

	public static final String STATE_SPONSOR_TYPE_PARAM = "STATE_SPONSOR_TYPE";
	public static final String INVOICE_REPORT_DESC_PARAM = "FIN_SYS_INVOICE_REPORT_DESC";
	public static final String ROOT_AWARD_SUFFIX = "-00001";
	public static final String AWARD_ID = "awardId";
	public static final String AWARD_NUMBER = "awardNumber";
	public static final String AWARD_REPORT_TERM_ID = "awardReportTermId";
	public static final String AWARD_SEQUENCE_STATUS = "awardSequenceStatus";
	public static final String MAX_AWARD_ID = "max(awardId)";

	private AwardConstants() {
		throw new UnsupportedOperationException();
	}
}
