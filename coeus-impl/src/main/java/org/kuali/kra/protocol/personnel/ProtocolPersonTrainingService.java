/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import java.util.List;




/**
 * This class represents service interface for protocol personnel
 * training. Each institution can customize this interface to deal
 * with person training.
 */
public interface ProtocolPersonTrainingService {

    /**
     * This method is to set trained flag for each person
     * This method is invoked while navigating to personnel page to set the trained flag for 
     * each person in the list.
     * Hook this service method to external / other training session as required. 
     * @param protocolPersons
     */
    public void updatePersonTrained(List<ProtocolPersonBase> protocolPersons);
    
    /**
     * This method is to set trained flag for a person
     * Set true / false
     * This method is invoked from isPersonTrained and while adding a new person to the list.
     * @param protocolPerson
     */
    public void setTrainedFlag(ProtocolPersonBase protocolPerson);
}
