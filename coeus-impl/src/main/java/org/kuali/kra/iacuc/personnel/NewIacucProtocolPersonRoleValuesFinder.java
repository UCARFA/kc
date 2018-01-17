/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.personnel;

import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NewIacucProtocolPersonRoleValuesFinder extends UifKeyValuesFinderBase {

    

    private static final long serialVersionUID = 6921118298914738374L;

    /**
     * Constructs the list of Protocol Person Roles.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * status code and the "value" is the textual description that is viewed
     * by a user.  The list is obtained from the PROTOCOL_PERSON_ROLES database table
     * via the "KeyValueFinderService".
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        KeyValuesService keyValuesService = KcServiceLocator.getService(KeyValuesService.class);
        Collection<IacucProtocolPersonRole> protocolPersonRoles = keyValuesService.findAllOrderBy(IacucProtocolPersonRole.class,"description",true);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(0, new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));
        for (IacucProtocolPersonRole protocolPersonRole : protocolPersonRoles) {
            keyValues.add(new ConcreteKeyValue(protocolPersonRole.getProtocolPersonRoleId(), protocolPersonRole.getDescription()));                            
        }
        return keyValues;
    }

}
