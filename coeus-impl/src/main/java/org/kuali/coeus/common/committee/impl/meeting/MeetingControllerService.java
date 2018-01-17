/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import javax.servlet.http.HttpServletRequest;

/**
 * MeetingControllerService used by Meeting form and action classes
 */
public interface MeetingControllerService {

    /**
     * Populates the MeetingFormBase passed in with the current schedule from the database based on scheduleId.
     */
    void populateSchedule(MeetingFormBase form, HttpServletRequest request, String scheduleId);

}
