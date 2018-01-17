/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.personnel;

import org.kuali.kra.iacuc.IacucPersonTraining;
import org.kuali.kra.protocol.personnel.ProtocolPersonTrainingService;

import java.util.List;

public interface IacucProtocolPersonTrainingService extends ProtocolPersonTrainingService {

    /**
     * This method is to get the iacuc person training details
     * @param personId
     * @return
     */
    public List<IacucPersonTraining> getIacucPersonTrainingDetails(String personId);
    
}
