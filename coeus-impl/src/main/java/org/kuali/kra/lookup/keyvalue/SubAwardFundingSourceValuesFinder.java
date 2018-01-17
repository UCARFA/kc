/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.lookup.keyvalue;

import java.util.*;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.subaward.bo.SubAwardFundingSource;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;

public class SubAwardFundingSourceValuesFinder extends FormViewAwareUifKeyValuesFinderBase {

    private transient BusinessObjectService businessObjectService;

    @Override
    public List<KeyValue> getKeyValues() {
        final SubAwardDocument doc = (SubAwardDocument) getDocument();
        final StringBuilder fundingValues = new StringBuilder();
        final Long subawardID = doc.getSubAward().getSubAwardId();
        final List<KeyValue> keyValues = new ArrayList<>();
        final Collection<SubAwardFundingSource> fundingSource = getBusinessObjectService().findMatching(SubAwardFundingSource.class, Collections.singletonMap("subAwardId", subawardID));
        
        for (SubAwardFundingSource subAwardFunding : fundingSource) {
                fundingValues.append(subAwardFunding.getAward().getAwardNumber());
                keyValues.add(new ConcreteKeyValue(subAwardFunding.getSubAwardFundingSourceId().toString(),"Award:"+subAwardFunding.getAward().getAwardNumber()));
        }
        if(fundingValues.length() == 0){
            keyValues.add(0, new ConcreteKeyValue("", "No Funding Source has been added to this Subaward"));
        }
        return keyValues;
    }


    public BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }

        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
