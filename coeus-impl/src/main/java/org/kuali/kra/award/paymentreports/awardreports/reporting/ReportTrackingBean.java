/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * This class is used for the multi edit of report tracking records.
 */
public class ReportTrackingBean implements Serializable {


    private static final long serialVersionUID = -2415483170400832422L;
    private String preparerId;
    private String preparerName;
    private String statusCode;
    private Date activityDate;
    private String comments;
    public String getPreparerId() {
        return preparerId;
    }
    public void setPreparerId(String preparerId) {
        this.preparerId = preparerId;
    }
    
    public String getPreparerName() {
        return preparerName;
    }
    public void setPreparerName(String preparerName) {
        this.preparerName = preparerName;
    }
    public String getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    public Date getActivityDate() {
        return activityDate;
    }
    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
}
