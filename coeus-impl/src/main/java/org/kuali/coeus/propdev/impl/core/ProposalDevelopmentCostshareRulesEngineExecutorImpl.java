/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.core;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.rice.kew.engine.RouteContext;
import org.kuali.rice.krms.api.engine.Engine;
import org.kuali.rice.krms.api.engine.EngineResults;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.SelectionCriteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProposalDevelopmentCostshareRulesEngineExecutorImpl extends ProposalDevelopmentRulesEngineExecutorImpl  {

    private KcKrmsFactBuilderServiceHelper kcKrmsFactBuilderServiceHelper;
    @Override
    protected KcKrmsFactBuilderServiceHelper getKcKrmsFactBuilderServiceHelper (){
        if (kcKrmsFactBuilderServiceHelper == null)
            kcKrmsFactBuilderServiceHelper = getProposalDevelopmentFactBuilderService();
        return kcKrmsFactBuilderServiceHelper;
    }

    @Override
    public EngineResults performExecute(RouteContext routeContext, Engine engine) {
        Map<String, String> contextQualifiers = new HashMap<>();
        contextQualifiers.put(KcKrmsConstants.NAMESPACE_CODE, Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT);
        contextQualifiers.put(KcKrmsConstants.NAME, KcKrmsConstants.ProposalDevelopment.PROPOSAL_DEVELOPMENT_CONTEXT);

        String docContent = routeContext.getDocument().getDocContent();
        String proposalNumber = getElementValue(docContent, "//proposalNumber");
        List<String> unitNumbers = getProposalUnits(proposalNumber, routeContext);
        String unitNumbersAsString = StringUtils.join(unitNumbers, ',');

        final Map<String, String> agendaQualifiers = new HashMap<>();
        agendaQualifiers.put(Constants.COST_SHARE_AGENDA_UNITS, unitNumbersAsString);
        SelectionCriteria selectionCriteria = SelectionCriteria.createCriteria(null, contextQualifiers,
                agendaQualifiers);

        KcKrmsFactBuilderServiceHelper fbService = getProposalDevelopmentFactBuilderService();
        Facts.Builder factsBuilder = Facts.Builder.create();
        fbService.addFacts(factsBuilder, docContent);
        EngineResults results = engine.execute(selectionCriteria, factsBuilder.build(), null);
        return results;
    }

    private KcKrmsFactBuilderServiceHelper getProposalDevelopmentFactBuilderService() {
		return KcServiceLocator.getService("proposalDevelopmentFactBuilderService");
	}

}
