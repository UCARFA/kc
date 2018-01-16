/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;

import org.kuali.coeus.sys.framework.persistence.KcPersistenceStructureService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.datadictionary.BusinessObjectEntry;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.krad.datadictionary.AttributeDefinition;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProposalColumnsValuesFinder extends UifKeyValuesFinderBase {

    private DataDictionaryService dataDictionaryService;

    @Override
    public List<KeyValue> getKeyValues() {
        BusinessObjectEntry proposalEntry = 
            (BusinessObjectEntry) getDataDictionaryService().getDataDictionary().getBusinessObjectEntry(DevelopmentProposal.class.getName());
        KcPersistenceStructureService persistenceStructureService = KcServiceLocator.getService(KcPersistenceStructureService.class);
        Map<String, String> attrToColumnMap = persistenceStructureService.getPersistableAttributesColumnMap(DevelopmentProposal.class);        
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (AttributeDefinition entry : proposalEntry.getAttributes()) {
            if (attrToColumnMap.get(entry.getName()) == null) {
                //if the data dictionary name cannot be found in the 
                //database mapping then this is not a valid entry
                continue;
            }
            ConcreteKeyValue keyPair = new ConcreteKeyValue();
            keyPair.setKey(attrToColumnMap.get(entry.getName()));
            keyPair.setValue(entry.getShortLabel());
            keyValues.add(keyPair);
        }
        
        return keyValues;
    }
    
    private DataDictionaryService getDataDictionaryService() {
        if (dataDictionaryService == null) {
            dataDictionaryService = KcServiceLocator.getService(DataDictionaryService.class);
        }
        return dataDictionaryService;
    }
}
