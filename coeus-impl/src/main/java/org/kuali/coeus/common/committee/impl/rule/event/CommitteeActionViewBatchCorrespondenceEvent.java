/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBatchCorrespondenceBase;
import org.kuali.coeus.common.committee.impl.rules.CommitteeActionPrintCommitteeDocumentRule;
import org.kuali.coeus.common.committee.impl.rules.CommitteeActionViewBatchCorrespondenceRule;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.rice.krad.document.Document;

import java.util.List;

public class CommitteeActionViewBatchCorrespondenceEvent extends CommitteeActionsEventBase<CommitteeActionPrintCommitteeDocumentRule> {
    private static final String MSG = "view batch correspondence";
    
    private List<CommitteeBatchCorrespondenceBase> committeeBatchCorrespondences;
    private boolean viewGenerated;

    public CommitteeActionViewBatchCorrespondenceEvent(String errorPathPrefix, Document document, List<CommitteeBatchCorrespondenceBase> committeeBatchCorrespondences, boolean viewGenerated) {
        super(MSG + getDocumentId(document), errorPathPrefix, document);
        setCommitteeBatchCorrespondences(committeeBatchCorrespondences);
        setViewGenerated(viewGenerated);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return new CommitteeActionViewBatchCorrespondenceRule();
    }

    public List<CommitteeBatchCorrespondenceBase> getCommitteeBatchCorrespondences() {
        return committeeBatchCorrespondences;
    }

    public void setCommitteeBatchCorrespondences(List<CommitteeBatchCorrespondenceBase> committeeBatchCorrespondences) {
        this.committeeBatchCorrespondences = committeeBatchCorrespondences;
    }

    public void setViewGenerated(boolean viewGenerated) {
        this.viewGenerated = viewGenerated;
    }

    public boolean isViewGenerated() {
        return viewGenerated;
    }

}
