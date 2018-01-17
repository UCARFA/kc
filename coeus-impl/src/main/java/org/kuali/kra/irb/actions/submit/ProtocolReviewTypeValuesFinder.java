/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.coeus.sys.framework.keyvalue.PrefixValuesFinder;
import org.kuali.kra.authorization.KraAuthorizationConstants;
import org.kuali.kra.irb.actions.IrbActionsKeyValuesBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kim.api.permission.PermissionService;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Assembles the Protocol Review Types to display in the drop-down menu when
 * submitting a protocol to the IRB office for review.
 */
public class ProtocolReviewTypeValuesFinder extends IrbActionsKeyValuesBase {

    private static final String PERMISSION_NAME = "View Active Protocol Review Types";

    private PermissionService permissionService;

    private List<ProtocolReviewType>allReviewTypes = null;
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = filterActiveProtocolReviewTypes();
        keyValues.add(0, new ConcreteKeyValue(PrefixValuesFinder.getPrefixKey(), PrefixValuesFinder.getDefaultPrefixValue()));
        return keyValues;
    }
    
    private List<KeyValue> filterActiveProtocolReviewTypes() {
        final List<KeyValue> filteredKeyValues = new ArrayList<KeyValue>();
        
        boolean canViewNonGlobalReviewTypes = getPermissionService().hasPermission(
                GlobalVariables.getUserSession().getPrincipalId(), KraAuthorizationConstants.KC_SYSTEM_NAMESPACE_CODE , PERMISSION_NAME);
        
        for (ProtocolReviewType item : getAllReviewTypes()) {
            if (item.isGlobalFlag() || canViewNonGlobalReviewTypes) {
                filteredKeyValues.add(new ConcreteKeyValue(item.getReviewTypeCode(), item.getDescription()));
            }
        }
        
        return filteredKeyValues;
    }

    @SuppressWarnings("unchecked")
    public List<ProtocolReviewType> getAllReviewTypes() {
        if (allReviewTypes == null) {
            allReviewTypes = new ArrayList<ProtocolReviewType>();
            Collection<ProtocolReviewType> prTypes = this.getKeyValuesService().findAll(ProtocolReviewType.class);
            for (ProtocolReviewType protocolReviewType : prTypes) {
                allReviewTypes.add(protocolReviewType);
            }
        }
        return allReviewTypes;
    }

    public PermissionService getPermissionService() {
        if (permissionService == null) {
            permissionService = KimApiServiceLocator.getPermissionService();
        }
        return permissionService;
    }
    

}
