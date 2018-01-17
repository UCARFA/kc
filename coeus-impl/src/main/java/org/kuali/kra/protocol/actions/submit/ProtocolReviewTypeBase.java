/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.submit;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * A ProtocolBase Review Type refers to the type of review that an
 * IRB Committee will perform, e.g. Full, Expedited, Exempt, etc.
 */
@SuppressWarnings("serial")
public class ProtocolReviewTypeBase extends KcPersistableBusinessObjectBase {

    private String reviewTypeCode;

    private String description;

    private boolean globalFlag;


    public ProtocolReviewTypeBase() {
    }

    public String getReviewTypeCode() {
        return reviewTypeCode;
    }

    public void setReviewTypeCode(String reviewTypeCode) {
        this.reviewTypeCode = reviewTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGlobalFlag() {
        return globalFlag;
    }

    public void setGlobalFlag(boolean globalFlag) {
        this.globalFlag = globalFlag;
    }
}
