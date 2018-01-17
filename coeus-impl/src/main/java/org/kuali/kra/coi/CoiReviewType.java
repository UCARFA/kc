/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * A Coi Review Type refers to the type of review that an
 * COI Committee will perform, e.g. Full, Expedited, Response, etc.
 */
@SuppressWarnings("serial")
public class CoiReviewType extends KcPersistableBusinessObjectBase {

    private String reviewTypeCode;
    private String description;
    

    public CoiReviewType() {
        
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
}

