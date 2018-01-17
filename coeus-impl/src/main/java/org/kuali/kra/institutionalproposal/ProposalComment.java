/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal;

import org.kuali.kra.bo.CommentType;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

public class ProposalComment extends InstitutionalProposalAssociate {

    private static final long serialVersionUID = 1L;

    private Long proposalCommentsId;

    private Long proposalId;

    private String commentTypeCode;

    private String comments;

    private CommentType commentType;

    private InstitutionalProposal proposal;

    public ProposalComment() {
    }

    public Long getProposalCommentsId() {
        return proposalCommentsId;
    }

    public void setProposalCommentsId(Long proposalCommentsId) {
        this.proposalCommentsId = proposalCommentsId;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public String getCommentTypeCode() {
        return commentTypeCode;
    }

    public void setCommentTypeCode(String commentTypeCode) {
        this.commentTypeCode = commentTypeCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public InstitutionalProposal getProposal() {
        return proposal;
    }

    public void setProposal(InstitutionalProposal proposal) {
        this.proposal = proposal;
    }
}
