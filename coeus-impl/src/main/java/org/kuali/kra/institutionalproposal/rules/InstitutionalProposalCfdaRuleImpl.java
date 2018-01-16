/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.rules;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.krad.util.GlobalVariables;


public class InstitutionalProposalCfdaRuleImpl extends KcTransactionalDocumentRuleBase implements
        InstitutionalProposalCfdaRule {

    public static final String CFDA_NUMBER = "cfdaNumber";

    @Override
    public boolean processCfdaRules(
            InstitutionalProposalCfdaRuleEvent institutionalProposalCfdaRuleEvent) {
        return validateCfdaNumber(institutionalProposalCfdaRuleEvent.getInstitutionalProposalForValidation());
    }
    
    private boolean validateCfdaNumber(InstitutionalProposal institutionalProposal) {
        if (!isValidCfda(institutionalProposal.getCfdaNumber())
                && GlobalVariables.getMessageMap().getMessages(Constants.INSTITUTIONAL_PROPOSAL_CFDA_NUMBER) == null) {
            this.reportWarning(Constants.INSTITUTIONAL_PROPOSAL_CFDA_NUMBER, KeyConstants.CFDA_INVALID, new String[]{institutionalProposal.getCfdaNumber()});
         }
        return Boolean.TRUE;
    }

    public boolean isValidCfda(String cfdaNumber) {
        return StringUtils.isBlank(cfdaNumber) || cfdaNumber.matches(Constants.CFDA_REGEX);
    }

}
