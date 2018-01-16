/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notesandattachments.comments;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.home.AwardComment;
import org.kuali.kra.bo.CommentType;
import org.kuali.kra.award.service.AwardCommentService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains comment helper fields and methods for form and action classes
 */
public class AwardCommentBean implements Serializable {


    private static final long serialVersionUID = -8505814106872342691L;
    private List<CommentType> awardCommentScreenDisplayTypes;
    private AwardForm form;
    

    public AwardCommentBean() {
        
    }
    
    /**
     * 
     * Constructs a AwardCommentBean.java.
     * @param form
     */
    public AwardCommentBean(AwardForm form) {
        this.form = form;
    }
    
    /**
     * Gets the awardCommentScreenDisplayTypes attribute. 
     * @return Returns the awardCommentScreenDisplayTypes.
     */
    public List<CommentType> getAwardCommentScreenDisplayTypes() {
        return awardCommentScreenDisplayTypes;
    }

    /**
     * Sets the awardCommentScreenDisplayTypes attribute value.
     * @param awardCommentScreenDisplayTypes The awardCommentScreenDisplayTypes to set.
     */
    public void setAwardCommentScreenDisplayTypes(List<CommentType> awardCommentScreenDisplayTypes) {
        this.awardCommentScreenDisplayTypes = awardCommentScreenDisplayTypes;
    }

    /**
     * Gets the form attribute. 
     * @return Returns the form.
     */
    public AwardForm getForm() {
        return form;
    }
    
    /**
     * Sets the form attribute value.
     * @param form The form to set.
     */
    public void setForm(AwardForm form) {
        this.form = form;
    }
    
    //
    public void setAwardCommentScreenDisplayTypesOnForm() {
        AwardCommentService awardCommentService = getAwardCommentService();
        setAwardCommentScreenDisplayTypes(awardCommentService.retrieveCommentTypes());
        for (CommentType commentType :  getAwardCommentScreenDisplayTypes()) {
            setupAwardComment(form, commentType);
        }
    }
    
    /*
     * This method is to add awardComment for a commenttype.
     */
    private void setupAwardComment(AwardForm form, CommentType commentType) {
        for (AwardComment awardComment : form.getAwardDocument().getAward().getAwardComments()) {
            if (StringUtils.equals(awardComment.getCommentTypeCode(), commentType.getCommentTypeCode())) {
                return;
            }
        }
        AwardComment awardComment = new AwardComment();
        awardComment.setCommentTypeCode(commentType.getCommentTypeCode());
        awardComment.setCommentType(commentType);
        awardComment.setAwardNumber(form.getAwardDocument().getAward().getAwardNumber());
        form.getAwardDocument().getAward().getAwardComments().add(awardComment);
        
    }
    
    public void setAwardCommentHistoryFlags() {
        List<Boolean> results = new ArrayList<Boolean>();
        List<AwardComment> comments = form.getAwardDocument().getAward().getAwardComments();
        AwardCommentService awardCommentService = getAwardCommentService();
        List<String>allAwardCommentTypes = awardCommentService.retrieveCommentHistoryFlags(form.getAwardDocument().getAward().getAwardNumber());
        for (AwardComment comment : comments) {
            results.add(new Boolean(allAwardCommentTypes.contains(comment.getCommentTypeCode())));
        }
        form.getAwardDocument().getAward().setAwardCommentHistoryFlags(results);
    }
    
    /**
     * 
     * This method is a helper method to retrieve AwardSponsorTermService.
     * @return
     */
    protected AwardCommentService getAwardCommentService() {
        return KcServiceLocator.getService(AwardCommentService.class);
    }

}
