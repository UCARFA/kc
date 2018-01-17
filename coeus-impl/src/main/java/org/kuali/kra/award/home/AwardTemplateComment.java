/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.bo.CommentType;

public class AwardTemplateComment extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -4617051298910760741L;

    private Integer templateCommentsId;

    private AwardTemplate template;

    private String commentTypeCode;

    private CommentType commentType;

    private Boolean checklistPrintFlag;

    private String comments;

    public AwardTemplateComment() {
    }

    public Integer getTemplateCommentsId() {
        return templateCommentsId;
    }

    public void setTemplateCommentsId(Integer templateCommentsId) {
        this.templateCommentsId = templateCommentsId;
    }

    public AwardTemplate getTemplate() {
        return template;
    }

    public void setTemplate(AwardTemplate template) {
        this.template = template;
    }

    /**
     * Gets the commentTypeCode attribute. 
     * @return Returns the commentTypeCode.
     */
    public String getCommentTypeCode() {
        return commentTypeCode;
    }

    /**
     * Sets the commentTypeCode attribute value.
     * @param commentTypeCode The commentTypeCode to set.
     */
    public void setCommentTypeCode(String commentTypeCode) {
        this.commentTypeCode = commentTypeCode;
    }

    /**
     * Gets the commentType attribute. 
     * @return Returns the commentType.
     */
    public CommentType getCommentType() {
        return commentType;
    }

    /**
     * Sets the commentType attribute value.
     * @param commentType The commentType to set.
     */
    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    /**
     * Gets the checklistPrintFlag attribute. 
     * @return Returns the checklistPrintFlag.
     */
    public Boolean getChecklistPrintFlag() {
        return checklistPrintFlag;
    }

    /**
     * Sets the checklistPrintFlag attribute value.
     * @param checklistPrintFlag The checklistPrintFlag to set.
     */
    public void setChecklistPrintFlag(Boolean checklistPrintFlag) {
        this.checklistPrintFlag = checklistPrintFlag;
    }

    /**
     * Gets the comments attribute. 
     * @return Returns the comments.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the comments attribute value.
     * @param comments The comments to set.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
