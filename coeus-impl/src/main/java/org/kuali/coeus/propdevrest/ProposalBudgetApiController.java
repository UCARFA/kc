/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdevrest;

import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.propdevrest.Dto.ModularBudgetDto;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RequestMapping(value="/api/v1")
@RestController("proposalBudgetApiController")
public class ProposalBudgetApiController extends org.kuali.coeus.sys.framework.controller.rest.RestController {

    @Autowired
    @Qualifier("commonApiService")
    private CommonApiService commonApiService;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @GetMapping(value="/budgets/{id}/modular-budget/", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    ModularBudgetDto getBudgets(@PathVariable Long id) throws WorkflowException, InvocationTargetException, IllegalAccessException {
        Budget budget = dataObjectService.find(Budget.class, id);
        if (budget == null) {
            throw new ResourceNotFoundException("Budget with id " + id + " not found.");

        }
        return commonApiService.convertObject(budget, ModularBudgetDto.class);

    }


}
