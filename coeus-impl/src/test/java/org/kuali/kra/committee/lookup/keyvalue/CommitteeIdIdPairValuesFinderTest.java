/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.lookup.keyvalue;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class CommitteeIdIdPairValuesFinderTest {

    private final String CMT_1_ID = "c1";
    private final String CMT_2_ID = "c2";
    private final String CMT_3_ID = "c3";
    private final String CMT_4_ID = "c4";
        
    @Test
    public void testGetKeyValues() {
        Committee committee1 = new Committee();
        committee1.setCommitteeId(this.CMT_1_ID);
        
        Committee committee2 = new Committee();
        committee2.setCommitteeId(this.CMT_2_ID);
        
        Committee committee3 = new Committee();
        committee3.setCommitteeId(this.CMT_3_ID);
        
        Committee committee4 = new Committee();
        committee4.setCommitteeId(this.CMT_4_ID);
        
        
        final List<CommitteeBase> activeCommittees = new ArrayList<CommitteeBase>();
        activeCommittees.add(committee1);
        activeCommittees.add(committee2);
        activeCommittees.add(committee3);
        activeCommittees.add(committee4);
        
        KeyValue klp0 = ValuesFinderUtils.getSelectOption();
        KeyValue klp1 = new ConcreteKeyValue(CMT_1_ID, CMT_1_ID);
        KeyValue klp2 = new ConcreteKeyValue(CMT_2_ID, CMT_2_ID);
        KeyValue klp3 = new ConcreteKeyValue(CMT_3_ID, CMT_3_ID);
        KeyValue klp4 = new ConcreteKeyValue(CMT_4_ID, CMT_4_ID);
       
        // create an anonymous instance of the finder overriding the
        // superclass's getActiveCommittees() method, with our mock
        CommitteeIdIdPairValuesFinder finder = new CommitteeIdIdPairValuesFinder(){
            @Override
            public List<CommitteeBase> getActiveCommittees() {
                return activeCommittees;
            }
        };
        List<KeyValue> results = finder.getKeyValues();
        
        Assert.assertEquals(5, results.size());
        Assert.assertTrue(results.contains(klp0));
        Assert.assertTrue(results.contains(klp1));
        Assert.assertTrue(results.contains(klp2));
        Assert.assertTrue(results.contains(klp3));
        Assert.assertTrue(results.contains(klp4));
        
    }

}
