/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class CoiReviewStatus extends KcPersistableBusinessObjectBase {
    


    private static final long serialVersionUID = -7843513213298067208L;
    private String reviewStatusCode; 
    private String description; 
    private boolean statusUpdatedOnlyByAction;
    
    public static final String IN_PROGRESS = "1";
    public static final String SUBMITTED_FOR_REVIEW = "2";
    public static final String ASSIGNED_TO_REVIEWER = "3";
    public static final String ASSIGNED_REVIEW_COMPLETE = "4";
    public static final String REVIEW_COMPLETE = "5";
    
    public CoiReviewStatus() { 

    } 
    
    public String getReviewStatusCode() {
        return reviewStatusCode;
    }

    public void setReviewStatusCode(String reviewStatusCode) {
        this.reviewStatusCode = reviewStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatusUpdatedOnlyByAction() {
        return statusUpdatedOnlyByAction;
    }

    public void setStatusUpdatedOnlyByAction(boolean statusUpdatedOnlyByAction) {
        this.statusUpdatedOnlyByAction = statusUpdatedOnlyByAction;
    }

}
