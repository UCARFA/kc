/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.custom;

import org.kuali.rice.krms.api.engine.TermResolver;
import org.kuali.rice.krms.api.repository.term.TermResolverDefinition;
import org.kuali.rice.krms.framework.type.TermResolverTypeService;

import java.util.Set;

public abstract class CustomDataResolverTypeServiceImpl  implements TermResolverTypeService {
    @Override
    public TermResolver<?> loadTermResolver(TermResolverDefinition termResolverDefinition) {
        Set<String> paramsSet = termResolverDefinition.getParameterNames();
        return new CustomDataResolver(termResolverDefinition.getOutput().getName(), paramsSet, getModuleNamePrereq());
    }

    protected abstract String getModuleNamePrereq();
}