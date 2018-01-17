/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.junit.Test;
import org.kuali.kra.committee.rule.event.CommitteeActionGenerateBatchCorrespondenceEvent;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.sql.Date;

public class CommitteeActionGenerateBatchCorrespondenceRuleTest extends KcIntegrationTestBase {
    
    @Test
    public void testTrue() {
        
        new TemplateRuleTest<CommitteeActionGenerateBatchCorrespondenceEvent, CommitteeActionGenerateBatchCorrespondenceRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = "1";
                Date startDate = Date.valueOf("2010-01-01");
                Date endDate = Date.valueOf("2010-12-31");
                String committeeId = "Committee1";
                
                event = new CommitteeActionGenerateBatchCorrespondenceEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate, committeeId);
                rule = new CommitteeActionGenerateBatchCorrespondenceRule();
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testFalseMissingBatchCorrespondence() {
        
        new TemplateRuleTest<CommitteeActionGenerateBatchCorrespondenceEvent, CommitteeActionGenerateBatchCorrespondenceRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = null;
                Date startDate = Date.valueOf("2010-01-01");
                Date endDate = Date.valueOf("2010-12-31");
                String committeeId = "Committee1";
                
                event = new CommitteeActionGenerateBatchCorrespondenceEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate, committeeId);
                rule = new CommitteeActionGenerateBatchCorrespondenceRule();
                expectedReturnValue = false;
            }
        };
    }

    @Test
    public void testFalseMissingStartDate() {
        
        new TemplateRuleTest<CommitteeActionGenerateBatchCorrespondenceEvent, CommitteeActionGenerateBatchCorrespondenceRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = "1";
                Date startDate = null;
                Date endDate = Date.valueOf("2010-12-31");
                String committeeId = "Committee1";
                
                event = new CommitteeActionGenerateBatchCorrespondenceEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate, committeeId);
                rule = new CommitteeActionGenerateBatchCorrespondenceRule();
                expectedReturnValue = false;
            }
        };
    }

    @Test
    public void testFalseMissingEndDate() {
        
        new TemplateRuleTest<CommitteeActionGenerateBatchCorrespondenceEvent, CommitteeActionGenerateBatchCorrespondenceRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = "1";
                Date startDate = Date.valueOf("2010-01-01");
                Date endDate = null;
                String committeeId = "Committee1";
                
                event = new CommitteeActionGenerateBatchCorrespondenceEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate, committeeId);
                rule = new CommitteeActionGenerateBatchCorrespondenceRule();
                expectedReturnValue = false;
            }
        };
    }

    @Test
    public void testFalseEndDateBeforeStartDate() {
        
        new TemplateRuleTest<CommitteeActionGenerateBatchCorrespondenceEvent, CommitteeActionGenerateBatchCorrespondenceRule>() {

            @Override
            protected void prerequisite() {
                String batchCorrespondenceTypeCode = "1";
                Date startDate = Date.valueOf("2010-12-31");
                Date endDate = Date.valueOf("2010-01-01");
                String committeeId = "Committee1";
                
                event = new CommitteeActionGenerateBatchCorrespondenceEvent(Constants.EMPTY_STRING, null, batchCorrespondenceTypeCode, startDate, endDate, committeeId);
                rule = new CommitteeActionGenerateBatchCorrespondenceRule();
                expectedReturnValue = false;
            }
        };
    }

}
