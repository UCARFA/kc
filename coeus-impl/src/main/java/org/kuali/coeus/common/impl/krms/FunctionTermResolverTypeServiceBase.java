/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.krms;

import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krms.api.engine.TermResolver;
import org.kuali.rice.krms.api.repository.function.FunctionDefinition;
import org.kuali.rice.krms.api.repository.function.FunctionParameterDefinition;
import org.kuali.rice.krms.api.repository.function.FunctionRepositoryService;
import org.kuali.rice.krms.api.repository.term.TermResolverDefinition;
import org.kuali.rice.krms.framework.type.TermResolverTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 
 * This class implements <code>TermResolverTypeService</code> for resolving Stored Functions or Java Functions as Terms.
 */
public abstract class FunctionTermResolverTypeServiceBase implements TermResolverTypeService {

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("functionRepositoryService")
    private FunctionRepositoryService functionRepositoryService;

    public abstract FunctionTermResolver createFunctionResolver(List<String> orderedInputParams, Set<String> parameterNames, 
                                                                    String output, FunctionDefinition functionTerm);
    
    @Override
    public TermResolver<?> loadTermResolver(TermResolverDefinition termResolverDefinition) {
        String functionId = termResolverDefinition.getOutput().getName();
        FunctionDefinition functionTerm = functionRepositoryService.getFunction(functionId);
        if(functionTerm==null){
            throw new RuntimeException("Not able to find Term for function : "+functionId);
        }
        List<String> params = getFunctionParameters(functionTerm);
        Set<String> paramNames = termResolverDefinition.getParameterNames();
        return createFunctionResolver(params,paramNames,functionId,functionTerm);
    }
    private List<String> getFunctionParameters(FunctionDefinition functionTerm) {
        List<FunctionParameterDefinition> functionParams = functionTerm.getParameters();
        List<FunctionParameterDefinition> modifiableParams = new ArrayList<FunctionParameterDefinition>(functionParams);
        Collections.sort(modifiableParams, new FunctionParamComparator());
        List<String> params = new ArrayList<String>();
        for (FunctionParameterDefinition termResolverFunctionParamDefinition : modifiableParams) {
            params.add(termResolverFunctionParamDefinition.getName());
        }
        return params;
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public FunctionRepositoryService getFunctionRepositoryService() {
        return functionRepositoryService;
    }

    public void setFunctionRepositoryService(FunctionRepositoryService functionRepositoryService) {
        this.functionRepositoryService = functionRepositoryService;
    }
}
