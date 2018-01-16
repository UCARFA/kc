/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.junit.Test;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.committee.rule.event.CommitteeActionPrintCommitteeDocumentEvent;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

public class CommitteeActionPrintCommitteeDocumentRuleTest {

    @Test
    public void testTrue() {
        
        new TemplateRuleTest<CommitteeActionPrintCommitteeDocumentEvent, CommitteeActionPrintCommitteeDocumentRule>() {

            @Override
            protected void prerequisite() {
                event = new CommitteeActionPrintCommitteeDocumentEvent(Constants.EMPTY_STRING, null, true, true);
                rule = new CommitteeActionPrintCommitteeDocumentRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testFalse() {
        
        new TemplateRuleTest<CommitteeActionPrintCommitteeDocumentEvent, CommitteeActionPrintCommitteeDocumentRule>() {

            @Override
            protected void prerequisite() {
                event = new CommitteeActionPrintCommitteeDocumentEvent(Constants.EMPTY_STRING, null, false, false);
                rule = new CommitteeActionPrintCommitteeDocumentRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }

}
