/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;

/**
 * This interface addresses the adds rule for adding a new <code>ProtocolParticipant</code>.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class AddProtocolParticipantRule extends ProtocolParticipantRuleBase implements KcBusinessRule<AddProtocolParticipantEvent> {

    @Override
    public boolean processRules(AddProtocolParticipantEvent event) {
        return processAddProtocolParticipantEvent(event);
    }

}
