/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notification;

/**
 * 
 * This class defines the replacement parameters available for the COI module
 */
public class CoiReplacementParameters {

    public static final String DOCUMENT_NUMBER = "{DOCUMENT_NUMBER}";
    public static final String SEQUENCE_NUMBER = "{SEQUENCE_NUMBER}";
    public static final String DISCLOSURE_ID = "{DISCLOSURE_ID}";
    public static final String DISCLOSURE_TYPE = "{DISCLOSURE_TYPE}";
    public static final String DISCLOSURE_NUMBER = "{DISCLOSURE_NUMBER}";
    public static final String DISCLOSURE_REPORTER = "{DISCLOSURE_REPORTER}";
    public static final String DISCLOSURE_STATUS = "{DISCLOSURE_STATUS}";
    
    public static final String[] REPLACEMENT_PARAMETERS = new String[] { DOCUMENT_NUMBER,
                                                                         SEQUENCE_NUMBER,
                                                                         DISCLOSURE_ID,
                                                                         DISCLOSURE_TYPE,
                                                                         DISCLOSURE_NUMBER,
                                                                         DISCLOSURE_REPORTER,
                                                                         DISCLOSURE_STATUS,
                                                                       };
}
