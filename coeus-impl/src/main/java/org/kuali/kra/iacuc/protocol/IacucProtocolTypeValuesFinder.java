/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.protocol;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IacucProtocolTypeValuesFinder extends UifKeyValuesFinderBase {

    private static final long serialVersionUID = -3626497316348500710L;

    /**
     * Constructs the list of Protocol Types.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * status code and the "value" is the textual description that is viewed
     * by a user.  The list is obtained from the IACUC_PROTOCOL_TYPE database table
     * via the "KeyValueFinderService".
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */

    @Override
    public List<KeyValue> getKeyValues() {
        KeyValuesService keyValuesService = (KeyValuesService) KcServiceLocator.getService("keyValuesService");
        Collection protocolTypes = keyValuesService.findAllOrderBy(IacucProtocolType.class,"description",true);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();   
        for (Iterator iter = protocolTypes.iterator(); iter.hasNext();) {
            IacucProtocolType protocolType = (IacucProtocolType) iter.next();
            keyValues.add(new ConcreteKeyValue(protocolType.getProtocolTypeCode().toString(), protocolType.getDescription()));
        }
        return keyValues;
    }  
}
