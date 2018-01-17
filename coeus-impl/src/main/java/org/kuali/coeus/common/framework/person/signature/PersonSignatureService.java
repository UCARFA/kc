/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.signature;


import java.io.IOException;

public interface PersonSignatureService {

    /**
     * 
     * This method is to apply signature to the pdf document.
     * In this method the input pdfBytes are merged with appropriate signature and 
     * the result is returned.
     */
    byte[] applySignature(byte[] pdfBytes) throws IOException;

}
