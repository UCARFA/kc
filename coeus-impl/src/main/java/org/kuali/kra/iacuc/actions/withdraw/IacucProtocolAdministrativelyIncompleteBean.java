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
import org.kuali.kra.protocol.actions.withdraw.ProtocolAdministrativelyIncompleteBean;

public class IacucProtocolAdministrativelyIncompleteBean extends IacucProtocolWithdrawBean implements ProtocolAdministrativelyIncompleteBean {


    private static final long serialVersionUID = 8495329655747136375L;

    public IacucProtocolAdministrativelyIncompleteBean(IacucActionHelper actionHelper) {
        super(actionHelper);
    }
    
    /**
     * 
     * This method returns the correct correspondence for this object
     * 
     */
    @Override
    public IacucProtocolActionsCorrespondence getCorrespondence() {
        IacucProtocolActionsCorrespondence correspondence = new IacucProtocolActionsCorrespondence(IacucProtocolActionType.ADMINISTRATIVELY_INCOMPLETE);
        return correspondence;
    }
    

}
