/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.specialreview;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewTypeValuesFinder;

/**
 * Provides a value finder for the Proposal-specific Special Review Types.
 */
public class ProposalSpecialReviewTypeValuesFinder extends SpecialReviewTypeValuesFinder {

    @Override
    public String getModuleCode() {
        return CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE;
    }

}
