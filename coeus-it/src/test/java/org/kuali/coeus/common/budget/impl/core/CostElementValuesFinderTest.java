/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.budget.impl.core;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.data.DataObjectService;

import java.util.ArrayList;
import java.util.List;

import static org.kuali.rice.core.api.criteria.PredicateFactory.equal;

public class CostElementValuesFinderTest extends KcIntegrationTestBase {


    @Test
    public void testValuesFinderUnitsMapped() {

        CostElementValuesFinder valuesFinder = new CostElementValuesFinder();
        List<KeyValue> valuesReturned;
        setAllUnitsOfCostElementsToUnit("P", "000001");

        valuesReturned = valuesFinder.getKeyValues("P", true, null, "BL-BL");
        Assert.assertTrue(valuesReturned.size() == 38);

        valuesReturned = valuesFinder.getKeyValues("P", true, null, "IU-UNIV");
        Assert.assertTrue(valuesReturned.size() == 38);

        valuesReturned = valuesFinder.getKeyValues("P", true, null, null);
        Assert.assertTrue(valuesReturned.size() == 38);

        setAllUnitsOfCostElementsToUnit("E", "000001");

        valuesReturned = valuesFinder.getKeyValues("E", true, null, "BL-BL");
        Assert.assertTrue(valuesReturned.size() == 5);

        valuesReturned = valuesFinder.getKeyValues("E", true, null, "IU-UNIV");
        Assert.assertTrue(valuesReturned.size() == 5);

        valuesReturned = valuesFinder.getKeyValues("E", true, null, null);
        Assert.assertTrue(valuesReturned.size() == 5);

        valuesReturned = valuesFinder.getKeyValues("E", true, null, "000001");
        Assert.assertTrue(valuesReturned.size() == 5);

        /*--*/
        setAllUnitsOfCostElementsToUnit("P", null);
        setAllUnitsOfCostElementsToUnit("E", null);



        valuesReturned = valuesFinder.getKeyValues("P", true, null, "IU-UNIV");
        Assert.assertTrue(valuesReturned.size() == 38);


        List<CostElement> costElements = getCostElements("P");
        int totalSize = costElements.size();

        CostElement costElement = costElements.get(0);
        costElement.setUnitNumber("BL-BL");
        getDataObjectservice().save(costElement);

        valuesReturned = valuesFinder.getKeyValues("E", true, null, "IU-UNIV");
        Assert.assertTrue(valuesReturned.size() == 5);

        List<CostElement> costElements2 = getCostElements("E");
        int totalSize2 = costElements.size();

        CostElement costElement2 = costElements2.get(0);
        costElement2.setUnitNumber("BL-BL");
        getDataObjectservice().save(costElement2);


        valuesReturned = valuesFinder.getKeyValues("P", true, null, "BL-BL");
        Assert.assertTrue(valuesReturned.size() == 2);

        valuesReturned = valuesFinder.getKeyValues("P", true, null, "IU-UNIV");
        Assert.assertTrue(valuesReturned.size() == 38);

        valuesReturned = valuesFinder.getKeyValues("P", true, null, null);
        Assert.assertTrue(valuesReturned.size() == 38);

        valuesReturned = valuesFinder.getKeyValues("E", true, null, "BL-BL");
        Assert.assertTrue(valuesReturned.size() == 2);

        valuesReturned = valuesFinder.getKeyValues("E", true, null, "IU-UNIV");
        Assert.assertTrue(valuesReturned.size() == 5);

        valuesReturned = valuesFinder.getKeyValues("E", true, null, null);
        Assert.assertTrue(valuesReturned.size() == 5);



    }

    public List<CostElement> getCostElements(String budgetCategoryTypeCode) {
        QueryByCriteria.Builder builder2 = QueryByCriteria.Builder.create();
        List<Predicate> predicates2 = new ArrayList<>();
        predicates2.add(equal("budgetCategory.budgetCategoryTypeCode", budgetCategoryTypeCode));
        Predicate[] preds2 = predicates2.toArray(new Predicate[predicates2.size()]);
        builder2.setPredicates(preds2);
        return getDataObjectservice().findMatching(CostElement.class, builder2.build()).getResults();
    }

    public void setAllUnitsOfCostElementsToUnit(String budgetCategoryTypeCode, String unitNumber) {
        List<CostElement> costElements2 = getCostElements(budgetCategoryTypeCode);
        for (CostElement currentCostElement : costElements2) {
            currentCostElement.setUnitNumber(unitNumber);
            getDataObjectservice().save(currentCostElement);
        }
    }

    public DataObjectService getDataObjectservice() {
        return KcServiceLocator.getService(DataObjectService.class);
    }

}
