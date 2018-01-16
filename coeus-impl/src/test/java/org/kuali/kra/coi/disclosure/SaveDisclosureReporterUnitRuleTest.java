/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.junit.Test;
import org.kuali.kra.coi.personfinancialentity.FinancialEntityReporterUnit;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;

import java.util.ArrayList;
import java.util.List;

public class SaveDisclosureReporterUnitRuleTest {

    @Test
    public void testSaveFinancialEntityReporterUnitOK() {
        new TemplateRuleTest<SaveDisclosureReporterUnitEvent, SaveDisclosureReporterUnitRule>() {
            @Override
            protected void prerequisite() {
                List<FinancialEntityReporterUnit> financialEntityReporterUnits = new ArrayList<FinancialEntityReporterUnit>();
                FinancialEntityReporterUnit financialEntityReporterUnit = new FinancialEntityReporterUnit();
                financialEntityReporterUnit.setUnitNumber("1");
                financialEntityReporterUnit.setLeadUnitFlag(true);
                financialEntityReporterUnits.add(financialEntityReporterUnit);
                FinancialEntityReporterUnit financialEntityReporterUnit1 = new FinancialEntityReporterUnit();
                financialEntityReporterUnit1.setUnitNumber("2");
                financialEntityReporterUnits.add(financialEntityReporterUnit1);
                event = new SaveDisclosureReporterUnitEvent(Constants.EMPTY_STRING, financialEntityReporterUnits);
                rule = new SaveDisclosureReporterUnitRule();
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testNoFinancialEntityReporterUnit() {
        new TemplateRuleTest<SaveDisclosureReporterUnitEvent, SaveDisclosureReporterUnitRule>() {
            @Override
            protected void prerequisite() {
                List<FinancialEntityReporterUnit> financialEntityReporterUnits = new ArrayList<FinancialEntityReporterUnit>();
                event = new SaveDisclosureReporterUnitEvent(Constants.EMPTY_STRING, financialEntityReporterUnits);
                rule = new SaveDisclosureReporterUnitRule();
                expectedReturnValue = false;
            }
        };
    }

    @Test
    public void testNoLeadUnit() {
        new TemplateRuleTest<SaveDisclosureReporterUnitEvent, SaveDisclosureReporterUnitRule>() {
            @Override
            protected void prerequisite() {
                List<FinancialEntityReporterUnit> financialEntityReporterUnits = new ArrayList<FinancialEntityReporterUnit>();
                FinancialEntityReporterUnit financialEntityReporterUnit = new FinancialEntityReporterUnit();
                financialEntityReporterUnit.setUnitNumber("1");
                financialEntityReporterUnits.add(financialEntityReporterUnit);
                FinancialEntityReporterUnit financialEntityReporterUnit1 = new FinancialEntityReporterUnit();
                financialEntityReporterUnit1.setUnitNumber("2");
                financialEntityReporterUnits.add(financialEntityReporterUnit1);
                event = new SaveDisclosureReporterUnitEvent(Constants.EMPTY_STRING, financialEntityReporterUnits);
                rule = new SaveDisclosureReporterUnitRule();
                expectedReturnValue = false;
            }
        };
    }

}
