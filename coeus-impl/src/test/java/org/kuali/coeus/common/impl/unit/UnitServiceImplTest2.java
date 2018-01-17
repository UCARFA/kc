/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitServiceImplTest2 {

    public static final String ONE = "ONE";
    public static final String TWO = "TWO";
    public static final String THREE = "THREE";
    public static final String OTHER = "OTHER";
    public static final String ANOTHER = "ANOTHER";
    private Unit one;
    private Unit two;
    private Unit three;
    private Unit other;
    private Unit another;
    private UnitServiceImpl unitAgenda;
    @Before
    public void buildServiceToTest() {
        unitAgenda = new UnitServiceImpl();
    }

    @Before
    public void buildAllUnits() {
        //unit hierarchy = one-->two-->three
        one = new Unit();
        one.setUnitNumber(ONE);

        two = new Unit();
        two.setUnitNumber(TWO);
        two.setParentUnitNumber(ONE);

        three = new Unit();
        three.setUnitNumber(THREE);
        three.setParentUnitNumber(TWO);

        //other unit hierachy = one-->other-->another
        other = new Unit();
        other.setUnitNumber(OTHER);
        other.setParentUnitNumber(ONE);

        another = new Unit();
        another.setUnitNumber(ANOTHER);
        another.setParentUnitNumber(OTHER);
    }

    @Test
    public void test_appliesToAnyUnitInHierarchy_bottom() {
        List<Unit> unitHierarchy = new ArrayList<Unit>(){{
            add(one);
            add(two);
            add(three);
        }};
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(ONE, unitHierarchy));
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(TWO, unitHierarchy));
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(THREE, unitHierarchy));
    }

    @Test
    public void test_appliesToAnyUnitInHierarchy_middle() {
        List<Unit> unitHierarchy = new ArrayList<Unit>(){{
            add(one);
            add(two);
        }};
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(ONE, unitHierarchy));
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(TWO, unitHierarchy));
        Assert.assertFalse(unitAgenda.appliesToAnyUnitInHierarchy(THREE, unitHierarchy));
    }

    @Test
    public void test_appliesToAnyUnitInHierarchy_top() {
        List<Unit> unitHierarchy = new ArrayList<Unit>(){{
            add(one);
        }};
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(ONE, unitHierarchy));
        Assert.assertFalse(unitAgenda.appliesToAnyUnitInHierarchy(TWO, unitHierarchy));
        Assert.assertFalse(unitAgenda.appliesToAnyUnitInHierarchy(THREE, unitHierarchy));
    }

    @Test
    public void test_appliesToAnyUnitInHierarchy_differentBranch() {
        List<Unit> unitHierarchy = new ArrayList<Unit>(){{
            add(one);
            add(other);
            add(another);
        }};
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(ONE, unitHierarchy));
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(OTHER, unitHierarchy));
        Assert.assertTrue(unitAgenda.appliesToAnyUnitInHierarchy(ANOTHER, unitHierarchy));
        Assert.assertFalse(unitAgenda.appliesToAnyUnitInHierarchy(TWO, unitHierarchy));
        Assert.assertFalse(unitAgenda.appliesToAnyUnitInHierarchy(THREE, unitHierarchy));
    }
}
