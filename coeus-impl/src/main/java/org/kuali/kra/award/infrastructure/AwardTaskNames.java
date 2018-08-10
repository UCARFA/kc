/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.infrastructure;


public enum AwardTaskNames {
    MODIFY_AWARD("modifyAward"),VIEW_AWARD("viewAward"),MODIFY_AWARD_ROLES("modifyAwardRoles"),ADD_AWARD_NOTES("addAwardNotes"),
    MAINTAIN_REPORT_TRACKING("maintainReportTracking"),CREATE_AWARD_ACCOUNT("createAwardAccount"),ADMIN_MODIFY_AWARD("adminModifyAward");

    private String awardTaskName;   
     
    AwardTaskNames(String awardTaskName) {
        this.awardTaskName = awardTaskName;
    }    
    
    public String getAwardTaskName() {
        return awardTaskName;
    }

}

