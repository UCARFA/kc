/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.List;

public class BatchCorrespondenceDetailServiceImpl implements BatchCorrespondenceDetailService {

    private static final String REFERENCE_PROTOCOL_CORRESPONDENCE_TYPE = "protocolCorrespondenceType";

    BusinessObjectService businessObjectService;

    /**
     * 
     * @see org.kuali.kra.irb.correspondence.BatchCorrespondenceDetailService#addBatchCorrespondenceDetail(
     * org.kuali.kra.irb.correspondence.BatchCorrespondence, org.kuali.kra.irb.correspondence.BatchCorrespondenceDetail)
     */
    @Override
    public void addBatchCorrespondenceDetail(BatchCorrespondence batchCorrespondence,
                                             BatchCorrespondenceDetail newBatchCorrespondenceDetail) {

        newBatchCorrespondenceDetail.setBatchCorrespondenceTypeCode(batchCorrespondence.getBatchCorrespondenceTypeCode());
        newBatchCorrespondenceDetail.refreshReferenceObject(REFERENCE_PROTOCOL_CORRESPONDENCE_TYPE);

        batchCorrespondence.getBatchCorrespondenceDetails().add(newBatchCorrespondenceDetail);
    }

    /**
     * 
     * @see org.kuali.kra.irb.correspondence.BatchCorrespondenceDetailService#saveBatchCorrespondenceDetails(
     * org.kuali.kra.irb.correspondence.BatchCorrespondence, java.util.List)
     */
    @Override
    public void saveBatchCorrespondenceDetails(BatchCorrespondence batchCorrespondence, List<BatchCorrespondenceDetail> deletedBos) {
        if (!deletedBos.isEmpty()) {
            businessObjectService.delete(deletedBos);
        }
        
        businessObjectService.save(batchCorrespondence);
    }
    
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
