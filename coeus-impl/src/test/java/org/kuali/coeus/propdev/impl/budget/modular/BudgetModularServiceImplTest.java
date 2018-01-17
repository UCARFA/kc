package org.kuali.coeus.propdev.impl.budget.modular;

import junit.framework.Assert;
import org.junit.Test;
import org.kuali.coeus.common.budget.framework.calculator.BudgetCalculationService;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItemCalculatedAmount;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetRateAndBase;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.common.budget.framework.rate.RateClass;
import org.kuali.coeus.common.budget.impl.calculator.BudgetCalculationServiceImpl;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.util.ArrayList;
import java.util.Collection;

public class BudgetModularServiceImplTest {

    @Test
    public void testEquipmentWithoutAnyMTDCWithoutBaseRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        budget.getBudgetPeriod(0).getBudgetLineItems().add(getLineItemWithoutAnyMTDC(25800));

        BudgetModular budgetModular = modularService.initializeModularBudget(budgetPeriod);

        ScaleTwoDecimal directCostWithoutConsortiumFna = modularService.calculateConsortiumAmounts(budget, budgetPeriod, budgetModular, modularService.getFnaRateClassType(), modularService.getConsortiumFnaOnlyCostElements());
        Assert.assertTrue(directCostWithoutConsortiumFna.compareTo(new ScaleTwoDecimal(25800)) == 0);
        modularService.synchModularBudgetWithoutRoundingFandABase(budget);
        Assert.assertTrue(budgetModular.getConsortiumFna().isZero());
        Assert.assertTrue(budgetModular.getDirectCostLessConsortiumFna().compareTo(new ScaleTwoDecimal(50000)) == 0);

    }

    @Test
    public void testServiceContractsWithMTDCWithoutBaseRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        budget.getBudgetPeriod(0).getBudgetLineItems().add(getLineItemWithMTDC(500, 48));

        BudgetModular budgetModular = modularService.initializeModularBudget(budgetPeriod);

        ScaleTwoDecimal directCostWithoutConsortiumFna = modularService.calculateConsortiumAmounts(budget, budgetPeriod, budgetModular, modularService.getFnaRateClassType(), modularService.getConsortiumFnaOnlyCostElements());
        Assert.assertTrue(directCostWithoutConsortiumFna.compareTo(new ScaleTwoDecimal(500)) == 0);
        modularService.synchModularBudgetWithoutRoundingFandABase(budget);
        Assert.assertTrue(budgetModular.getConsortiumFna().isZero());
        Assert.assertTrue(budgetModular.getDirectCostLessConsortiumFna().compareTo(new ScaleTwoDecimal(25000)) == 0);
        Assert.assertTrue(budgetModular.getTotalFnaRequested().compareTo(new ScaleTwoDecimal(.48 * 500)) == 0);
        Assert.assertTrue(budgetModular.getBudgetModularIdc(0).getIdcBase().compareTo(new ScaleTwoDecimal(500)) == 0);

    }

    @Test
    public void testSubcontractFandANoMTDCWithoutBaseRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        budget.getBudgetPeriod(0).getBudgetLineItems().add(getSubcontractFandANoMTDC(10000));

        BudgetModular budgetModular = modularService.initializeModularBudget(budgetPeriod);

        ScaleTwoDecimal directCostWithoutConsortiumFna = modularService.calculateConsortiumAmounts(budget, budgetPeriod, budgetModular, modularService.getFnaRateClassType(), modularService.getConsortiumFnaOnlyCostElements());
        Assert.assertTrue(directCostWithoutConsortiumFna.isZero());
        modularService.synchModularBudgetWithoutRoundingFandABase(budget);
        Assert.assertTrue(budgetModular.getConsortiumFna().compareTo(new ScaleTwoDecimal(10000)) == 0);
        Assert.assertTrue(budgetModular.getDirectCostLessConsortiumFna().isZero());
        Assert.assertTrue(budgetModular.getTotalFnaRequested().isZero());
        Assert.assertTrue(budgetModular.getBudgetModularIdc(0).getIdcBase().isZero());

    }

    @Test
    public void testSubcontractFandAWithMTDCWithoutBaseRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        budget.getBudgetPeriod(0).getBudgetLineItems().add(getSubcontractFandAWithMTDC(20000, 48));

        BudgetModular budgetModular = modularService.initializeModularBudget(budgetPeriod);

        ScaleTwoDecimal directCostWithoutConsortiumFna = modularService.calculateConsortiumAmounts(budget, budgetPeriod, budgetModular, modularService.getFnaRateClassType(), modularService.getConsortiumFnaOnlyCostElements());
        Assert.assertTrue(directCostWithoutConsortiumFna.isZero());
        modularService.synchModularBudgetWithoutRoundingFandABase(budget);
        Assert.assertTrue(budgetModular.getConsortiumFna().compareTo(new ScaleTwoDecimal(20000)) == 0);
        Assert.assertTrue(budgetModular.getDirectCostLessConsortiumFna().isZero());
        Assert.assertTrue(budgetModular.getTotalFnaRequested().compareTo(new ScaleTwoDecimal(20000).multiply(new ScaleTwoDecimal(.48)) ) == 0);
        Assert.assertTrue(budgetModular.getBudgetModularIdc(0).getIdcBase().compareTo(new ScaleTwoDecimal(20000)) == 0);
    }

    @Test
    public void testSubcontractDirectCostsNoMTDCWithoutBaseRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        budget.getBudgetPeriod(0).getBudgetLineItems().add(getSubcontractDirectCostsNoMTDC(2000));

        BudgetModular budgetModular = modularService.initializeModularBudget(budgetPeriod);

        ScaleTwoDecimal directCostWithoutConsortiumFna = modularService.calculateConsortiumAmounts(budget, budgetPeriod, budgetModular, modularService.getFnaRateClassType(), modularService.getConsortiumFnaOnlyCostElements());
        Assert.assertTrue(directCostWithoutConsortiumFna.compareTo(new ScaleTwoDecimal(2000)) == 0);
        modularService.synchModularBudgetWithoutRoundingFandABase(budget);
        Assert.assertTrue(budgetModular.getConsortiumFna().isZero());
        Assert.assertTrue(budgetModular.getDirectCostLessConsortiumFna().compareTo(new ScaleTwoDecimal(25000)) == 0);
        Assert.assertTrue(budgetModular.getTotalFnaRequested().isZero());
        Assert.assertTrue(budgetModular.getBudgetModularIdc(0).getIdcBase().isZero());
    }

    @Test
    public void testSubcontractDirectCostsWithMTDCWithoutBaseRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        budget.getBudgetPeriod(0).getBudgetLineItems().add(getSubcontractDirectCostsWithMTDC(2000, 48));

        BudgetModular budgetModular = modularService.initializeModularBudget(budgetPeriod);

        ScaleTwoDecimal directCostWithoutConsortiumFna = modularService.calculateConsortiumAmounts(budget, budgetPeriod, budgetModular, modularService.getFnaRateClassType(), modularService.getConsortiumFnaOnlyCostElements());
        Assert.assertTrue(directCostWithoutConsortiumFna.compareTo(new ScaleTwoDecimal(2000)) == 0);
        modularService.synchModularBudgetWithoutRoundingFandABase(budget);
        Assert.assertTrue(budgetModular.getConsortiumFna().isZero());
        Assert.assertTrue(budgetModular.getDirectCostLessConsortiumFna().compareTo(new ScaleTwoDecimal(25000)) == 0);
        Assert.assertTrue(budgetModular.getBudgetModularIdc(0).getFundsRequested().compareTo(new ScaleTwoDecimal(2000).multiply(new ScaleTwoDecimal(.48))) == 0);
        Assert.assertTrue(budgetModular.getTotalFnaRequested().compareTo(new ScaleTwoDecimal(2000).multiply(new ScaleTwoDecimal(.48)) ) == 0);
        Assert.assertTrue(budgetModular.getBudgetModularIdc(0).getIdcBase().compareTo(new ScaleTwoDecimal(2000)) == 0);
        Assert.assertTrue(budgetModular.getTotalRequestedCost().compareTo(new ScaleTwoDecimal(25960)) == 0);
    }

    private BudgetLineItem getSubcontractDirectCostsWithMTDC(int line_item_cost, int rate) {
        BudgetLineItem subcontractFandANoMTDC = new BudgetLineItem();
        subcontractFandANoMTDC.setCostElement("420600");
        subcontractFandANoMTDC.setLineItemCost(new ScaleTwoDecimal(line_item_cost));
        subcontractFandANoMTDC.setApplyInRateFlag(true);
        subcontractFandANoMTDC.setDirectCost(new ScaleTwoDecimal(line_item_cost));
        subcontractFandANoMTDC.setIndirectCost(new ScaleTwoDecimal(line_item_cost).multiply(new ScaleTwoDecimal(rate / 100)));
        final ArrayList<BudgetLineItemCalculatedAmount> budgetLineItemCalculatedAmounts = new ArrayList<>();
        budgetLineItemCalculatedAmounts.add(getLineItemCalculatedAmount("1", "1", new ScaleTwoDecimal(line_item_cost), "MTDC", "O"));
        subcontractFandANoMTDC.setBudgetLineItemCalculatedAmounts(budgetLineItemCalculatedAmounts);
        ArrayList<BudgetRateAndBase> ratesAndBase = new ArrayList<>();
        ratesAndBase.add(getBudgetRateAndBase("1", "1", "O", new ScaleTwoDecimal(line_item_cost), new ScaleTwoDecimal(rate)));
        subcontractFandANoMTDC.setBudgetRateAndBaseList(ratesAndBase);
        return subcontractFandANoMTDC;
    }


    private BudgetLineItem getSubcontractFandAWithMTDC(int lineItemAmount, int rate) {
        BudgetLineItem subcontractFandANoMTDC = new BudgetLineItem();
        subcontractFandANoMTDC.setCostElement("420610");
        subcontractFandANoMTDC.setLineItemCost(new ScaleTwoDecimal(lineItemAmount));
        subcontractFandANoMTDC.setApplyInRateFlag(true);
        subcontractFandANoMTDC.setDirectCost(new ScaleTwoDecimal(lineItemAmount));
        subcontractFandANoMTDC.setIndirectCost(ScaleTwoDecimal.ZERO);
        final ArrayList<BudgetLineItemCalculatedAmount> budgetLineItemCalculatedAmounts = new ArrayList<>();
        budgetLineItemCalculatedAmounts.add(getLineItemCalculatedAmount("1", "1", new ScaleTwoDecimal(lineItemAmount), "MTDC", "O"));
        subcontractFandANoMTDC.setBudgetLineItemCalculatedAmounts(budgetLineItemCalculatedAmounts);
        ArrayList<BudgetRateAndBase> ratesAndBase = new ArrayList<>();
        ratesAndBase.add(getBudgetRateAndBase("1", "1", "O", new ScaleTwoDecimal(lineItemAmount), new ScaleTwoDecimal(rate)));
        subcontractFandANoMTDC.setBudgetRateAndBaseList(ratesAndBase);
        return subcontractFandANoMTDC;
    }

    private BudgetLineItem getSubcontractDirectCostsNoMTDC(int lineItemAmount) {
        BudgetLineItem subcontractFandANoMTDC = new BudgetLineItem();
        subcontractFandANoMTDC.setCostElement("420620");
        subcontractFandANoMTDC.setLineItemCost(new ScaleTwoDecimal(lineItemAmount));
        subcontractFandANoMTDC.setApplyInRateFlag(true);
        subcontractFandANoMTDC.setDirectCost(new ScaleTwoDecimal(lineItemAmount));
        subcontractFandANoMTDC.setIndirectCost(ScaleTwoDecimal.ZERO);
        final ArrayList<BudgetLineItemCalculatedAmount> budgetLineItemCalculatedAmounts = new ArrayList<>();
        subcontractFandANoMTDC.setBudgetLineItemCalculatedAmounts(budgetLineItemCalculatedAmounts);
        ArrayList<BudgetRateAndBase> ratesAndBase = new ArrayList<>();
        subcontractFandANoMTDC.setBudgetRateAndBaseList(ratesAndBase);
        return subcontractFandANoMTDC;
    }

    private BudgetLineItem getSubcontractFandANoMTDC(int lineItemAmount) {
        BudgetLineItem subcontractFandANoMTDC = new BudgetLineItem();
        subcontractFandANoMTDC.setCostElement("420630");
        subcontractFandANoMTDC.setLineItemCost(new ScaleTwoDecimal(lineItemAmount));
        subcontractFandANoMTDC.setApplyInRateFlag(true);
        subcontractFandANoMTDC.setDirectCost(new ScaleTwoDecimal(lineItemAmount));
        subcontractFandANoMTDC.setIndirectCost(ScaleTwoDecimal.ZERO);
        final ArrayList<BudgetLineItemCalculatedAmount> budgetLineItemCalculatedAmounts = new ArrayList<>();
        subcontractFandANoMTDC.setBudgetLineItemCalculatedAmounts(budgetLineItemCalculatedAmounts);
        ArrayList<BudgetRateAndBase> ratesAndBase = new ArrayList<>();
        subcontractFandANoMTDC.setBudgetRateAndBaseList(ratesAndBase);
        return subcontractFandANoMTDC;
    }

    private BudgetLineItem getLineItemWithMTDC(int lineItemCost, int rate) {
        BudgetLineItem lineItemWithMTDC = new BudgetLineItem();
        lineItemWithMTDC.setCostElement("420338");
        lineItemWithMTDC.setLineItemCost(new ScaleTwoDecimal(lineItemCost));
        lineItemWithMTDC.setApplyInRateFlag(true);
        lineItemWithMTDC.setDirectCost(new ScaleTwoDecimal(lineItemCost));
        lineItemWithMTDC.setIndirectCost(new ScaleTwoDecimal(lineItemCost).multiply(new ScaleTwoDecimal(rate / 100)));
        final ArrayList<BudgetLineItemCalculatedAmount> budgetLineItemCalculatedAmounts = new ArrayList<>();
        // do not need other rates because we'll unapply for these tests
        budgetLineItemCalculatedAmounts.add(getLineItemCalculatedAmount("1", "1", new ScaleTwoDecimal(240), "MTDC", "O"));
        lineItemWithMTDC.setBudgetLineItemCalculatedAmounts(budgetLineItemCalculatedAmounts);
        ArrayList<BudgetRateAndBase> ratesAndBase = new ArrayList<>();
        ratesAndBase.add(getBudgetRateAndBase("1", "1", "O", new ScaleTwoDecimal(lineItemCost), new ScaleTwoDecimal(rate)));
        lineItemWithMTDC.setBudgetRateAndBaseList(ratesAndBase);
        return lineItemWithMTDC;
    }

    private BudgetLineItem getLineItemWithoutAnyMTDC(int lineItemCost) {
        BudgetLineItem lineItemWithoutMTDC = new BudgetLineItem();
        lineItemWithoutMTDC.setCostElement("421818");
        lineItemWithoutMTDC.setLineItemCost(new ScaleTwoDecimal(lineItemCost));
        lineItemWithoutMTDC.setApplyInRateFlag(true);
        lineItemWithoutMTDC.setDirectCost(new ScaleTwoDecimal(lineItemCost));
        lineItemWithoutMTDC.setIndirectCost(ScaleTwoDecimal.ZERO);
        lineItemWithoutMTDC.setBudgetLineItemCalculatedAmounts(new ArrayList<>());
        return lineItemWithoutMTDC;
    }

    private BudgetRateAndBase getBudgetRateAndBase(String rateClassCode, String rateTypeCode, String rateClassTypeCode, ScaleTwoDecimal baseCost, ScaleTwoDecimal appliedRate) {
        BudgetRateAndBase rateAndBase = new BudgetRateAndBase() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {
            }

        };
        rateAndBase.setRateClassCode(rateClassCode);
        RateClass rateClass = new RateClass();
        rateClass.setRateClassTypeCode(rateClassTypeCode);
        rateAndBase.setRateClass(rateClass);
        rateAndBase.setRateTypeCode(rateTypeCode);
        rateAndBase.setCalculatedCost(baseCost.multiply(appliedRate.divide(ScaleTwoDecimal.ONE_HUNDRED)));
        rateAndBase.setBaseCost(baseCost);
        rateAndBase.setAppliedRate(appliedRate);
        return rateAndBase;
    }

    private BudgetLineItemCalculatedAmount getLineItemCalculatedAmount(String rateClassCode, String rateTypeCode, ScaleTwoDecimal calculatedCost,
                                                                       String rateTypeDescription, String rateClassTypeCode) {
        BudgetLineItemCalculatedAmount budgetLineItemCalculatedAmount = new BudgetLineItemCalculatedAmount();
        budgetLineItemCalculatedAmount.setRateClassCode(rateClassCode);
        budgetLineItemCalculatedAmount.setRateTypeCode(rateTypeCode);
        budgetLineItemCalculatedAmount.setCalculatedCost(calculatedCost);
        budgetLineItemCalculatedAmount.setRateTypeDescription(rateTypeDescription);
        budgetLineItemCalculatedAmount.setApplyRateFlag(true);
        RateClass rateClass = new RateClass();
        rateClass.setRateClassTypeCode(rateClassTypeCode);
        rateClass.setDescription(rateTypeDescription);

        budgetLineItemCalculatedAmount.setRateClass(rateClass);
        return budgetLineItemCalculatedAmount;
    }

    public BudgetModularServiceImpl getBudgetModularService() {
        return new BudgetModularServiceImpl() {
            @Override
            public String getFnaRateClassType() {
                return "O";
            }

            @Override
            public Collection<String> getConsortiumFnaOnlyCostElements() {
                final Collection<String> values = new ArrayList<>();
                values.add("420630");
                values.add("420610");
                return values;
            }

            @Override
            public String getCostelementSubconFandAUnder25K() {
                return "420610";
            }

            @Override
            public String getCostelementSubconFandAOver25K() {
                return "420630";
            }

            @Override
            public BudgetCalculationService getBudgetCalculationService() {
                return new BudgetCalculationServiceImpl() {
                    @Override
                    public void calculateBudgetLineItem(Budget budget, BudgetLineItem budgetLineItem) {
                    }
                };
            }

        };
    }
    
    @Test
    public void testFandAbaseSubconFandANoMTDCRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        final DevelopmentProposal developmentProposal = new DevelopmentProposal();
        developmentProposal.setProposalNumber("1");
        budget.setDevelopmentProposal(developmentProposal);
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        final BudgetLineItem subcontractFandANoMTDC = getSubcontractFandANoMTDC(35176);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(subcontractFandANoMTDC);

        modularService.synchModularBudgetAndRoundFandABase(budget, false);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalFnaRequested().isZero());
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getConsortiumFna().compareTo(new ScaleTwoDecimal(35176)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalRequestedCost().compareTo(new ScaleTwoDecimal(35176)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdcs().size() == 0);

    }

    @Test
    public void testFandAbaseSubconDirectCostWithMTDCRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        final DevelopmentProposal developmentProposal = new DevelopmentProposal();
        developmentProposal.setProposalNumber("1");
        budget.setDevelopmentProposal(developmentProposal);
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        final BudgetLineItem subcontractDirectCostsWithMTDC = getSubcontractDirectCostsWithMTDC(25000, 50);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(subcontractDirectCostsWithMTDC);

        modularService.synchModularBudgetAndRoundFandABase(budget, false);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalFnaRequested().compareTo(new ScaleTwoDecimal(12500)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getConsortiumFna().isZero());
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalRequestedCost().compareTo(new ScaleTwoDecimal(37500)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getIdcBase().compareTo(new ScaleTwoDecimal(25000)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getIdcBaseUnrounded().compareTo(new ScaleTwoDecimal(25000)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getFundsRequested().compareTo(new ScaleTwoDecimal(12500)) == 0);

    }

    @Test
    public void testFandAbaseSubconDirectCostNoMTDCRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        final DevelopmentProposal developmentProposal = new DevelopmentProposal();
        developmentProposal.setProposalNumber("1");
        budget.setDevelopmentProposal(developmentProposal);
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        final BudgetLineItem subcontractDirectCostsNoMTDC = getSubcontractDirectCostsNoMTDC(70100);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(subcontractDirectCostsNoMTDC);

        modularService.synchModularBudgetAndRoundFandABase(budget, false);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalFnaRequested().isZero());
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getConsortiumFna().isZero());
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalRequestedCost().compareTo(new ScaleTwoDecimal(75000)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdcs().size() == 0);

    }

    @Test
    public void testFandAbaseLineItemWithMTDCRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        final DevelopmentProposal developmentProposal = new DevelopmentProposal();
        developmentProposal.setProposalNumber("1");
        budget.setDevelopmentProposal(developmentProposal);
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        final BudgetLineItem lineItemWithMTDC = getLineItemWithMTDC(105126, 50);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(lineItemWithMTDC);

        modularService.synchModularBudgetAndRoundFandABase(budget, false);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalFnaRequested().compareTo(new ScaleTwoDecimal(62500)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getDirectCostLessConsortiumFna().compareTo(new ScaleTwoDecimal(125000)) == 0);

        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getConsortiumFna().isZero());
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalRequestedCost().compareTo(new ScaleTwoDecimal(187500)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getIdcBase().compareTo(new ScaleTwoDecimal(125000)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getIdcBaseUnrounded().compareTo(new ScaleTwoDecimal(105126)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getFundsRequested().compareTo(new ScaleTwoDecimal(62500)) == 0);
    }

    @Test
    public void testFandAbaseAllItemsRounding() {
        BudgetModularServiceImpl modularService = getBudgetModularService();
        ProposalDevelopmentBudgetExt budget = new ProposalDevelopmentBudgetExt();
        final DevelopmentProposal developmentProposal = new DevelopmentProposal();
        developmentProposal.setProposalNumber("1");
        budget.setDevelopmentProposal(developmentProposal);
        budget.setBudgetId(1L);
        budget.setBudgetPeriods(new ArrayList<>());
        final BudgetPeriod budgetPeriod = new BudgetPeriod();
        budgetPeriod.setBudget(budget);
        budget.getBudgetPeriods().add(budgetPeriod);

        final BudgetLineItem subcontractDirectCostsWithMTDC = getSubcontractDirectCostsWithMTDC(25000, 50);
        subcontractDirectCostsWithMTDC.setLineItemNumber(1);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(subcontractDirectCostsWithMTDC);

        final BudgetLineItem subcontractFandANoMTDC = getSubcontractFandANoMTDC(35176);
        subcontractFandANoMTDC.setLineItemNumber(2);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(subcontractFandANoMTDC);

        final BudgetLineItem subcontractDirectCostsNoMTDC = getSubcontractDirectCostsNoMTDC(70100);
        subcontractDirectCostsNoMTDC.setLineItemNumber(3);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(subcontractDirectCostsNoMTDC);

        final BudgetLineItem lineItemWithMTDC = getLineItemWithMTDC(105126, 50);
        lineItemWithMTDC.setLineItemNumber(4);
        budget.getBudgetPeriod(0).getBudgetLineItems().add(lineItemWithMTDC);

        modularService.synchModularBudgetAndRoundFandABase(budget, false);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalFnaRequested().compareTo(new ScaleTwoDecimal(77450)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getDirectCostLessConsortiumFna().compareTo(new ScaleTwoDecimal(225000)) == 0);

        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getConsortiumFna().compareTo(new ScaleTwoDecimal(35176)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getTotalRequestedCost().compareTo(new ScaleTwoDecimal(337626)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getIdcBase().compareTo(new ScaleTwoDecimal(154900)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getIdcBaseUnrounded().compareTo(new ScaleTwoDecimal(130126)) == 0);
        Assert.assertTrue(budget.getBudgetPeriod(0).getBudgetModular().getBudgetModularIdc(0).getFundsRequested().compareTo(new ScaleTwoDecimal(77450)) == 0);
    }

}