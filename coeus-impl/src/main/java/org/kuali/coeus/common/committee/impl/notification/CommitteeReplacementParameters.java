/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.notification;

/**
 * 
 * This class defines the replacement parameters available for the IRB coeus module
 */
public class CommitteeReplacementParameters {

    public static final String DOCUMENT_NUMBER = "{DOCUMENT_NUMBER}";
    public static final String SEQUENCE_NUMBER = "{SEQUENCE_NUMBER}";
    public static final String COMMITTEE_NAME = "{COMMITTEE_NAME}";
    public static final String ACTION_TAKEN = "{ACTION_TAKEN}";
    public static final String LAST_ACTION_DATE = "{LAST_ACTION_DATE}";
    public static final String OBJECT_INDEX = "{OBJECT_INDEX}";
    public static final String SCHEDULE_ID = "{SCHEDULE_ID}";
    
    public static final String[] REPLACEMENT_PARAMETERS = new String[] { DOCUMENT_NUMBER,
                                                                         SEQUENCE_NUMBER, 
                                                                         COMMITTEE_NAME,
                                                                         ACTION_TAKEN, 
                                                                         LAST_ACTION_DATE,
                                                                         OBJECT_INDEX,
                                                                         SCHEDULE_ID
                                                                       };
}
