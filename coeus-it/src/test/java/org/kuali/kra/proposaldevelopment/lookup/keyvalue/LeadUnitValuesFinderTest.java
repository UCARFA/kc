/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.proposaldevelopment.lookup.keyvalue;

import org.junit.Test;
import org.kuali.coeus.propdev.impl.basic.LeadUnitValuesFinder;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.keyvalue.ValuesFinderTestBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests LeadUnitValuesFinder.
 */
public class LeadUnitValuesFinderTest extends ValuesFinderTestBase {

    @Override
    protected Class<LeadUnitValuesFinder> getTestClass() {
        return LeadUnitValuesFinder.class;
    }

    @Override
    protected List<KeyValue> getKeyValues() {
        final List<KeyValue> keylabel = new ArrayList<KeyValue>();
        
        keylabel.add(ValuesFinderUtils.getSelectOption());
        keylabel.add(new ConcreteKeyValue("BL-IIDC", "BL-IIDC - IND INST ON DISABILITY/COMMNTY"));
        keylabel.add(new ConcreteKeyValue("IN-MDEP", "IN-MDEP - MEDICINE DEPT"));
        keylabel.add(new ConcreteKeyValue("IN-PED", "IN-PED - PEDIATRICS"));
        
        return keylabel;
    }
    
    @Override
    @Test
    public void testGetKeyValues() throws InstantiationException, IllegalAccessException {
    	UserSession previousUserSession = GlobalVariables.getUserSession();
    	GlobalVariables.setUserSession(new UserSession("woods"));
    	try {
    		super.testGetKeyValues();
    	} finally {
    		GlobalVariables.setUserSession(previousUserSession);
    	}
    }

}
