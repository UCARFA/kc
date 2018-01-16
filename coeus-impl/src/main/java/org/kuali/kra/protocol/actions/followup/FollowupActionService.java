/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.followup;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.submit.ValidProtocolActionActionBase;

import java.util.List;

public interface FollowupActionService<T extends ValidProtocolActionActionBase> {
    
    
    /**
     * Determines if the action is a follow-up action for the current state of the
     * protocol.  This is a replacement method for the one found in the ProtocolActionService
     * that relies on drools rules instead of the ValidProtocolActionActionBase maintenance artifact.
     * 
     * @param protocolActionTypeCode  The type code we are checking is a follow up action
     * @param protocol The protocol you are interested in.
     * 
     * @return 
     */
    boolean isActionOpenForFollowup(String protocolActionTypeCode, ProtocolBase protocol);
    
    List<T> getFollowupsForActionTypeAndMotionType(String protocolActionTypeCode, String committeeMotionTypeCode);
    
    List<T> getFollowupsForProtocol(ProtocolBase protocol);

}
