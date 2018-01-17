/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.compliance.core;

import org.kuali.coeus.common.framework.compliance.exemption.SpecialReviewExemption;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;

/**
 * Runs the rule processing for adding a Special Review.
 * @param <T> The subclass of Special Review
 */
public class AddSpecialReviewRule<T extends SpecialReview<? extends SpecialReviewExemption>> extends SpecialReviewRuleBase<T> 
    implements KcBusinessRule<AddSpecialReviewEvent<T>> {

    @Override
    public boolean processRules(AddSpecialReviewEvent<T> event) {
        return processAddSpecialReviewEvent(event);
    }

}
