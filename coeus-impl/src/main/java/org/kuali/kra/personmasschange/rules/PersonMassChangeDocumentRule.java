/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.rules;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.personmasschange.bo.PersonMassChange;
import org.kuali.kra.personmasschange.document.PersonMassChangeDocument;
import org.kuali.kra.personmasschange.rule.event.PerformPersonMassChangeEvent;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.document.Document;

public class PersonMassChangeDocumentRule extends KcTransactionalDocumentRuleBase {
    
    @Override
    protected boolean processCustomRouteDocumentBusinessRules(Document document) {
        boolean rulePassed = true;
        
        PersonMassChangeDocument personMassChangeDocument = (PersonMassChangeDocument) document;
        PersonMassChange personMassChange = personMassChangeDocument.getPersonMassChange();
        
        rulePassed &= processRules(new PerformPersonMassChangeEvent(personMassChangeDocument, personMassChange));
        
        return rulePassed;
    }

    @Override
    protected boolean processCustomSaveDocumentBusinessRules(Document document) {
        boolean rulePassed = true;
        
        PersonMassChangeDocument personMassChangeDocument = (PersonMassChangeDocument) document;
        PersonMassChange personMassChange = personMassChangeDocument.getPersonMassChange();
        
        rulePassed &= processRules(new PerformPersonMassChangeEvent(personMassChangeDocument, personMassChange));

        return rulePassed;
    }
    
    @SuppressWarnings("unchecked")
    private boolean processRules(KcDocumentEventBaseExtension event) {
        return event.getRule().processRules(event);
    }
    
}
