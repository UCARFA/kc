/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.delete;

import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolActionBean;

/**
 * This class is really just a "form" containing the reason
 * for deleting a protocol/amendment/renewal.
 */
public class ProtocolDeleteBean extends ProtocolActionBean implements org.kuali.kra.protocol.actions.delete.ProtocolDeleteBean {

    private static final long serialVersionUID = 7654109710201779704L;
    
    private String reason = "";
    
    /**
     * Constructs a ProtocolDeleteBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolDeleteBean(ActionHelper actionHelper) {
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
}
