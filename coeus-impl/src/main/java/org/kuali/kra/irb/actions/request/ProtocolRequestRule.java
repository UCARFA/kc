/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.request;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * Business rule for a protocol request.  If the mandatory option has been
 * set in the system params, the committee must be selected.
 */
@SuppressWarnings("unchecked")
public class ProtocolRequestRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<ProtocolRequestEvent> {
    
    private static final String MANDATORY = "M";
    private ParameterService parameterService;
    @Override
    public boolean processRules(ProtocolRequestEvent event) {
        
        boolean valid = true;
        
        if (isMandatory()) {
            valid &= validateCommittee(event.getPropertyKey(), event.getRequestBean());
        }
        return valid;
    }
    
    /**
     * If the committee is mandatory, verify that a committee has been selected.
     */
    private boolean validateCommittee(String propertyKey, ProtocolRequestBean requestBean) {
        boolean valid = true;
        if (StringUtils.isBlank(requestBean.getCommitteeId())) {
            valid = false;
            GlobalVariables.getMessageMap().putError(propertyKey + ".committeeId", 
                    KeyConstants.ERROR_PROTOCOL_COMMITTEE_NOT_SELECTED);
        }
        return valid;
    }
    
    /**
     * Is it mandatory for the submission to contain the committee and schedule?
     * @return true if mandatory; otherwise false
     */
    private boolean isMandatory() {
        final String param = this.getParameterService().getParameterValueAsString(ProtocolDocument.class, Constants.PARAMETER_IRB_COMM_SELECTION_DURING_SUBMISSION);
        
        return StringUtils.equalsIgnoreCase(MANDATORY, param);  
    }

    protected ParameterService getParameterService() {
        if (this.parameterService == null) {
            this.parameterService = KcServiceLocator.getService(ParameterService.class);
        }
        return this.parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
}
