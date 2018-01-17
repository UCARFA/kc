/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.assignreviewers;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public interface ExecuteProtocolAssignReviewersRule extends BusinessRule {

    /**
     * ProcessDefinitionDefinitionDefinition the business validation when a protocol is assigned
     * to some reviewers.
     * @param document the protocol document
     * @param actionBean contains the reviewers to assign to
     * @return true if valid; otherwise false
     */
    public boolean processAssignReviewers(ProtocolDocument document, ProtocolAssignReviewersBean actionBean);
}
