/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.multicampus;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.attr.KcPersonExtendedAttributes;
import org.kuali.coeus.common.framework.multicampus.MultiCampusIdentityService;
import org.kuali.rice.kim.api.identity.IdentityService;
import org.kuali.rice.kim.api.identity.affiliation.EntityAffiliationContract;
import org.kuali.rice.kim.api.identity.entity.EntityContract;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component("multiCampusIdentityService")
public class MultiCampusIdentityServiceImpl implements MultiCampusIdentityService {

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("identityService")
    private IdentityService identityService;

    @Override
    public String getMultiCampusPrincipalName(String principalName, String campusCode) {
        String result = principalName;
        
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("multiCampusPrincipalName", principalName);
        Collection<KcPersonExtendedAttributes> multiCampusPersons = getBusinessObjectService().findMatching(KcPersonExtendedAttributes.class, fieldValues);
        for (KcPersonExtendedAttributes multiCampusPerson : multiCampusPersons) {
            String principalId = multiCampusPerson.getPersonId();
            if (hasCampusAffiliation(principalId, campusCode)) {
                result = getIdentityService().getPrincipal(principalId).getPrincipalName();
                break;
            }
        }
        
        return result;
    }
    
    private boolean hasCampusAffiliation(String principalId, String campusCode) {
        boolean hasCampusAffiliation = false;
        
        EntityContract entityInfo = getIdentityService().getEntityByPrincipalId(principalId);
        for (EntityAffiliationContract affiliation : entityInfo.getAffiliations()) {
            if (StringUtils.equals(campusCode, affiliation.getCampusCode())) {
                hasCampusAffiliation = true;
                break;
            }
        }
        
        return hasCampusAffiliation;
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }
    
}
