/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.org.crrspndnt;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.org.OrganizationService;
import org.kuali.coeus.common.framework.org.crrspndnt.OrganizationCorrespondent;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kew.api.identity.Id;
import org.kuali.rice.kew.api.identity.PrincipalId;
import org.kuali.rice.kew.api.rule.RoleName;
import org.kuali.rice.kew.engine.RouteContext;
import org.kuali.rice.kew.routeheader.DocumentContent;
import org.kuali.rice.kew.rule.GenericRoleAttribute;
import org.kuali.rice.kew.rule.QualifiedRoleName;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrganizationCorrespondentRoleAttribute extends GenericRoleAttribute {

    private static final String ROLE_NAME = "OrganizationCorrespondent";
    private static final String ORGANIZATION_ID = "organizationId";

    @Override
    public List<String> getQualifiedRoleNames(String roleName, DocumentContent documentContent) {
        List<String> qualifiedRoleNames = new ArrayList<String>();
        qualifiedRoleNames.add(ROLE_NAME);
        
        return qualifiedRoleNames;
    }

    @Override
    public List<RoleName> getRoleNames() {
        RoleName role = RoleName.Builder.create(OrganizationCorrespondentRoleAttribute.class.getName(), ROLE_NAME, ROLE_NAME).build();
        return Collections.singletonList(role);
    }
    
    @Override
    public Map<String, String> getProperties() {
        // intentionally unimplemented...not intending on using this attribute client-side
        return null;
    }

    private OrganizationService getOrganizationService() {
        return KcServiceLocator.getService(OrganizationService.class);
    }
    
    @Override
    protected List<Id> resolveRecipients(RouteContext routeContext, QualifiedRoleName qualifiedRoleName) {
        List<Id> members = new ArrayList<Id>();
        
        DocumentContent dc = routeContext.getDocumentContent();
        NodeList nodes = dc.getDocument().getElementsByTagName(ORGANIZATION_ID);
        String orgId = nodes.item(0).getTextContent();
        if (StringUtils.isNotBlank(orgId)) {
            List<OrganizationCorrespondent> organizationCorrespondents = getOrganizationService().retrieveOrganizationCorrespondentsByOrganizationId(orgId);
            for ( OrganizationCorrespondent organizationCorrespondent : organizationCorrespondents ) {
                if ( StringUtils.isNotBlank(organizationCorrespondent.getPersonId()) ) {
                    members.add( new PrincipalId(organizationCorrespondent.getPersonId()));
                }
            }
        }
        
        return members;
    }

}
