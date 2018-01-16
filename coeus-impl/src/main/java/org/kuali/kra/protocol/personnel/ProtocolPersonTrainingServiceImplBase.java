/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.attr.PersonTraining;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class ProtocolPersonTrainingServiceImplBase implements ProtocolPersonTrainingService {
    
    private static final String PERSON_ID_FIELD = "personId";
    private static final String ACTIVE_FLAG_FIELD = "active";
    private static final String FOLLOWUP_DATE_FIELD = "followupDate";
    private static final String IS_ACTIVE_VALUE = "Y";
    private BusinessObjectService businessObjectService;
    private DateTimeService dateTimeService;
    
    
    @Override
    public void updatePersonTrained(List<ProtocolPersonBase> protocolPersons) {
        for(ProtocolPersonBase protocolPerson : protocolPersons) {
            setTrainedFlag(protocolPerson);
        }
    }
    
    @Override
    public void setTrainedFlag(ProtocolPersonBase protocolPerson) {
        protocolPerson.setTrained(isTrained(protocolPerson.getPersonId()));
    }
    
    /**
     * This method verifies that the person is trained.
     * @param personId
     * @return true if the person is trained, false otherwise.
     */
    @SuppressWarnings("unchecked")
    private boolean isTrained(String personId) {
        if (StringUtils.isNotEmpty(personId)) {
            Map<String, Object> matchingKeys = new HashMap<String, Object>();
            matchingKeys.put(PERSON_ID_FIELD, personId);
            matchingKeys.put(ACTIVE_FLAG_FIELD, IS_ACTIVE_VALUE);
            Collection<PersonTraining> personTrainings = getBusinessObjectService().findMatchingOrderBy(PersonTraining.class, matchingKeys, FOLLOWUP_DATE_FIELD, false);
            for (PersonTraining personTraining : personTrainings) {
                if (personTraining.getFollowupDate() == null ||
                    getDateTimeService().getCurrentDate().before(personTraining.getFollowupDate())) {
                    return true;
                }
            }
        }
        return false;        
    }
    
    /**
     * Gets the businessObjectService attribute.
     * 
     * @return Returns the businessObjectService.
     */
    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    /**
     * Sets the businessObjectService attribute value.
     * 
     * @param businessObjectService The businessObjectService to set.
     */
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    /**
     * Gets the dateTimeService attribute.
     * 
     * @return Returns the dateTimeService.
     */
    public DateTimeService getDateTimeService() {
        return dateTimeService;
    }

    /**
     * Sets the dateTimeService attribute value.
     * 
     * @param dateTimeService The dateTimeService to set.
     */
    public void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }
    
}
