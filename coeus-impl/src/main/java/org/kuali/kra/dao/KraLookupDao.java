/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.dao;

import org.kuali.rice.krad.dao.LookupDao;

import java.util.Collection;

/**
 * This class is Custom lookup service Interface for kc development.
 */
public interface KraLookupDao extends LookupDao {

    /**
     * This method returns collection with wildcard in lookup string.
     * @param example
     * @param criteria
     * @param unbounded
     * @return
     */
    @SuppressWarnings("unchecked")
    Collection findCollectionUsingWildCard(Class businessObjectClass, String field, String wildCard, boolean unbounded);

    Collection findCollectionUsingWildCardWithSorting(Class businessObjectClass, String field, String wildCard, String sortProprtyName,boolean ascending,boolean unbounded);
}
