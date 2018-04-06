package org.kuali.coeus.propdev.impl.budget.person;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.personnel.BudgetPerson;

import java.util.ArrayList;
import java.util.List;

public class ProposalBudgetProjectPersonnelControllerTest {

    @Test
    public void getNextTbnNameTestRegular(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA Graduate Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA Graduate Assistant - 3"));
    }

    @Test
    public void getNextTbnNameTest1(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA Research");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA Research - 1"));
    }

    @Test
    public void getNextTbnNameTest2(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA Graduate Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA Graduate Assistant - 3"));

    }

    @Test
    public void getNextTbnNameTest2DoubleDigit(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate Assistant - 13");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate Assistant - 14");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA Graduate Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA Graduate Assistant - 1"));

    }

    @Test
    public void getNextTbnNameTest3(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate - 2 Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate - 2 Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA Graduate - 3 Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA Graduate - 3 Assistant - 1"));

    }

    @Test
    public void getNextTbnNameTest4(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate - 2 Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate - 2 Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("Graduate - 2 Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("Graduate - 2 Assistant - 1"));

    }

    @Test
    public void getNextTbnNameTest5(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate - 2 Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate - 2 Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("Batman - 3 Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("Batman - 3 Assistant - 1"));

    }

    @Test
    public void getNextTbnNameTest6(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate - 2 Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate - 2 Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA Graduate - Batman - 3 Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA Graduate - Batman - 3 Assistant - 1"));
    }

    @Test
    public void getNextTbnNameTest7(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA Graduate - Batman - 3 Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA Graduate - Batman - 3 Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA Graduate - Batman - 3 Assistant");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA Graduate - Batman - 3 Assistant - 3"));
    }

    @Test
    public void getNextTbnNameTestPersonWithUnderscores(){

        List<BudgetPerson> personList = new ArrayList<>();
        BudgetPerson budgetPerson = new BudgetPerson();
        budgetPerson.setTbnId("1");
        budgetPerson.setPersonName("TBA-Graduate Assistant - 1");
        personList.add(budgetPerson);

        BudgetPerson budgetPerson2 = new BudgetPerson();
        budgetPerson2.setTbnId("2");
        budgetPerson2.setPersonName("TBA-Graduate Assistant - 2");
        personList.add(budgetPerson2);

        BudgetPerson newPerson = new BudgetPerson();
        budgetPerson2.setTbnId("3");
        newPerson.setPersonName("TBA - Research");

        String nextName = getController().getNextTbnName(personList, newPerson);
        Assert.assertTrue(nextName.equalsIgnoreCase("TBA - Research - 1"));
    }



    public ProposalBudgetProjectPersonnelController getController() {

        return new ProposalBudgetProjectPersonnelController();
    }
}
