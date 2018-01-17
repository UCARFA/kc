/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.multicampus.MultiCampusConstants;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kim.impl.identity.PersonImpl;
import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.kuali.rice.kns.web.ui.Field;
import org.kuali.rice.kns.web.ui.Row;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("kcPersonLookupableHelperServiceKNS")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class KcPersonLookupableHelperServiceKNSImpl extends KualiLookupableHelperServiceImpl {
    
    private static final long serialVersionUID = 1L;
    
    private static final String CAMPUS_CODE_FIELD = "code";
    private static final String PERSON_CAMPUS_CODE_FIELD = "campusCode";
    private static final String CAMPUS_LOOKUPABLE_CLASS_NAME = "org.kuali.rice.location.impl.campus.CampusBo";
    
    @Autowired
    @Qualifier("kcPersonService")
    private KcPersonService kcPersonService;
    
    @Override
    public List<Row> getRows() {
        List<Row> rows = super.getRows();
        
        boolean multiCampusEnabled = getParameterService().getParameterValueAsBoolean(
            Constants.KC_GENERIC_PARAMETER_NAMESPACE, Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, MultiCampusConstants.PARAMETER_MULTI_CAMPUS_ENABLED);
        
        for (Row row : rows) {
            for (Field field : row.getFields()) {
                if (field.getPropertyName().equals(PERSON_CAMPUS_CODE_FIELD)) {
                    field.setFieldConversions(CAMPUS_CODE_FIELD + Constants.COLON + field.getPropertyName());
                    field.setLookupParameters(field.getPropertyName() + Constants.COLON + CAMPUS_CODE_FIELD);
                    field.setInquiryParameters(field.getPropertyName() + Constants.COLON + CAMPUS_CODE_FIELD);
                    field.setQuickFinderClassNameImpl(CAMPUS_LOOKUPABLE_CLASS_NAME);
                    field.setFieldDirectInquiryEnabled(true);
                    if (multiCampusEnabled) {
                        if (StringUtils.isBlank(field.getDefaultValue())) {
                            String campusCode = (String) GlobalVariables.getUserSession().retrieveObject(MultiCampusConstants.USER_CAMPUS_CODE_KEY);
                            field.setDefaultValue(campusCode);
                            field.setPropertyValue(field.getDefaultValue());
                        }
                    }
                }
            }
        }
        
        return rows;
    }

    @Override
    public List<KcPerson> getSearchResults(Map<String, String> fieldValues) {
        this.kcPersonService.modifyFieldValues(fieldValues);
        this.businessObjectClass = PersonImpl.class;
        List<Person> personResults = (List<Person>) super.getSearchResults(fieldValues);
        this.businessObjectClass = KcPerson.class;
        return this.kcPersonService.createKcPersonsFromPeople(personResults); 
    }

    public void setKcPersonService(KcPersonService kcPersonService) {
        this.kcPersonService = kcPersonService;
    }

	protected KcPersonService getKcPersonService() {
		return kcPersonService;
	}
    
}
