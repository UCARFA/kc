/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.kuali.coeus.common.framework.person.attr.PersonEditableField;
import org.kuali.coeus.sys.framework.keyvalue.KeyValueComparator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.service.DataDictionaryService;
import org.kuali.rice.krad.datadictionary.AttributeDefinition;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.sort;
import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;

/**
 * Lookup acceptable values for <code>{@link PersonEditableField}</code> business object
 *  
 * @author $Author: gmcgrego $
 * @version $Revision: 1.5 $
 */
public class PersonEditableFieldValuesFinder extends UifKeyValuesFinderBase {
    List<AttributeDefinition> attributes; 

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> retval = new ArrayList<KeyValue>();
        retval.add(ValuesFinderUtils.getSelectOption());

        for (AttributeDefinition attribute : getAttributes()) {
            if (!getExcludedAttributes().contains(attribute.getName())) {
                retval.add(new ConcreteKeyValue(attribute.getName(), attribute.getLabel()));
            }
        }
        
        sort(retval, new KeyValueComparator());
        
        return retval;
    }

    /**
     * Returns a searchable <code>{@link Collection}</code> of attributes to explicitly not allow for <code>{@link PersonEditableField}</code>
     *  assignment.
     *  
     * @return Collection&lt;String&gt;
     */
    private Collection<String> getExcludedAttributes() {
        return asList(new String[] {"proposalNumber", "proposalPersonNumber", "personId", "rolodexId", "delete", "versionNumber"});
    }
    
    /**
     * Read-only access to a map of attributes for <code>{@link ProposalPerson}</code>
     * @return Map&lt;String, AttributeDefinition&gt;
     */
    private List<AttributeDefinition> getAttributes() {
    	if (attributes == null) {
    		attributes = getDataDictionaryService().getDataDictionary().getBusinessObjectEntry(ProposalPerson.class.getName()).getAttributes();
    	}
        return attributes;
    }
    
    /**
     * Lookup the <code>{@link DataDictionaryService}</code>
     * 
     * @return DataDictionaryService
     */
    private DataDictionaryService getDataDictionaryService() {
        return getService(DataDictionaryService.class);
    }
}
