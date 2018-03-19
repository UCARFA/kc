package org.kuali.coeus.common.budget.impl.personnel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.common.budget.framework.personnel.*;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class BudgetPersonnelBudgetServiceTest extends KcIntegrationTestBase {


    protected BudgetPersonServiceImpl budgetPersonService;
    protected KcPersonService kcPersonService;
    protected ProposalDevelopmentBudgetExt budget;
    protected BudgetPersonnelBudgetService budgetPersonnelBudgetService;

    @Before
    public void setUp() throws Exception {
        kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        budgetPersonService = (BudgetPersonServiceImpl) KcServiceLocator.getService(BudgetPersonService.class);
        budgetPersonnelBudgetService = KcServiceLocator.getService(BudgetPersonnelBudgetService.class);
        budget = new ProposalDevelopmentBudgetExt() {
            int nextVal = 1;
            @Override
            public Integer getNextValue(String documentComponentIdKey) {
                return nextVal++;
            }
        };

        Date startDate = createDate(2016, Calendar.JULY, 1);
        Date endDate = createDate(2017, Calendar.JUNE, 30);
        budget.setStartDate(startDate);
        budget.setEndDate(endDate);
        budget.setDevelopmentProposal(new DevelopmentProposal());
        budget.setOnOffCampusFlag("N");
    }

    @Test
    public void testTBNCalculations() throws Exception {
        addTbnPersons();
        final BudgetPeriod budgetPeriod = getBudgetPeriod();
        Date endDate = createDate(2017, Calendar.JUNE, 30);
        Date startDate = createDate(2016, Calendar.JULY, 1);
        budget.getBudgetPeriods().add(budgetPeriod);

        BudgetLineItem lineItem1 = new BudgetLineItem();
        lineItem1.setEndDate(startDate);
        lineItem1.setStartDate(endDate);
        lineItem1.setCostElement("400350");
        lineItem1.setApplyInRateFlag(false);
        lineItem1.setBudgetCategoryCode("26");
        BusinessObjectService businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        HashMap<String, String> searchCriteria =  new HashMap<String, String>();
        searchCriteria.put("costElement", "400350");
        CostElement costElement = businessObjectService.findByPrimaryKey(CostElement.class, searchCriteria);
        lineItem1.setCostElementBO(costElement);
        lineItem1.setBudget(budget);

        BudgetPersonnelDetails budgetPersonnelDetail = new BudgetPersonnelDetails();
        budgetPersonnelDetail.setApplyInRateFlag(false);
        budgetPersonnelDetail.setEndDate(endDate);
        budgetPersonnelDetail.setStartDate(startDate);
        budgetPersonnelDetail.setJobCode("AA000");
        budgetPersonnelDetail.setPercentCharged(ScaleTwoDecimal.ONE_HUNDRED);
        budgetPersonnelDetail.setPercentEffort(ScaleTwoDecimal.ONE_HUNDRED);
        budgetPersonnelDetail.setCostElement("400350");
        budgetPersonnelDetail.setBudgetPerson(budget.getBudgetPerson(0));
        budgetPersonnelDetail.setPersonSequenceNumber(budget.getBudgetPersons().get(0).getPersonSequenceNumber());
        budgetPersonnelBudgetService.addBudgetPersonnelToPeriod(budgetPeriod, lineItem1, budgetPersonnelDetail);
        Assert.assertTrue(budgetPersonnelDetail.getLineItemCost().compareTo(new ScaleTwoDecimal(10000)) == 0);

        BudgetPersonnelDetails budgetPersonnelDetail2 = new BudgetPersonnelDetails();
        budgetPersonnelDetail2.setEndDate(endDate);
        budgetPersonnelDetail2.setStartDate(startDate);
        budgetPersonnelDetail2.setJobCode("AA000");
        budgetPersonnelDetail2.setPercentCharged(ScaleTwoDecimal.ONE_HUNDRED);
        budgetPersonnelDetail2.setPercentEffort(ScaleTwoDecimal.ONE_HUNDRED);
        budgetPersonnelDetail2.setCostElement("400350");
        budgetPersonnelDetail2.setBudgetPerson(budget.getBudgetPerson(1));
        budgetPersonnelDetail2.setPersonSequenceNumber(budget.getBudgetPersons().get(1).getPersonSequenceNumber());
        budgetPersonnelBudgetService.addBudgetPersonnelToPeriod(budgetPeriod, lineItem1, budgetPersonnelDetail2);
        Assert.assertTrue(budgetPersonnelDetail2.getLineItemCost().compareTo(new ScaleTwoDecimal(20000)) == 0);

        budget.getBudgetPeriods();

    }

    public BudgetPeriod getBudgetPeriod() {
        BudgetPeriod period1 = new BudgetPeriod();
        Date endDate = createDate(2017, Calendar.JUNE, 30);
        Date startDate = createDate(2016, Calendar.JULY, 1);
        period1.setStartDate(startDate);
        period1.setEndDate(endDate);
        period1.setBudgetPeriod(1);
        period1.setBudget(budget);
        return period1;
    }

    public void addTbnPersons() throws Exception {
        TbnPerson tbnPerson = new TbnPerson();
        tbnPerson.setTbnId("1");
        tbnPerson.setPersonName("Tbn Person 1");
        BudgetPerson testPerson = new BudgetPerson(tbnPerson);
        testPerson.setPersonSequenceNumber(1);
        testPerson.setEffectiveDate(createDate(2015, Calendar.JULY, 1)); //07/01/2015
        testPerson.setCalculationBase(new ScaleTwoDecimal(10000));
        testPerson.setJobCode("AA000");

        TbnPerson tbnPerson2 = new TbnPerson();
        tbnPerson2.setTbnId("1");
        tbnPerson2.setPersonName("Tbn Person 2");
        BudgetPerson testPerson2 = new BudgetPerson(tbnPerson2);
        testPerson2.setPersonSequenceNumber(2);
        testPerson2.setEffectiveDate(createDate(2016, Calendar.JULY, 1)); //07/01/2016
        testPerson2.setCalculationBase(new ScaleTwoDecimal(20000));
        testPerson2.setJobCode("AA000");

        budgetPersonService.addBudgetPerson(budget, testPerson);
        budgetPersonService.addBudgetPerson(budget, testPerson2);
        assertTrue(budget.getBudgetPersons().size() == 2);
    }



    public Date createDate(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, date);
        return new Date(cal.getTime().getTime());
    }

}
