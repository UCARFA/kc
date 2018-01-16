/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.org;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.common.framework.org.OrganizationService;
import org.kuali.coeus.common.framework.org.crrspndnt.OrganizationCorrespondent;
import org.kuali.kra.iacuc.bo.IacucOrganizationCorrespondent;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the implementation of the OrganizationService.
 * It provides service methods related to organization object.
 */
@Component("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    private static final String ORGANIZATION_ID = "organizationId";

	@Autowired
	@Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Override
    public String getOrganizationName(String organizationId) {
        final Organization organization = getOrganization(organizationId);
        return organization != null ? organization.getOrganizationName() : null;
    }

    @Override
    public String getOrganizationDuns(String organizationId) {
        final Organization organization = getOrganization(organizationId);
        return organization != null ? organization.getDunsNumber() : null;
    }

    @Override
    public Organization getOrganization(String organizationId) {
        Organization organization = null;
        if (StringUtils.isNotEmpty(organizationId)) {
            Map<String, Object> primaryKeys = new HashMap<>();
            primaryKeys.put(ORGANIZATION_ID, organizationId);
            organization = getBusinessObjectService().findByPrimaryKey(Organization.class, primaryKeys);
        }

        return organization;
    }

    @Override
    public List<OrganizationCorrespondent> retrieveOrganizationCorrespondentsByOrganizationId(String organizationId) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(ORGANIZATION_ID, organizationId);
        return (List<OrganizationCorrespondent>) getBusinessObjectService().findMatching(OrganizationCorrespondent.class, queryMap);
    }
    
    @Override
    public List<IacucOrganizationCorrespondent> retrieveIacucOrganizationCorrespondentsByOrganizationId(String organizationId) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(ORGANIZATION_ID, organizationId);
        return (List<IacucOrganizationCorrespondent>) getBusinessObjectService().findMatching(IacucOrganizationCorrespondent.class, queryMap);
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public BusinessObjectService getBusinessObjectService() {
        return this.businessObjectService;
    }
    
}
