/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.core;

public final class QuestionnaireConstants {
	
	/**
	 * field names
	 */
	public static final String QUESTIONNAIRE_ID_PARAMETER_NAME = "id";
	public static final String QUESTIONNAIRE_SEQUENCE_ID_PARAMETER_NAME = "questionnaireSeqId";
	public static final String QUESTIONNAIRE_SEQUENCE_NUMBER_PARAMETER_NAME = "sequenceNumber";

	public static final String QUESTION_SEQEQUENCE_ID = "questionSeqId";
	public static final String QUESTION_ID = "id";
	
	/**
	 * Sequence name
	 */
	public static final String DB_SEQUENCE_NAME_QUESTION_SEQ_ID = "SEQ_QUESTION_ID";
	public static final String MODULE_CODE = "moduleCode";
	public static final String MODULE_ITEM_KEY = "moduleItemKey";
	public static final String MODULE_SUB_ITEM_KEY = "moduleSubItemKey";
	public static final String MODULE_ITEM_CODE = "moduleItemCode";

	private QuestionnaireConstants() {
		throw new UnsupportedOperationException("do not instantiate");
	}

}
