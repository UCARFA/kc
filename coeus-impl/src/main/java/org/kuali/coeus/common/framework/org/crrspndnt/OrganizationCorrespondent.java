/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.org.crrspndnt;

import org.kuali.coeus.common.framework.crrspndnt.Correspondent;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.common.framework.person.KcPerson;

public class OrganizationCorrespondent extends Correspondent {

    private static final long serialVersionUID = 1L;

    private String organizationId;

    private Organization organization;
    
    public OrganizationCorrespondent() {
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
    public KcPerson getPerson() {
        return getKcPersonService().getKcPersonByPersonId(getPersonId());
    }
    
    @Override
    public org.kuali.kra.irb.correspondence.CorrespondentType getCorrespondentType() {
        return (org.kuali.kra.irb.correspondence.CorrespondentType) correspondentType;
    }

    public void setCorrespondentType(org.kuali.kra.irb.correspondence.CorrespondentType correspondentType) {
        this.correspondentType = correspondentType;
    }
    
}
