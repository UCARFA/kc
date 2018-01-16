/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.rule.event;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.personmasschange.bo.PersonMassChange;
import org.kuali.kra.personmasschange.rule.PerformPersonMassChangeRule;
import org.kuali.rice.krad.document.Document;

public class PerformPersonMassChangeEvent extends KcDocumentEventBaseExtension {
    
    private PersonMassChange personMassChange;

    public PerformPersonMassChangeEvent(Document document, PersonMassChange personMassChange) {
        super("performing person mass change", Constants.EMPTY_STRING, document);
        
        this.personMassChange = personMassChange;
    }

    public PersonMassChange getPersonMassChange() {
        return personMassChange;
    }

    public void setPersonMassChange(PersonMassChange personMassChange) {
        this.personMassChange = personMassChange;
    }

    @Override
    public KcBusinessRule<PerformPersonMassChangeEvent> getRule() {
        return new PerformPersonMassChangeRule();
    }

}
