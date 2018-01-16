/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.service;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.personmasschange.bo.PersonMassChange;

import java.util.List;

/**
 * Defines the service interface for performing a Person Mass Change on Protocols.
 */
public interface ProtocolPersonMassChangeService {
    
    /**
     * Returns the Protocols that would have a Person Mass Change performed on them.
     * 
     * @param personMassChange the Person Mass Change to be performed
     * @return the Protocols that would have a Person Mass Change performed on them
     */
    List<Protocol> getProtocolChangeCandidates(PersonMassChange personMassChange);
    
    /**
     * Performs the Person Mass Change on the Protocols.
     * 
     * @param personMassChange the Person Mass Change to be performed
     * @param protocolChangeCandidates the Protocols to perform a Person Mass Change on
     */
    void performPersonMassChange(PersonMassChange personMassChange, List<Protocol> protocolChangeCandidates);

}
