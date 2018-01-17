/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.ValidAwardBasisPayment;
import org.kuali.kra.award.service.AwardPaymentAndInvoicesService;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Values Finder for Invoice Instructions Indicator Values.
 * 
 */
public class ValidAwardBasisPaymentValueFinder extends FormViewAwareUifKeyValuesFinderBase {
    
    private transient AwardPaymentAndInvoicesService awardPaymentInfoService;
    
    private AwardPaymentAndInvoicesService getAwardPaymentAndInvoicesService() {
        if( awardPaymentInfoService == null ) {
            awardPaymentInfoService = KcServiceLocator.getService(AwardPaymentAndInvoicesService.class);
        }
        return awardPaymentInfoService;
    }

    @Override
    public List<KeyValue> getKeyValues() {
       List<KeyValue> keyLabels = new ArrayList<KeyValue>();
       AwardDocument awardDocument = (AwardDocument) getDocument();
       keyLabels.add( new ConcreteKeyValue( "", "select" ));
       if( awardDocument != null && awardDocument.getAward() != null
               && awardDocument.getAward().getAwardTypeCode() != null ) {
         
           List<ValidAwardBasisPayment> results =  getAwardPaymentAndInvoicesService().getValidAwardBasisPaymentsByAwardTypeCode(awardDocument.getAward().getAwardTypeCode());
           for( ValidAwardBasisPayment awardBasisPayment : results ) {
               awardBasisPayment.refresh();
               keyLabels.add( new ConcreteKeyValue( awardBasisPayment.getBasisOfPaymentCode(), awardBasisPayment.getBasisOfPayment().getDescription()));
           }
       }
       return keyLabels;
    }
    
    
}
