/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup;

import org.apache.commons.collections4.CollectionUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.coi.CoiReviewer;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoiReviewerValuesFinder extends UifKeyValuesFinderBase {

    private BusinessObjectService businessObjectService;
    
    
    public BusinessObjectService getBusinessObjectService() {
        if(null == this.businessObjectService) {
            this.setBusinessObjectService(KcServiceLocator.getService(BusinessObjectService.class));
        }
        return this.businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();

        Collection<CoiReviewer> reviewerCodes = getBusinessObjectService().findAll(CoiReviewer.class);
        if (CollectionUtils.isNotEmpty(reviewerCodes)) {
            for (CoiReviewer reviewerCode : reviewerCodes) {
                keyValues.add(new ConcreteKeyValue(reviewerCode.getReviewerCode(), reviewerCode.getDescription()));
            }
        }
        
        return keyValues;
    }

}
