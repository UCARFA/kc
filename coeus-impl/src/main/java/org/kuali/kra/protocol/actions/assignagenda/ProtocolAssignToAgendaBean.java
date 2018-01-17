/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.assignagenda;

import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;

import java.io.Serializable;

/**
 * This class is really just a "form" for assigning a protocol to an agenda.
 */
public interface ProtocolAssignToAgendaBean extends ProtocolGenericActionBean, Serializable {


    public void setCommitteeId(String committeeId);

    public void setCommitteName(String committeName);


    public void setScheduleDate(String scheduleDate);


    public void setProtocolAssigned(boolean protocolAssigned);

    public String getCommitteeId();


    public String getCommitteName();


    public String getScheduleDate();


    public boolean isProtocolAssigned();

    /**
     * Prepare the Assign to Committee and Schedule for rendering with JSP.
     */
    public void prepareView();
    
    /**
     * 
     * This method returns the appropriate printable for this class
     * @return a Printable
     */
    public Printable getCorrespondence();
    
}
