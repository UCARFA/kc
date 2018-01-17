/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.service;

import org.kuali.kra.personmasschange.bo.PersonMassChange;

/**
 * Defines the service interface for performing a Person Mass Change.
 */
public interface PersonMassChangeService {
    
    /**
     * Performs the Person Mass Change.
     * 
     * @param personMassChange the Person Mass Change to be performed
     */
    void performPersonMassChange(PersonMassChange personMassChange);

}
