/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
