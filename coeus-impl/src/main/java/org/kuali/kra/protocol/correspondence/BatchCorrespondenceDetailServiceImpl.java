/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.List;

public class BatchCorrespondenceDetailServiceImpl implements BatchCorrespondenceDetailService {

    private static final String REFERENCE_PROTOCOL_CORRESPONDENCE_TYPE = "protocolCorrespondenceType";

    BusinessObjectService businessObjectService;

    /**
     * 
     * @see org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailService#addBatchCorrespondenceDetail(
     * org.kuali.kra.protocol.correspondence.BatchCorrespondenceBase, org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailBase)
     */
    @Override
    public void addBatchCorrespondenceDetail(BatchCorrespondenceBase batchCorrespondence,
                                             BatchCorrespondenceDetailBase newBatchCorrespondenceDetail) {

        newBatchCorrespondenceDetail.setBatchCorrespondenceTypeCode(batchCorrespondence.getBatchCorrespondenceTypeCode());
        newBatchCorrespondenceDetail.refreshReferenceObject(REFERENCE_PROTOCOL_CORRESPONDENCE_TYPE);

        batchCorrespondence.getBatchCorrespondenceDetails().add(newBatchCorrespondenceDetail);
    }

    /**
     * 
     * @see org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailService#saveBatchCorrespondenceDetails(
     * org.kuali.kra.protocol.correspondence.BatchCorrespondenceBase, java.util.List)
     */
    @Override
    public void saveBatchCorrespondenceDetails(BatchCorrespondenceBase batchCorrespondence, List<BatchCorrespondenceDetailBase> deletedBos) {
        if (!deletedBos.isEmpty()) {
            businessObjectService.delete(deletedBos);
        }
        
        businessObjectService.save(batchCorrespondence);
    }
    
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
