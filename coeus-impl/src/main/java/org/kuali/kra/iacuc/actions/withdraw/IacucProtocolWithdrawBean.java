/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.withdraw;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolActionBean;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.correspondence.IacucProtocolActionsCorrespondence;
import org.kuali.kra.protocol.actions.withdraw.ProtocolWithdrawBean;

import java.sql.Date;

/**
 * This class is really just a "form" containing the reason
 * for withdrawing a protocol.
 */
public class IacucProtocolWithdrawBean extends IacucProtocolActionBean implements ProtocolWithdrawBean {
    

    private static final long serialVersionUID = 4142586313917806739L;
    
    private String reason = "";
    
    private Date actionDate = new Date(System.currentTimeMillis());
    
    /**
     * Constructs a ProtocolWithdrawBean.java.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolWithdrawBean(IacucActionHelper actionHelper) {
        super(actionHelper);
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public Date getActionDate() {
        return actionDate;
    }
    
    @Override
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    /**
     * 
     * This method returns the correct correspondence for this object
     * 
     */
    @Override
    public IacucProtocolActionsCorrespondence getCorrespondence() {
        IacucProtocolActionsCorrespondence correspondence = new IacucProtocolActionsCorrespondence(IacucProtocolActionType.IACUC_WITHDRAWN);
        return correspondence;
    }

}
