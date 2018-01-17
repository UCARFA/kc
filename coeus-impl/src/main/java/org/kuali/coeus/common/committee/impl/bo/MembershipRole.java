/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class implements the membership role object.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class MembershipRole extends KcPersistableBusinessObjectBase {

    private String membershipRoleCode;

    private String description;
    
    private String committeeTypeCode;
    
    private CommitteeType committeeType;

    public String getCommitteeTypeCode() {
        return committeeTypeCode;
    }

    public void setCommitteeTypeCode(String committeeTypeCode) {
        this.committeeTypeCode = committeeTypeCode;
    }

    public CommitteeType getCommitteeType() {
        return committeeType;
    }

    public void setCommitteeType(CommitteeType committeeType) {
        this.committeeType = committeeType;
    }

    public MembershipRole() {
    }

    public String getMembershipRoleCode() {
        return membershipRoleCode;
    }

    public void setMembershipRoleCode(String membershipRoleCode) {
        this.membershipRoleCode = membershipRoleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
