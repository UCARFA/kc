/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.print;

import edu.mit.irb.irbnamespace.PersonDocument.Person;
import edu.mit.irb.irbnamespace.ProtocolDocument.Protocol.Submissions;
import edu.mit.irb.irbnamespace.ProtocolSubmissionDocument.ProtocolSubmission;
import edu.mit.irb.irbnamespace.ScheduleDocument.Schedule;
import edu.mit.irb.irbnamespace.SubmissionDetailsDocument.SubmissionDetails;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.irb.personnel.ProtocolPerson;
import org.kuali.kra.irb.personnel.ProtocolPersonRolodex;

/**
 * This class has different helper methods to populate data for Person XML data.
 */
public interface IrbPrintXmlUtilService {
    public void setPersonXml(KcPerson person, Person personType);
    public void setPersonXml(ProtocolPersonRolodex rolodex, Person personType);
    public void setPersonRolodexType(ProtocolPerson protocolPerson, Person personType);
    public void setProtocolSubmissionAction(org.kuali.kra.irb.actions.submit.ProtocolSubmission protocolSubmission,
            SubmissionDetails protocolSubmissionDetail);
    public void setSubmissionCheckListinfo(org.kuali.kra.irb.actions.submit.ProtocolSubmission protocolSubmission,
            SubmissionDetails protocolSubmissionDetail);
    public void setMinutes(CommitteeSchedule scheduleDetailsBean, Schedule schedule);
    public void setProcotolMinutes(CommitteeSchedule committeeSchedule, 
            org.kuali.kra.irb.actions.submit.ProtocolSubmissionLite protocolSubmission, ProtocolSubmission protocolSubmissionType);
    public void setProcotolSubmissionMinutes(CommitteeSchedule committeeSchedule,
            org.kuali.kra.irb.actions.submit.ProtocolSubmission protocolSubmission, Submissions submissionsType);
    
    public void setProtocolReviewMinutes(CommitteeSchedule committeeSchedule,
            org.kuali.kra.irb.actions.submit.ProtocolSubmission protocolSubmission, Submissions submissionsType);
    
}
