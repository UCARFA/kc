/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.decision;

import org.kuali.coeus.common.committee.impl.bo.CommitteeDecisionMotionType;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolActionBean;
import org.kuali.kra.irb.actions.reviewcomments.ReviewAttachmentsBean;
import org.kuali.kra.irb.actions.reviewcomments.ReviewCommentsBean;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.meeting.ProtocolVoteAbstainee;
import org.kuali.kra.meeting.ProtocolVoteRecused;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsBeanBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.*;

/**
 * This class is a bean for managing the input for a committee decision.
 */
public class CommitteeDecision extends ProtocolActionBean implements org.kuali.kra.protocol.actions.decision.CommitteeDecision<CommitteePerson> {

    private static final long serialVersionUID = -8052093280852074307L;
    
    private String motionTypeCode;
    private Integer noCount;
    private Integer yesCount;
    private Integer abstainCount;
    private Integer recusedCount;
    private String votingComments;
    
    private CommitteeDecisionMotionType motionType;
    
    private CommitteePerson newAbstainer = new CommitteePerson();
    private CommitteePerson newRecused = new CommitteePerson();
    
    private List<CommitteePerson> abstainers = new ArrayList<CommitteePerson>();
    private List<CommitteePerson> recused = new ArrayList<CommitteePerson>();
    private List<CommitteePerson> abstainersToDelete = new ArrayList<CommitteePerson>();
    private List<CommitteePerson> recusedToDelete = new ArrayList<CommitteePerson>();
    
    private ReviewCommentsBean reviewCommentsBean;
    
    /**
     * Constructs a CommitteeDecision.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public CommitteeDecision(ActionHelper actionHelper) {
        super(actionHelper);
        
        reviewCommentsBean = new ReviewCommentsBean(Constants.PROTOCOL_COMMITTEE_DECISION_ACTION_PROPERTY_KEY);
    }
    
    /**
     * This method initializes the class.
     */
    @Override
    public void init() {
        // getSubmission(protocol) is not necessary the most recent one.
        // this may cause problem later if the most recent submission does not have schedule, then
        // npe when try to getavailable member
        ProtocolSubmission submission = (ProtocolSubmission) getProtocol().getProtocolSubmission();
        if (submission != null) {
            this.motionTypeCode = submission.getCommitteeDecisionMotionTypeCode();
            this.noCount = submission.getNoVoteCount();
            this.yesCount = submission.getYesVoteCount();
            this.abstainCount = submission.getAbstainerCount();
            this.recusedCount = submission.getRecusedCount();
            this.votingComments = submission.getVotingComments();
            this.setMotionType(submission.getCommitteeDecisionMotionType());
            
            //not sure if I really need to deal with protocol actions    
            //ES: Please remove condition before checking in.
            if (submission.getScheduleIdFk() != null) {
                initializeAbstainees(submission);
                initializeRecused(submission);
            }
        }
    }
    
    @Override
    public Integer getRecusedCount() {
        return this.getRecused().size();
    }

    @Override
    public void setRecusedCount(Integer recusedCount) {
        this.recusedCount = recusedCount;
    }

    private Map<String, Long> getLookUpFields(Long protocolId, Long submissionIdFk) {
        Map<String, Long> lookUpFields = new HashMap<String, Long>();
        lookUpFields.put("PROTOCOL_ID_FK", protocolId);
        lookUpFields.put("SUBMISSION_ID_FK", submissionIdFk);
        return lookUpFields;
    }
    
    private List<CommitteeMembershipBase> getCommitteeMemberships() {
        String committeeId = getProtocol().getProtocolSubmission().getCommittee().getCommitteeId();
        String scheduleId = getProtocol().getProtocolSubmission().getScheduleId();
        List<CommitteeMembershipBase> committeeMemberships = KcServiceLocator.getService(CommitteeService.class).getAvailableMembers(committeeId, scheduleId);
        return committeeMemberships;
    }
    
    private void initializeAbstainees(ProtocolSubmission submission) {
        Map<String, Long> absenteeLookFields = getLookUpFields(getProtocol().getProtocolId(), submission.getSubmissionId());
        
        Collection<ProtocolVoteAbstainee> protocolVoteAbstainees = KcServiceLocator.getService(BusinessObjectService.class).findMatching(ProtocolVoteAbstainee.class, absenteeLookFields);
        
        List<CommitteeMembershipBase> committeeMemberships = getCommitteeMemberships();
        
        for (ProtocolVoteAbstainee abstainee : protocolVoteAbstainees) {
            for (CommitteeMembershipBase membership : committeeMemberships) {
                if (abstainee.isProtocolReviewerFromCommitteeMembership(membership)) {
                    //this committee person is an abstainee
                    CommitteePerson person = new CommitteePerson();
                    person.setMembershipId(membership.getCommitteeMembershipId());
                    this.abstainers.add(person);
                    break;
                }
            }
        }
    }
    
    private void initializeRecused(ProtocolSubmission submission) {
        Map<String, Long> absenteeLookFields = getLookUpFields(getProtocol().getProtocolId(), submission.getSubmissionId());
        
        Collection<ProtocolVoteRecused> protocolVoteRecused = KcServiceLocator.getService(BusinessObjectService.class).findMatching(ProtocolVoteRecused.class, absenteeLookFields);
        
        List<CommitteeMembershipBase> committeeMemberships = getCommitteeMemberships();
        
        for (ProtocolVoteRecused recusee : protocolVoteRecused) {
            for (CommitteeMembershipBase membership : committeeMemberships) {
                if (recusee.isProtocolReviewerFromCommitteeMembership(membership)) {
                    //this committee person is an recusee
                    CommitteePerson person = new CommitteePerson();
                    person.setMembershipId(membership.getCommitteeMembershipId());
                    this.recused.add(person);
                    break;
                }
            }
        }
    }

    @Override
    public String getMotionTypeCode() {
        return motionTypeCode;
    }

    @Override
    public void setMotionTypeCode(String commDecisionMotionTypeCode) {
        this.motionTypeCode = commDecisionMotionTypeCode;
    }

    @Override
    public Integer getNoCount() {
        return noCount;
    }

    @Override
    public void setNoCount(Integer noCount) {
        this.noCount = noCount;
    }

    @Override
    public Integer getYesCount() {
        return yesCount;
    }

    @Override
    public void setYesCount(Integer yesCount) {
        this.yesCount = yesCount;
    }

    @Override
    public Integer getAbstainCount() {
        return this.getAbstainers().size();
    }

    @Override
    public void setAbstainCount(Integer abstainCount) {
        this.abstainCount = abstainCount;
    }

    @Override
    public String getVotingComments() {
        return votingComments;
    }

    @Override
    public void setVotingComments(String votingComments) {
        this.votingComments = votingComments;
    }
    
    @Override
    public CommitteeDecisionMotionType getMotionType() {
        return motionType;
    }

    @Override
    public void setMotionType(CommitteeDecisionMotionType motionType) {
        this.motionType = motionType;
    }

    @Override
    public List<CommitteePerson> getAbstainers() {
        return abstainers;
    }

    @Override
    public void setAbstainers(List<CommitteePerson> abstainers) {
        this.abstainers = abstainers;
    }
    
    @Override
    public List<CommitteePerson> getAbstainersToDelete() {
        return abstainersToDelete;
    }

    @Override
    public List<CommitteePerson> getRecused() {
        return recused;
    }

    @Override
    public void setRecused(List<CommitteePerson> recused) {
        this.recused = recused;
    }
    
    @Override
    public List<CommitteePerson> getRecusedToDelete() {
        return recusedToDelete;
    }

    @Override
    public CommitteePerson getNewAbstainer() {
        return newAbstainer;
    }

    @Override
    public void setNewAbstainer(CommitteePerson newAbstainer) {
        this.newAbstainer = newAbstainer;
    }

    @Override
    public CommitteePerson getNewRecused() {
        return newRecused;
    }

    @Override
    public void setNewRecused(CommitteePerson newRecused) {
        this.newRecused = newRecused;
    }
    
    @Override
    public int getTotalVoteCount() {
        return (this.getYesCount() != null ? this.getYesCount() : 0) + 
                (this.getNoCount() != null ? this.getNoCount() : 0) + 
                (this.getAbstainCount() != null ? this.getAbstainCount() : 0) + 
                (this.getRecusedCount() != null ? this.getRecusedCount() : 0);
    }

    @Override
    public ReviewCommentsBean getReviewCommentsBean() {
        return reviewCommentsBean;
    }

    @Override
    public void setReviewCommentsBean(ReviewCommentsBeanBase reviewCommentsBean) {
        this.reviewCommentsBean = (ReviewCommentsBean) reviewCommentsBean;
    }

    @Override
    public ReviewAttachmentsBean getReviewAttachmentsBean() {

        return null;
    }
    
    @Override
    public int getYesCountValue() {
        return (this.getYesCount() != null) ? this.getYesCount() : 0;
    }
    
    @Override
    public int getNoCountValue() {
        return (this.getNoCount() != null) ? this.getNoCount() : 0;
    }

}
