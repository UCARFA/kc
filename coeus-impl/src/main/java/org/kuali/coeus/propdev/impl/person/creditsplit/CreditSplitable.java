/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.creditsplit;

import org.kuali.coeus.propdev.impl.person.creditsplit.CreditSplit;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.List;

/**
 * Used to describe a <code>{@link BusinessObject}</code> with credit that can be split. Usually,
 * this is a <code>{@link org.kuali.coeus.propdev.impl.person.ProposalPerson}</code> or the like.
 *
 * @author $Author: gmcgrego $
 * @version $Revision: 1.4 $
 */
public interface CreditSplitable {
    /**
     * Get a <code>{@link List}</code> of credit splits
     *
     * @return List&lt;T&gt;
     */ 
    public List<? extends CreditSplit> getCreditSplits();
  
}
