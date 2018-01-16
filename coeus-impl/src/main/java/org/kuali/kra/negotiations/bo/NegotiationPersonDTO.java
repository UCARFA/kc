/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.bo;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.kra.bo.AbstractProjectPerson;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

public class NegotiationPersonDTO implements AbstractProjectPerson {
    
    private KcPerson person;
    private String roleCode;
    
    public NegotiationPersonDTO(KcPerson person, String roleCode) {
        this.person = person;
        this.roleCode = roleCode;
    }

    @Override
    public KcPerson getPerson() {
        return person;
    }

    public void setPerson(KcPerson person) {
        this.person = person;
    }

    @Override
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    
    public boolean isPrincipalInvestigator() {
        return StringUtils.equals(roleCode, Constants.PRINCIPAL_INVESTIGATOR_ROLE);
    }

    @Override
    public String getFullName() {
        return getPerson().getFullName();
    }

    @Override
    public PersistableBusinessObject getParent() {
        return null;
    }

    @Override
    public String getPersonId() {
        return getPerson().getPersonId();
    }

    @Override
    public Integer getRolodexId() {
        return null;
    }

}
