/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.service;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipRole;
import org.kuali.kra.bo.ResearchAreaBase;

import java.util.Collection;

public interface CommitteeMembershipServiceBase<CMT extends CommitteeBase<CMT, ?, ?>> {
    /**
     * This method adds a CommitteeMembershipBase to the List of CommitteeMemberships.
     * @param committee which contains list of CommitteeeMembership.
     * @param committeeMembership object is added to CommitteeMemberhip list.
     */
    void addCommitteeMembership(CMT committee, CommitteeMembershipBase committeeMembership);
    
    /**
     * This method deletes CommitteeMembershipBase(s) - those marked as delete
     * @param committee which contains list of CommitteeMemberhips
     */
    void deleteCommitteeMembership(CMT committee);
    
    /**
     * This method adds a CommitteeMembershipRole to the list of CommitteeMembershipRoles of a 
     * committee member.
     * @param committee - the committee that contains the CommitteeMembershipBase to which the role is to be added.
     * @param selectedmembershipIndex - the index position of the CommitteeMembershipBase to which the role is to be added. 
     * @param committeeMembershipRole - the role that is to be added
     */
    void addCommitteeMembershipRole(CMT committee, int selectedMembershipIndex, CommitteeMembershipRole committeeMembershipRole);

    /**
     * This method deletes a CommitteeMembershipRole from the list of CommitteeMembershipRoles
     * @param committee - the committee that contains the CommitteeMembershipBase from which the role is to be deleted.
     * @param selectedMembershipIndex - the index position of the CommitteeMembershipBase from which the role is to be deleted.
     * @param lineNumber - the position of the ComitteeMembershipRole to be deleted
     */
    void deleteCommitteeMembershipRole(CMT committee, int selectedMembershipIndex, int lineNumber);

    /**
     * This method adds CommitteeMembershipExpertise to a committeeMembership
     * @param committeeMembership - the CommitteeMembershipBase to which the expertise is to be added.
     * @param committeeMembershipExpertise - collection of expertise that is to be added
     */
    void addCommitteeMembershipExpertise(CommitteeMembershipBase committeeMembership, Collection<ResearchAreaBase> researchAreas);

    /**
     * This method deletes a CommitteeMembershipExpertise from the list of CommitteeMembershipExpertise
     * @param committee - the committee that contains the CommitteeMembershipBase from which the role is to be deleted.
     * @param selectedMembershipIndex - the index position of the CommitteeMembershipBase from which the role is to be deleted.
     * @param lineNumber - the position of the CommitteeMembershipExpertise to be deleted
     */
    void deleteCommitteeMembershipExpertise(CMT committee, int selectedMembershipIndex, int lineNumber);

    /**
     * 
     * This method is to check whether this committee member is assigned as reviewer of a protocol
     * which is submitted to this committee.
     * 
     * @param member
     * @param committeeId
     * @return
     */
    boolean isMemberAssignedToReviewer(CommitteeMembershipBase member, String committeeId);

    /**
     * 
     * This method is to check whether this committee member has attended a scheduled meeting
     * which is submitted to this committee.
     * 
     * @param member
     * @param committeeId
     * @return
     */
    boolean isMemberAttendedMeeting(CommitteeMembershipBase member, String committeeId);
}
