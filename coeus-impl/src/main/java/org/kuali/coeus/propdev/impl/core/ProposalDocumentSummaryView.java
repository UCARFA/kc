/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

import org.kuali.rice.krad.datadictionary.DocumentEntry;
import org.kuali.rice.krad.document.DocumentRequestAuthorizationCache;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * View for a ProposalDocument that is used as a summary view on the action list, used to workaround one
 * view per document type limitation.
 */
public class ProposalDocumentSummaryView extends ProposalDocumentView{

    public ProposalDocumentSummaryView () {
   		super();

        setRequestAuthorizationCacheClass(DocumentRequestAuthorizationCache.class);
   	}

    @Override
    public void performInitialization(Object model) {
        super.performInitialization(model);

        setObjectPathToConcreteClassMapping(new HashMap<String, Class<?>>());
        getObjectPathToConcreteClassMapping().put("document", ProposalDevelopmentDocument.class);

        // Workaround for non-set additionalScriptFiles files
        setAdditionalScriptFiles(new ArrayList<String>());
    }

    @Override
    protected DocumentEntry getDocumentEntryForView() {
        DocumentEntry documentEntry = KRADServiceLocatorWeb.getDocumentDictionaryService().getDocumentEntryByClass(
                ProposalDevelopmentDocument.class);

        return documentEntry;
    }
}
