/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.reporting.printing.print;

import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.util.PrintingUtils;
import org.kuali.kra.subaward.reporting.printing.SubAwardPrintType;

import javax.xml.transform.Source;
import java.util.List;

public class SubAwardSF294Print extends AbstractPrint {

    @Override
    public List<Source> getXSLTemplates() {
        List<Source> sourceList = PrintingUtils
                .getXSLTforReport(SubAwardPrintType.SUB_AWARD_SF_294_PRINT_TYPE
                        .getSubAwardPrintType());
        return sourceList;
    }
}
