/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.service;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleMinuteBase;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;


public interface CommitteeScheduleServiceBase<CS extends CommitteeScheduleBase<CS, CMT, ?, CSM>, 
                                                CMT extends CommitteeBase<CMT,?,CS>,
                                                CSM extends CommitteeScheduleMinuteBase<CSM, CS>> {
    
    /**
     * This method implementer must check if passed CommitteeScheduleBase is deleteable.
     *
     * Rule:
     *
     * Any past schedule date must not be allowed to delete.
     *
     * Allow delete if NO Protocol is assigned to CommitteeScheduleBase.
     * @param committeeSchedule
     * @return
     */
    public Boolean isCommitteeScheduleDeletable(CS committeeSchedule);
    
    /**
     * This method implementer must add new non conflicting, non-repeating schedule dates to existing CommitteeBase.CommitteeScheduleBase list.
     * @param scheduleData
     * @param committee
     * @throws ParseException
     */
    public void addSchedule(ScheduleData scheduleData, CMT committee) throws ParseException;
    
    /**
     * 
     * This method returns a list of minutes based on a protocol ID
     * @param protocolId
     * @return
     */
    public List<CSM> getMinutesByProtocol(Long protocolId);

    /**
     * This method will downloadAttachment  to CommitteeScheduleAttachmentsBase.
     * @param committeScheduleAttachments
     * @return
     */
     public void downloadAttachment(KcPersistableBusinessObjectBase attachmentDataSource, HttpServletResponse response) throws Exception;
}
