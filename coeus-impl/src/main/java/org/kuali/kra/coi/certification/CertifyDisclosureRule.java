/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.certification;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

//TODO: Note, this is a stub class that must be filled out to allow print and submission of disclosure certification.

public class CertifyDisclosureRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<CertifyDisclosureEvent> {
    
    @Override
    public boolean processRules(CertifyDisclosureEvent event) {
        boolean isValid = true;

// TODO Implement any business rules for Disclosure Certification here...
        isValid &= GlobalVariables.getMessageMap().hasNoErrors();
        GlobalVariables.getMessageMap().removeFromErrorPath(event.getPropertyName());
        return isValid;
    }

}
