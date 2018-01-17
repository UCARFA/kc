/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.grantexemption;

import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.correspondence.AbstractProtocolActionsCorrespondence;

/**
 * 
 * This class deals with the template and the printing for the grant exemption protocol action.
 */
public class GrantExemptionCorrespondence extends AbstractProtocolActionsCorrespondence {

    public static final long serialVersionUID = 1234563880;
    @Override
    public String getProtocolActionType() {
        return ProtocolActionType.GRANT_EXEMPTION;
    }

}
