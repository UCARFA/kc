/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.print;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.util.PrintingUtils;

public class CorrespondencePrint extends AbstractPrint {
    private static final long serialVersionUID = -5905174316529503137L;
    private static final String XSL_CONTEXT_DIR = "/org/kuali/kra/printing/stylesheet";

    /**
     * This method fetches the XSL style-sheets required for transforming the
     * generated XML into PDF.
     * 
     * @return {@link ArrayList}} of {@link Source} XSLs
     */
    @Override
    public List<Source> getXSLTemplates() {
        List<Source> sourceList = new ArrayList<>();
        Object template = getReportParameters().get("template");
        if (template != null && ((byte[]) template).length > 0) {
            sourceList.add(new StreamSource(new ByteArrayInputStream((byte[]) template)));
        } else {
            Source src = new StreamSource(PrintingUtils.class.getResourceAsStream(
                    XSL_CONTEXT_DIR + "/QuestionnaireReport.xsl"));
            sourceList.add(src);
        }
        return sourceList;
    }
}
