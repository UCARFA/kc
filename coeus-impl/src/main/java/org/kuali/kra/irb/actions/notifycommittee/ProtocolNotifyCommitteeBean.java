/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notifycommittee;

import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolActionBean;

import java.sql.Date;

/**
 * This class is really just a "form" for notifying the Committee.
 */
public class ProtocolNotifyCommitteeBean extends ProtocolActionBean implements org.kuali.kra.protocol.actions.notifycommittee.ProtocolNotifyCommitteeBean {
    

    private static final long serialVersionUID = 6386919161260179234L;
    
    private String comment = "";
    private String committeeId;
    private Date actionDate = new Date(System.currentTimeMillis());
    
    /**
     * Constructs a ProtocolNotifyCommitteeBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolNotifyCommitteeBean(ActionHelper actionHelper) {
        super(actionHelper);
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Date getActionDate() {
        return actionDate;
    }

    @Override
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    
    @Override
    public String getCommitteeId() {
        return committeeId;
    }

    @Override
    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;        
    }
    
    @Override
    public void prepareView() {
        // we refresh only if the user is not currently working on this task since we do not want to lose user changes
        if( !(TaskName.NOTIFY_COMMITTEE.equalsIgnoreCase(getActionHelper().getCurrentTask())) ) {
            // do nothing, a placeholder for code to be added as fuctionality for this action is fleshed out better 
        }
    }
         
}
