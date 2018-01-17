/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.withdraw;

import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.correspondence.AbstractProtocolActionsCorrespondence;

/**
 * 
 * This class deals with the template and the printing for the withdrawl protocol action.
 */
public class WithdrawCorrespondence extends AbstractProtocolActionsCorrespondence {
    
    public static final long serialVersionUID = 1234567890;
    @Override
    public String getProtocolActionType() {
        return ProtocolActionType.WITHDRAWN;
    }

}
