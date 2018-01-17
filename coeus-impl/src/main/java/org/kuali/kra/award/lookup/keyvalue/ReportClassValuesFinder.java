/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.paymentreports.ReportClass;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * This class is a values finder for <code>ReportClass</code> business object.
 */
public class ReportClassValuesFinder extends UifKeyValuesFinderBase {
    
    /**
     * Constructs the list of Report Classes using KeyValuesService.  
     * Each entry in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * report class code and the "value" is the textual description that is viewed
     * by a user.
     * 
     */
    @Override
    public List<KeyValue> getKeyValues() {
        Collection<ReportClass> reportClasses = (Collection<ReportClass>)getKeyValuesService().findAll(ReportClass.class);
        
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        
        for(ReportClass reportClass: reportClasses){
            keyValues.add(new ConcreteKeyValue(reportClass.getReportClassCode(), reportClass.getDescription()));
        }
        
        return keyValues;
    }
    
    protected KeyValuesService getKeyValuesService(){
        return (KeyValuesService) KcServiceLocator.getService("keyValuesService");
    }
   
}
