/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

import org.kuali.rice.krms.api.engine.TermResolutionException;
import org.kuali.rice.krms.api.engine.TermResolver;
import org.kuali.rice.krms.api.repository.term.TermResolverDefinition;
import org.kuali.rice.krms.api.repository.term.TermSpecificationDefinition;
import org.kuali.rice.krms.framework.type.TermResolverTypeService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component("unitNumberTermResolverTypeService")
public class UnitNumberTermResolverTypeServiceImpl implements TermResolverTypeService {

    @Override
    public TermResolver<?> loadTermResolver(
            final TermResolverDefinition termResolverDefinition) {
        
            return new TermResolver<String>() {

                @Override
                public Set<String> getPrerequisites() {
                    HashSet<String> results = new HashSet<String>();

                    results.add("pdoc");
                    return results;
                }

                @Override
                public String getOutput() {
                    TermSpecificationDefinition def = termResolverDefinition.getOutput();
                    return def.getName();
                }

                @Override
                public Set<String> getParameterNames() {
                    return Collections.unmodifiableSet(termResolverDefinition.getParameterNames());
                }

                @Override
                public int getCost() {
                    return 1;
                }

                @Override
                public String resolve(
                        Map<String, Object> resolvedPrereqs,
                        Map<String, String> parameters)
                        throws TermResolutionException {
                    ProposalDevelopmentDocument pd = (ProposalDevelopmentDocument)resolvedPrereqs.get("pdoc");
                    return pd.getDevelopmentProposal().getUnitNumber();
                }
                
            };
   }

}
