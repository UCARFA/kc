/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.data.DataObjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("proposalPersonService")
public class ProposalPersonServiceImpl implements ProposalPersonService {
    
    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("kcPersonService")
    private KcPersonService kcPersonService;

    protected DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }

    public void setKcPersonService(KcPersonService kcPersonService) {
        this.kcPersonService = kcPersonService;
    }
    protected KcPersonService getKcPersonService(){
        return kcPersonService;
    }

    @Override
    public String getPersonName(ProposalDevelopmentDocument doc, String userId) {
        String propPersonName = null;
        List<ProposalPerson> proposalPersons = doc.getDevelopmentProposal().getProposalPersons();
        if(proposalPersons.isEmpty()) {
            proposalPersons = getProposalKeyPersonnel(doc.getDevelopmentProposal().getProposalNumber());
        }
        for (ProposalPerson proposalPerson : proposalPersons) {
            if(StringUtils.equals(proposalPerson.getPersonId(), userId)){
                propPersonName = proposalPerson.getFullName();
                break;
            }
        }
        if(StringUtils.isBlank(propPersonName)){
            KcPerson person = this.kcPersonService.getKcPersonByPersonId(userId);
            propPersonName = person.getFullName();
        }
        return propPersonName;
    }
    
    @Override
    public List<ProposalPerson> getProposalKeyPersonnel(String proposalNumber) {
        Map<String, String> keys = new HashMap<>();
        keys.put("developmentProposal.proposalNumber", proposalNumber);

        return dataObjectService.findMatching(ProposalPerson.class,
                QueryByCriteria.Builder.andAttributes(keys).build()).getResults();
    }

    /**
     * This method is to get list of ProposalPersons by matching partial name.
     * Wildcards work as well.
     */
    @Override
    public List<ProposalPerson> getProposalPersonsByPartialName(String partialName) {
        return getDataObjectService().findMatching(ProposalPerson.class, QueryByCriteria.Builder.fromPredicates(PredicateFactory.likeIgnoreCase("fullName", partialName))).getResults();
    }
}
