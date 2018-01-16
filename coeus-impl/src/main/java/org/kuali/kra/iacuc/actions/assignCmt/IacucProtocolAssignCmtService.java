/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.assignCmt;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;


public interface IacucProtocolAssignCmtService {
    
    public void assignToCommittee(ProtocolBase protocol, IacucProtocolAssignCmtBean actionBean) throws Exception;

    public String getAssignedCommitteeId(ProtocolBase protocol);
    
    public String getAssignedScheduleId(ProtocolBase protocol);
    
    public ProtocolSubmissionBase getLastSubmission(ProtocolBase protocol);

}
