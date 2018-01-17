/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.closeout;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * This class is a values finder for <code>ReportClass</code> business object.
 */
public class CloseoutReportTypeValuesFinder extends UifKeyValuesFinderBase {
    
    private ParameterService parameterService;
    
    /**
     * Constructs the list of Report Classes using KeyValuesService.  
     * Each entry in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * report class code and the "value" is the textual description that is viewed
     * by a user.
     *
     */
    @Override
    public List<KeyValue> getKeyValues() {
        Collection<CloseoutReportType> closeoutReportTypes = (Collection<CloseoutReportType>)getKeyValuesService().findAll(CloseoutReportType.class);
        
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        
        for(CloseoutReportType closeoutReportType: closeoutReportTypes){
            if (!StringUtils.equalsIgnoreCase(closeoutReportType.getCloseoutReportCode(), this.getParameterService().getParameterValueAsString(
                    AwardDocument.class, 
                    KeyConstants.CLOSE_OUT_REPORT_TYPE_USER_DEFINED))){
                keyValues.add(new ConcreteKeyValue(closeoutReportType.getCloseoutReportCode(), closeoutReportType.getDescription()));    
            }
        }
        
        return keyValues;
    }
    
    protected KeyValuesService getKeyValuesService(){
        return (KeyValuesService) KcServiceLocator.getService(KeyValuesService.class);
    }
    
    /**
     * Looks up and returns the ParameterService.
     * @return the parameter service. 
     */
    protected ParameterService getParameterService() {
        if (this.parameterService == null) {
            this.parameterService = KcServiceLocator.getService(ParameterService.class);
        }
        return this.parameterService;
    }
   
}
