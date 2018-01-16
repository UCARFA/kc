/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.rules.DeleteCommitteeScheduleRuleBase;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * 
 * This class is the rule event for deleting committee schedule.
 */
public abstract class DeleteCommitteeScheduleEventBase extends CommitteeScheduleEventBase<DeleteCommitteeScheduleRuleBase> {
    
    private static final String MSG = "deleting CommitteeScheduleBase ";
    
    /**
     * 
     * Constructs a DeleteCommitteeScheduleEventBase.java.
     * @param errorPathPrefix
     * @param document
     * @param scheduleData
     * @param committeeSchedules
     * @param type
     */
    public DeleteCommitteeScheduleEventBase(String errorPathPrefix, CommitteeDocumentBase document, ScheduleData scheduleData, List<CommitteeScheduleBase> committeeSchedules, ErrorType type) {
        super(MSG + getDocumentId(document), errorPathPrefix, document, scheduleData, committeeSchedules, type);
    }
    
    /**
     * 
     * Constructs a DeleteCommitteeScheduleEventBase.java.
     * @param errorPathPrefix
     * @param document
     * @param scheduleData
     * @param committeeSchedules
     * @param type
     */
    public DeleteCommitteeScheduleEventBase(String errorPathPrefix, Document document, ScheduleData scheduleData,
            List<CommitteeScheduleBase> committeeSchedules, ErrorType type) {
        this(errorPathPrefix, (CommitteeDocumentBase) document, scheduleData, committeeSchedules, type);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public KcBusinessRule getRule() {
        return getNewDeleteCommitteeScheduleRuleInstanceHook();
    }

    protected abstract DeleteCommitteeScheduleRuleBase getNewDeleteCommitteeScheduleRuleInstanceHook();
    
}
