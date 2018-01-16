/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.dao;

import org.kuali.coeus.sys.framework.rest.SearchResults;
import org.kuali.kra.award.budget.AwardBudgetExt;
import org.kuali.kra.award.home.Award;

import java.util.*;

public interface AwardDao {
    String getAwardNumber(Long awardId);

    /**
     * Does a non-wildcarded yet still limited search of awards, retrieved by the given criteria
     * @param fieldValues the field values to set
     * @return a Collection of found awards
     */
    Collection<Award> retrieveAwardsByCriteria(Map<String, Object> fieldValues);
    
    SearchResults<Award> retrieveActiveAwardsByCriteria(Map<String, Object> fieldValues, Date updatedSince, Integer pageNum, Integer numPerPage);
    
    SearchResults<Award> retrieveAwardsByCriteria(Map<String, Object> fieldValues, Date updatedSince, Integer page, Integer numberPerPage);

    List<Integer> getAwardSequenceNumbers(String awardNumber);

    Award getAward(Long awardId);

    List<Award> getAwardByAwardNumber(String awardNumber);

    List<Award> getAwardByAwardHierarchy(String awardFamily);

    AwardBudgetExt getAwardBudget(String budgetId);

    List<AwardBudgetExt> getAwardBudgetByStatusCode(Integer code);

    }
