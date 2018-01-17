/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.lookup.keyvalue;

import org.junit.Test;
import org.kuali.coeus.common.framework.type.DeadlineType;
import org.kuali.kra.keyvalue.PersistableBusinessObjectValuesFinderTestBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.krad.keyvalues.PersistableBusinessObjectValuesFinder;

/**
 * This class tests DeadlineTypeValuesFinder.
 */
public class DeadlineTypeValuesFinderTest extends PersistableBusinessObjectValuesFinderTestBase{
    
    public DeadlineTypeValuesFinderTest() {
        setValuesFinderClass(PersistableBusinessObjectValuesFinder.class);
        setBusinessObjectClass(DeadlineType.class);
        setKeyAttributeName("deadlineTypeCode");
        setLabelAttributeName("description");
        setIncludeKeyInDescription(false);
    }

    @Override
    @Test public void testGetKeyValues() throws Exception {
        super.testGetKeyValues();
    }
    
    @Override
    protected void addKeyValues() {
        testKeyValues.add(new ConcreteKeyValue("P", "Postmark"));
        testKeyValues.add(new ConcreteKeyValue("R", "Receipt"));
        testKeyValues.add(new ConcreteKeyValue("T", "Target"));
    }
}
