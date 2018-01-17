/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.specialreview;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewTypeValuesFinder;

/**
 * Provides a value finder for the Award-specific Special Review Types.
 */
public class AwardSpecialReviewTypeValuesFinder extends SpecialReviewTypeValuesFinder {

    @Override
    public String getModuleCode() {
        return CoeusModule.AWARD_MODULE_CODE;
    }

}
