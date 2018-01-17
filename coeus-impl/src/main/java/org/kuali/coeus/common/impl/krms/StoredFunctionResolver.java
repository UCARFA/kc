/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.krms;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class is for resolving terms for StoredFuncions. It extract values from prerequisites, execute Stored Function 
 * and resolves the result.
 */
public class StoredFunctionResolver extends FunctionTermResolver {

    public StoredFunctionResolver(List<String> orderedInputParams, Set<String> parameterNames, String output) {
        super(orderedInputParams, parameterNames, output);
    }

    @Override
    protected String executeFunction(String packageName, String functionName, Map<String, Object> resolvedPrereqs, Map<String,String> resolvedParameters) {
        if(packageName!=null) {
            functionName = packageName+"."+functionName;
        }
        List<Object> orderedParamValues = extractParamValues(resolvedPrereqs,resolvedParameters);
        return callFunction(functionName,orderedParamValues);
    }
    
    private String callFunction(String functionName, List<Object> orderedParamValues) {
        StoredFunctionDao storedFunctionDao = getStoredFucntionDao();
        return storedFunctionDao.executeFunction(functionName, orderedParamValues);
    }
    private StoredFunctionDao getStoredFucntionDao() {
        return KcServiceLocator.getService(StoredFunctionDao.class);
    }
}
