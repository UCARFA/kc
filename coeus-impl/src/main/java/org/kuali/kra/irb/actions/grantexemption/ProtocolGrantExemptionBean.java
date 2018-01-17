/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.grantexemption;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.genericactions.ProtocolGenericActionBean;

import java.io.Serializable;
import java.sql.Date;

/**
 * This class is really just a "form" for granting an exemption.
 */
public class ProtocolGrantExemptionBean extends ProtocolGenericActionBean implements Serializable {

    private static final long serialVersionUID = 1066298574931838541L;
    
    private Date approvalDate = new Date(System.currentTimeMillis());

    public ProtocolGrantExemptionBean() {}
    /**
     * Constructs a ProtocolGrantExemptionBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolGrantExemptionBean(ActionHelper actionHelper) {
        super(actionHelper, Constants.PROTOCOL_GRANT_EXEMPTION_ACTION_PROPERTY_KEY);
    }
    
    public Date getApprovalDate() {
        return approvalDate;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public GrantExemptionCorrespondence getCorrespondence() {
        return new GrantExemptionCorrespondence();
    }
    
}
