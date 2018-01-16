/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolReviewTypeBase;

/**
 * A Protocol Review Type refers to the type of review that an
 * IRB Committee will perform, e.g. Full, Expedited, Exempt, etc.
 */
@SuppressWarnings("serial")
public class ProtocolReviewType extends ProtocolReviewTypeBase {

    public static final String FULL_TYPE_CODE = "1";

    public static final String EXPEDITED_REVIEW_TYPE_CODE = "2";

    public static final String EXEMPT_STUDIES_REVIEW_TYPE_CODE = "3";

    public static final String RESPONSE_REVIEW_TYPE_CODE = "6";

    public static final String FYI_TYPE_CODE = "7";

    private String reviewTypeCode;

    private String description;

    private boolean globalFlag;


    public ProtocolReviewType() {
    }

    @Override
    public String getReviewTypeCode() {
        return reviewTypeCode;
    }

    @Override
    public void setReviewTypeCode(String reviewTypeCode) {
        this.reviewTypeCode = reviewTypeCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isGlobalFlag() {
        return globalFlag;
    }

    @Override
    public void setGlobalFlag(boolean globalFlag) {
        this.globalFlag = globalFlag;
    }
}
