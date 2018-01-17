/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

/**
 * 
 * This class holds the action types for notifications and possible drools use.  This
 * is intended as a placeholder until a more complete solution is implemented
 */
public class CoiActionType {

    //These numbers are arbitrary, just don't duplicate
    public static final String ASSIGN_REVIEWER = "205";
    public static final String CERTIFIED_EVENT = "214";
    public static final String APPROVED_EVENT = "204";
    public static final String DISAPPROVED_EVENT = "304";
    public static final String REVIEW_COMPLETE_EVENT = "805";
    
    public static final String FE_CREATED_EVENT = "845";
    public static final String FE_MODIFIED_EVENT = "846";
}
