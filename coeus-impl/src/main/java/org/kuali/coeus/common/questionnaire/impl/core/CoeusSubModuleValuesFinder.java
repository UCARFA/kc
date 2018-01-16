/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl.core;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.*;

public class CoeusSubModuleValuesFinder extends UifKeyValuesFinderBase {
    List<KeyValue> subModuleCodes = null;
    private String moduleCode;
    @Override
    public List<KeyValue> getKeyValues() {

        if (subModuleCodes == null) {
            List<KeyValue> labels = new ArrayList<KeyValue>();
            labels.add(new ConcreteKeyValue("0", "select"));
            if (StringUtils.isNotBlank(moduleCode)) {
                KeyValuesService boService = KNSServiceLocator.getKeyValuesService();
                Map<String, Object> fieldValues = new HashMap<String, Object>();
                fieldValues.put("moduleCode", moduleCode);
                Collection<CoeusSubModule> codes = (Collection<CoeusSubModule>) boService.findMatching(CoeusSubModule.class,
                        fieldValues);
                for (CoeusSubModule coeusSubModule : codes) {
                    labels.add(new ConcreteKeyValue(coeusSubModule.getSubModuleCode(), coeusSubModule.getDescription()));
                }
            }
            subModuleCodes = labels;
        }
        return subModuleCodes;
    }

    public String getModuleCode() {
        return moduleCode;
    }
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }


}



