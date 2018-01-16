/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.participant;

import org.junit.Before;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.keyvalue.ValuesFinderTestBase;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Test the Participant Type Values Finder.
 *
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class ParticipantTypeValuesFinderTest extends ValuesFinderTestBase {
    @Before
    public void setUp() throws Exception {
        GlobalVariables.clear();
        GlobalVariables.clear();
    }
    
    @Override
    protected Class<ParticipantTypeValuesFinder> getTestClass() {
        return ParticipantTypeValuesFinder.class;
    }
    
    @Override
    protected ParticipantTypeValuesFinder getKeyValuesFinder() {
    	return new ParticipantTypeValuesFinder() {
    	    @Override
            protected Document getDocument() {
    	    	ProtocolDocument doc = new ProtocolDocument();
    	    	doc.setProtocol(new Protocol());
    	    	return doc;
    	    }
    	};
    }

    @Override
    protected List<KeyValue> getKeyValues() {
        final List<KeyValue> keylabel = new ArrayList<KeyValue>();
        
        keylabel.add(createKeyValue("", "select"));
        keylabel.add(createKeyValue("1", "Children"));
        keylabel.add(createKeyValue("2", "Decisionally impaired"));
        keylabel.add(createKeyValue("3", "Employees"));
        keylabel.add(createKeyValue("4", "Prisoners"));
        keylabel.add(createKeyValue("5", "Pregnant women"));
        keylabel.add(createKeyValue("6", "Fetuses"));
        keylabel.add(createKeyValue("7", "Students"));
        keylabel.add(createKeyValue("8", "Students - minors"));
        keylabel.add(createKeyValue("9", "Wards of the state"));
        keylabel.add(createKeyValue("10", "Other"));
        
        return keylabel;
    }
}
