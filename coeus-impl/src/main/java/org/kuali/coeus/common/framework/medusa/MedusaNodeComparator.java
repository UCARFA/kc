/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.medusa;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.kra.subaward.bo.SubAward;

import java.util.Comparator;


public class MedusaNodeComparator implements Comparator<MedusaNode> {

    @Override
    public int compare(MedusaNode m1, MedusaNode m2) {
        return getNodeValue(m1).compareTo(getNodeValue(m2));
    }   

    private String getNodeValue(MedusaNode m){             
        String nodeType = m.getType();  
        Object mBo = m.getBo();
        if(!StringUtils.isNotBlank(nodeType) || mBo == null){
            return "medusa: unknown medusa node type";
        } else {
            if(StringUtils.equals(nodeType, "award")){
                return nodeType + ((Award)mBo).getAwardNumber();
            }
            else if(StringUtils.equals(nodeType, "IP"))
                return nodeType + ((InstitutionalProposal)mBo).getProposalNumber();
            else if(StringUtils.equals(nodeType, "DP")) 
                return nodeType + ((DevelopmentProposal)mBo).getProposalNumber();    
            else if (StringUtils.equals(nodeType, "neg")) {
                return nodeType + ((Negotiation)mBo).getNegotiationId();
            } else if (StringUtils.equals(nodeType, "subaward")) {
                return nodeType + ((SubAward)mBo).getSubAwardId();
            } else
                return "medusa: unsupported medusa node type";
        }
    }
}
