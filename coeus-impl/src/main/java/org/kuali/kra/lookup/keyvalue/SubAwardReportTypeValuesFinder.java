/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.lookup.keyvalue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.subaward.bo.SubAwardReportType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

public class SubAwardReportTypeValuesFinder extends UifKeyValuesFinderBase {
    
    @Override
    public List<KeyValue> getKeyValues() {
        KeyValuesService keyValuesService = (KeyValuesService) KcServiceLocator.getService("keyValuesService");
        Collection SubAwardReportType = keyValuesService.findAllOrderBy(SubAwardReportType.class,"sortId",true);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        
        for (Iterator iter = SubAwardReportType.iterator(); iter.hasNext();) {
            SubAwardReportType reportTypes = (SubAwardReportType) iter.next();
            keyValues.add(new ConcreteKeyValue(reportTypes.getSubAwardReportTypeCode().toString(), reportTypes.getDescription()));                            
        }       
        return keyValues;
    }

}
