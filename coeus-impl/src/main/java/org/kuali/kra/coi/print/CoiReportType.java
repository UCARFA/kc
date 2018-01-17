/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.print;

/**
 * This class represents different types of reports for COI.
 */
public enum CoiReportType {
    /** Report type for the COI reports that utilize templates. */
    COI_TEMPLATE ("committee_template"),

    /** Report type for the COI correspondence reports that utilize templates. */
    COI_CORRESPONDENCE_TEMPLATE ("protocol_correspondence_template"),

    COI_BATCH_CORRESPONDENCE("coiBatchCorrespondence"),
    
    COI_APPROVED_DISCLOSURE("coiApprovedDisclosure");

    private String coiReportType;

    /**
     * 
     * Constructs a CoiReportType.java.
     * @param coiReportType
     */
    CoiReportType(String coiReportType) {
        this.coiReportType = coiReportType;
    }
    
    public String getCoiReportType() {
        return coiReportType;
    }
}
