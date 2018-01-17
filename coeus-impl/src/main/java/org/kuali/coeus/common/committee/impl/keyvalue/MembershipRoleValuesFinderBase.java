/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.keyvalue;

import org.kuali.coeus.common.committee.impl.bo.MembershipRole;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MembershipRoleValuesFinderBase extends UifKeyValuesFinderBase {


    private static final long serialVersionUID = -7492852270320003877L;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyLabels = new ArrayList<KeyValue>();
        keyLabels.add(ValuesFinderUtils.getSelectOption());

        Map<String, String> criteria = new HashMap<String, String>();
        
        criteria.put("committeeTypeCode", getCommitteeTypeCodeHook());

        List<? extends MembershipRole> roles = (List<? extends MembershipRole>) getBusinessObjectService().findMatching(MembershipRole.class, criteria);

        for(MembershipRole role : roles) {
            keyLabels.add(new ConcreteKeyValue(role.getMembershipRoleCode(), role.getDescription()));
        }
        return keyLabels;
    }
    
    protected abstract String getCommitteeTypeCodeHook();

    protected BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }
    
}
