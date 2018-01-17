/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.coi.disclosure.DisclosurePerson;
import org.kuali.kra.coi.disclosure.DisclosurePersonUnit;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.framework.krms.KcRulesEngineExecuter;
import org.kuali.coeus.common.framework.krms.KcKrmsFactBuilderService;
import org.kuali.rice.kew.engine.RouteContext;
import org.kuali.rice.krms.api.engine.Engine;
import org.kuali.rice.krms.api.engine.EngineResults;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.SelectionCriteria;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CoiDisclosureRulesEngineExecutorImpl  extends KcRulesEngineExecuter {
    
    @Override
    public EngineResults performExecute(RouteContext routeContext, Engine engine) {
        Map<String, String> contextQualifiers = new HashMap<String, String>();
        contextQualifiers.put("namespaceCode", Constants.MODULE_NAMESPACE_COIDISCLOSURE);
        contextQualifiers.put("name", KcKrmsConstants.CoiDisclosure.COI_DISCLOSURE_CONTEXT);

        // extract facts from routeContext
        String docContent = routeContext.getDocument().getDocContent();
        String unitNumber = getElementValue(docContent, "//document/coiDisclosureList[1]/" + CoiDisclosure.class.getName() + "[1]/disclosurePersons[1]/" + DisclosurePerson.class.getName() + "[1]/disclosurePersonUnits[1]/" + DisclosurePersonUnit.class.getName() + "[1]/unitNumber[1]");
        
        SelectionCriteria selectionCriteria = SelectionCriteria.createCriteria(null, contextQualifiers,
                Collections.singletonMap("Unit Number", unitNumber));

        KcKrmsFactBuilderService fbService = KcServiceLocator.getService("coiDisclosureFactBuilderService");
        Facts.Builder factsBuilder = Facts.Builder.create();
        fbService.addFacts(factsBuilder, docContent);
        EngineResults results = engine.execute(selectionCriteria, factsBuilder.build(), null);
        return results;
    }
}
