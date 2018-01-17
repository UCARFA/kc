/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.rules.CommitteeActionGenerateBatchCorrespondenceRuleBase;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.rice.krad.document.Document;

import java.sql.Date;

public abstract class CommitteeActionGenerateBatchCorrespondenceEventBase extends CommitteeActionsEventBase<CommitteeActionGenerateBatchCorrespondenceRuleBase> {

    private static final String MSG = "generate batch correspondence";
    
    private String batchCorrespondenceTypeCode;
    private Date startDate;
    private Date endDate;
    private String committeeId;
    
    public CommitteeActionGenerateBatchCorrespondenceEventBase(String errorPathPrefix, Document document, String batchCorrespondenceTypeCode,
            Date startDate, Date endDate, String committeeId) {
        super(MSG + getDocumentId(document), errorPathPrefix, document);
        setBatchCorrespondenceTypeCode(batchCorrespondenceTypeCode);
        setStartDate(startDate);
        setEndDate(endDate);
        setCommitteeId(committeeId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {

        return getNewCommitteeActionGenerateBatchCorrespondenceRuleInstanceHook();
    }

    protected abstract CommitteeActionGenerateBatchCorrespondenceRuleBase getNewCommitteeActionGenerateBatchCorrespondenceRuleInstanceHook();
    

    public String getBatchCorrespondenceTypeCode() {
        return batchCorrespondenceTypeCode;
    }

    public void setBatchCorrespondenceTypeCode(String batchCorrespondenceTypeCode) {
        this.batchCorrespondenceTypeCode = batchCorrespondenceTypeCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
    }

}
