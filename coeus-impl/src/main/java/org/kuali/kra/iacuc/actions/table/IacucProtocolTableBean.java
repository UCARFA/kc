/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.table;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolActionBean;

import java.io.Serializable;
import java.sql.Date;

/**
 * This class is really just a "form" containing the comments and action date 
 * for tabling an IACUC protocol.
 */
public class IacucProtocolTableBean extends IacucProtocolActionBean implements Serializable {
    

    private static final long serialVersionUID = 6076002106217543225L;
    
    private String comments = "";
    private Date actionDate = new Date(System.currentTimeMillis());


    /**
     * Constructs a IacucProtocolTableBean
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolTableBean(IacucActionHelper actionHelper) {
        super(actionHelper);
    }
    
    public String getComments() {
        return comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public Date getActionDate() {
        return actionDate;
    }
    
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

}
