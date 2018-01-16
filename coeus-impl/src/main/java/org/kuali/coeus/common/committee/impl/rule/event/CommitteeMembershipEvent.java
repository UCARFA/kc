/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.rice.krad.rules.rule.event.DocumentEvent;

/**
*
* This interface addresses the lookup of the <code>{@link CommitteeMembershipBase}</code> of an event.
*
* @author Kuali Research Administration Team (kc.dev@kuali.org)
*/
public interface CommitteeMembershipEvent extends DocumentEvent {
    /**
     * 
     * Get the <code>{@link CommitteeMembershipBase}</code> of this event.
     * 
     * @return <code>CommitteeMembershipBase</code>
     */
    CommitteeMembershipBase getCommitteeMembership();
}
