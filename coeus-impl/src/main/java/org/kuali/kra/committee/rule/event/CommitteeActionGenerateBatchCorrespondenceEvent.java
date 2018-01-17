/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rule.event;

import org.kuali.coeus.common.committee.impl.rule.event.CommitteeActionGenerateBatchCorrespondenceEventBase;
import org.kuali.coeus.common.committee.impl.rules.CommitteeActionGenerateBatchCorrespondenceRuleBase;
import org.kuali.kra.committee.rules.CommitteeActionGenerateBatchCorrespondenceRule;
import org.kuali.rice.krad.document.Document;

import java.sql.Date;

public class CommitteeActionGenerateBatchCorrespondenceEvent extends CommitteeActionGenerateBatchCorrespondenceEventBase {

    public CommitteeActionGenerateBatchCorrespondenceEvent(String errorPathPrefix, Document document, String batchCorrespondenceTypeCode, Date startDate, Date endDate, String committeeId) {
        super(errorPathPrefix, document, batchCorrespondenceTypeCode, startDate, endDate, committeeId);
    }

    @Override
    protected CommitteeActionGenerateBatchCorrespondenceRuleBase getNewCommitteeActionGenerateBatchCorrespondenceRuleInstanceHook() {
        return new CommitteeActionGenerateBatchCorrespondenceRule();
    }

}
