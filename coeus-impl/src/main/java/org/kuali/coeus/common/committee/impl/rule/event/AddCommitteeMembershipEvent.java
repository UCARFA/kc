/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.rule.AddCommitteeMembershipRule;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * 
 * This class represents the event when a <code>{@link CommitteeMembershipBase}</code> is added to a 
 * <code>{@link CommitteeBase}</code>.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class AddCommitteeMembershipEvent extends CommitteeMembershipEventBase {

    /**
     * 
     * Constructs a <code>{@link AddCommitteeMembershipEvent}</code>.
     * 
     * @param errorPathPrefix
     * @param committeeDocument
     * @param committeeMembership
     */
   public AddCommitteeMembershipEvent(String errorPathPrefix, CommitteeDocumentBase comitteeDocument, 
           CommitteeMembershipBase committeeMembership) {
        super("adding CommitteeMembershipBase to document " + getDocumentId(comitteeDocument),
                errorPathPrefix, comitteeDocument, committeeMembership);
    }

   /**
    * 
    * Constructs a <code>{@link AddCommitteeMembershipEvent}</code>.
    * 
    * @param errorPathPrefix
    * @param document
    * @param committeeMembership
    */
  public AddCommitteeMembershipEvent(String errorPathPrefix, Document document, 
          CommitteeMembershipBase committeeMembership) {
       this(errorPathPrefix, (CommitteeDocumentBase) document, committeeMembership);
   }

    /**
     * 
     * Returns the <code>{@link AddCommitteeMembershipRule}</code> class which is needed to validate a
     * <code>{@link CommitteeMembershipBase}</code>
     * 
     * @return <code>{@link AddCommitteeMembershipRule} class</code>
     */
    @Override
    public Class getRuleInterfaceClass() {
        return AddCommitteeMembershipRule.class;
    }

    /**
     * 
     * Invokes the processing of the rules when adding a <code>{@link CommitteeMembershipBase}</code>.
     * 
     * @param The <code>{@link AddCommitteeMembershipRule}</code> that is to be used for processing
     * @return <code>true</code> if all rules are satisfied, otherwise <code>false</code>
     */
    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddCommitteeMembershipRule) rule).processAddCommitteeMembershipBusinessRules(this);
    }

}
