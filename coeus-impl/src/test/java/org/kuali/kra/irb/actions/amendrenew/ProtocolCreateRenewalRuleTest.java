/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.amendrenew;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.ErrorMessage;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.util.List;

import static org.junit.Assert.*;

public class ProtocolCreateRenewalRuleTest {
    private static final String PROPERTY_KEY = "key";
    private static final String SUMMARY = "summary";

    @Before
    public void setUp() throws Exception {
        GlobalVariables.setMessageMap(new MessageMap());
    }

    @Test
    public void testOK() {

        //CreateRenewalEvent<?> event = new CreateRenewalEvent<CreateRenewalRule>(null, PROPERTY_KEY, SUMMARY);
        CreateRenewalEvent event = new CreateRenewalEvent(null, PROPERTY_KEY, SUMMARY);

        CreateRenewalRule rule = new CreateRenewalRule();
        rule.setErrorReporter(new ErrorReporterImpl());
        assertTrue(rule.processRules(event));
    }

    @Test
    public void testSummary() {

        //CreateRenewalEvent<?> event = new CreateRenewalEvent<CreateRenewalRule>(null, PROPERTY_KEY, "");
        CreateRenewalEvent event = new CreateRenewalEvent(null, PROPERTY_KEY, "");

        CreateRenewalRule rule = new CreateRenewalRule();
        rule.setErrorReporter(new ErrorReporterImpl());
        assertFalse(rule.processRules(event));
        assertError(PROPERTY_KEY, KeyConstants.ERROR_PROTOCOL_SUMMARY_IS_REQUIRED);
    }


    /**
     * Assert an error. The Error Map should have one error with the given property key and error key.
     * 
     * @param propertyKey
     * @param errorKey
     */
    protected void assertError(String propertyKey, String errorKey) {
        List errors = GlobalVariables.getMessageMap().getMessages(propertyKey);
        assertNotNull(errors);
        assertTrue(errors.size() == 1);

        ErrorMessage message = (ErrorMessage) errors.get(0);
        assertNotNull(message);
        assertEquals(message.getErrorKey(), errorKey);
    }


}
