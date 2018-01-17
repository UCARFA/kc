/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.approve;

import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;

import java.sql.Date;

/**
 * This class is really just a "form" for approving a protocol.
 */
public interface ProtocolApproveBean extends ProtocolGenericActionBean {
   
    public Date getApprovalDate();
    
    public void setApprovalDate(Date approvalDate);
    
    public Date getExpirationDate();
    
    public void setExpirationDate(Date expirationDate);

    public void setDefaultExpirationDateDifference(int defaultExpirationDateDifference);
    
}
