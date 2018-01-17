/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.kuali.coeus.common.committee.impl.meeting.MinuteEntryTypeValuesFinder;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.keyvalue.ValuesFinderTestBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class MinuteEntryTypeValuesFinderTest extends ValuesFinderTestBase {

    @Override
    protected Class<MinuteEntryTypeValuesFinder> getTestClass() {
        return MinuteEntryTypeValuesFinder.class;
    }

    @Override
    protected List<KeyValue> getKeyValues() {
        final List<KeyValue> keylabel = new ArrayList<KeyValue>();
        
        // if permission changed, this needs to be adjusted too.
        keylabel.add(ValuesFinderUtils.getSelectOption());
        keylabel.add(new ConcreteKeyValue("1", "General Comments"));
        keylabel.add(new ConcreteKeyValue("2", "Attendance"));
        keylabel.add(new ConcreteKeyValue("3", "Protocol"));
        keylabel.add(new ConcreteKeyValue("4", "Other Business"));
        keylabel.add(new ConcreteKeyValue("5", "Adverse Events"));
        
        return keylabel;
    }
}


