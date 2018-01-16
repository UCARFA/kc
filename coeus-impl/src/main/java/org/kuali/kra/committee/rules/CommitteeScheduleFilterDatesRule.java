/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.committee.rule.event.CommitteeScheduleFilterEvent;
import org.kuali.kra.infrastructure.KeyConstants;

import java.sql.Date;

public class CommitteeScheduleFilterDatesRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<CommitteeScheduleFilterEvent> {
    
    public static final String SCHEDULEDATE_FILTERSTARTDATE = "committeeHelper.scheduleData.filterStartDate";
    
    public static final String SCHEDULEDATE_FILTERENDDATE = "committeeHelper.scheduleData.filerEndDate";
    
    public static final String [] MSG = {"Start date", "End date"}; 
            
    @Override
    public boolean processRules(CommitteeScheduleFilterEvent filterCommitteeScheduleEvent) {
        
        boolean rulePassed = true;
        
        Date startDate = filterCommitteeScheduleEvent.getScheduleData().getFilterStartDate();
        Date endDate = filterCommitteeScheduleEvent.getScheduleData().getFilerEndDate();
        
        if(null == startDate) {
            reportError(SCHEDULEDATE_FILTERSTARTDATE, KeyConstants.ERROR_COMMITTEESCHEDULE_FILTER_DATE, MSG[0]);
            rulePassed = false;
        }
        if(null == endDate) {
            reportError(SCHEDULEDATE_FILTERENDDATE, KeyConstants.ERROR_COMMITTEESCHEDULE_FILTER_DATE, MSG[1]);
            rulePassed = false;
        }     
        
        if(rulePassed && startDate.toString().equals(endDate.toString())) {            
            reportError(SCHEDULEDATE_FILTERENDDATE, KeyConstants.ERROR_COMMITTEESCHEDULE_STARTANDENDDATE_EQUAL);
            rulePassed = false;
        }
        
        if(rulePassed && startDate.after(endDate)) {            
            reportError(SCHEDULEDATE_FILTERENDDATE, KeyConstants.ERROR_COMMITTEESCHEDULE_STARTANDENDDATE);
            rulePassed = false;
        }
        
        return rulePassed;
    }

}
