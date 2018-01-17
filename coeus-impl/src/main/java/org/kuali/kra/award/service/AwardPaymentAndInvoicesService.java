/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.kra.award.home.ValidAwardBasisPayment;
import org.kuali.kra.award.home.ValidBasisMethodPayment;

import java.util.List;


public interface AwardPaymentAndInvoicesService {
    /**
     * This method returns the ValidAwardBasisPayment objects associated with the given awardTypeCode
     * @param awardTypeCode the awardTypeCode that will be used in the lookup of ValidAwardBasisPayments.
     * @return List of ValidAwardBasisPayment records associated with the given awardTypeCode
     */
    public List<ValidAwardBasisPayment> getValidAwardBasisPaymentsByAwardTypeCode( Integer awardTypeCode );

    /**
     * 
     * @param basisOfPaymentCode The basisOfPayment code
     * @return List of ValidBasisMethodPayment codes that have basisOfPaymentCode equal to the given parameter.
     */
    public List<ValidBasisMethodPayment> getValidBasisMethodPaymentByBasisCode( String basisOfPaymentCode );
    
    public ValidAwardBasisPayment getValidAwardBasisPayment(Integer validAwardBasisPaymentId);
    
    /**
     * Return a delimited string representation of the getValidAwardBasisPaymentsByAwardTypeCode method.
     * @param awardTypeCode
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getEncodedValidAwardBasisPaymentsByAwardTypeCode(Integer awardTypeCode);


    /**
     * Return a delimited string representation of the output from getValidBasisMethodPayment method.
     * @param basisOfPaymentCode
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getEncodedValidBasisMethodPaymentsByBasisCode( String basisOfPaymentCode);
}
