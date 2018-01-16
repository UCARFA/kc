/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * 
 * This class implements the business to check when moving member absent to present voting or present other.
 */
public class MeetingPresentOtherOrVotingRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<MeetingPresentOtherOrVotingEvent> {


    private ErrorReporter errorReporter;

    /**
     * 
     * This method is to validate that the member absent is not an alternate for.
     * This will be called by action 'presentVoting &amp; 'presentOther'
     * @param event
     * @return
     */
@Override
public boolean processRules(MeetingPresentOtherOrVotingEvent event) {
        boolean rulePassed = true;
        errorReporter = KcServiceLocator.getService(ErrorReporter.class);
        for (MemberPresentBean memberPresentBean : event.getMeetingHelper().getMemberPresentBeans()) {
            if (isAlternateFor(memberPresentBean, event.getMemberAbsentBean())) {
                errorReporter.reportError("meetingHelper.memberAbsentBean.attendance.personId",
                        KeyConstants.ERROR_PRESENT_MEMBER_ABSENT, event.getMemberAbsentBean().getAttendance().getPersonName());
                rulePassed = false;
            }

        }

        return rulePassed;
    }
    
    /*
     * check if the member in absent panel is selected as alternate for already
     */
    private boolean isAlternateFor(MemberPresentBean memberPresentBean, MemberAbsentBean memberAbsentBean) {
        boolean isPresent = false;

        if (StringUtils.isNotBlank(memberPresentBean.getAttendance().getAlternateFor())
                && StringUtils.isNotBlank(memberAbsentBean.getAttendance().getPersonId())
                && memberPresentBean.getAttendance().getAlternateFor().equals(memberAbsentBean.getAttendance().getPersonId())) {
            isPresent = true;
        }
        return isPresent;
    }

}
