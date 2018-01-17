/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.notifycommittee;

import org.kuali.kra.protocol.actions.ProtocolActionBean;

import java.io.Serializable;
import java.sql.Date;

public interface ProtocolNotifyCommitteeBean extends ProtocolActionBean, Serializable {
    
    public String getComment();

    public void setComment(String comment);

    public String getCommitteeId();

    public void setCommitteeId(String committeeId);

    public Date getActionDate();

    public void setActionDate(Date actionDate);
    
    public void prepareView();    

}
