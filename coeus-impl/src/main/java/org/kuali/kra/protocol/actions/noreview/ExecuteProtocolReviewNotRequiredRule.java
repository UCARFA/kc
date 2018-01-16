/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.noreview;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * 
 * This class defines the method needed to validate a review not required action.
 */
public interface ExecuteProtocolReviewNotRequiredRule extends BusinessRule {
    
    /**
     * 
     * This method validates the business rules for setting a protocol to review not required.
     * @param document
     * @param actionBean
     * @return
     */
    boolean processReviewNotRequiredRule(ProtocolDocumentBase document, ProtocolReviewNotRequiredBean actionBean);
}
