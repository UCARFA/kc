/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.action;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.core.api.util.RiceKeyConstants;

public class ProposalDevelopmentRejectionRule extends KcTransactionalDocumentRuleBase {

    public boolean proccessProposalDevelopmentRejection(ProposalDevelopmentActionBean bean) {
        boolean valid = true;
        if (StringUtils.isEmpty(bean.getActionReason())) {
            valid = false;
            String errorParams = "";
            reportError("proposalDevelopmentRejectionBean.actionReason", RiceKeyConstants.ERROR_REQUIRED, errorParams);
        }
        return valid;
    }

}
