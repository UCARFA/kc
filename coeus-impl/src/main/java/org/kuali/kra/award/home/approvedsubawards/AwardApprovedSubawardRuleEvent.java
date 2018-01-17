/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.approvedsubawards;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.rice.krad.rules.rule.BusinessRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AwardApprovedSubawardRuleEvent extends KcDocumentEventBase {
    
    private AwardApprovedSubaward awardApprovedSubaward;
    private List<AwardApprovedSubaward> awardApprovedSubawards;
    


    public AwardApprovedSubawardRuleEvent(String errorPathPrefix, 
                                           AwardDocument awardDocument,
                                           AwardApprovedSubaward awardApprovedSubaward,
                                           List<AwardApprovedSubaward> awardApprovedSubawards) {
        super("ApprovedSubaward", errorPathPrefix, awardDocument);
        this.awardApprovedSubaward = awardApprovedSubaward;
        this.awardApprovedSubawards = new ArrayList<>(awardApprovedSubawards);
    }
    

    public AwardDocument getAwardDocument() {
        return (AwardDocument) getDocument();
    }
    

    public AwardApprovedSubaward getApprovedSubaward() {
        return awardApprovedSubaward;
    }
    
    
    class SubAwardComparator implements Comparator
    {    
        @Override
        public int compare(Object kv1, Object kv2 )
        {    
            try
            {
                String orgName1 = ((AwardApprovedSubaward)kv1).getOrganizationName();
                String orgName2 = ((AwardApprovedSubaward)kv2).getOrganizationName();
                if (orgName1 == null)
                {
                    orgName1 = "";
                }
                if (orgName2 == null)
                {
                    orgName2 = "";
                }
                return orgName1.compareTo(orgName2);  
            }
            catch (Exception e)
            {
                return 0;
            }
        }
        
    }

    public List<AwardApprovedSubaward> getAwardApprovedSubawards() {
        
        Collections.sort(awardApprovedSubawards, new SubAwardComparator());
        return awardApprovedSubawards;
    }

    
    @Override
    protected void logEvent() {


    }

    @Override
    public Class getRuleInterfaceClass() {

        return null;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {

        return false;
    }

}
