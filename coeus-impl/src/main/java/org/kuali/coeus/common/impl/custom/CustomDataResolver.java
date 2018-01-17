/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.custom;

import com.google.common.base.Objects;
import org.kuali.coeus.common.framework.custom.CustomDataContainer;
import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.rice.krms.api.engine.TermResolutionException;
import org.kuali.rice.krms.api.engine.TermResolver;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomDataResolver implements TermResolver<Object> {
    public static final String CUSTOM_ATTRIBUTE_ID = "Custom Attribute Id";
    private String outputName;
    private Set<String> prereqs;
    private Set<String> params;

    private String moduleNamePreReq;

    public CustomDataResolver(String outputName, Set<String> params, String moduleNamePrereq) {
        this.outputName = outputName;
        this.prereqs = new HashSet<>();
        this.moduleNamePreReq = moduleNamePrereq;
        prereqs.add(moduleNamePrereq);
        if (params == null) {
            this.params = Collections.emptySet();
        } else {
            this.params = params;
        }
    }

    public String getModuleNamePreReq() {
        return moduleNamePreReq;
    }

    @Override
    public Set<String> getPrerequisites() {
        return prereqs;
    }

    @Override
    public String getOutput() {
        return outputName;
    }

    @Override
    public Set<String> getParameterNames() {
        return params;
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public Object resolve(Map<String, Object> resolvedPrereqs, Map<String, String> parameters) throws TermResolutionException {
        CustomDataContainer customDataContainer = (CustomDataContainer) resolvedPrereqs.get(getModuleNamePreReq());
        return customDataContainer.getCustomDataList().stream().
                                                            filter(
                                                                    customData -> Objects.equal(customData.getCustomAttributeId().toString(), parameters.get(CUSTOM_ATTRIBUTE_ID))
                                                            ).findFirst().map(DocumentCustomData::getValue).orElse(null);
    }
}
