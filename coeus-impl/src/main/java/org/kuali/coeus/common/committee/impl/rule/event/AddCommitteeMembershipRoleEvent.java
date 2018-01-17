/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipRole;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.rule.AddCommitteeMembershipRoleRule;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AddCommitteeMembershipRoleEvent extends CommitteeMembershipRoleEventBase {

    /**
     * 
     * Constructs a <code>{@link AddCommitteeMembershipRoleEvent}</code>.
     * 
     * @param errorPathPrefix
     * @param committeeDocument
     * @param committeeMembership
     * @param committeeMembershipRole
     * @param membershipIndex
     */
    public AddCommitteeMembershipRoleEvent(String errorPathPrefix, CommitteeDocumentBase comitteeDocument,
            CommitteeMembershipRole committeeMembershipRole, int membershipIndex) {
        super("adding CommitteeMembershipRole to document " + getDocumentId(comitteeDocument), errorPathPrefix, comitteeDocument,
            committeeMembershipRole, membershipIndex);
    }

    /**
     * 
     * Constructs a <code>{@link AddCommitteeMembershipRoleEvent}</code>.
     * 
     * @param errorPathPrefix
     * @param document
     * @param committeeMembership
     * @param committeeMembershipRole
     * @param membershipIndex
     */
    public AddCommitteeMembershipRoleEvent(String errorPathPrefix, Document document, 
            CommitteeMembershipRole committeeMembershipRole, int membershipIndex) {
        this(errorPathPrefix, (CommitteeDocumentBase) document, committeeMembershipRole, membershipIndex);
    }

    /**
     * 
     * Returns the <code>{@link AddCommitteeMembershipRoleRule}</code> class which is needed to validate a
     * <code>{@link CommitteeMembershipRole}</code>
     * 
     * @return <code>{@link AddCommitteeMembershipRoleRule} class</code>
     */
    @Override
    public Class getRuleInterfaceClass() {
        return AddCommitteeMembershipRoleRule.class;
    }

    /**
     * 
     * Invokes the processing of the rules when adding a <code>{@link CommitteeMembershipRole}</code>.
     * 
     * @param rule <code>{@link AddCommitteeMembershipRoleRule}</code> that is to be used for processing
     * @return <code>true</code> if all rules are satisfied, otherwise <code>false</code>
     */
    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddCommitteeMembershipRoleRule) rule).processAddCommitteeMembershipRoleBusinessRules(this);
    }

}
