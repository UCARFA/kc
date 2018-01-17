/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.withdraw;

import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolActionBean;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionsCorrespondenceBase;

import java.sql.Date;

/**
 * This class is really just a "form" containing the reason
 * for withdrawing a protocol.
 */
public class ProtocolWithdrawBean extends ProtocolActionBean implements org.kuali.kra.protocol.actions.withdraw.ProtocolWithdrawBean {
    
    private static final long serialVersionUID = -3244694733749584969L;
    
    private String reason = "";
    
    private Date actionDate = new Date(System.currentTimeMillis());
    
    /**
     * Constructs a ProtocolWithdrawBean.java.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolWithdrawBean(ActionHelper actionHelper) {
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
     * @return a WithdrawCorrespondence object
     */
    @Override
    public ProtocolActionsCorrespondenceBase getCorrespondence() {
        WithdrawCorrespondence correspondence = new WithdrawCorrespondence();
        return correspondence;
    }
}
