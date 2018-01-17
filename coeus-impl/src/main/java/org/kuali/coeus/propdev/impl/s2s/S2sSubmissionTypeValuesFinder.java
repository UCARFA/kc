/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class S2sSubmissionTypeValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        KeyValuesService keyValuesService = (KeyValuesService) KcServiceLocator.getService("keyValuesService");
        Collection S2SSubmissionTypes = keyValuesService.findAllOrderBy(S2sSubmissionType.class,"sortId",true);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        
        for (Iterator iter = S2SSubmissionTypes.iterator(); iter.hasNext();) {
            S2sSubmissionType s2sSubmissionType = (S2sSubmissionType) iter.next();
            keyValues.add(new ConcreteKeyValue(s2sSubmissionType.getCode(), s2sSubmissionType.getDescription()));
        }       
        return keyValues;
    }
    
}
