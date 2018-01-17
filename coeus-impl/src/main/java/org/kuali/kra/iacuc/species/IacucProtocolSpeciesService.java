/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species;

import org.kuali.kra.iacuc.IacucProtocol;

import java.util.HashMap;

public interface IacucProtocolSpeciesService {

    /**
     * This method adds Protocol Species to the List of Protocol Species.
     * @param protocol which contains list of ProtocolSpecies.
     * @param ProtocolSpecies object is added to ProtocolSpecies list.
     */
    public abstract void addProtocolSpecies(IacucProtocol protocol, IacucProtocolSpecies protocolSpecies);

    /**
     * This method is to get formatted new protocol species
     * @param protocol
     * @param protocolSpecies
     * @return
     */
    public IacucProtocolSpecies getNewProtocolSpecies(IacucProtocol protocol, IacucProtocolSpecies protocolSpecies);
    
    
    /**
     * This method is to get a map of old and new protocol species id
     * @param protocol
     * @return
     */
    public HashMap<Integer, Integer> getNewProtocolSpeciesMap(IacucProtocol protocol);
    
    
}
