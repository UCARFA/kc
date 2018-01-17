/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.modifysubmission;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * 
 * This class defines the rules for modifying a protocol submission.
 */
public interface ExecuteProtocolModifySubmissionRule extends BusinessRule {
    /**
     * 
     * This method is the rule for modifying a protocol submission.
     * @param document
     * @param actionBean
     * @return
     */
    boolean processModifySubmissionRule(ProtocolDocument document, ProtocolModifySubmissionBean actionBean);
}
