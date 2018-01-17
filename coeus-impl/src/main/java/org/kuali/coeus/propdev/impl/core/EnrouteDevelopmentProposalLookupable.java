/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;
import org.kuali.rice.krad.lookup.LookupForm;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("enrouteDevelopmentProposalLookupable")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EnrouteDevelopmentProposalLookupable extends PropDevLookupableHelperServiceImpl {

	private static final long serialVersionUID = 1L;
	
     @SuppressWarnings("unchecked")
	@Override
    public List<?> performSearch(LookupForm form, Map<String, String> searchCriteria, boolean unbounded) {
    	
    	searchCriteria.put("proposalStateTypeCode", "2|5");
    	List<DevelopmentProposal> list = (List<DevelopmentProposal>) super.performSearch(form, searchCriteria, unbounded);
    	return list;
    }
    
    @Override
    public boolean validateSearchParameters(LookupForm form, Map<String,String> fieldValues) {
    	form.getViewPostMetadata().getLookupCriteria().put("proposalStateTypeCode", new HashMap<String, Object>());
        return super.validateSearchParameters(form, fieldValues);
       
    }
}
