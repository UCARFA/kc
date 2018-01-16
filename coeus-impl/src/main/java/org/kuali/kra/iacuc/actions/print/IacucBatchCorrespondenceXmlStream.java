/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.print;

import org.kuali.coeus.common.framework.compliance.core.ComplianceConstants;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.protocol.actions.print.BatchCorrespondenceXmlStreamBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;

public class IacucBatchCorrespondenceXmlStream extends BatchCorrespondenceXmlStreamBase {
	
    @Override
    public String getRenewalReminderCorrespondenceTypesParamValues() {
        return getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_IACUC, ParameterConstants.DOCUMENT_COMPONENT, ComplianceConstants.IACUC_RENEWAL_REMINDER_CORRESP_TYPES);
    }

}
