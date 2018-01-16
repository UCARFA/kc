/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup.keyvalue;

import org.apache.commons.collections4.CollectionUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.coi.CoiDisclosureEventType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class CoiDisclosureManualEventTypesValuesFinder extends UifKeyValuesFinderBase {


    private static final long serialVersionUID = -2760943363607401164L;

    /**
     * This method returns all active coi disclosure event types that qualify for a manual disclosure type
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());

        List<CoiDisclosureEventType> eventTypes = (List<CoiDisclosureEventType>) getBusinessObjectService().findAll(CoiDisclosureEventType.class);
        if (CollectionUtils.isNotEmpty(eventTypes)) {
            for (CoiDisclosureEventType eventType : eventTypes) {
                if (eventType.isActive() && !eventType.isSystemEvent()) {
                    keyValues.add(new ConcreteKeyValue(eventType.getEventTypeCode(), eventType.getDescription()));
                }
            }
        }
        
        return keyValues;
    }

    /**
     * 
     * This method returns a reference to the business object service
     * @return the business object service
     */
    private BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }
}
