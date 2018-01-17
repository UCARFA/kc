/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rule.event;

import org.kuali.coeus.common.committee.impl.rule.event.DeleteCommitteeMemberEventBase;
import org.kuali.coeus.common.committee.impl.rules.DeleteCommitteeMemberRuleBase;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.kra.committee.rules.DeleteCommitteeMemberRule;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * 
 * This class is the rule event for deleting committee member.
 */
public class DeleteCommitteeMemberEvent extends DeleteCommitteeMemberEventBase {
    
    /**
     * 
     * Constructs a DeleteCommitteeMemberEvent.java.
     * 
     * @param errorPathPrefix
     * @param document
     * @param committeeMemberships
     * @param type
     */
    public DeleteCommitteeMemberEvent(String errorPathPrefix, CommitteeDocument document, List<CommitteeMembership> committeeMemberships, ErrorType type) {
        super(errorPathPrefix, document, (List) committeeMemberships, type);
    }

    /**
     * 
     * Constructs a DeleteCommitteeMemberEvent.java.
     * 
     * @param errorPathPrefix
     * @param document
     * @param committeeMemberships
     * @param type
     */
    public DeleteCommitteeMemberEvent(String errorPathPrefix, Document document, List<CommitteeMembership> committeeMemberships, ErrorType type) {
        this(errorPathPrefix, (CommitteeDocument) document, committeeMemberships, type);
    }
    

    @Override
    protected DeleteCommitteeMemberRuleBase getNewDeleteCommitteeMemberRuleInstanceHook() {
        return new DeleteCommitteeMemberRule();
    }
}
