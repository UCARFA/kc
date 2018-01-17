/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolReviewTypeBase;

/**
 * A Protocol Review Type refers to the type of review that an
 * IACUC Committee will perform
 */
@SuppressWarnings("serial")
public class IacucProtocolReviewType extends ProtocolReviewTypeBase {

    public static final String ADMINISTRATIVE_REVIEW = "1";
    
    public static final String DESIGNATED_MEMBER_REVIEW = "2";
    
    public static final String FULL_COMMITTEE_REVIEW = "3";
    
    public static final String FYI = "4";

    public static final String RESPONSE = "5";

    public static final String IACUC_REVIEW_NOT_REQUIRED = "6";


    public IacucProtocolReviewType() {
    }

}
