/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.kuali.coeus.common.committee.impl.meeting.MeetingAddMinuteRuleBase;
import org.kuali.coeus.common.committee.impl.meeting.ProtocolContingencyBase;

/**
 * 
 * This class implements the business when adding committee schedule minute.
 */
public class MeetingAddMinuteRule extends MeetingAddMinuteRuleBase {

    @Override
    protected Class<? extends ProtocolContingencyBase> getProtocolContingencyBOClassHook() {
        return ProtocolContingency.class;
    }
}
