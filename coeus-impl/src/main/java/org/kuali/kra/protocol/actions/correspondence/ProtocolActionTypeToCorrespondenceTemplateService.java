/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.correspondence;

import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateBase;

import java.util.List;

public interface ProtocolActionTypeToCorrespondenceTemplateService {
    /**
     * 
     * This method maps a protocol action type to a protocol correspondence template, and returns a list of ProtocolCorrespondenceTemplateBase objects.
     * @param protocolActionType a ProtocolActionType String
     * @param committeeId a Committee id
     * @return a list of ProtocolCorrespondenceTemplateBase objects tied to a committee.
     */
    List<ProtocolCorrespondenceTemplateBase> getTemplatesByProtocolAction(String protocolActionType, String committeeId); 

    /**
     * This method maps a protocol action type to a protocol correspondence template, and returns a list of ProtocolCorrespondenceTemplateBase objects.
     * @param protocolActionType a ProtocolActionType String
     * @return a list of ProtocolCorrespondenceTemplateBase DEFAULT objects.
     */
    List<ProtocolCorrespondenceTemplateBase> getTemplatesByProtocolAction(String protocolActionType); 

}
