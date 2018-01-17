/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.instprop.impl.api.dto;

public class IpPersonDto {


    private String personId;
    private String roleCode;
    private String keyPersonRole;
    private Integer rolodexId;

    private Long institutionalProposalContactId;

    public Integer getRolodexId() {
        return rolodexId;
    }

    public void setRolodexId(Integer rolodexId) {
        this.rolodexId = rolodexId;
    }

    public String getPersonId() {
        return personId;
    }

    public Long getInstitutionalProposalContactId() {
        return institutionalProposalContactId;
    }

    public void setInstitutionalProposalContactId(Long institutionalProposalContactId) {
        this.institutionalProposalContactId = institutionalProposalContactId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getKeyPersonRole() {
        return keyPersonRole;
    }

    public void setKeyPersonRole(String keyPersonRole) {
        this.keyPersonRole = keyPersonRole;
    }
}
