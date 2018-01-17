/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.decision;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class defines the methods needed for committee decision rules.
 */
public interface ExecuteCommitteeDecisionRule<CD extends CommitteeDecision<?> > extends BusinessRule {
   
    /**
     * 
     * This method will check for valid user input and attach error message to fields as needed.
     * @param document the ProtocolDocumentBase
     * @param actionBean a CommitteeDecision bean
     * @return a boolean as to whether the user input is valid
     */
    boolean proccessCommitteeDecisionRule(ProtocolDocumentBase document, CD actionBean);

}
