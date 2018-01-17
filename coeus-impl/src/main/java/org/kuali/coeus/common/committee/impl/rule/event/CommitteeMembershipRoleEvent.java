/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipRole;
import org.kuali.rice.krad.rules.rule.event.DocumentEvent;

public interface CommitteeMembershipRoleEvent extends DocumentEvent {

    /**
     * Get the <code>{@link CommitteeMembershipRole}</code> of this event.
     * 
     * @return <code>CommitteeMembershipRole</code>
     */
     CommitteeMembershipRole getCommitteeMembershipRole();
}
