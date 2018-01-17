/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.budget.impl;


import org.kuali.kfs.module.external.kc.service.BudgetAdjustmentService;
import org.kuali.kra.external.budget.BudgetAdjustmentClient;
import org.kuali.rice.core.api.resourceloader.GlobalResourceLoader;

/**
 * This class is an implementation of the Budget Adjustment client that uses the KSB
 * to communicate with the financial system.
 */
public class BudgetAdjustmentKSBClientImpl  extends BudgetAdjustmentClientBase {
    private static  BudgetAdjustmentKSBClientImpl  ksbClient;

    private BudgetAdjustmentKSBClientImpl() {  }
    
    public static BudgetAdjustmentClient getInstance() {
      if (ksbClient == null)
          ksbClient = new BudgetAdjustmentKSBClientImpl();
      return ksbClient;
    }

    @Override
    protected BudgetAdjustmentService getServiceHandle() {
        BudgetAdjustmentService budgetAdjustmentService = (BudgetAdjustmentService) GlobalResourceLoader.getService(SERVICE_NAME);
        return budgetAdjustmentService;
    }
}
