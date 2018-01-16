/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.krms;

import org.kuali.rice.krms.api.repository.function.FunctionDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * This class is used for calling appropriate Stored Function Resolver from KRMS Type Service
 */
@Component("storedFunctionTermResolverTypeService")
public class StoredFunctionTermResolverTypeServiceImpl extends FunctionTermResolverTypeServiceBase {

    @Override
    public FunctionTermResolver createFunctionResolver(List<String> functionParams, Set<String> termResolverParams, String output, FunctionDefinition functionTerm) {
        FunctionTermResolver functionResolver = new StoredFunctionResolver(functionParams,termResolverParams,output);
        return functionResolver;
    }

}
