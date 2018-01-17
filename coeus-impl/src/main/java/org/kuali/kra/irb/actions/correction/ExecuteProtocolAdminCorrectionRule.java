/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.correction;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * 
 * This interface describes the public methods needed for validating an assignment and agenda.
 */
public interface ExecuteProtocolAdminCorrectionRule extends BusinessRule {

    /**
     * ProcessDefinitionDefinitionDefinition the business validation when a protocol is assigned to a committee/schedule.
     * 
     * @param document the protocol document
     * @param actionBean contains the committee/schedule to assign to
     * @return true if valid; otherwise false
     */
    boolean processAdminCorrectionRule(ProtocolDocument document, AdminCorrectionBean actionBean);
}
