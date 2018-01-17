/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import java.util.List;

public interface BatchCorrespondenceDetailService {

    /**
     * 
     * This method add a BatchCorrespondenceDetailBase to the BatchCorrespondenceBase.
     * @param batchCorrespondence
     * @param newBatchCorrespondenceDetail
     */
    void addBatchCorrespondenceDetail(BatchCorrespondenceBase batchCorrespondence,
            BatchCorrespondenceDetailBase newBatchCorrespondenceDetail);

    /**
     * 
     * This method saves the BatchCorrespondenceDetais of the BatchCorrespondenceBase.
     * @param batchCorrespondence
     * @param deletedBos
     */
    void saveBatchCorrespondenceDetails(BatchCorrespondenceBase batchCorrespondence, 
            List<BatchCorrespondenceDetailBase> deletedBos);
}
