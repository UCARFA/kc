/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.noreview;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.IacucProtocolActionBean;
import org.kuali.kra.protocol.actions.ActionHelperBase;
import org.kuali.kra.protocol.actions.noreview.ProtocolReviewNotRequiredBean;

import java.sql.Date;

/**
 * This class manages the HTML Elements needed for the review not required panel.
 */
public class IacucProtocolReviewNotRequiredBean extends IacucProtocolActionBean implements ProtocolReviewNotRequiredBean {

    private static final long serialVersionUID = -8686091412369007790L;
    
    private String comments = "";
    private Date actionDate = new Date(System.currentTimeMillis());
    private Date decisionDate = new Date(System.currentTimeMillis());

    /**
     * Constructs a ProtocolReviewNotRequiredBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolReviewNotRequiredBean(ActionHelperBase actionHelper) {
        super(actionHelper);
    }

    public IacucProtocol getIacucProtocol() {
        return (IacucProtocol)getProtocol();
    }
    

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public void setComments(String comments) {
        this.comments = comments;
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
    public Date getDecisionDate() {
        return decisionDate;
    }

    @Override
    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }    
}
