/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.lookup.keyvalue;

import org.kuali.coeus.propdev.impl.attachment.NarrativeStatusValuesFinder;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.keyvalue.ValuesFinderTestBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class NarrativeStatusValuesFinderTest extends ValuesFinderTestBase {

    @Override
    protected Class<NarrativeStatusValuesFinder> getTestClass() {
        return NarrativeStatusValuesFinder.class;
    }

    @Override
    protected List<KeyValue> getKeyValues() {
        final List<KeyValue> keylabel = new ArrayList<KeyValue>();
        
        keylabel.add(ValuesFinderUtils.getSelectOption());
        keylabel.add(new ConcreteKeyValue("I","Incomplete"));
        keylabel.add(new ConcreteKeyValue("C","Complete"));
        
        return keylabel;
    }

}
