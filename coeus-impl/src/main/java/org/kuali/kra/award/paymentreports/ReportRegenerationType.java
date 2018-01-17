/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports;

/**
 * Enum that displays the different types of regenerations available.
 */
public enum ReportRegenerationType {

    /**
     * Fully regenerate all pending entries.
     */
    REGEN("Regenerate"), 
    /**
     * Never remove entries, only add new ones.
     */
    ADDONLY("Only Add New"),
    /**
     * Do not regenerate or add entries for this report class type.
     */
    NONE("None");
    
    private String description;
    
    ReportRegenerationType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
