/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.approve;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.genericactions.IacucProtocolGenericActionBean;
import org.kuali.kra.protocol.actions.approve.ProtocolApproveBean;

import java.sql.Date;

public class IacucProtocolApproveBean extends IacucProtocolGenericActionBean implements ProtocolApproveBean {
    

    private static final long serialVersionUID = -8184965873953673608L;
    
    private Date approvalDate;
    private Date expirationDate;
    
    private int defaultExpirationDateDifference;
 
    /**
     * Constructs a ProtocolApproveBean.
     * @param actionHelper a reference back to the parent helper
     */
    public IacucProtocolApproveBean(IacucActionHelper actionHelper, String errorPropertyKey) {
        super(actionHelper, errorPropertyKey);
    }
    
    @Override
    public Date getApprovalDate() {
        return approvalDate;
    }
    
    @Override
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    
    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }
    
    @Override
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getDefaultExpirationDateDifference() {
        return defaultExpirationDateDifference;
    }

    @Override
    public void setDefaultExpirationDateDifference(int defaultExpirationDateDifference) {
        this.defaultExpirationDateDifference = defaultExpirationDateDifference;
    }
 
       
}
