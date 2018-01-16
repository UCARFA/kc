/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.protocol.funding;

import org.junit.Test;
import org.kuali.coeus.sys.impl.validation.ErrorReporterImpl;
import org.kuali.kra.bo.FundingSourceType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.ProtocolEventBase;
import org.kuali.kra.rules.TemplateRuleTest;

public class LookupProtocolFundingSourceRuleTest {
    
    
    
    @Test
    public void testAward() {    
        new  TemplateRuleTest<LookupProtocolFundingSourceEvent, LookupProtocolFundingSourceRule> (){            
            @Override
            protected void prerequisite() {            
                event = new LookupProtocolFundingSourceEvent(Constants.EMPTY_STRING, null, FundingSourceType.AWARD, 
                        ProtocolEventBase.ErrorType.HARDERROR );
                rule = new LookupProtocolFundingSourceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
    
    @Test
    public void testPropDev() {    
        new  TemplateRuleTest<LookupProtocolFundingSourceEvent, LookupProtocolFundingSourceRule> (){            
            @Override
            protected void prerequisite() {            
                event = new LookupProtocolFundingSourceEvent(Constants.EMPTY_STRING, null, FundingSourceType.PROPOSAL_DEVELOPMENT, 
                        ProtocolEventBase.ErrorType.HARDERROR );
                rule = new LookupProtocolFundingSourceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
    @Test
    public void testUnit() {    
        new  TemplateRuleTest<LookupProtocolFundingSourceEvent, LookupProtocolFundingSourceRule> (){            
            @Override
            protected void prerequisite() {            
                event = new LookupProtocolFundingSourceEvent(Constants.EMPTY_STRING, null, FundingSourceType.UNIT, 
                        ProtocolEventBase.ErrorType.HARDERROR );
                rule = new LookupProtocolFundingSourceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
    @Test
    public void testOther() {    
        new  TemplateRuleTest<LookupProtocolFundingSourceEvent, LookupProtocolFundingSourceRule> (){            
            @Override
            protected void prerequisite() {            
                event = new LookupProtocolFundingSourceEvent(Constants.EMPTY_STRING, null, FundingSourceType.OTHER, 
                        ProtocolEventBase.ErrorType.HARDERROR );
                rule = new LookupProtocolFundingSourceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = false;
            }
        };
    }
    @Test
    public void testSponsor() {    
        new  TemplateRuleTest<LookupProtocolFundingSourceEvent, LookupProtocolFundingSourceRule> (){            
            @Override
            protected void prerequisite() {            
                event = new LookupProtocolFundingSourceEvent(Constants.EMPTY_STRING, null, FundingSourceType.SPONSOR, 
                        ProtocolEventBase.ErrorType.HARDERROR );
                rule = new LookupProtocolFundingSourceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
    @Test
    public void  testInstProp() {    
        new  TemplateRuleTest<LookupProtocolFundingSourceEvent, LookupProtocolFundingSourceRule> (){            
            @Override
            protected void prerequisite() {            
                event = new LookupProtocolFundingSourceEvent(Constants.EMPTY_STRING, null, FundingSourceType.INSTITUTIONAL_PROPOSAL, 
                        ProtocolEventBase.ErrorType.HARDERROR );
                rule = new LookupProtocolFundingSourceRule();
                rule.setErrorReporter(new ErrorReporterImpl());
                expectedReturnValue = true;
            }
        };
    }
    

}
