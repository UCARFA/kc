/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import java.util.Objects;

import java.sql.Date;

/**
 * 
 * This class implements the committee membership role business object.
 * 
 */
public class CommitteeMembershipRole extends CommitteeSequenceAssociateBase {

    private static final long serialVersionUID = 6048477313137155626L;

    private Long committeeMembershipRoleId;

    private Long committeeMembershipIdFk;

    private String membershipRoleCode;

    private Date startDate;

    private Date endDate;

    private MembershipRole membershipRole;

    public static final String ALTERNATE_ROLE = "12";

    public static final String INACTIVE_ROLE = "14";

    public CommitteeMembershipRole() {
    }

    public Long getCommitteeMembershipRoleId() {
        return committeeMembershipRoleId;
    }

    public void setCommitteeMembershipRoleId(Long committeeMembershipRoleId) {
        this.committeeMembershipRoleId = committeeMembershipRoleId;
    }

    public Long getCommitteeMembershipIdFk() {
        return committeeMembershipIdFk;
    }

    public void setCommitteeMembershipIdFk(Long committeeMembershipIdFk) {
        this.committeeMembershipIdFk = committeeMembershipIdFk;
    }

    public String getMembershipRoleCode() {
        return membershipRoleCode;
    }

    public void setMembershipRoleCode(String membershipRoleCode) {
        this.membershipRoleCode = membershipRoleCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public MembershipRole getMembershipRole() {
        return membershipRole;
    }

    public void setMembershipRole(MembershipRole membershipRole) {
        this.membershipRole = membershipRole;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        CommitteeMembershipRole committeeMembershipRole = (CommitteeMembershipRole) obj;
        if (Objects.equals(this.committeeMembershipIdFk, committeeMembershipRole.committeeMembershipIdFk) && Objects.equals(this.membershipRoleCode, committeeMembershipRole.membershipRoleCode) && Objects.equals(this.startDate, committeeMembershipRole.startDate) && Objects.equals(this.endDate, committeeMembershipRole.endDate)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (this.committeeMembershipIdFk == null ? 0 : this.committeeMembershipIdFk.hashCode());
        result = PRIME * result + (this.committeeMembershipRoleId == null ? 0 : this.committeeMembershipRoleId.hashCode());
        result = PRIME * result + (this.startDate == null ? 0 : this.startDate.hashCode());
        return result;
    }

    @Override
    public void resetPersistenceState() {
        setCommitteeMembershipRoleId(null);
    }
}
