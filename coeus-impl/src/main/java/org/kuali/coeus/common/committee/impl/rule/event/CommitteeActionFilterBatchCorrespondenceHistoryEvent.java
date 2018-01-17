/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.rules.CommitteeActionFilterBatchCorrespondenceHistoryRule;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.rice.krad.document.Document;

import java.sql.Date;

/**
 * 
 * This class implements the CommitteeActionFilterBatchCorrespondenceHistoryEven which is used
 * to view a specific set of batch correspondence that has been generated in the past.
 */
public class CommitteeActionFilterBatchCorrespondenceHistoryEvent extends CommitteeActionsEventBase<CommitteeActionFilterBatchCorrespondenceHistoryRule> {
    private static final String MSG = "filter batch correspondence history";
    
    private String batchCorrespondenceTypeCode;
    private Date startDate;
    private Date endDate;
    
    /**
     * 
     * Constructs a CommitteeActionFilterBatchCorrespondenceHistoryEvent.java.
     * @param errorPathPrefix
     * @param document
     * @param batchCorrespondenceTypeCode
     * @param startDate
     * @param endDate
     */
    public CommitteeActionFilterBatchCorrespondenceHistoryEvent(String errorPathPrefix, Document document, String batchCorrespondenceTypeCode,
            Date startDate, Date endDate) {
        super(MSG + getDocumentId(document), errorPathPrefix, document);
        setBatchCorrespondenceTypeCode(batchCorrespondenceTypeCode);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new CommitteeActionFilterBatchCorrespondenceHistoryRule();
    }

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

}
