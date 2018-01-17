/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.lookup;

import org.kuali.kra.negotiations.bo.Negotiation;

import java.util.Collection;
import java.util.Map;

/**
 * Negotiation Dao Interface.
 */
public interface NegotiationDao {

    /**
     * Get negotiation results using the field values provided.
     * @param fieldValues
     * @return
     */
    Collection<Negotiation> getNegotiationResults(Map<String, String> fieldValues);
}
