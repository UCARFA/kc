/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.infrastructure;

/**
 * 
 * This is used in <code>AwardOnOffCampusValuesFinder</code>.
 */
public enum AwardOnOffCampusFlagConstants {
    On("N", "on"),
    Off("F", "off");


    private final String code;   
    private final String description; 
    AwardOnOffCampusFlagConstants(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String code()   
    { 
        return code; 
    }

    public String description() 
    { 
        return description; 
    }

}

