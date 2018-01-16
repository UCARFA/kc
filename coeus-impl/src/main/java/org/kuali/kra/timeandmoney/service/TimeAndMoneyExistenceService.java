/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.service;

import org.kuali.kra.award.home.Award;
import org.kuali.rice.kew.api.exception.WorkflowException;

public interface TimeAndMoneyExistenceService {

    boolean validateTimeAndMoneyRule(Award award, String rootAwardNumber) throws WorkflowException;
    void addAwardVersionErrorMessage();
    }
