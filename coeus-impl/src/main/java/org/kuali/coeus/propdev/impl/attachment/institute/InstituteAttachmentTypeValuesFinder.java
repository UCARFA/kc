/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment.institute;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentConstants;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.propdev.impl.attachment.NarrativeType;
import org.kuali.rice.core.api.criteria.PredicateFactory;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component("instituteAttachmentTypeValuesFinder")
public class InstituteAttachmentTypeValuesFinder  extends UifKeyValuesFinderBase {

    private static final String SYSTEM_GENERATED = "systemGenerated";

	private static final String NARRATIVE_TYPE_GROUP = "narrativeTypeGroup";

	@Autowired
    @Qualifier("parameterService")
    private  ParameterService parameterService;
    
    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Override
    public List<KeyValue> getKeyValues() {
        List<NarrativeType> narrativeTypes = getInstituteNarrativeTypes();
        if (shouldAttachmentListBeAlphabetized()) {
        	narrativeTypes.sort(Comparator.comparing(NarrativeType::getDescription, Comparator.nullsFirst(Comparator.naturalOrder())));
        }
        return narrativeTypes.stream().map(narrativeType -> {
        	return new ConcreteKeyValue(narrativeType.getCode(), narrativeType.getDescription());
        }).collect(Collectors.toList());
    }

	protected String getInstituteNarrativeTypeGroup() {
		return getParameterService().getParameterValueAsString(ProposalDevelopmentDocument.class, Constants.INSTITUTE_NARRATIVE_TYPE_GROUP);
	}

	protected Boolean shouldAttachmentListBeAlphabetized() {
		return getParameterService().getParameterValueAsBoolean(ProposalDevelopmentDocument.class, ProposalDevelopmentConstants.Parameters.ALPHABETIZE_ATTACHMENT_TYPES);
	}

	protected List<NarrativeType> getInstituteNarrativeTypes() {
		return getDataObjectService().findMatching(NarrativeType.class, 
        		QueryByCriteria.Builder.fromPredicates(PredicateFactory.equal(NARRATIVE_TYPE_GROUP, getInstituteNarrativeTypeGroup()),
        				PredicateFactory.equal(SYSTEM_GENERATED, false))).getResults();
	}

	public DataObjectService getDataObjectService() {
		if (dataObjectService == null) {
			dataObjectService = KcServiceLocator.getService(DataObjectService.class);
		}
		return dataObjectService;
	}

	public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}
	
    protected ParameterService getParameterService() {
    	if (parameterService == null) {
    		parameterService = KcServiceLocator.getService(ParameterService.class);
    	}
        return this.parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
}
