/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.bo;

import org.kuali.coeus.common.framework.crrspndnt.Correspondent;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.kra.iacuc.correspondence.IacucCorrespondentType;
import org.kuali.kra.protocol.correspondence.CorrespondentType;

public class IacucOrganizationCorrespondent extends Correspondent {

    private static final long serialVersionUID = 1L;

    private String organizationId;
    
    private Organization organization;

    public IacucOrganizationCorrespondent() {
        super();
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public IacucCorrespondentType getCorrespondentType() {
        return (IacucCorrespondentType) correspondentType;
    }

    public void setCorrespondentType(IacucCorrespondentType correspondentType) {
        this.correspondentType = (CorrespondentType) correspondentType;
    }

}
