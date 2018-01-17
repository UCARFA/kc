/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.rules;

import org.kuali.coeus.common.committee.impl.rules.DeleteCommitteeMemberRuleBase;
import org.kuali.coeus.common.committee.impl.service.CommitteeMembershipServiceBase;
import org.kuali.kra.committee.service.CommitteeMembershipService;

/**
 * 
 * This class is to implement business rule for deleting committee member.
 */
public class DeleteCommitteeMemberRule extends DeleteCommitteeMemberRuleBase {

    @Override
    protected Class<? extends CommitteeMembershipServiceBase> getCommitteeMembershipServiceClassHook() {
        return CommitteeMembershipService.class;
    }
}
