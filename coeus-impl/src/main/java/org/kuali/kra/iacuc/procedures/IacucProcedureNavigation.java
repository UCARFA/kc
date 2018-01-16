/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.procedures;

/**
 * This class represents different possible enumerations of iacuc procedure details navigation
 */
public enum IacucProcedureNavigation {
    PROCEDURES("procedures", "updateProcedures"),
    PERSONNEL("personnel", "updatePersonnel"),
    LOCATION("location", "updateLocation"),
    SUMMARY("summary", "updateSummary");

    private final String displayName;
    private final String methodName;
    
    IacucProcedureNavigation(String displayName, String methodName){
        this.displayName = displayName;
        this.methodName = methodName;
    }
    
    public String getDisplayName(){
        return displayName;
    }
    
    public String getMethodName(){
        return methodName;
    }

}
