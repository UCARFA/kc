/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.dao;

import org.kuali.kra.award.contacts.AwardPerson;

import java.util.List;
import java.util.Map;

/**
 * This interface defines contract for database interactions with AwardPersons
 */
public interface AwardPersonDao {
    List<AwardPerson> getAwardPersons(Map<String, String> fieldValues);
}
