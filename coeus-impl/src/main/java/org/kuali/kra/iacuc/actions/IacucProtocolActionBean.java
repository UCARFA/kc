/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ActionHelperBase;
import org.kuali.kra.protocol.actions.ProtocolActionBean;

/**
 * Defines the superclass of all ProtocolBase action beans.
 */
public abstract class IacucProtocolActionBean implements ProtocolActionBean {
    
    private ActionHelperBase actionHelper;
    
    /**
     * Constructs a ProtocolActionBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolActionBean(ActionHelperBase actionHelper) {
        this.setActionHelper(actionHelper);
    }
    
    public IacucProtocolActionBean() {
    }

    @Override
    public void setActionHelper(ActionHelperBase actionHelper) {
        this.actionHelper = actionHelper;
    }

    @Override
    public ActionHelperBase getActionHelper() {
        return actionHelper;
    }
    
    @Override
    public ProtocolBase getProtocol() {
        return actionHelper.getProtocol();
    }

}
