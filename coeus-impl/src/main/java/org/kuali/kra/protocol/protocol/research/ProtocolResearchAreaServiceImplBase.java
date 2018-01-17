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
import java.util.List;


public abstract class ProtocolResearchAreaServiceImplBase implements ProtocolResearchAreaService {

       
    @Override
    public void addProtocolResearchArea(ProtocolBase protocol, Collection<ResearchAreaBase> selectedBOs) {
        for (ResearchAreaBase newResearchAreas : selectedBOs) {
            //New ResearchAreas added by user selection
            // ignore / drop duplicates
            if (!isDuplicateResearchAreas(newResearchAreas, protocol.getProtocolResearchAreas())) {
                //Add new ProtocolResearchAreas to list
                protocol.addProtocolResearchAreas(createInstanceOfProtocolResearchAreas(protocol, newResearchAreas));
            }
        }
    }

    /**
     * This method is private helper method, to create instance of ProtocolResearchAreas and set appropriate values.
     * @param protocolDocument
     * @param researchAreas
     * @return
     */
    protected ProtocolResearchAreaBase createInstanceOfProtocolResearchAreas(ProtocolBase protocol, ResearchAreaBase researchAreas) {
        ProtocolResearchAreaBase protocolResearchAreas = getNewProtocolResearchAreaInstanceHook();
        protocolResearchAreas.setProtocol(protocol);                            
        
        if(null != protocol.getProtocolNumber())
            protocolResearchAreas.setProtocolNumber(protocol.getProtocolNumber());
        else
            protocolResearchAreas.setProtocolNumber("0");
        
        if(null != protocol.getSequenceNumber())
            protocolResearchAreas.setSequenceNumber(protocol.getSequenceNumber());
        else
            protocolResearchAreas.setSequenceNumber(0);
        
        protocolResearchAreas.setResearchAreaCode(researchAreas.getResearchAreaCode());
        protocolResearchAreas.setResearchAreas(researchAreas);
        return protocolResearchAreas;
    }
    
    protected abstract ProtocolResearchAreaBase getNewProtocolResearchAreaInstanceHook();
    
    
    /**
     * This method is private helper method, to restrict duplicate ProtocolResearchAreas insertion in list.
     * @param newResearchAreaCode
     * @param protocolResearchAreas
     * @return
     */
    protected boolean isDuplicateResearchAreas(ResearchAreaBase newResearchAreas, List<ProtocolResearchAreaBase> protocolResearchAreas) {
        for (ProtocolResearchAreaBase pra  : protocolResearchAreas) {    
            if (pra.getResearchAreas().equals(newResearchAreas)) {
                return true;
            }
        }
        return false;
    }    
}
