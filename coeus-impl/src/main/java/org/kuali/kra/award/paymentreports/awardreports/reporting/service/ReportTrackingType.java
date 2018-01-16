/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

public enum ReportTrackingType {
    /** Report type for the Approved Disclosure reports that utilize templates. */
    AWARD_REPORT_TRACKING ("awardReportTracking");
    private final String reportTrackingType;

    ReportTrackingType(String reportTrackingType) {
        this.reportTrackingType = reportTrackingType;
    }

    public String getReportTrackingType() {
        return reportTrackingType;
    }
}
