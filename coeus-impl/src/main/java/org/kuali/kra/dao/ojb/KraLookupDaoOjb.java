/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.dao.ojb;

import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.QueryFactory;
import org.kuali.kra.dao.KraLookupDao;
import org.kuali.rice.kns.lookup.LookupUtils;
import org.kuali.rice.krad.dao.impl.LookupDaoOjb;
import org.springframework.dao.DataIntegrityViolationException;
import org.springmodules.orm.ojb.OjbOperationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class is the custom service class for kc Lookup Dao Ojb.
 */
public class KraLookupDaoOjb extends LookupDaoOjb implements KraLookupDao {

    @Override
    @SuppressWarnings("unchecked")
    public Collection findCollectionUsingWildCard(Class businessObjectClass, String field, String wildCard, boolean unbounded) {
        Criteria criteria = new Criteria();
        criteria.addLike(field, wildCard);
        return findBoCollection(businessObjectClass, unbounded, criteria);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection findCollectionUsingWildCardWithSorting(Class businessObjectClass, String field, String wildCard, String sortPropertyName, boolean ascending, boolean unbounded) {
        Criteria criteria = new Criteria();
        criteria.addLike(field, wildCard);
        criteria.addOrderBy(sortPropertyName, ascending);
        return findBoCollection(businessObjectClass, unbounded, criteria);
    }

    private Collection findBoCollection(Class businessObjectClass, boolean unbounded, Criteria criteria) {
        Collection searchResults = new ArrayList();
        try {
            Integer searchResultsLimit = LookupUtils.getSearchResultsLimit(businessObjectClass);
            if (!unbounded && (searchResultsLimit != null)) {
                LookupUtils.applySearchResultsLimit(businessObjectClass, criteria, getDbPlatform());
            }
            searchResults = getPersistenceBrokerTemplate().getCollectionByQuery(QueryFactory.newQuery(businessObjectClass, criteria));
            List bos = new ArrayList();
            bos.addAll(searchResults);
            searchResults = bos;
        }
        catch (OjbOperationException e) {
            throw new RuntimeException("KraLookupDaoOjb encountered exception during executeSearch", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new RuntimeException("KraLookupDaoOjb encountered exception during executeSearch", e);
        }
        return searchResults;
    }
}
