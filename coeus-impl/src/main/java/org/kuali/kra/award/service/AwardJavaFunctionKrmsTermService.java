/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.coeus.common.framework.krms.KcKrmsJavaFunctionTermService;
import org.kuali.kra.award.home.Award;

public interface AwardJavaFunctionKrmsTermService extends KcKrmsJavaFunctionTermService {
    Boolean checkCommentEntered(Award award, String commentTypeCode);
    Boolean awardPersonnelTotalEffort(Award award, String effortToMatch);
    Boolean awardPersonnelCalendarEffort(Award award, String effortToMatch);
    Boolean awardCommentsRule(Award award, String comments, String commentTypeCode);
    Boolean hasSpecialReviewOfType(Award award, String specialReviewTypeCode);
}
