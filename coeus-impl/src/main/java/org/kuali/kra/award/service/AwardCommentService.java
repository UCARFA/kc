/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.kra.award.home.AwardComment;
import org.kuali.kra.bo.CommentType;

import java.util.List;

/**
 * This is the Award Comment Service interface.
 */
public interface AwardCommentService {

    /**
     * This method gets all of the comment types from database where awardCommentScreenFlag is set to 'Y' so
     * they can be displayed on the Comments, Notes &amp; Attachments tab.
     * @return
     */
    List<CommentType> retrieveCommentTypes();
    
    /**
     * This method retrieves a list of Booleans that indicate whether or not to display the Show History
     * button on the panel.  Each element should correspond to an element returned by retrieveCommentTypes() method.
     * @return
     */
    List<String> retrieveCommentHistoryFlags(String awardId);
    
    /**
     * This method retrieves from the database all Award Comments with the give type code and Award ID for
     * display in view history popup page.
     * @param awardCommentTypeCode
     * @return
     */
    List<AwardComment> retrieveCommentHistoryByType(String awardCommentTypeCode, String awardId);
}
