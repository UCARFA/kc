/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.service.AwardJavaFunctionKrmsTermService;
import org.kuali.coeus.common.impl.krms.KcKrmsJavaFunctionTermServiceBase;
import org.kuali.kra.award.home.AwardComment;
import org.kuali.kra.award.specialreview.AwardSpecialReview;

import java.util.Objects;

public class AwardJavaFunctionKrmsTermServiceImpl extends KcKrmsJavaFunctionTermServiceBase implements AwardJavaFunctionKrmsTermService {

    public Boolean checkCommentEntered(Award award, String commentTypeCode) {
        for (AwardComment comment : award.getAwardComments()) {
            if (StringUtils.equals(comment.getCommentTypeCode(), commentTypeCode) && StringUtils.isNotBlank(comment.getComments())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean hasSpecialReviewOfType(Award award, String specialReviewType) {
        return award.getSpecialReviews().stream().anyMatch(awardReview -> doesSpecialReviewMatch(awardReview, specialReviewType));
    }

    public boolean doesSpecialReviewMatch(AwardSpecialReview specialReview, String specialReviewType) {
        return (StringUtils.equals(specialReview.getSpecialReviewTypeCode(), specialReviewType) ||
                specialReview.getSpecialReviewType() != null && StringUtils.equals(specialReview.getSpecialReviewType().getDescription(), specialReviewType));
    }

    @Override
    public Boolean awardPersonnelTotalEffort(Award award, String effortToMatch) {
        ScaleTwoDecimal effort = convertToScaleTwoDecimal(effortToMatch);
        return award.getProjectPersons().size() == 0 ? Boolean.FALSE : award.getProjectPersons().stream().anyMatch(person -> Objects.equals(person.getTotalEffort(), effort));
    }

    @Override
    public Boolean awardPersonnelCalendarEffort(Award award, String effortToMatch) {
        ScaleTwoDecimal effort = convertToScaleTwoDecimal(effortToMatch);
        return award.getProjectPersons().size() == 0 ? Boolean.FALSE : award.getProjectPersons().stream().anyMatch(person -> Objects.equals(person.getCalendarYearEffort(), effort));
    }

    @Override
    public Boolean awardCommentsRule(Award award, String comments, String commentTypeCode) {
        String commentOfSameType = getCommentOfType(commentTypeCode, award);
        return commentOfSameType == null && comments.equalsIgnoreCase("null") ||
                StringUtils.equalsIgnoreCase(comments, commentOfSameType);
    }

    private String getCommentOfType(String commentTypeCode, Award award) {
        AwardComment awardComment = award.getAwardComments().stream().filter(comment -> StringUtils.equals(comment.getCommentTypeCode(), commentTypeCode)).
                                                                                findFirst().orElse(null);
        return awardComment == null? null : awardComment.getComments();
    }

    protected ScaleTwoDecimal convertToScaleTwoDecimal(String effortToMatch) {
        ScaleTwoDecimal effort;
        if (effortToMatch.equalsIgnoreCase("null") || StringUtils.isEmpty(effortToMatch)) {
            effort = null;
        } else {
            effort = new ScaleTwoDecimal(effortToMatch);
        }
        return effort;
    }
}
