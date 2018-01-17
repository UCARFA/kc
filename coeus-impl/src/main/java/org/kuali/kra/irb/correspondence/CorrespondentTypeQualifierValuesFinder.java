/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class returns the qualifiers that CorrespondentType can have.
 */
public class CorrespondentTypeQualifierValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> KeyValues = new ArrayList<KeyValue>();

        KeyValues.add(ValuesFinderUtils.getSelectOption());
        for (CorrespondentTypeQualifierConstants correspondentTypeQualifierConstants : CorrespondentTypeQualifierConstants.values()) {
            KeyValues.add(new ConcreteKeyValue(correspondentTypeQualifierConstants.code(), correspondentTypeQualifierConstants.description()));
        }
        
        return KeyValues; 
    }

}
