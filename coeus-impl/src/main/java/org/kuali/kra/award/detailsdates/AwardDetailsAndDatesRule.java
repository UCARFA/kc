/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.detailsdates;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This interface declares the rule methods associated with <code>AwardDetailsAndDates</code> functionality.
 * 
 * @author Kuali Coeus development team (kc.dev@kuali.org)
 */
public interface AwardDetailsAndDatesRule extends BusinessRule {
    
    /**
     * Check rules associated with adding a new Award Transferring Sponsor
     * <code>{@link org.kuali.kra.award.document.AwardDocument}</code>
     *
     * @return boolean
     */
    boolean processAddAwardTransferringSponsorEvent(AddAwardTransferringSponsorEvent addAwardTransferringSponsorEvent);

    
    /**
     * Check rules associated with Saving Award Details and Dates panel
     * <code>{@link org.kuali.kra.award.document.AwardDocument}</code>
     *
     * @return boolean
     */
    boolean processSaveAwardDetailsAndDates(AwardDetailsAndDatesSaveEvent awardDetailsAndDatesSaveEvent);
    
}
