/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.assignCmt;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.actions.IacucProtocolActionBean;
import org.kuali.kra.protocol.actions.ActionHelperBase;

import java.io.Serializable;

public class IacucProtocolAssignCmtBean extends  IacucProtocolActionBean implements Serializable {


    private static final long serialVersionUID = -4408101740397922792L;
    private String committeeId = "";
    private String newCommitteeId = "";

    public void init() {
        String committeeId = getAssignCmtService().getAssignedCommitteeId(getProtocol());
        if (committeeId != null) {
            this.newCommitteeId = committeeId;
            this.committeeId = committeeId;
        }
    }
    
    public IacucProtocolAssignCmtBean(ActionHelperBase actionHelper) {
        super(actionHelper);
    }

    public String getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
    }

    public String getNewCommitteeId() {
        return newCommitteeId;
    }

    public void setNewCommitteeId(String newCommitteeId) {
        this.newCommitteeId = newCommitteeId;
    }
   
    protected IacucProtocolAssignCmtService getAssignCmtService() {
        return KcServiceLocator.getService(IacucProtocolAssignCmtService.class);
    }
}
