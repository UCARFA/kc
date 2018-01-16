/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.onlinereview.lookup;

public interface ProtocolOnlineReviewLookupConstants {

    public static class Property {
        public static final String REVIEWER_EMPLOYEE = "lookupReviewerPersonId";
        public static final String REVIEWER_NONEMPLOYEE = "lookupReviewerRolodexId";
        public static final String PROTOCOL_ID="protocolId";
        public static final String PROTOCOL_NUMBER="lookupProtocolNumber";
        public static final String SUBMISSION_ID="submissionIdFk";
        public static final String DATE_DUE="dateDue";
        public static final String DATE_REQUESTED="dateRequested";
    }
}
