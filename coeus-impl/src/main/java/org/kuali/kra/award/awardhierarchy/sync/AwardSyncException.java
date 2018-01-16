/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

/**
 * Exception helpers throw to indicate a warning or exception. Warnings should be reported, but ignored otherwise.
 */
public class AwardSyncException extends RuntimeException {
    private static final long serialVersionUID = -5525034768210252309L;

    private final boolean success;
    private final String statusMessage;
    
    public AwardSyncException(String statusMessage, boolean success) {
        this.statusMessage = statusMessage;
        this.success = success;
    }
    
    public boolean isSuccess() {
        return success;
    } 

    public String getStatusMessage() {
        return statusMessage;
    }
}
