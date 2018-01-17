/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.negotiations.bo.NegotiationAssociationType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NegotiationAssociationTypeValuesFinder extends UifKeyValuesFinderBase {
    
    private BusinessObjectService businessObjectService;
    /**
     * Filter results based on whether the association is enabled.
     * @see org.kuali.rice.krad.keyvalues.PersistableBusinessObjectValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<ConcreteKeyValue> labels = new ArrayList<ConcreteKeyValue>();
        Collection<NegotiationAssociationType> associations = getBusinessObjectService().findAll(NegotiationAssociationType.class);
        for (NegotiationAssociationType type : associations) {
            if (type.isActive()){
                labels.add(new ConcreteKeyValue(type.getId().toString(), type.getDescription()));
            }
        }
        Collections.sort(labels);
        labels.add(0, new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));
        
        List<KeyValue> returnLabels = new ArrayList<KeyValue>();
        returnLabels.addAll(labels);
        
        return returnLabels;
    }

    protected BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
