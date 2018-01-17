/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.specialreview;

import org.apache.commons.lang3.BooleanUtils;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewHelperBase;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.bo.FundingSourceType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.kns.authorization.AuthorizationConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the Special Review Helper for Award.
 */
public class SpecialReviewHelper extends SpecialReviewHelperBase<AwardSpecialReview> {

    private static final long serialVersionUID = 6164616866447994314L;

    private static final String PROTOCOL_AWARD_LINKING_ENABLED_PARAMETER = "irb.protocol.award.linking.enabled";
    private static final String IACUC_PROTOCOL_AWARD_LINKING_ENABLED_PARAMETER = "iacuc.protocol.award.linking.enabled";
    private AwardForm form;
    
    /**
     * Constructs a SpecialReviewHelper.
     * @param form the container form
     */
    public SpecialReviewHelper(AwardForm form) {
        this.form = form;
        setNewSpecialReview(new AwardSpecialReview());
        setLinkedProtocolNumbers(new ArrayList<String>());
    }
    
    /**
     * Synchronizes the information between this Award's Special Reviews and the corresponding Protocol Funding Sources.
     */
    public void syncProtocolFundingSourcesWithSpecialReviews() {
        String fundingSourceNumber = form.getAwardDocument().getAward().getAwardNumber();
        String fundingSourceTypeCode = FundingSourceType.AWARD;
        String fundingSourceName = form.getAwardDocument().getAward().getSponsorName();
        String fundingSourceTitle = form.getAwardDocument().getAward().getTitle();
        syncProtocolFundingSourcesWithSpecialReviews(fundingSourceNumber, fundingSourceTypeCode, fundingSourceName, fundingSourceTitle);
    }

    @Override
    protected boolean hasModifySpecialReviewPermission(String principalId) {
        return BooleanUtils.toBoolean((String) form.getEditingMode().get(AuthorizationConstants.EditMode.FULL_ENTRY));
    }
    
    @Override
    protected boolean isIrbProtocolLinkingEnabledForModule() {
        return getParameterService().getParameterValueAsBoolean(NAMESPACE_CODE, PARAMETER_CODE, PROTOCOL_AWARD_LINKING_ENABLED_PARAMETER);
    }

    @Override
    protected boolean isIacucProtocolLinkingEnabledForModule() {
        return getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_IACUC, PARAMETER_CODE, IACUC_PROTOCOL_AWARD_LINKING_ENABLED_PARAMETER);
    }

    @Override
    protected List<AwardSpecialReview> getSpecialReviews() {
        return form.getAwardDocument().getAward().getSpecialReviews();
    }
 
    @Override
     public boolean isCanCreateIrbProtocol() {
        return false;
    }
    @Override
    public boolean isCanCreateIacucProtocol() {
        return false;
    }
    
}
