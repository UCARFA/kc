/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.assignCmt;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

public class IacucProtocolAssignCmtRuleImpl extends KcTransactionalDocumentRuleBase implements IacucProtocolAssignCmtRule {

    @Override
    public boolean processAssignToCommittee(ProtocolDocumentBase document, IacucProtocolAssignCmtBean actionBean) {
        boolean valid = true;
        if (StringUtils.isBlank(actionBean.getCommitteeId())) {
            valid = false;
            GlobalVariables.getMessageMap().putError(Constants.PROTOCOL_ASSIGN_CMT_SCHED_ACTION_PROPERTY_KEY + ".committeeId", 
                                                   KeyConstants.ERROR_PROTOCOL_COMMITTEE_NOT_SELECTED);
        }
        return valid;
    }


}
