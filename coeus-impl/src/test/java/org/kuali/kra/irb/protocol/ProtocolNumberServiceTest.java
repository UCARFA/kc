/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.kra.irb.Protocol;
import org.kuali.rice.krad.service.SequenceAccessorService;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Test the ProtocolNumberService Implementation.
 */
@RunWith(JMock.class)
public class ProtocolNumberServiceTest {

    private static final Long sequenceNumber = new Long(562);
    
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    private String expectedProtocolNumber;

    @Before
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        expectedProtocolNumber = getYear(calendar) + getMonth(calendar) + "000" + sequenceNumber;
    }

    /**
     * Test the generation of the protocol number.  It should invoked the Sequence Accessor Service
     * only once.  The expected protocol number will be today's YYMM followed by 000562.
     */
    @Test
    public void testProtocolNumber() {
        ProtocolNumberServiceImpl protocolNumberService = new ProtocolNumberServiceImpl();

        final SequenceAccessorService sequenceAccessorService = context.mock(SequenceAccessorService.class);
        context.checking(new Expectations() {
            {
                oneOf(sequenceAccessorService).getNextAvailableSequenceNumber("SEQ_PROTOCOL_ID", Protocol.class);
                will(returnValue(sequenceNumber));
            }
        });
        protocolNumberService.setSequenceAccessorService(sequenceAccessorService);

        String protocolNumber = protocolNumberService.generateProtocolNumber();
        assertEquals(expectedProtocolNumber, protocolNumber);
    }
    
    /**
     * Get the current year, only the last two digits.
     * @param calendar the current time
     * @return the year as 2 digits as a string
     */
    private String getYear(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR) - 2000;
        String s = Integer.toString(year);
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }
    
    /**
     * Get the current month, always 2 digits.
     * @param calendar the current time
     * @return the month as 2 digits, e.g. 03 is March
     */
    private String getMonth(Calendar calendar) {
        int month = calendar.get(Calendar.MONTH) + 1;
        String s = Integer.toString(month);
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }
}
