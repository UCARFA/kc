/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.infrastructure;


public enum AwardRoleConstants {    

    AWARD_BUDGET_APPROVER("Award Budget Approver"),
    AWARD_BUDGET_ADMINISTRATOR("Award Budget Admnistrator"), AWARD_MODIFIER("Award Modifier"),
    OSP_ADMINISTRATOR("OSP Administrator"), AWARD_BUDGET_AGGREGATOR("Award Budget Aggregator"),
    AWARD_BUDGET_MAINTAINER("Award Budget Maintainer"), AWARD_ATTACHMENTS_MAINTAINER("Award Attachments Maintainer"),
    AWARD_BUDGET_MODIFIER("Award Budget Modifier"),AWARD_VIEWER("Award Viewer"),
    AWARD_BUDGET_VIEWER("Award Budget Viewer"),AWARD_ATTACHMENTS_VIEWER("Award Attachments Viewer"),
    DEPARTMENTS_AWARDS_VIEWER("Departments Awards Viewer"),TEMPLATE_VIEWER("Template Viewer"),
    AWARD_UNASSIGNED("Award Unassigned");

    private String role;   
     
    AwardRoleConstants(String role) {
        this.role = role;
    }    
    
    public String getAwardRole() {
        return role;
    }
}

