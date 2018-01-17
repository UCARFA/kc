/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.specialreview;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

public interface ProposalDevelopmentSpecialReviewService {

    boolean createProtocol(ProposalSpecialReview specialReview, ProposalDevelopmentDocument document) throws Exception;
    
    boolean isIrbLinkingEnabled();
    
    boolean isIacucLinkingEnabled();
    
    boolean canCreateIrbProtocol(ProposalDevelopmentDocument document);

    boolean canCreateIacucProtocol(ProposalDevelopmentDocument document);
    
    public boolean isCreateIrbProtocolEnabled();
    
    public boolean isCreateIacucProtocolEnabled();

    public boolean isCreateProtocolFromProposalEnabled(String protocolLinkParam);
    
    public Integer generateSpecialReviewNumber(ProposalDevelopmentDocument document);

    }
