/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.noo;

import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.keyvalue.ValuesFinderTestBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests NoticeOfOpportunityValuesFinder.
 */
public class NoticeOfOpportunityValuesFinderTest extends ValuesFinderTestBase {

    @Override
    protected Class<NoticeOfOpportunityValuesFinder> getTestClass() {
        return NoticeOfOpportunityValuesFinder.class;
    }

    @Override
    protected List<KeyValue> getKeyValues() {
        final List<KeyValue> keylabel = new ArrayList<KeyValue>();
        
        keylabel.add(ValuesFinderUtils.getSelectOption());
        keylabel.add(new ConcreteKeyValue("1", "Federal Solicitation"));
        keylabel.add(new ConcreteKeyValue("2", "Unsolicited"));
        keylabel.add(new ConcreteKeyValue("3", "Verbal Request for Proposal"));
        keylabel.add(new ConcreteKeyValue("4", "SBIR Solicitation"));
        keylabel.add(new ConcreteKeyValue("5", "STTR Solicitation"));
        keylabel.add(new ConcreteKeyValue("6", "Non-Federal Solicitation"));
        keylabel.add(new ConcreteKeyValue("7", "Internal"));

        return keylabel;
    }

}
