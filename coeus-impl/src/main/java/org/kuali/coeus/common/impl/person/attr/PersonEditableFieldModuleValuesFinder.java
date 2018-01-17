/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person.attr;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PersonEditableFieldModuleValuesFinder extends UifKeyValuesFinderBase {
    List<KeyValue> moduleCodes = null;

    @Override
    public List<KeyValue> getKeyValues() {
        List<String> validCodes = Arrays.asList(new String[] {CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE, CoeusModule.IRB_MODULE_CODE});
        if (moduleCodes == null) {
            KeyValuesService boService = KNSServiceLocator.getKeyValuesService();
            Collection<CoeusModule> codes = (Collection<CoeusModule>) boService.findAll(CoeusModule.class);
            List<KeyValue> labels = new ArrayList<KeyValue>();
            labels.add(ValuesFinderUtils.getSelectOption());
            for (CoeusModule coeusModule : codes) {
                if (validCodes.contains(coeusModule.getModuleCode())) {
                    labels.add(new ConcreteKeyValue(coeusModule.getModuleCode(), coeusModule.getDescription()));
                }
            }

            moduleCodes = labels;
        }
        return moduleCodes;
    }


}
