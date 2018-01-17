/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rules;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBatchCorrespondenceBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBatchCorrespondenceDetailBase;
import org.kuali.coeus.common.committee.impl.rule.event.CommitteeActionViewBatchCorrespondenceEvent;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * 
 * This class contains the document rules of the ViewBatchCorrespondence event.
 */
public class CommitteeActionViewBatchCorrespondenceRule extends KcTransactionalDocumentRuleBase
                                                        implements KcBusinessRule<CommitteeActionViewBatchCorrespondenceEvent> {
    
    private static final String BATCH_VIEW_ERROR_FIELD = "committeeHelper.generateBatchCorrespondence";
    private static final String HISTORY_VIEW_ERROR_FIELD = "committeeHelper.batchCorrespondenceHistory";

    /**
     * 
     * This method processes the rules of the CommitteeActionViewBatchCorrespondenceEvent.
     * 
     * @param event to be validated against the rules.
     * @return true if validation passed the rules, false otherwise.
     */
    @Override
    public boolean processRules(CommitteeActionViewBatchCorrespondenceEvent event) {
        for (CommitteeBatchCorrespondenceBase committeeBatchCorrespondence : event.getCommitteeBatchCorrespondences()) {
            for (CommitteeBatchCorrespondenceDetailBase committeeBatchCorrespondenceDetail : 
                    committeeBatchCorrespondence.getCommitteeBatchCorrespondenceDetails()) {
                if (committeeBatchCorrespondenceDetail.getSelected()) {
                    return true;
                }
            }
        }
        
        if (event.isViewGenerated()) {
            reportError(BATCH_VIEW_ERROR_FIELD, KeyConstants.ERROR_COMMITTEE_ACTION_GENERATE_VIEW_NOT_SPECIFIED);
        } else {
            reportError(HISTORY_VIEW_ERROR_FIELD, KeyConstants.ERROR_COMMITTEE_ACTION_HISTORY_VIEW_NOT_SPECIFIED);
        }
        return false;
    }

}
