/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.apache.commons.lang3.StringUtils;


/**
 * This class holds the possible values for the InvoiceInstructionsIndicator on 
 * the ValidBasisMethodPayment.  There are three possibilities:
 * 
 * Optional:  The user can fill out the invoice instructions, but it is not required.
 * Mandatory: The user must fill out the invoice instructions.
 * Blank: The user must not fill it out, and the rendered field for instructions shall be disabled.
 */
public enum InvInstructionsIndicatorConstants {
    
    Optional ("O"),
    Mandatory ("M"),
    Blank ("B");

    String code;
    
    InvInstructionsIndicatorConstants( String code ) {
        this.code = code;
    }
    
    /**
     * Gets the code attribute.  The code is stored in the db. 
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    public static InvInstructionsIndicatorConstants getByCode(  String code ) {
        for( InvInstructionsIndicatorConstants cont : InvInstructionsIndicatorConstants.values() ) {
            if( StringUtils.equals(cont.code, code )) return cont;
        }
        return null;
    }

}
