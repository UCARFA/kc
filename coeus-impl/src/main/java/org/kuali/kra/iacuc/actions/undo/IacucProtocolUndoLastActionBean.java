/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.undo;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.genericactions.IacucProtocolGenericActionBean;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.undo.UndoLastActionBean;
import org.kuali.kra.protocol.actions.undo.UndoLastActionBeanHelperBase;

public class IacucProtocolUndoLastActionBean extends IacucProtocolGenericActionBean implements UndoLastActionBean {

    private UndoLastActionBeanHelperBase helper;
    
    public IacucProtocolUndoLastActionBean(IacucActionHelper actionHelper, String errorPropertyKey) {
        super(actionHelper, errorPropertyKey);
        this.helper = new IacucProtocolUndoLastActionBeanHelper();
    }

    @Override
    public boolean canUndoLastAction() {
        return helper.canUndoLastAction(getProtocol());
    }

    @Override
    public ProtocolActionBase getLastAction() {
        return helper.getLastPerformedAction(getProtocol().getProtocolActions());
    }

}
