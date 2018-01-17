/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.schedule;


import org.kuali.coeus.propdev.impl.s2s.S2sAppSubmission;

/**
 * 
 * This class is a wrapper around {@link org.kuali.coeus.propdev.impl.s2s.S2sAppSubmission} business object. IT helps in storing some additional information related
 * to scheduling that is in addition to the opportunity submission information that is available in the business object.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class SubmissionData {
    private char acType;
    private S2sAppSubmission s2sAppSubmission;
    private String sortId;


    /**
     * Getter for BO {@link S2sAppSubmission}
     * 
     * @return {@link S2sAppSubmission)
     */
    public S2sAppSubmission getS2sAppSubmission() {
        return s2sAppSubmission;
    }

    /**
     * Setter for BO {@link S2sAppSubmission}
     * 
     * @param {@link S2sAppSubmission}
     */
    public void setS2sAppSubmission(S2sAppSubmission appSubmission) {
        s2sAppSubmission = appSubmission;
    }


    /**
     * Getter for property acType.
     * 
     * @return Value of property acType.
     */
    public char getAcType() {
        return acType;
    }

    /**
     * Setter for property acType.
     * 
     * @param acType New value of property acType.
     */
    public void setAcType(char acType) {
        this.acType = acType;
    }

    /**
     * Getter for property sortId.
     * 
     * @return Value of property sortId.
     */
    public java.lang.String getSortId() {
        return sortId;
    }

    /**
     * Setter for property sortId.
     * 
     * @param sortId New value of property sortId.
     */
    public void setSortId(java.lang.String sortId) {
        this.sortId = sortId;
    }
}
