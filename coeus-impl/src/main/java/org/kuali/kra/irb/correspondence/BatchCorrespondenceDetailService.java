/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import java.util.List;

public interface BatchCorrespondenceDetailService {

    /**
     * 
     * This method add a BatchCorrespondenceDetail to the BatchCorrespondence.
     * @param batchCorrespondence
     * @param newBatchCorrespondenceDetail
     */
    void addBatchCorrespondenceDetail(BatchCorrespondence batchCorrespondence,
            BatchCorrespondenceDetail newBatchCorrespondenceDetail);

    /**
     * 
     * This method saves the BatchCorrespondenceDetais of the BatchCorrespondence.
     * @param batchCorrespondence
     * @param deletedBos
     */
    void saveBatchCorrespondenceDetails(BatchCorrespondence batchCorrespondence, 
            List<BatchCorrespondenceDetail> deletedBos);
}
