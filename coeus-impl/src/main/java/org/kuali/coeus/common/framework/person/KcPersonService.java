/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person;

import org.kuali.rice.kim.api.identity.Person;

import java.util.List;
import java.util.Map;

/**
 * Service for working with KcPerson objects.
 */
public interface KcPersonService {
    
    /**
     * Gets a KcPerson from a user name (kim principal name).
     * @param userName the user name
     * @return the KcPerson
     * @throws IllegalArgumentException if the userName is null or empty
     */
    KcPerson getKcPersonByUserName(String userName);
    
    /**
     * Gets a KcPerson from a person id (kim principal id).
     * @param personId the person id
     * @return the KcPerson
     * @throws IllegalArgumentException if the personId is null or empty
     */
    KcPerson getKcPersonByPersonId(String personId);
    
    
    void modifyFieldValues(final Map<String, String> fieldValues);
    
    List<KcPerson> createKcPersonsFromPeople(List<Person> people);
}
