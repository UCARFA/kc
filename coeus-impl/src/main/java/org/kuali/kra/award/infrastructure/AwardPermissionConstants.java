/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.infrastructure;


public enum AwardPermissionConstants {
        VIEW_ANY_PROPOSAL("View Any Proposal"),APPROVE_AWARD_BUDGET("Approve AwardBudget"),CREATE_AWARD_BUDGET("Create AwardBudget")
        ,MODIFY_AWARD_BUDGET("Modify AwardBudget"),SUBMIT_AWARD_BUDGET("Submit AwardBudget"),VIEW_AWARD_BUDGET("View AwardBudget")
        ,MAINTAIN_AWARD_BUDGET_ROUTING("Maintain AwardBudgetRouting"),POST_AWARD_BUDGET("Post AwardBudget")
        ,CREATE_AWARD("Create Award"),MAINTAIN_REPORTING_REQUIREMENTS("Maintain Reporting Requirements")
        ,MODIFY_AWARD("Modify Award"),VIEW_AWARD("View Award"),MAINTAIN_NOTEPAD_ENTRIES("Maintain Notepad Entries")
        ,MAINTAIN_AWARD_ATTACHMENTS("Maintain Award Attachments")
        ,SUBMIT_AWARD("Submit Award")
        ,VIEW_AWARD_ATTACHMENTS("View Award Attachments"),VIEW_AWARDS_AT_UNIT("View Award At Unit"),VIEW_AWARD_TEMPLATE("View Award Template")
        ,MODIFY_AWARD_REPORT_TRACKING("Modify Award Report Tracking"),CREATE_AWARD_ACCOUNT("Create Award Account"), POST_AWARD("Post Award")
        ,SEND_AWARD_NOTICE("Send Award Notice"),ADMIN_MODIFY_AWARD("Admin Modify Award");

    private String permission;   
     
    AwardPermissionConstants(String permission) {
        this.permission = permission;
    }    
    
    public String getAwardPermission() {
        return permission;
    }

}

