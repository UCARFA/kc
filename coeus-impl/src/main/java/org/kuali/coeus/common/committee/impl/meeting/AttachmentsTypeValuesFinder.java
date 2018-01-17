/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttachmentsTypeValuesFinder extends UifKeyValuesFinderBase {
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for ( AttachmentsEntryType attachmentsEntryType : getAttachmentsEntryTypes()) {
                  keyValues.add(new ConcreteKeyValue(attachmentsEntryType.getAttachmentsTypeCode(), attachmentsEntryType.getDescription()));
        }
        keyValues.add(0, ValuesFinderUtils.getSelectOption());
        return keyValues;
        
    }
    
    private List<AttachmentsEntryType> getAttachmentsEntryTypes(){
        List<AttachmentsEntryType> entryTypes = (List<AttachmentsEntryType>) KcServiceLocator.getService(BusinessObjectService.class)
                .findAll(AttachmentsEntryType.class);
       Collections.sort(entryTypes);
       return entryTypes;
    }
    
}
