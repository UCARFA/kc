/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.persistence;

import org.kuali.rice.krad.util.MessageMap;

import java.util.Collection;
import java.util.List;

public interface PersistenceVerificationService {

    /**
     * Determines if a BusinessObject can safely be deleted by looking for other BusinessObjects that have direct
     * references to this business object.
     *
     * @param bo the Business Object. Cannot be bull.
     * @param ignoredRelationships any BusinessObject classes to ignore.  Cannot be null.
     * @return any messages related to the inability to safely delete the BusinessObject
     */
    MessageMap verifyRelationshipsForDelete(Object bo, Collection<Class<?>> ignoredRelationships);

    /**
     * Determines if a BusinessObject can safely be updated by looking for whether references to other business objects are valid.
     *
     * @param bo the Business Object. Cannot be bull.
     * @param ignoredRelationships any BusinessObject classes to ignore.  Cannot be null.
     * @return any messages related to the inability to safely update the BusinessObject
     */
    MessageMap verifyRelationshipsForUpdate(Object bo, Collection<Class<?>> ignoredRelationships);

    /**
     * Determines if a BusinessObject can safely be inserted by looking for whether references to other business objects are valid.
     *
     * @param bo the Business Object. Cannot be bull.
     * @param ignoredRelationships any BusinessObject classes to ignore.  Cannot be null.
     * @return any messages related to the inability to safely insert the BusinessObject
     */
    MessageMap verifyRelationshipsForInsert(Object bo, Collection<Class<?>> ignoredRelationships);

    /**
     * Retrieves all persistable business object fields.  Will not return null.
     * @param boClazz the Business Object class. Cannot be bull.
     * @return a list of fields.  never null.
     */
    List<String> persistableFields(Class<?> boClazz);

    /**
     * Retrieves all business object primary key fields.  Will not return null.
     * @param boClazz the Business Object class. Cannot be bull.
     * @return a list of primary key fields.  never null.
     */
    List<String> pkFields(Class<?> boClazz);
}
