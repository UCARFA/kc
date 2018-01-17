/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.print;

import org.kuali.coeus.common.committee.impl.print.TemplatePrintBase;
import org.kuali.coeus.common.framework.print.watermark.Watermarkable;
import org.kuali.kra.irb.actions.print.ProtocolPrintWatermark;

/**
 * 
 * This class identifies the template print functionality for committee reports.
 */
public class ProtocolCorrespondenceTemplatePrint extends TemplatePrintBase {

    private static final long serialVersionUID = 8304381236192765809L;

    @Override
    public String getProtoCorrespTypeCode() {
        return  (String) getReportParameters().get("protoCorrespTypeCode");
    }
    /**
     * This method is to enable watermark in correspondence. Overriding AbstractPrint method isWatermarkEnabled()
     * 
     * @return boolean
     */
    @Override
    public boolean isWatermarkEnabled() {
        return true;
    }

    /**
     * This method for getting watermark for protocol correspondence printing. Overriding AbstractPrint method getWatermarkable
     * 
     * @return prtocolPrintWatermark
     */
    @Override
    public Watermarkable getWatermarkable() {
        ProtocolPrintWatermark prtocolPrintWatermark = new ProtocolPrintWatermark();
        prtocolPrintWatermark.setPersistableBusinessObject(getPrintableBusinessObject());
        return prtocolPrintWatermark;
    }

}
