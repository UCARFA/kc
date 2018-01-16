/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import org.junit.Test;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.rules.TemplateRuleTest;

public class ProtocolActionPrintRuleTest {
    @Test
    public void testOK() {
        new TemplateRuleTest<ProtocolActionPrintEvent, ProtocolActionPrintRule>() {
            @Override
            protected void prerequisite() {

                event = new ProtocolActionPrintEvent(null, true, false, false, false);
                rule = new ProtocolActionPrintRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };


    }

    @Test
    public void testNotOK() {
        new TemplateRuleTest<ProtocolActionPrintEvent, ProtocolActionPrintRule>() {
            @Override
            protected void prerequisite() {

                event = new ProtocolActionPrintEvent(null, false, false, false, false);
                rule = new ProtocolActionPrintRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };


    }

}
