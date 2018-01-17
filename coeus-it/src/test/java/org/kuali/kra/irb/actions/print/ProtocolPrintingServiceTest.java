/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import org.junit.Test;
import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.printing.util.PrintingServiceTestBase;

import static org.junit.Assert.assertTrue;
public class ProtocolPrintingServiceTest extends PrintingServiceTestBase {
    private ProtocolPrintingService protocolPrintingService;

    @Test
    public void testGetProtocolPrintable() {

        Printable printable = getPrintingService().getProtocolPrintable(org.kuali.kra.protocol.actions.print.ProtocolPrintType.PROTOCOL_FULL_PROTOCOL_REPORT);
        assertTrue(printable instanceof ProtocolFullProtocolPrint);
        printable = getPrintingService().getProtocolPrintable(org.kuali.kra.protocol.actions.print.ProtocolPrintType.PROTOCOL_PROTOCOL_HISTORY_REPORT);
        assertTrue(printable instanceof ProtocolHistoryPrint);
        printable = getPrintingService().getProtocolPrintable(org.kuali.kra.protocol.actions.print.ProtocolPrintType.PROTOCOL_REVIEW_COMMENTS_REPORT);
        assertTrue(printable instanceof ProtocolReviewCommentsPrint);
        printable = getPrintingService().getProtocolPrintable(org.kuali.kra.protocol.actions.print.ProtocolPrintType.PROTOCOL_SUMMARY_VIEW_REPORT);
        assertTrue(printable instanceof ProtocolSummaryViewPrint);
    }

    private ProtocolPrintingService getPrintingService() {
        if (protocolPrintingService == null) {
            protocolPrintingService = KcServiceLocator.getService(ProtocolPrintingService.class);
        }
        return protocolPrintingService;
    }

}
