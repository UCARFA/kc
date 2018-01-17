/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.rule;

import org.kuali.kra.iacuc.species.IacucProtocolSpecies;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

/**
 * This class is implementation of <code>AddProtocolSpeciesRule</code> interface. Impl makes sure necessary rules are satisfied 
 * before object can be used.
 */
public class ProtocolSpeciesRule extends KcTransactionalDocumentRuleBase implements AddProtocolSpeciesRule {
    private static final String NEW_PROTOCOL_SPECIES_PATH = "iacucProtocolSpeciesHelper.newIacucProtocolSpecies";

    @Override
    public boolean processAddProtocolSpeciesBusinessRules(AddProtocolSpeciesEvent addProtocolSpeciesEvent) {
        
        boolean rulePassed = true;
        MessageMap errorMap = GlobalVariables.getMessageMap();
        errorMap.addToErrorPath(NEW_PROTOCOL_SPECIES_PATH);
        IacucProtocolSpecies protocolSpecies = addProtocolSpeciesEvent.getProtocolSpecies();
        
        getDictionaryValidationService().validateBusinessObject(protocolSpecies);
        rulePassed &= GlobalVariables.getMessageMap().hasNoErrors();

        errorMap.removeFromErrorPath(NEW_PROTOCOL_SPECIES_PATH);

        return rulePassed;
    }

}
