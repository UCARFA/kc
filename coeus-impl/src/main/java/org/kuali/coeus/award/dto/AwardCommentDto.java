/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.award.dto;

public class AwardCommentDto {

    private Long awardCommentId;
    private String commentTypeCode;
    private Boolean checklistPrintFlag;
    private String comments;

    public Long getAwardCommentId() {
        return awardCommentId;
    }

    public void setAwardCommentId(Long awardCommentId) {
        this.awardCommentId = awardCommentId;
    }

    public String getCommentTypeCode() {
        return commentTypeCode;
    }

    public void setCommentTypeCode(String commentTypeCode) {
        this.commentTypeCode = commentTypeCode;
    }

    public Boolean getChecklistPrintFlag() {
        return checklistPrintFlag;
    }

    public void setChecklistPrintFlag(Boolean checklistPrintFlag) {
        this.checklistPrintFlag = checklistPrintFlag;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
