/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
// TODO *********code has been moved to base class, should ultimately be removed**********

package org.kuali.kra.irb.protocol;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.authorization.KraAuthorizationConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kim.api.permission.PermissionService;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ProtocolTypeValuesFinder extends UifKeyValuesFinderBase {
    /**
     * Constructs the list of Protocol Types.  Each entry
     * in the list is a &lt;key, value&gt; pair, where the "key" is the unique
     * status code and the "value" is the textual description that is viewed
     * by a user.  The list is obtained from the PROTOCOL_TYPE database table
     * via the "KeyValueFinderService".
     * 
     * @return the list of &lt;key, value&gt; pairs of abstract types.  The first entry
     * is always &lt;"", "select:"&gt;.
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    private PermissionService permissionService;
    private static final String PERMISSION_NAME = "View Active Protocol Types";
    @Override
    public List<KeyValue> getKeyValues() {
        KeyValuesService keyValuesService = (KeyValuesService) KcServiceLocator.getService("keyValuesService");
        Collection protocolTypes = keyValuesService.findAllOrderBy(ProtocolType.class,"description",true);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();   
        boolean canViewNonGlobalProtocolTypes = getPermissionService().hasPermission(GlobalVariables.getUserSession().getPrincipalId(), KraAuthorizationConstants.KC_SYSTEM_NAMESPACE_CODE, PERMISSION_NAME);
        for (Iterator iter = protocolTypes.iterator(); iter.hasNext();) {
            ProtocolType protocolType = (ProtocolType) iter.next();
           if(protocolType.isGlobalFlag() || canViewNonGlobalProtocolTypes ){
            if (StringUtils.equals(protocolType.getDescription(), "Standard")) {
                keyValues.add(0, new ConcreteKeyValue(protocolType.getProtocolTypeCode().toString(), protocolType.getDescription()));
            } else {
                keyValues.add(new ConcreteKeyValue(protocolType.getProtocolTypeCode().toString(), protocolType.getDescription()));
            }
        }
        }
        return keyValues;
    }  
    public PermissionService getPermissionService() {
        if (permissionService == null) {
            permissionService = KimApiServiceLocator.getPermissionService();
        }
        return permissionService;
    }
}
