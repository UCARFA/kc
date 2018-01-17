/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.kuali.coeus.common.committee.impl.meeting.MeetingControllerService;
import org.kuali.coeus.common.committee.impl.meeting.MeetingFormBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;

/**
 * 
 * This class is a form for Meeting management,
 */
public class MeetingForm extends MeetingFormBase {
    

    private static final long serialVersionUID = -8524010367028447411L;

    @Override
    protected MeetingHelper getNewMeetingHelperInstanceHook(MeetingFormBase meetingForm) {
        return new MeetingHelper(meetingForm);
    }

    @Override
    protected MeetingControllerService getMeetingControllerService() {
        return KcServiceLocator.getService("meetingControllerService");
    }
}
