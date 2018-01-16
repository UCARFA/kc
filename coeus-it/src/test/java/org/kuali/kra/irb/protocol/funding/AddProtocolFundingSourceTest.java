/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.funding;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.bo.FundingSourceType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.rules.TemplateRuleTest;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.ArrayList;
import java.util.List;

public class AddProtocolFundingSourceTest extends KcIntegrationTestBase {
    
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};

    private final String goodFundingSourceId = "000100";
    private final String goodFundingSourceName = "Air Force";
    private final String badFundingSourceId = "goober99";
    private final String badFundingSourceName = "";
    
    private ProtocolFundingSource fundingSource;
    private ProtocolFundingSource badFundingSource;
    private List<ProtocolFundingSource> protocolFundingSources;
    private List<ProtocolFundingSource> emptyProtocolFundingSources;
    private ProtocolDocument doc = null;

    
    /**
     * Create the mock services and insert them into the protocol auth service.
     * 
     * @see org.kuali.kra.KraTestBase#setUp()
     */
    @Before
    public void setUp() throws Exception {
        fundingSource = new ProtocolFundingSource(goodFundingSourceId, FundingSourceType.SPONSOR, goodFundingSourceName, "" );
        protocolFundingSources = new ArrayList<ProtocolFundingSource>();
        protocolFundingSources.add(fundingSource);
        
        emptyProtocolFundingSources = new ArrayList<ProtocolFundingSource>();
        
        badFundingSource = new ProtocolFundingSource(badFundingSourceId, FundingSourceType.SPONSOR, badFundingSourceName, "" );

    }  
    
    @Test
    public void testSimple() {    
        new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
            @Override
            protected void prerequisite() {        
                event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, fundingSource, emptyProtocolFundingSources);
                rule = new ProtocolFundingSourceRule();
                rule.setBusinessObjectService(null);
                rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                expectedReturnValue = true;
            }
        };
    }

    @Test
    public void testDuplicate() { 
        TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule>  theTest = 
            new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
                @Override
                protected void prerequisite() {        
                    event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, fundingSource, protocolFundingSources);
                    rule = new ProtocolFundingSourceRule();
                    rule.setBusinessObjectService(null);
                    rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                    expectedReturnValue = false;
                }                
                @Override
                public void checkRuleAssertions() {
                    Assert.assertTrue(getErrorMap().containsMessageKey(KeyConstants.ERROR_PROTOCOL_FUNDING_SOURCE_DUPLICATE));
                }
            };
            theTest.checkRuleAssertions();            
    }
    
    @Test
    public void testNullFundingSource() { 
        TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule>  theTest = 
            new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
                @Override
                protected void prerequisite() {        
                    event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, null, protocolFundingSources);
                    rule = new ProtocolFundingSourceRule();
                    rule.setBusinessObjectService(null);
                    rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                    expectedReturnValue = false;
                }                
                @Override
                public void checkRuleAssertions() {
                    Assert.assertTrue(getErrorMap().containsMessageKey(KeyConstants.ERROR_PROTOCOL_FUNDING_SOURCE_TYPE_NOT_FOUND));
                }
            };
            theTest.checkRuleAssertions();            
    }

    
    @Test
    public void testBlankNumberFundingSource() { 
        TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule>  theTest = 
            new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
                @Override
                protected void prerequisite() {        
                    fundingSource.setFundingSourceNumber("");
                    event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, fundingSource, protocolFundingSources);
                    rule = new ProtocolFundingSourceRule();
                    rule.setBusinessObjectService(null);
                    rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                    expectedReturnValue = false;
                }                
                @Override
                public void checkRuleAssertions() {
                    Assert.assertTrue(getErrorMap().containsMessageKey(KeyConstants.ERROR_PROTOCOL_FUNDING_SOURCE_NUMBER_NOT_FOUND));
                }
            };
            theTest.checkRuleAssertions();            
    }
    
    @Test
    public void testBlankNameFundingSource() { 
        TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule>  theTest = 
            new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
                @Override
                protected void prerequisite() {        
                    fundingSource.setFundingSourceName("");
                    event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, fundingSource, protocolFundingSources);
                    rule = new ProtocolFundingSourceRule();
                    rule.setBusinessObjectService(null);
                    rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                    expectedReturnValue = false;
                }                
                @Override
                public void checkRuleAssertions() {
                    Assert.assertTrue(getErrorMap().containsMessageKey(KeyConstants.ERROR_PROTOCOL_FUNDING_SOURCE_NAME_NOT_FOUND));
                }
            };
            theTest.checkRuleAssertions();            
    }

    @Test
    public void testBlankNameFundingSourceOther() { 
        TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule>  theTest = 
            new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
                @Override
                protected void prerequisite() {        
                    fundingSource.setFundingSourceName("");
                    fundingSource.setFundingSourceTypeCode(FundingSourceType.OTHER);
                    event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, fundingSource, protocolFundingSources);
                    rule = new ProtocolFundingSourceRule();
                    rule.setBusinessObjectService(null);
                    rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                    expectedReturnValue = false;
                }                
                @Override
                public void checkRuleAssertions() {
                    Assert.assertFalse(getErrorMap().containsMessageKey(KeyConstants.ERROR_PROTOCOL_FUNDING_SOURCE_NAME_NOT_FOUND));
                }
            };
            theTest.checkRuleAssertions();            
    }
    
    @Test
    public void testNullTypeFundingSource() { 
        TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule>  theTest = 
            new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
                @Override
                protected void prerequisite() {        
                    fundingSource.setFundingSourceTypeCode(null);
                    event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, fundingSource, protocolFundingSources);
                    rule = new ProtocolFundingSourceRule();
                    rule.setBusinessObjectService(null);
                    rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                    expectedReturnValue = false;
                }                
                @Override
                public void checkRuleAssertions() {
                    Assert.assertTrue(getErrorMap().containsMessageKey(KeyConstants.ERROR_PROTOCOL_FUNDING_SOURCE_TYPE_NOT_FOUND));
                }
            };
            theTest.checkRuleAssertions();            
    }
    
    @Test
    public void testInvalidNumberTypeFundingSource() { 
        TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule>  theTest = 
            new  TemplateRuleTest<AddProtocolFundingSourceEvent, ProtocolFundingSourceRule> (){            
                @Override
                protected void prerequisite() {        
                    event = new AddProtocolFundingSourceEvent(Constants.EMPTY_STRING, doc, badFundingSource, protocolFundingSources);
                    rule = new ProtocolFundingSourceRule();
                    rule.setBusinessObjectService(null);
                    rule.setProtocolFundingSourceService(getProtocolFundingSourceService());
                    expectedReturnValue = false;
                }                
                @Override
                public void checkRuleAssertions() {
                    Assert.assertTrue(getErrorMap().containsMessageKey(KeyConstants.ERROR_PROTOCOL_FUNDING_SOURCE_NUMBER_INVALID_FOR_TYPE));
                }
            };
            theTest.checkRuleAssertions();            
    }
    
    protected ProtocolFundingSourceService getProtocolFundingSourceService() {
        final ProtocolFundingSourceService protocolFundingSourceService = context.mock(ProtocolFundingSourceService.class);
        context.checking(new Expectations() {{
          allowing(protocolFundingSourceService).isValidIdForType(fundingSource); 
          will(returnValue(true));
          one(protocolFundingSourceService).isValidIdForType(badFundingSource); 
          will(returnValue(false));
          allowing(protocolFundingSourceService).isEditable(fundingSource.getFundingSourceTypeCode());
          will(returnValue(true));
        }});
        return protocolFundingSourceService;
    }
    
}
