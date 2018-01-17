/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.withdraw;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.correspondence.IacucProtocolActionsCorrespondence;
import org.kuali.kra.protocol.actions.withdraw.ProtocolAdministrativelyWithdrawBean;

public class IacucProtocolAdministrativelyWithdrawBean extends IacucProtocolWithdrawBean implements ProtocolAdministrativelyWithdrawBean {


    private static final long serialVersionUID = 6918550703566682822L;

    public IacucProtocolAdministrativelyWithdrawBean(IacucActionHelper actionHelper) {
        super(actionHelper);
    }
    
    /**
     * 
     * This method returns the correct correspondence for this object
     * 
     */
    @Override
    public IacucProtocolActionsCorrespondence getCorrespondence() {
        IacucProtocolActionsCorrespondence correspondence = new IacucProtocolActionsCorrespondence(IacucProtocolActionType.ADMINISTRATIVELY_WITHDRAWN);
        return correspondence;
    }


}
