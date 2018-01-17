/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.medusa;

import java.util.Collection;
import java.util.List;

/**
 * 
 * Medusa Service provides the methods for displaying the tree-like view and summary of
 * related documents.
 */
public interface MedusaService {

    /**
     * 
     * Returns a list of MedusaNode objects that describe the top level of
     * the tree-like structure of the Medusa object passed in using the Awards(if available)
     * as the top level nodes.
     * @param moduleName name of the module to be looked up (ie. award, IP, DP)
     * @param moduleIdentifier the primary key of the object to be looked up in the specified module
     * @return
     */
    List<MedusaNode> getMedusaByAward(String moduleName, Long moduleIdentifier);
    
    /**
     * 
     * Returns a list of MedusaNode objects that describe the top level of
     * the tree-like structure of the Medusa object passed in using the Institutional Proposals(if available)
     * as the top level nodes.
     * @param moduleName name of the module to be looked up (ie. award, IP, DP)
     * @param moduleIdentifier the primary key of the object to be looked up in the specified module
     * @return
     */
    List<MedusaNode> getMedusaByProposal(String moduleName, Long moduleIdentifier);
    
    /**
     * 
     * Returns a single MedusaNode that can be used to render the lazy-loaded summary for the
     * BO contained in that node
     * @param moduleName name of the module to be looked up (ie. award, IP, DP)
     * @param moduleIdentifier the primary key of the object to be looked up in the specified module
     * @return
     */
    MedusaNode getMedusaNode(String moduleName, Long moduleIdentifier);

    /**
     * Determines which modules should have their document descriptions displayed in the Medusa view
     * @return the {@link org.kuali.coeus.common.framework.module.CoeusModule} codes that should display descriptions
     */
    Collection<String> getDocumentDescriptionDisplayModules();

    /**
     * Returns whether the new React Medusa UI is enabled
     * @return true if the new React UI should be displayed, false if the old KRAD/KNS UI should be used
     */
    boolean isReactMedusaEnabled();
 
}
