/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.rule.event.DeleteCommitteeMemberEventBase;
import org.kuali.coeus.common.committee.impl.rules.DeleteCommitteeMemberRuleBase;
import org.kuali.kra.iacuc.committee.rules.IacucDeleteCommitteeMemberRule;
import org.kuali.rice.krad.document.Document;

import java.util.List;

public class IacucDeleteCommitteeMemberEvent extends DeleteCommitteeMemberEventBase {

    /**
     * 
     * Constructs a DeleteCommitteeMemberEventBase.java.
     * 
     * @param errorPathPrefix
     * @param document
     * @param committeeMemberships
     * @param type
     */
    public IacucDeleteCommitteeMemberEvent(String errorPathPrefix, CommitteeDocumentBase document, List<CommitteeMembershipBase> committeeMemberships, ErrorType type) {
        super(errorPathPrefix, document, committeeMemberships, type);
    }

    /**
     * 
     * Constructs a DeleteCommitteeMemberEventBase.java.
     * 
     * @param errorPathPrefix
     * @param document
     * @param committeeMemberships
     * @param type
     */
    public IacucDeleteCommitteeMemberEvent(String errorPathPrefix, Document document, List<CommitteeMembershipBase> committeeMemberships, ErrorType type) {
        this(errorPathPrefix, (CommitteeDocumentBase) document, committeeMemberships, type);
    }

    @Override
    protected DeleteCommitteeMemberRuleBase getNewDeleteCommitteeMemberRuleInstanceHook() {
        return new IacucDeleteCommitteeMemberRule();
    }

}
