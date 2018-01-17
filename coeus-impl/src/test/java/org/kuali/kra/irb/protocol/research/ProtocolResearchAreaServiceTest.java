/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.research;

import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ResearchArea;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ProtocolResearchAreaServiceTest {
    
    private ResearchArea bo1;
    private ResearchArea bo2;
    private ResearchArea bo3;
    private List<ResearchArea> listOfResearchArea;
    private Protocol protocol;
    private ProtocolResearchAreaService service;
    
    @Before
    public void setUp() throws Exception {
        bo1 = new ResearchArea();
        bo1.setResearchAreaCode("1");
        bo1.setDescription("Test1");
        
        bo2 = new ResearchArea();
        bo2.setResearchAreaCode("2");
        bo2.setDescription("Test2");
     
        listOfResearchArea = new ArrayList<ResearchArea>();
        listOfResearchArea.add(bo1);
        listOfResearchArea.add(bo2);
        
        protocol = new Protocol(){
            @Override
            public void refreshReferenceObject(String referenceObjectName) {}

            
        };
        protocol.setProtocolId(1L);
        
        service = new ProtocolResearchAreaServiceImpl();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testAddProtocolResearchArea() throws Exception {
                   
        service.addProtocolResearchArea(protocol, (List)listOfResearchArea);
        //Protocol must have 2 objects in ProtocolResearchArea
        assertEquals(2, protocol.getProtocolResearchAreas().size());
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testAddProtocolResearchAreaForDuplicate() throws Exception {
                   
        service.addProtocolResearchArea(protocol, (List)listOfResearchArea);
        //Protocol must have 2 objects in ProtocolResearchArea
        assertEquals(2, protocol.getProtocolResearchAreas().size());
        
        bo3 = new ResearchArea();
        bo3.setResearchAreaCode("3");
        bo3.setDescription("Test3");
        listOfResearchArea.add(bo3);
        
        //Duplicate insert test
        service.addProtocolResearchArea(protocol, (List)listOfResearchArea);
        //Size must be 3, only newer object is added to list
        assertEquals(3, protocol.getProtocolResearchAreas().size());
    }
    
}
