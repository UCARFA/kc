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
