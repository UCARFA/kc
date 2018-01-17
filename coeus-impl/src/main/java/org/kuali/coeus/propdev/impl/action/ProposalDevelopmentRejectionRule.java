/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.action;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.core.api.util.RiceKeyConstants;

public class ProposalDevelopmentRejectionRule extends KcTransactionalDocumentRuleBase {

    private static final String ACTION_REASON = "proposalDevelopmentRejectionBean.actionReason";

    public boolean proccessProposalDevelopmentRejection(ProposalDevelopmentActionBean bean) {
        boolean valid = true;
        if (StringUtils.isEmpty(bean.getActionReason())) {
            valid = false;
            String errorParams = "";
            reportError(ACTION_REASON, RiceKeyConstants.ERROR_REQUIRED, errorParams);
        }
        return valid;
    }

}
