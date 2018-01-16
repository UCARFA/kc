/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.junit.Test;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBatchCorrespondenceBase;
import org.kuali.coeus.common.committee.impl.rule.event.CommitteeActionViewBatchCorrespondenceEvent;
import org.kuali.coeus.common.committee.impl.rules.CommitteeActionViewBatchCorrespondenceRule;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.committee.bo.CommitteeBatchCorrespondence;
import org.kuali.kra.committee.bo.CommitteeBatchCorrespondenceDetail;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

import java.util.ArrayList;
import java.util.List;

public class CommitteeActionViewBatchCorrespondenceRuleTest {
    
    @Test
    public void testTrue() {
        
        new TemplateRuleTest<CommitteeActionViewBatchCorrespondenceEvent, CommitteeActionViewBatchCorrespondenceRule>() {

            @Override
            protected void prerequisite() {
                CommitteeBatchCorrespondenceDetail committeeBatchCorrespondenceDetail = new CommitteeBatchCorrespondenceDetail();
                committeeBatchCorrespondenceDetail.setSelected(true);
                CommitteeBatchCorrespondence committeeBatchCorrespondence = new CommitteeBatchCorrespondence();
                committeeBatchCorrespondence.getCommitteeBatchCorrespondenceDetails().add(committeeBatchCorrespondenceDetail);
                List<CommitteeBatchCorrespondenceBase> committeeBatchCorrespondences = new ArrayList<CommitteeBatchCorrespondenceBase>();
                committeeBatchCorrespondences.add(committeeBatchCorrespondence);
                
                event = new CommitteeActionViewBatchCorrespondenceEvent(Constants.EMPTY_STRING, null, committeeBatchCorrespondences, false);
                rule = new CommitteeActionViewBatchCorrespondenceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testFalse() {
        
        new TemplateRuleTest<CommitteeActionViewBatchCorrespondenceEvent, CommitteeActionViewBatchCorrespondenceRule>() {

            @Override
            protected void prerequisite() {
                List<CommitteeBatchCorrespondenceBase> committeeBatchCorrespondences = new ArrayList<CommitteeBatchCorrespondenceBase>();
                event = new CommitteeActionViewBatchCorrespondenceEvent(Constants.EMPTY_STRING, null, committeeBatchCorrespondences, false);
                rule = new CommitteeActionViewBatchCorrespondenceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }

}
