/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule;

import org.kuali.coeus.common.committee.impl.rule.event.AddCommitteeMembershipEvent;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * 
 * This interface addresses the adds rule for adding a new <code>CommitteeMembershipBase</code>
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public interface AddCommitteeMembershipRule extends BusinessRule {
    
    /**
     * 
     * ProcessDefinitionDefinitiones the validation rules for an <code>{@link AddCommitteeMembershipEvent}</code>
     * 
     * @param addCommitteeMembershipEvent
     * @return <code>true</code> if valid, <code>false</code> otherwise
     */
    public boolean processAddCommitteeMembershipBusinessRules(AddCommitteeMembershipEvent addCommitteeMembershipEvent);
}
