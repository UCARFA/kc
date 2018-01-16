/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.junit.Test;
import org.kuali.coeus.common.committee.impl.rule.event.CommitteeActionFilterBatchCorrespondenceHistoryEvent;
import org.kuali.coeus.common.committee.impl.rules.CommitteeActionFilterBatchCorrespondenceHistoryRule;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

import java.sql.Date;

public class CommitteeActionFilterBatchCorrespondenceHistoryRuleTest {

    @Test
    public void testTrue() {
        
        new TemplateRuleTest<CommitteeActionFilterBatchCorrespondenceHistoryEvent, CommitteeActionFilterBatchCorrespondenceHistoryRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = "1";
                Date startDate = Date.valueOf("2010-01-01");
                Date endDate = Date.valueOf("2010-12-31");
                
                event = new CommitteeActionFilterBatchCorrespondenceHistoryEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate);
                rule = new CommitteeActionFilterBatchCorrespondenceHistoryRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testFalseMissingBatchCorrespondence() {
        
        new TemplateRuleTest<CommitteeActionFilterBatchCorrespondenceHistoryEvent, CommitteeActionFilterBatchCorrespondenceHistoryRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = null;
                Date startDate = Date.valueOf("2010-01-01");
                Date endDate = Date.valueOf("2010-12-31");
                
                event = new CommitteeActionFilterBatchCorrespondenceHistoryEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate);
                rule = new CommitteeActionFilterBatchCorrespondenceHistoryRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }

    @Test
    public void testFalseEndDateBeforeStartDate() {
        
        new TemplateRuleTest<CommitteeActionFilterBatchCorrespondenceHistoryEvent, CommitteeActionFilterBatchCorrespondenceHistoryRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = "1";
                Date startDate = Date.valueOf("2010-12-31");
                Date endDate = Date.valueOf("2010-01-01");
                
                event = new CommitteeActionFilterBatchCorrespondenceHistoryEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate);
                rule = new CommitteeActionFilterBatchCorrespondenceHistoryRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }

}
