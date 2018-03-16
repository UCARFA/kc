/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdevrest;

import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.common.budget.framework.calculator.BudgetCalculationService;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.propdev.impl.budget.modular.BudgetModularService;
import org.kuali.coeus.propdevrest.Dto.ModularBudgetDto;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestMapping(value="/api/v1")
@RestController("proposalBudgetApiController")
public class ProposalBudgetApiController extends org.kuali.coeus.sys.framework.controller.rest.RestController {

    private static final String CONSORTIUM_FNA_COST_ELEMENTS = "consortiumFnaCostElements";
    private static final String SUBCONTRACTOR_FNA_UNDER_25K_COST_ELEMENT = "subcontractorFnaUnder25kCostElement";
    private static final String SUBCONTRACTOR_FNA_OVER_25K_COST_ELEMENT = "subcontractorFnaOver25kCostElement";
    private static final String FNA_RATE_CLASS_TYPE_CODE = "fnaRateClassTypeCode";
    private static final String ROUND_FNA_BASE = "roundFnaBase";

    @Autowired
    @Qualifier("budgetCalculationService")
    private BudgetCalculationService budgetCalculationService;

    @Autowired
    @Qualifier("budgetModularService")
    private BudgetModularService budgetModularService;

    @Autowired
    @Qualifier("commonApiService")
    private CommonApiService commonApiService;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @GetMapping(value = "/budgets/{id}/modular-budget/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModularBudgetDto> getBudgets(@PathVariable Long id, @RequestParam(name = "lastUpdated", required = false) Long lastUpdated) {
        Budget budget = dataObjectService.find(Budget.class, id);
        if (budget == null) {
            throw new ResourceNotFoundException("Budget with id " + id + " not found.");
        }

        Optional<LocalDateTime> lastFetched = Optional.ofNullable(lastUpdated)
                .map(time -> LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));

        if (!lastFetched.isPresent() || budget.getUpdateTimestamp().toLocalDateTime().isAfter(lastFetched.get())) {
            budgetCalculationService.calculateBudget(budget);
            return ResponseEntity.ok(commonApiService.convertObject(budget, ModularBudgetDto.class));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/budgets/modular-budget/config", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Map<String, Object> getBudgetConfiguration() {
        Map<String, Object> config = new HashMap<>();
        config.put(CONSORTIUM_FNA_COST_ELEMENTS, budgetModularService.getConsortiumFnaOnlyCostElements());
        config.put(SUBCONTRACTOR_FNA_UNDER_25K_COST_ELEMENT, budgetModularService.getCostelementSubconFandAUnder25K());
        config.put(SUBCONTRACTOR_FNA_OVER_25K_COST_ELEMENT, budgetModularService.getCostelementSubconFandAOver25K());
        config.put(FNA_RATE_CLASS_TYPE_CODE, budgetModularService.getFnaRateClassType());
        config.put(ROUND_FNA_BASE, budgetModularService.roundFandAbase());
        return config;
    }

}
