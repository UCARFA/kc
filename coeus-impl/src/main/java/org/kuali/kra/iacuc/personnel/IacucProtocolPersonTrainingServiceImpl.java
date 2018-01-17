/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.personnel;

import org.kuali.kra.iacuc.IacucPersonTraining;
import org.kuali.kra.protocol.personnel.ProtocolPersonTrainingServiceImplBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IacucProtocolPersonTrainingServiceImpl extends ProtocolPersonTrainingServiceImplBase implements IacucProtocolPersonTrainingService{
    private static final String PERSON_ID_FIELD = "personId";

    @Override
    public List<IacucPersonTraining> getIacucPersonTrainingDetails(String personId) {
        Map<String, Object> matchingKeys = new HashMap<String, Object>();
        matchingKeys.put(PERSON_ID_FIELD, personId);
        return (List<IacucPersonTraining>) getBusinessObjectService().findMatching(IacucPersonTraining.class, matchingKeys);
    }

}
