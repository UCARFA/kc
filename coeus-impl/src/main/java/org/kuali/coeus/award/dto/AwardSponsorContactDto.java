/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;


import com.codiform.moo.annotation.Property;

public class AwardSponsorContactDto {

    protected Integer rolodexId;
    protected String roleCode;
    private Long awardContactId;
    private String orgName;
    @Property(translate = true, update = true)
    private RolodexDto rolodex;

    public Integer getRolodexId() {
        return rolodexId;
    }

    public void setRolodexId(Integer rolodexId) {
        this.rolodexId = rolodexId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getAwardContactId() {
        return awardContactId;
    }

    public void setAwardContactId(Long awardContactId) {
        this.awardContactId = awardContactId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public RolodexDto getRolodex() {
        return rolodex;
    }

    public void setRolodex(RolodexDto rolodex) {
        this.rolodex = rolodex;
    }
}
