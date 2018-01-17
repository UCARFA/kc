/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.printing.print;

import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.util.PrintingUtils;
import org.kuali.kra.negotiations.printing.NegotiationActivityPrintType;

import javax.xml.transform.Source;
import java.util.List;

public class NegotiationActivityprint extends AbstractPrint {

    @Override
    public List<Source> getXSLTemplates() {
        List<Source> sourceList = PrintingUtils
                .getXSLTforReport(NegotiationActivityPrintType.NEGOTIATION_ACTIVITY_REPORT
                        .getNegotiationActivityPrintType());
        return sourceList;
    }
}
