/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.specialreview;

import org.kuali.coeus.common.framework.compliance.core.SpecialReview;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.kra.protocol.ProtocolFinderDao;


public interface ProtocolSpecialReviewService {

    @SuppressWarnings("rawtypes")
    public void populateSpecialReview(SpecialReview specialReview);
    /**
     * 
     * This method gets a DevelopmentProposal object based on the proposalNumber
     * @param proposalNumber
     * @return
     */
    public DevelopmentProposal getPropososalDevelopment(String proposalNumber);
    
    public ProtocolFinderDao getProtocolFinderDao();

    public void setProtocolFinderDao(ProtocolFinderDao protocolFinderDao);

}
