/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import org.kuali.kra.protocol.actions.print.ProtocolHistoryPrintBase;
import org.kuali.kra.protocol.actions.print.ProtocolPrintWatermarkBase;


/**
 * This class provides the implementation for printing Protocol History Report. It generates XML that conforms with Protocol History Report
 * XSD, fetches XSL style-sheets applicable to this XML, returns XML and XSL for any consumer that would use this XML and XSls for
 * any purpose like report generation, PDF streaming etc.
 * 
 */
public class ProtocolHistoryPrint extends ProtocolHistoryPrintBase {

    private static final long serialVersionUID = 834187306362966953L;
    
    @Override
    protected ProtocolPrintWatermarkBase getNewProtocolPrintWatermarkInstanceHook() {
        return new ProtocolPrintWatermark();
    }
}
