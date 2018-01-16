/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.onlinereview.rules;

import org.kuali.kra.protocol.onlinereview.event.AddProtocolOnlineReviewCommentEvent;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public interface AddOnlineReviewCommentRule extends BusinessRule  {

    /**
     * 
     * This method validates the AddProtocolOnlineReviewCommentEvent
     * @param addProtocolOnlineReviewCommentEvent
     * @return true if it validates correctly
     */
    public boolean processAddProtocolOnlineReviewComment( AddProtocolOnlineReviewCommentEvent event );
    
    
    
    
}
