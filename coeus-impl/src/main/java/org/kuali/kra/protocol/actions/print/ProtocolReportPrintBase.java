/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.util.PrintingUtils;
import org.kuali.coeus.common.framework.print.watermark.Watermarkable;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is the abstract class for ProtocolBase report printables
 */
public abstract class ProtocolReportPrintBase extends AbstractPrint {

    private static final long serialVersionUID = 2778568731674597840L;
    private ProtocolPrintHelper printHelper;
    private static final String ERROR_MESSAGE = "Unknown report template.";

    /**
     * 
     * This method is get the print type of the printable.
     * 
     * @return
     */
    public abstract String getProtocolPrintType();

    /**
     * This method fetches the XSL style-sheets required for transforming the generated XML into PDF.
     * 
     * @return {@link ArrayList} of {@link Source} XSLs
     */
    @Override
    public List<Source> getXSLTemplates() {
        if(StringUtils.isBlank(getPrintHelper().getTemplate())) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        List<Source> sourceList = PrintingUtils.getXSLTforReportTemplate(getPrintHelper().getTemplate());
        return sourceList;
    }

    /**
     * This method is to enable watermark. Overriding AbstractPrint method isWatermarkEnabled()
     * 
     * @return boolean
     */
    @Override
    public boolean isWatermarkEnabled() {
        return true;
    }

    /**
     * This method for getting watermark for protocol report printing. Overriding AbstractPrint method getWatermarkable
     * 
     * @return prtocolPrintWatermark
     */
    @Override
    public Watermarkable getWatermarkable() {
        ProtocolPrintWatermarkBase prtocolPrintWatermark = getNewProtocolPrintWatermarkInstanceHook(); //new ProtocolPrintWatermarkBase();
        prtocolPrintWatermark.setPersistableBusinessObject(getPrintableBusinessObject());
        return prtocolPrintWatermark;
    }

    public ProtocolPrintHelper getPrintHelper() {
        return printHelper;
    }

    public void setPrintHelper(ProtocolPrintHelper printHelper) {
        this.printHelper = printHelper;
    }

    protected abstract ProtocolPrintWatermarkBase getNewProtocolPrintWatermarkInstanceHook();

}
