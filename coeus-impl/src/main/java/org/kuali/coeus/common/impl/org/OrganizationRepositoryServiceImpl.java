/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.org;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.api.org.OrganizationContract;
import org.kuali.coeus.common.api.org.OrganizationRepositoryService;
import org.kuali.coeus.common.api.rolodex.RolodexContract;
import org.kuali.coeus.common.api.rolodex.RolodexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("organizationRepositoryService")
public class OrganizationRepositoryServiceImpl implements OrganizationRepositoryService {

    @Autowired
    @Qualifier("rolodexService")
    private RolodexService rolodexService;

    @Override
    public String getCognizantFedAgency(OrganizationContract organization) {
        if (organization == null) {
            throw new IllegalArgumentException("organization is null");
        }

        final StringBuilder fedAgency = new StringBuilder();
        if (organization.getCognizantAuditor() != null) {
            RolodexContract rolodex = rolodexService.getRolodex(organization.getCognizantAuditor());
            if (rolodex != null) {
                fedAgency.append(rolodex.getOrganization());
                fedAgency.append(", ");
                fedAgency.append(StringUtils.trimToEmpty(rolodex.getFirstName()));
                fedAgency.append(" ");
                fedAgency.append(StringUtils.trimToEmpty(rolodex.getLastName()));
                fedAgency.append(" ");
                if (rolodex.getPhoneNumber() != null) {
                    if (rolodex.getPhoneNumber().length() < 180) {
                        fedAgency.append(rolodex.getPhoneNumber());
                    } else {
                        fedAgency.append(rolodex.getPhoneNumber().substring(0, 180));
                    }
                }
            }
        }
        return fedAgency.toString();
    }

    public RolodexService getRolodexService() {
        return rolodexService;
    }

    public void setRolodexService(RolodexService rolodexService) {
        this.rolodexService = rolodexService;
    }
}
