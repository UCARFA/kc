/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notesandattachments.notes;

import org.junit.Test;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.award.notesandattachments.notes.AwardNoteEventBase.ErrorType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

public class AwardNoteAddRuleTest {

    @Test
    public void testOK() {
        new TemplateRuleTest<AwardNoteAddEvent, AwardNoteAddRule>() {
            @Override
            protected void prerequisite() {

                AwardNotepad awardNotepad = new AwardNotepad();
                awardNotepad.setNoteTopic("test");
                event = new AwardNoteAddEvent(Constants.EMPTY_STRING, null, awardNotepad, ErrorType.HARDERROR);
                rule = new AwardNoteAddRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };


    }

    @Test
    public void testNotOK() {
        new TemplateRuleTest<AwardNoteAddEvent, AwardNoteAddRule>() {
            @Override
            protected void prerequisite() {

                AwardNotepad awardNotepad = new AwardNotepad();
                awardNotepad.setNoteTopic("");
                event = new AwardNoteAddEvent(Constants.EMPTY_STRING, null, awardNotepad, ErrorType.HARDERROR);
                rule = new AwardNoteAddRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };


    }

}
