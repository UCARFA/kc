/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.approve;

import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolRiskLevelCommentable;
import org.kuali.kra.irb.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.kra.irb.actions.risklevel.ProtocolRiskLevelBean;

import java.sql.Date;

/**
 * This class is really just a "form" for approving a protocol.
 */
public class ProtocolApproveBean extends ProtocolGenericActionBean implements org.kuali.kra.protocol.actions.approve.ProtocolApproveBean, ProtocolRiskLevelCommentable {

    private static final long serialVersionUID = 8022339401747868812L;
    
    private Date approvalDate;
    private Date expirationDate;
    
    private String errorPropertyKey;
    private ProtocolRiskLevelBean protocolRiskLevelBean;

    private int defaultExpirationDateDifference;

    public ProtocolApproveBean() {}

    /**
     * Constructs a ProtocolApproveBean.
     * @param actionHelper a reference back to the parent helper
     */
    public ProtocolApproveBean(ActionHelper actionHelper, String errorPropertyKey) {
        super(actionHelper, errorPropertyKey);
        
        this.errorPropertyKey = errorPropertyKey;
        protocolRiskLevelBean = new ProtocolRiskLevelBean(errorPropertyKey);
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
    
    @Override
    public String getErrorPropertyKey() {
        return errorPropertyKey;
    }
       
    @Override
    public ProtocolRiskLevelBean getProtocolRiskLevelBean() {
        return protocolRiskLevelBean;
    }
    
    public int getDefaultExpirationDateDifference() {
        return defaultExpirationDateDifference;
    }

    @Override
    public void setDefaultExpirationDateDifference(int defaultExpirationDateDifference) {
        this.defaultExpirationDateDifference = defaultExpirationDateDifference;
    }
    
}
