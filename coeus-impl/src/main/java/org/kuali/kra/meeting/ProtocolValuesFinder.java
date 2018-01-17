/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.kuali.coeus.common.committee.impl.meeting.ProtocolValuesFinderBase;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionLite;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionLiteBase;

/**
 * 
 * This class is to find protocols submitted to this committee schedule.
 */
public class ProtocolValuesFinder extends ProtocolValuesFinderBase {


    private static final long serialVersionUID = -6742435002576211916L;

    @Override
    protected Class<? extends ProtocolSubmissionLiteBase> getProtocolSubmissionBOClassHook() {
        return ProtocolSubmissionLite.class;
    }
}
