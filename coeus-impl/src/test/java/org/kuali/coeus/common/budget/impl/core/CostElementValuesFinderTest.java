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
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.impl.unit.UnitServiceImpl;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class CostElementValuesFinderTest {

    class UnitServiceMock extends UnitServiceImpl {

        public Unit getUnit(String unitNumber) {
            Unit unit = new Unit();
            unit.setUnitNumber(unitNumber);

            if (unitNumber == null) {
                return null;
            }
            if (unitNumber.equalsIgnoreCase("000001")) {
                unit.setParentUnitNumber(null);
            }
            else if (unitNumber.equalsIgnoreCase("BL-BL")) {
                unit.setParentUnitNumber("IU-UNIV");
            }
            else if (unitNumber.equalsIgnoreCase("IU-UNIV")) {
                unit.setParentUnitNumber("000001");
            }
            return unit;
        }

    }

    @Test
    public void testValuesFinderTopMostUnitMapped() {
        class CostElementValuesFinderMock extends CostElementValuesFinder {

            @Override
            protected List<CostElement> getMatchingResults(String budgetCategoryTypeCode, boolean budgetCategoryTypeCodeEqual, String budgetCategoryCode, Unit unit) {
                List<CostElement> costElements = new ArrayList<>();
                if (unit == null || unit.getUnitNumber().equalsIgnoreCase("000001")) {
                    CostElement ce1 = new CostElement();
                    ce1.setCostElement("1234");
                    ce1.setDescription("1234");
                    CostElement ce2 = new CostElement();
                    ce2.setCostElement("2345");
                    ce2.setDescription("2345");
                    CostElement ce3 = new CostElement();
                    ce3.setCostElement("3456");
                    ce3.setDescription("3456");

                    costElements.add(ce1);
                    costElements.add(ce2);
                    costElements.add(ce3);
                }
                else if (unit.getUnitNumber().equalsIgnoreCase("BL-BL")) {
                    return costElements;
                }
                else if (unit.getUnitNumber().equalsIgnoreCase("IU-UNIV")) {
                    return costElements;
                }
                return costElements;
            }

            @Override
            public UnitService getUnitService() {
                return new UnitServiceMock();
            }

        }
        CostElementValuesFinderMock valuesFinderMock = new CostElementValuesFinderMock();
        List<KeyValue> costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", "BL-BL");
        Assert.assertTrue(costElements.size() == 4);

        costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", "IU-UNIV");
        Assert.assertTrue(costElements.size() == 4);

        costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", "000001");
        Assert.assertTrue(costElements.size() == 4);

        costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", null);
        Assert.assertTrue(costElements.size() == 4);

    }

    @Test
    public void testValuesFinderUnitsMapped() {
        class CostElementValuesFinderMock extends CostElementValuesFinder {

            @Override
            protected List<CostElement> getMatchingResults(String budgetCategoryTypeCode, boolean budgetCategoryTypeCodeEqual, String budgetCategoryCode, Unit unit) {
                List<CostElement> costElements = new ArrayList<>();
                if (unit == null) {
                    CostElement ce1 = new CostElement();
                    ce1.setCostElement("1234");
                    ce1.setDescription("1234");
                    costElements.add(ce1);
                    CostElement ce2 = new CostElement();
                    ce2.setCostElement("2345");
                    ce2.setDescription("2345");
                    CostElement ce3 = new CostElement();
                    ce3.setCostElement("3456");
                    ce3.setDescription("3456");
                    costElements.add(ce2);
                    costElements.add(ce3);

                    CostElement ce4 = new CostElement();
                    ce4.setCostElement("0001");
                    ce4.setDescription("0001");
                    CostElement ce5 = new CostElement();
                    ce5.setCostElement("0002");
                    ce5.setDescription("0002");
                    costElements.add(ce4);
                    costElements.add(ce5);
                }

                else if (unit.getUnitNumber().equalsIgnoreCase("000001")) {
                    CostElement ce1 = new CostElement();
                    ce1.setCostElement("1234");
                    ce1.setDescription("1234");
                    costElements.add(ce1);

                }
                else if (unit.getUnitNumber().equalsIgnoreCase("BL-BL")) {
                    CostElement ce2 = new CostElement();
                    ce2.setCostElement("2345");
                    ce2.setDescription("2345");
                    CostElement ce3 = new CostElement();
                    ce3.setCostElement("3456");
                    ce3.setDescription("3456");
                    costElements.add(ce2);
                    costElements.add(ce3);
                    return costElements;
                }
                else if (unit.getUnitNumber().equalsIgnoreCase("IU-UNIV")) {
                    CostElement ce2 = new CostElement();
                    ce2.setCostElement("0001");
                    ce2.setDescription("0001");
                    CostElement ce3 = new CostElement();
                    ce3.setCostElement("0002");
                    ce3.setDescription("0002");
                    costElements.add(ce2);
                    costElements.add(ce3);
                    return costElements;
                }
                return costElements;
            }

            @Override
            public UnitService getUnitService() {
                return new UnitServiceMock();
            }

        }
        CostElementValuesFinderMock valuesFinderMock = new CostElementValuesFinderMock();
        List<KeyValue> costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", "BL-BL");
        Assert.assertTrue(costElements.size() == 3);

        costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", "IU-UNIV");
        Assert.assertTrue(costElements.size() == 3);

        costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", "000001");
        Assert.assertTrue(costElements.size() == 2);

        costElements = valuesFinderMock.getCostElementKeyValues("P", false, "P", null);
        Assert.assertTrue(costElements.size() == 6);

    }

}
