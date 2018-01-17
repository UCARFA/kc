/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.calculator;

import org.kuali.coeus.common.budget.impl.calculator.BreakUpInterval;

/**
 * This class is to calculate breakup interval, the basic unit used for budget calculation
 */
public interface BreakupIntervalService {
    public void calculate(BreakUpInterval breakupInterval);
}
