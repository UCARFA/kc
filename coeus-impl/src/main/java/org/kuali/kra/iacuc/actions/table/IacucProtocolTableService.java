/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.table;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolDocument;

/**
 * This class is the service API for the protocol "table" action
 */
public interface IacucProtocolTableService {
    
    /**
     * @param committee
     * @param schedule
     * @return the next schedule in order of schedule date, or null if there is no next schedule.
     */
    public CommitteeScheduleBase getNextScheduleForCommittee(CommitteeScheduleBase schedule);
    
    
    
    /**
     * This method will "table" the protocol by bumping it from its current assigned schedule to the next 
     * in order by date for the same committee, will also record the data from the actionBean. 
     * @param protocol
     * @param actionBean
     * @throws Exception 
     */
    public IacucProtocolDocument tableProtocol(IacucProtocol protocol, IacucProtocolTableBean actionBean) throws Exception;

}
