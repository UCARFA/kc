/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions;

import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class creates the key/values pair ProtocolCorrespondenceType that are valid as a final correspondence 
 * action for batch correspondence.
 */
public class ProtocolFinalCorrespondenceActionTypeValuesFinder extends IrbActionsKeyValuesBase {
    
    /**
     * Build the list of KeyValues using the key (keyAttributeName) and
     * label (labelAttributeName) of the list of all business objects found
     * for the BO class specified along with a "no correspondence action" entry.
     * 
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        
        Collection<ProtocolCorrespondenceType> protocolCorrespondenceTypes = this.getBusinessObjectService().findAll(ProtocolCorrespondenceType.class);

        keyValues.add(new ConcreteKeyValue("  ", "no correspondence action"));
        for (ProtocolCorrespondenceType protocolCorrespondenceType : protocolCorrespondenceTypes) {
            keyValues.add(new ConcreteKeyValue(protocolCorrespondenceType.getProtoCorrespTypeCode(), protocolCorrespondenceType.getDescription()));
        }
        
        return keyValues;
    }

}
