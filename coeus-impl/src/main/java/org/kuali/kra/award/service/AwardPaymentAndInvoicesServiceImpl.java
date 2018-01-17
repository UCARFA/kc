/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.award.home.ValidAwardBasisPayment;
import org.kuali.kra.award.home.ValidBasisMethodPayment;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AwardPaymentAndInvoicesServiceImpl implements AwardPaymentAndInvoicesService {
    
    static final String AWARDTYPECODE = "awardTypeCode";
    static final String VALIDAWARDBASISPAYMENT_ID = "validAwardBasisPaymentId";
    
    static final String BASISOFPAYMENTCODE = "basisOfPaymentCode";
    static final String METHODOFPAYMENTCODE = "methodOfPaymentCode";
    

    private static final String AWARDBASISOFPAYMENT_CODE = "basisOfPaymentCode"; 
    private static final String AWARDMETHODOFPAYMENT_CODE = "methodOfPaymentCode";
    
    BusinessObjectService businessObjectService;

    @Override
    public String getEncodedValidAwardBasisPaymentsByAwardTypeCode(Integer awardTypeCode) {
        List<KeyValue> results = new ArrayList<KeyValue>();
        results.add(ValuesFinderUtils.getSelectOption());
        List<ValidAwardBasisPayment> found = getValidAwardBasisPaymentsByAwardTypeCode(awardTypeCode);
        for( ValidAwardBasisPayment current : found ) {
            current.refresh();
            results.add(new ConcreteKeyValue( current.getBasisOfPaymentCode(), current.getBasisOfPayment().getDescription() ));
        }

        return ValuesFinderUtils.processKeyValueList(results);
    }

    @Override
    public String getEncodedValidBasisMethodPaymentsByBasisCode(String basisOfPaymentCode) {
        List<KeyValue> results = new ArrayList<KeyValue>();
        results.add(ValuesFinderUtils.getSelectOption());
        List<ValidBasisMethodPayment> found = getValidBasisMethodPaymentByBasisCode(basisOfPaymentCode);
        for( ValidBasisMethodPayment current : found ) {
            current.refresh();
            results.add(new ConcreteKeyValue( current.getMethodOfPaymentCode(), current.getMethodOfPayment().getDescription() ));
        }
        return ValuesFinderUtils.processKeyValueList(results);
    }


    @Override
    public List<ValidAwardBasisPayment> getValidAwardBasisPaymentsByAwardTypeCode(Integer awardTypeCode) {
        List<ValidAwardBasisPayment> results = new ArrayList<ValidAwardBasisPayment>( businessObjectService.findMatchingOrderBy(ValidAwardBasisPayment.class,
                Collections.singletonMap(AWARDTYPECODE, awardTypeCode),
                VALIDAWARDBASISPAYMENT_ID, 
                true ));
        return results;
    }

    @Override
    public List<ValidBasisMethodPayment> getValidBasisMethodPaymentByBasisCode(String basisOfPaymentCode) {
        
        List<ValidBasisMethodPayment> results = new ArrayList<ValidBasisMethodPayment>( businessObjectService.findMatchingOrderBy(ValidBasisMethodPayment.class,
                Collections.singletonMap(BASISOFPAYMENTCODE,  basisOfPaymentCode ),
                METHODOFPAYMENTCODE, 
                true ));
        return results;
    }

    @Override
    public ValidAwardBasisPayment getValidAwardBasisPayment( Integer validAwardBasisPaymentId ) {
        ValidAwardBasisPayment vBasisPayment = (ValidAwardBasisPayment)businessObjectService.findByPrimaryKey(ValidAwardBasisPayment.class, Collections.singletonMap(VALIDAWARDBASISPAYMENT_ID, validAwardBasisPaymentId));
        return vBasisPayment;
    }
    
    /**
     * Gets the businessObjectService attribute. 
     * @return Returns the businessObjectService.
     */
    protected BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }


    /**
     * Sets the businessObjectService attribute value.
     * @param businessObjectService The businessObjectService to set.
     */
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
