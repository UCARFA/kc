/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.kuali.kra.coi.*;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.rules.TemplateRuleTest;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.util.ArrayList;
import java.util.Date;

public class AddManualProjectRuleTest extends KcIntegrationTestBase {

    @Test
    public void testAddProposalEventOK() {
        new TemplateRuleTest<AddManualProjectEvent, AddManualProjectRule>() {
            @Override
            protected void prerequisite() {
                CoiDisclProject coiDisclProject = new CoiDisclProject() ;
                
                coiDisclProject.setDisclosureEventType(CoiDisclosureEventType.MANUAL_DEVELOPMENT_PROPOSAL);
                
                coiDisclProject.setCoiProjectId("test id");
                coiDisclProject.setCoiProjectTitle("test title");
                coiDisclProject.setModuleItemKey(coiDisclProject.getCoiProjectId());
                coiDisclProject.setShortTextField1("test project role");
                coiDisclProject.setLongTextField1("test sponsor");

                coiDisclProject.setNumberField1(new ScaleTwoDecimal(1000.00));
                coiDisclProject.setDateField1(new java.sql.Date(new Date().getTime()));
                CoiDisclosure coiDisclosure = new CoiDisclosure();
                coiDisclosure.setCoiDisclProjects(new ArrayList<CoiDisclProject>());
                coiDisclProject.setCoiDisclosure(coiDisclosure);
                Date dt = DateUtils.addDays(new Date(), 10);
                coiDisclProject.setDateField2(new java.sql.Date(dt.getTime()));
                
                coiDisclProject.setSelectBox1("1");
                
                coiDisclProject.setDisclosureDispositionCode(CoiDispositionStatus.IN_PROGRESS);
                coiDisclProject.setDisclosureStatusCode(CoiDisclosureStatus.IN_PROGRESS);
                
                event = new AddManualProjectEvent(Constants.EMPTY_STRING, coiDisclProject);
                rule = new AddManualProjectRule();
                expectedReturnValue = true;
            }
        };
    }


    @Test
    public void testAddAwardEventOK() {
        new TemplateRuleTest<AddManualProjectEvent, AddManualProjectRule>() {
            @Override
            protected void prerequisite() {
                CoiDisclProject coiDisclProject = new CoiDisclProject() ;

                coiDisclProject.setDisclosureEventType(CoiDisclosureEventType.MANUAL_AWARD);

                coiDisclProject.setCoiProjectId("test id");
                coiDisclProject.setCoiProjectTitle("test title");
                coiDisclProject.setModuleItemKey(coiDisclProject.getCoiProjectId());
                coiDisclProject.setDateField1(new java.sql.Date(new Date().getTime()));
                coiDisclProject.setDisclosureDispositionCode(CoiDispositionStatus.IN_PROGRESS);
                coiDisclProject.setDisclosureStatusCode(CoiDisclosureStatus.IN_PROGRESS);                
                CoiDisclosure coiDisclosure = new CoiDisclosure();
                coiDisclosure.setCoiDisclProjects(new ArrayList<CoiDisclProject>());
                coiDisclProject.setCoiDisclosure(coiDisclosure);
                event = new AddManualProjectEvent(Constants.EMPTY_STRING, coiDisclProject);
                rule = new AddManualProjectRule();
                expectedReturnValue = true;
            }
        };
    }


    @Test
    public void testAddProtocolEventOK() {
        new TemplateRuleTest<AddManualProjectEvent, AddManualProjectRule>() {
            @Override
            protected void prerequisite() {
                CoiDisclProject coiDisclProject = new CoiDisclProject() ;
                
                coiDisclProject.setDisclosureEventType(CoiDisclosureEventType.MANUAL_IRB_PROTOCOL);

                coiDisclProject.setCoiProjectId("test id");
                coiDisclProject.setCoiProjectTitle("test title");
                coiDisclProject.setModuleItemKey(coiDisclProject.getCoiProjectId());
                coiDisclProject.setDisclosureDispositionCode(CoiDispositionStatus.IN_PROGRESS);
                coiDisclProject.setDisclosureStatusCode(CoiDisclosureStatus.IN_PROGRESS);                
                CoiDisclosure coiDisclosure = new CoiDisclosure();
                coiDisclosure.setCoiDisclProjects(new ArrayList<CoiDisclProject>());
                coiDisclProject.setCoiDisclosure(coiDisclosure);
                
                coiDisclProject.setSelectBox1("1");
                
                event = new AddManualProjectEvent(Constants.EMPTY_STRING, coiDisclProject);
                rule = new AddManualProjectRule();
                expectedReturnValue = true;
            }
        };
    }

    
    @Test
    public void testAddTravelEventOK() {
        new TemplateRuleTest<AddManualProjectEvent, AddManualProjectRule>() {
            @Override
            protected void prerequisite() {
                CoiDisclProject coiDisclProject = new CoiDisclProject() ;
                
                coiDisclProject.setDisclosureEventType(CoiDisclosureEventType.MANUAL_TRAVEL);

                coiDisclProject.setCoiProjectId("event id");
                coiDisclProject.setCoiProjectTitle("event title");
                coiDisclProject.setModuleItemKey(coiDisclProject.getCoiProjectId());
                coiDisclProject.setDisclosureDispositionCode(CoiDispositionStatus.IN_PROGRESS);
                coiDisclProject.setDisclosureStatusCode(CoiDisclosureStatus.IN_PROGRESS);                
                CoiDisclosure coiDisclosure = new CoiDisclosure();
                coiDisclosure.setCoiDisclProjects(new ArrayList<CoiDisclProject>());
                coiDisclProject.setCoiDisclosure(coiDisclosure);
                
                coiDisclProject.setShortTextField1("destination");
                coiDisclProject.setLongTextField1("entity name");
                coiDisclProject.setLongTextField2("sponsor");
                coiDisclProject.setLongTextField3("purpose");

                coiDisclProject.setNumberField1(new ScaleTwoDecimal(1000));
                coiDisclProject.setDateField1(new java.sql.Date(new Date().getTime()));
                Date dt = DateUtils.addDays(new Date(), 10);
                coiDisclProject.setDateField2(new java.sql.Date(dt.getTime()));
                
                event = new AddManualProjectEvent(Constants.EMPTY_STRING, coiDisclProject);
                rule = new AddManualProjectRule();
                expectedReturnValue = true;
            }
        };
    }

}
