/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.custom.attr;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * This is for Custom Attribute document types.
 */
public class CustomAttributeValuesFinder extends UifKeyValuesFinderBase {
    private List<KeyValue> documentTypeParams;

    private static final String EQUAL_CHAR = "=";

    @Override
    public List<KeyValue> getKeyValues() {
        if (documentTypeParams == null) {
            Collection<String> validTypes = KcServiceLocator.getService(ParameterService.class).getParameterValuesAsString(Constants.KC_GENERIC_PARAMETER_NAMESPACE,
                    Constants.CUSTOM_ATTRIBUTE_DOCUMENT_DETAIL_TYPE_CODE, Constants.CUSTOM_ATTRIBUTE_DOCUMENT_PARAM_NAME);
            List<KeyValue> newList = new ArrayList<KeyValue>();
            newList.add(ValuesFinderUtils.getSelectOption());
            for (String documentType : validTypes) {
                String[] params = documentType.split(EQUAL_CHAR);
                newList.add(new ConcreteKeyValue(params[0].replace(" ", "+"), params[1]));
            }
            documentTypeParams = newList;
        }
        return documentTypeParams;
    }

}
