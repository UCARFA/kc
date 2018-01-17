/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.*;

public class IacucLocationNameValuesFinder extends UifKeyValuesFinderBase {


    private static final long serialVersionUID = -8545179201741577722L;
    private Integer locationTypeCode;

    /**
     * Constructs the list of Iacuc Location Names. Each entry in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * location id and the "value" is the textual description that is viewed by a user. The list is obtained from the IACUC_LOCATION_NAME
     * database table via the "KeyValuesService".
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types. The first entry is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        Map<String, Object> filterValues = new HashMap<String, Object>();
        filterValues.put("locationTypeCode", getLocationTypeCode());
        Collection<IacucLocationName> iacucLocationNames = getKeyValuesService().findMatching(IacucLocationName.class,
                filterValues);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(0, new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));
        for (Iterator<IacucLocationName> iter = iacucLocationNames.iterator(); iter.hasNext();) {
            IacucLocationName iacucLocationName = (IacucLocationName) iter.next();
            keyValues.add(new ConcreteKeyValue(iacucLocationName.getLocationId().toString(),
                    iacucLocationName.getLocationName()));
        }
        return keyValues;
    }
    
    protected KeyValuesService getKeyValuesService() {
        return (KeyValuesService) KcServiceLocator.getService("keyValuesService");
    }

    public Integer getLocationTypeCode() {
        return locationTypeCode;
    }

    public void setLocationTypeCode(Integer locationTypeCode) {
        this.locationTypeCode = locationTypeCode;
    }

}
