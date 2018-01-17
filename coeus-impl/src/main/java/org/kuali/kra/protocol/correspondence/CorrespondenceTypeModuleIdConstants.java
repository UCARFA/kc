/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

/**
 * 
 * This class used in the CorrespondenceTypeModuleIdValuesFinder.
 */
public enum CorrespondenceTypeModuleIdConstants {
    SYSTEM("Y", "System"),
    PROTOCOL("P", "Protocol"),
    SCHEDULE("S", "Schedule"),
    PROTOCOL_SUBMISSION("U", "Protocol Submission"),
    COMMITTEE("C", "Committee");
    
    private final String code;   
    private final String description; 
    CorrespondenceTypeModuleIdConstants(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode()   
    { 
        return code; 
    }

    public String getDescription() 
    { 
        return description; 
    }

}
