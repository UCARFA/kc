/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup;

import java.util.Map;

public interface AwardTransactionLookupService {

    /**
     * 
     * Gets all transaction ids that were added to the award version, excluding
     * transactions that were added to previous or later versions.
     * @param awardNumber
     * @param sequenceNumber
     * @return
     */
    public Map<Integer, String> getApplicableTransactionIds(String awardNumber, Integer sequenceNumber);
    
}
