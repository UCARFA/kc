/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InstitutionalProposalUnitContactsProjectRoleValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        BusinessObjectService boService = KcServiceLocator.getService(BusinessObjectService.class);
        Collection<UnitAdministratorType> types = (Collection<UnitAdministratorType>) boService.findAll(UnitAdministratorType.class);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (UnitAdministratorType aType: types) {
            if ( aType.getDefaultGroupFlag().equals(Constants.UNIT_CONTACTS_DEFAULT_GROUP_FLAG)) {    // only get Unit Contacts
                keyValues.add(new ConcreteKeyValue(aType.getCode(), aType.getDescription()));
            }
        }
        keyValues.add(0, new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));    
        
        return keyValues;
    }
}
