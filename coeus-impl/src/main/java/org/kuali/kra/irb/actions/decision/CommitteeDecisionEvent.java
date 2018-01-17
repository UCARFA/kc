/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.decision;

import org.apache.commons.logging.Log;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.protocol.actions.decision.CommitteeDecisionEventBase;


@SuppressWarnings("unchecked")
public class CommitteeDecisionEvent extends CommitteeDecisionEventBase {
    
    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(CommitteeDecisionEvent.class);
    
    public CommitteeDecisionEvent(ProtocolDocument document, CommitteeDecision decision) {
        super(document, decision);
    }

    @Override
    protected Log getLOGHook() {
        return LOG;
    }
}
