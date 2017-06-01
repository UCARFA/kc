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

package org.kuali.coeus.propdev.impl.sponsor;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;

public class AddProposalSponsorAndProgramInformationRuleImpl implements AddProposalSponsorAndProgramInformationRule {

    private GlobalVariableService globalVariableService;
    private ErrorReporter errorReporter;

    @Override
    public boolean processAddProposalSponsorAndProgramInformationRules(ProposalDevelopmentDocument proposalDevelopmentDocument) {
        boolean valid = Boolean.TRUE;
        if (StringUtils.isNotBlank(proposalDevelopmentDocument.getDevelopmentProposal().getCfdaNumber())
                && !(proposalDevelopmentDocument.getDevelopmentProposal().getCfdaNumber().matches(Constants.CFDA_REGEX))
                && getGlobalVariableService().getMessageMap().getMessages(Constants.DOCUMENT_DEVELOPMENT_PROPOSAL_CFDA_NUMBER) == null) {
            getErrorReporter().reportWarning(Constants.DEVELOPMENT_PROPOSAL_CFDA_NUMBER, KeyConstants.CFDA_INVALID,
                    proposalDevelopmentDocument.getDevelopmentProposal().getCfdaNumber());
        }
        return valid;
    }

    public ErrorReporter getErrorReporter() {
        if (this.errorReporter == null) {
            this.errorReporter = KcServiceLocator.getService(ErrorReporter.class);
        }

        return this.errorReporter;
    }

    public GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }
        return globalVariableService;
    }
}
