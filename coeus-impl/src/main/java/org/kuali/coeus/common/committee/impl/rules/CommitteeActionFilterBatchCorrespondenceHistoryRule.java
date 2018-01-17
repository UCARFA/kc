/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rules;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.rule.event.CommitteeActionFilterBatchCorrespondenceHistoryEvent;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * 
 * This class contains the rules to validate an <code>{@link CommitteeActionFilterBatchCorrespondenceHistoryEvent}</code>.
 */
public class CommitteeActionFilterBatchCorrespondenceHistoryRule extends KcTransactionalDocumentRuleBase
                                                                 implements KcBusinessRule<CommitteeActionFilterBatchCorrespondenceHistoryEvent> {

    private static final String BATCH_CORRESPONDENCE_TYPE_FIELD = "committeeHelper.historyBatchCorrespondenceTypeCode";
    private static final String END_DATE_FIELD = "committeeHelper.historyEndDate";

    /**
     * ProcessDefinitionDefinitionDefinition the validation rules for an <code>{@link CommitteeActionFilterBatchCorrespondenceHistoryEvent}</code>.
     * 
     * @param event the CommitteeActionFilterBatchCorrespondenceHistoryEvent
     * @return <code>true</code> if all validation rules are passed, <code>false</code> otherwise
     */
    @Override
    public boolean processRules(CommitteeActionFilterBatchCorrespondenceHistoryEvent event) {
        boolean rulePassed = true;
        
        if (StringUtils.isEmpty(event.getBatchCorrespondenceTypeCode())) {
            reportError(BATCH_CORRESPONDENCE_TYPE_FIELD, KeyConstants.ERROR_COMMITTEE_ACTION_HISTORY_BATCH_CORRESPONDENCE_TYPE_CODE_NOT_SPECIFIED);
            rulePassed = false;
        }
        
        if (event.getStartDate() != null && event.getEndDate() != null
                && event.getEndDate().before(event.getStartDate())) {
            reportError(END_DATE_FIELD, KeyConstants.ERROR_COMMITTEE_ACTION_HISTORY_END_DATE_BEFORE_START_DATE);
            rulePassed = false;
        }
        
        return rulePassed;
    }

}
