/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.research;

import org.kuali.kra.bo.ResearchAreaBase;
import org.kuali.kra.protocol.ProtocolBase;

import java.util.Collection;


public interface ProtocolResearchAreaService {

    /**
     * When a multi-lookup returns for a set of Research Areas, we must add them to the ProtocolBase Document.
     * Note that we don't add duplicate research areas.
     * NOTE: This should be moved to a service since it is business logic.
     * @param protocolDocument the ProtocolBase Document
     * @param selectedBOs the selected BOs (Research Areas)
     */
    public abstract void addProtocolResearchArea(ProtocolBase protocol, Collection<ResearchAreaBase> selectedBOs);
    
}
