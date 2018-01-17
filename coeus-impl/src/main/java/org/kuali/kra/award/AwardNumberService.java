/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

/**
 * This interface is used for creating new award numbers.
 */
public interface AwardNumberService {

    /**
     * This method returns an unused award number.
     * @return
     */
    String getNextAwardNumber();
}
