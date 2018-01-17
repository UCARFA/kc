/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.lock;

import org.kuali.rice.krad.service.PessimisticLockService;

/**
 * The Budget Lock Service.  Every document that customizes the PessimisticLockService
 * must subclass that service in order to override certain methods.
 */
public interface BudgetLockService extends PessimisticLockService {

}
