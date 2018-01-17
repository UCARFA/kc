/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.decision;

import org.kuali.coeus.common.committee.impl.bo.CommitteeDecisionMotionType;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.meeting.ProtocolVoteAbstaineeBase;
import org.kuali.coeus.common.committee.impl.meeting.ProtocolVoteRecusedBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolActionBean;
import org.kuali.kra.iacuc.actions.reviewcomments.IacucReviewCommentsBean;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmission;
import org.kuali.kra.iacuc.committee.meeting.IacucProtocolVoteAbstainee;
import org.kuali.kra.iacuc.committee.meeting.IacucProtocolVoteRecused;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.protocol.actions.decision.CommitteeDecision;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsBeanBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.*;

public class IacucCommitteeDecision extends IacucProtocolActionBean implements CommitteeDecision<IacucCommitteePerson> {
    
    private static final long serialVersionUID = -8052093280852074307L;
    
    private String motionTypeCode;
    private Integer noCount;
    private Integer yesCount;
    private Integer abstainCount;
    private Integer recusedCount;
    private String votingComments;
    
    private CommitteeDecisionMotionType motionType;
    
    private IacucCommitteePerson newAbstainer = new IacucCommitteePerson();
    private IacucCommitteePerson newRecused = new IacucCommitteePerson();
    
    private List<IacucCommitteePerson> abstainers = new ArrayList<IacucCommitteePerson>();
    private List<IacucCommitteePerson> recused = new ArrayList<IacucCommitteePerson>();
    private List<IacucCommitteePerson> abstainersToDelete = new ArrayList<IacucCommitteePerson>();
    private List<IacucCommitteePerson> recusedToDelete = new ArrayList<IacucCommitteePerson>();
    
    private IacucReviewCommentsBean reviewCommentsBean;
    
    /**
     * Constructs a CommitteeDecision.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucCommitteeDecision(IacucActionHelper actionHelper) {
        super(actionHelper);
        reviewCommentsBean = new IacucReviewCommentsBean(Constants.PROTOCOL_COMMITTEE_DECISION_ACTION_PROPERTY_KEY);
    }
    
    /**
     * This method initializes the class.
     */
    @Override
    public void init() {
        // getSubmission(protocol) is not necessary the most recent one.
        // this may cause problem later if the most recent submission does not have schedule, then
        // npe when try to getavailable member
        IacucProtocolSubmission submission = (IacucProtocolSubmission) getProtocol().getProtocolSubmission();
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
        lookUpFields.put("protocolIdFk", protocolId);
        lookUpFields.put("submissionIdFk", submissionIdFk);
        return lookUpFields;
    }
    
    private List<CommitteeMembershipBase> getCommitteeMemberships() {
        String committeeId = getProtocol().getProtocolSubmission().getCommittee().getCommitteeId();
        String scheduleId = getProtocol().getProtocolSubmission().getScheduleId();
        List<CommitteeMembershipBase> committeeMemberships = KcServiceLocator.getService(IacucCommitteeService.class).getAvailableMembers(committeeId, scheduleId);
        return committeeMemberships;
    }
    
    private void initializeAbstainees(IacucProtocolSubmission submission) {
        Map<String, Long> absenteeLookFields = getLookUpFields(getProtocol().getProtocolId(), submission.getSubmissionId());
        
        Collection<IacucProtocolVoteAbstainee> protocolVoteAbstainees = KcServiceLocator.getService(BusinessObjectService.class).findMatching(IacucProtocolVoteAbstainee.class, absenteeLookFields);
        
        List<CommitteeMembershipBase> committeeMemberships = getCommitteeMemberships();
        
        for (ProtocolVoteAbstaineeBase abstainee : protocolVoteAbstainees) {
            for (CommitteeMembershipBase membership : committeeMemberships) {
                if (abstainee.isProtocolReviewerFromCommitteeMembership(membership)) {
                    //this committee person is an abstainee
                    IacucCommitteePerson person = new IacucCommitteePerson();
                    person.setMembershipId(membership.getCommitteeMembershipId());
                    this.abstainers.add(person);
                    break;
                }
            }
        }
    }
    
    private void initializeRecused(IacucProtocolSubmission submission) {
        Map<String, Long> absenteeLookFields = getLookUpFields(getProtocol().getProtocolId(), submission.getSubmissionId());
        
        Collection<IacucProtocolVoteRecused> protocolVoteRecused = KcServiceLocator.getService(BusinessObjectService.class).findMatching(IacucProtocolVoteRecused.class, absenteeLookFields);
        
        List<CommitteeMembershipBase> committeeMemberships = getCommitteeMemberships();
        
        for (ProtocolVoteRecusedBase recusee : protocolVoteRecused) {
            for (CommitteeMembershipBase membership : committeeMemberships) {
                if (recusee.isProtocolReviewerFromCommitteeMembership(membership)) {
                    //this committee person is an recusee
                    IacucCommitteePerson person = new IacucCommitteePerson();
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
    public List<IacucCommitteePerson> getAbstainers() {
        return abstainers;
    }

    @Override
    public void setAbstainers(List<IacucCommitteePerson> abstainers) {
        this.abstainers = abstainers;
    }
    
    @Override
    public List<IacucCommitteePerson> getAbstainersToDelete() {
        return abstainersToDelete;
    }

    @Override
    public List<IacucCommitteePerson> getRecused() {
        return recused;
    }

    @Override
    public void setRecused(List<IacucCommitteePerson> recused) {
        this.recused = recused;
    }
    
    @Override
    public List<IacucCommitteePerson> getRecusedToDelete() {
        return recusedToDelete;
    }

    @Override
    public IacucCommitteePerson getNewAbstainer() {
        return newAbstainer;
    }

    @Override
    public void setNewAbstainer(IacucCommitteePerson newAbstainer) {
        this.newAbstainer = newAbstainer;
    }

    @Override
    public IacucCommitteePerson getNewRecused() {
        return newRecused;
    }

    @Override
    public void setNewRecused(IacucCommitteePerson newRecused) {
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
    public IacucReviewCommentsBean getReviewCommentsBean() {
        return reviewCommentsBean;
    }

    @Override
    public void setReviewCommentsBean(ReviewCommentsBeanBase reviewCommentsBean) {
        this.reviewCommentsBean = (IacucReviewCommentsBean) reviewCommentsBean;
    }

    @Override
    public ReviewAttachmentsBeanBase getReviewAttachmentsBean() {

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
