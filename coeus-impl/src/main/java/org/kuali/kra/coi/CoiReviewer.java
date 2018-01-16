/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class CoiReviewer extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 8787122160668915118L;

    private String reviewerCode;

    private String description;
    
    public static final String ASSIGNED_REVIEWER = "RVW";
    public static final String REVIEW_COMMITTEE = "COM";
    public static final String OSP_ADMINISTRATOR = "OSP";
    public static final String PRINCIPAL_INVESTIGATOR = "PI";
    
    public String getReviewerCode() {
        return reviewerCode;
    }

    public void setReviewerCode(String reviewerCode) {
        this.reviewerCode = reviewerCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
