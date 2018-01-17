/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.rule.event;

import org.kuali.coeus.common.committee.impl.rule.event.CommitteeActionGenerateBatchCorrespondenceEventBase;
import org.kuali.coeus.common.committee.impl.rules.CommitteeActionGenerateBatchCorrespondenceRuleBase;
import org.kuali.kra.iacuc.committee.rules.IacucCommitteeActionGenerateBatchCorrespondenceRule;
import org.kuali.rice.krad.document.Document;

import java.sql.Date;


public class IacucCommitteeActionGenerateBatchCorrespondenceEvent extends CommitteeActionGenerateBatchCorrespondenceEventBase {

    public IacucCommitteeActionGenerateBatchCorrespondenceEvent(String errorPathPrefix, Document document,
            String batchCorrespondenceTypeCode, Date startDate, Date endDate, String committeeId) {
        super(errorPathPrefix, document, batchCorrespondenceTypeCode, startDate, endDate, committeeId);
    }

    @Override
    protected CommitteeActionGenerateBatchCorrespondenceRuleBase getNewCommitteeActionGenerateBatchCorrespondenceRuleInstanceHook() {
        return new IacucCommitteeActionGenerateBatchCorrespondenceRule();
    }

}
