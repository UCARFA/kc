/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.budget.document;

import org.junit.Test;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.util.ObjectUtils;
import static org.junit.Assert.*;
/**
 * Testing ObjectUtils equalsByKey logic change
 * 
 * @author Kuali Rice Team (kuali-rice@googlegroups.com)
 */
public class ObjectUtilsTest extends KcIntegrationTestBase {
    @Test
    public void testObjectUtils_equalsByKey() throws Exception {
        BudgetPeriod periodDB = new BudgetPeriod();
        periodDB.setBudgetPeriodId(new Long(268));
//        periodDB.setProposalNumber("103");
//        periodDB.setBudgetVersionNumber(1);
        periodDB.setBudgetPeriod(3);
        
        BudgetPeriod periodNew = new BudgetPeriod();
        periodNew.setBudgetPeriodId(null);
//        periodNew.setProposalNumber(null);
//        periodNew.setBudgetVersionNumber(null);
        periodNew.setBudgetPeriod(3);
        
        boolean equalsResult = false;
        equalsResult = ObjectUtils.equalByKeys(periodDB, periodNew);
        assertFalse(equalsResult);
    }
}
