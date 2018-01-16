/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.print.watermark;



/**
 * 
 * This method invokes the KC watermarkBean for reports, docs. In this method the input pdfBytes are merged with watermark and
 * returns the resultant pdf.
 * 
 */

public interface WatermarkService {
    /**
     * 
     * This method for applying watermark to the pdf.In this method the input pdfBytes are merged with watermark content and returns
     * the resultant pdf.
     * @param pdfBytes
     * @param watermarkBean
     * @return pdfFileData
     * @throws Exception
     */
    byte[] applyWatermark(byte[] pdfBytes, WatermarkBean watermarkBean) throws Exception;

}
