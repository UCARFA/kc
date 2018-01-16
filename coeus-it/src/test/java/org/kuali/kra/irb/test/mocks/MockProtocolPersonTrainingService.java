/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.test.mocks;

import org.kuali.kra.irb.personnel.ProtocolPersonTrainingService;
import org.kuali.kra.protocol.personnel.ProtocolPersonBase;

import java.util.List;

/**
 * A Mock for the ProtocolPersonTrainingService.
 */
public class MockProtocolPersonTrainingService implements ProtocolPersonTrainingService {
    
    @Override
    public void updatePersonTrained(List<ProtocolPersonBase> protocolPersons) {
        for(ProtocolPersonBase protocolPerson : protocolPersons) {
            setTrainedFlag(protocolPerson);
        }
    }

    @Override
    public void setTrainedFlag(ProtocolPersonBase protocolPerson) {
        protocolPerson.setTrained(true);
    }

}
