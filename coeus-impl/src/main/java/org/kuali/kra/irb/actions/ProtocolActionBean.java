/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.actions.ActionHelperBase;

/**
 * Defines the superclass of all Protocol action beans.
 */
public abstract class ProtocolActionBean implements org.kuali.kra.protocol.actions.ProtocolActionBean {
    
    private ActionHelper actionHelper;
    
    /**
     * Constructs a ProtocolActionBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolActionBean(ActionHelper actionHelper) {
        this.setActionHelper(actionHelper);
    }
    
    public ProtocolActionBean() {
    }

    @Override
    public void setActionHelper(ActionHelperBase actionHelper) {
        this.actionHelper = (ActionHelper) actionHelper;
    }

    @Override
    public ActionHelper getActionHelper() {
        return actionHelper;
    }
    
    @Override
    public Protocol getProtocol() {
        return (Protocol) actionHelper.getProtocol();
    }

}
