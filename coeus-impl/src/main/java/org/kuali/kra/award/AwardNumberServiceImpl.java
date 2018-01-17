/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.service.SequenceAccessorService;

import java.text.DecimalFormat;

public class AwardNumberServiceImpl implements AwardNumberService {

    private SequenceAccessorService sequenceAccessorService;
    
    public AwardNumberServiceImpl() {
    }
    /**
     * Set the Sequence Accessor Service.
     * @param sequenceAccessorService the Sequence Accessor Service
     */
    public void setSequenceAccessorService(SequenceAccessorService sequenceAccessorService) {
        this.sequenceAccessorService = sequenceAccessorService;
    }

    
    @Override
    public String getNextAwardNumber() {
        Long nextAwardNumber = sequenceAccessorService.getNextAvailableSequenceNumber(Constants.AWARD_SEQUENCE_AWARD_NUMBER, Award.class);
        
        // Use Coeus' xxxxxx-yyy format for compatibility
        DecimalFormat formatter = new DecimalFormat("000000");        
        return formatter.format(nextAwardNumber) + "-00001";
    }
}
