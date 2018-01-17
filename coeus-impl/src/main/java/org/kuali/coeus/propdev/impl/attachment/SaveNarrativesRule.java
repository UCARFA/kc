/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.kuali.coeus.propdev.impl.attachment.SaveNarrativesEvent;
import org.kuali.rice.krad.rules.rule.BusinessRule;


/**
 * Interface for saving proposal narratives
 *
 * @author $Author: gmcgrego $
 * @version $Revision: 1.2 $
 */
public interface SaveNarrativesRule extends BusinessRule {
    
    /**
     * Rule invoked upon saving narratives 
     * @return boolean
     */
    public boolean processSaveNarrativesBusinessRules(SaveNarrativesEvent saveNarrativesEvent);
}
