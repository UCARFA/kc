/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person;

import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kns.inquiry.KualiInquirableImpl;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.Map;

/**
 * This class is used to perform an inquiry on a KC Person.
 */
public class KcPersonInquirableImpl extends KualiInquirableImpl {
    
    private KcPersonService kcPersonService;
    
    @Override
    public BusinessObject getBusinessObject(@SuppressWarnings("unchecked") Map fieldValues) {
        final String personId = (String) fieldValues.get("personId");
        
        return personId != null ? this.getKcPersonService().getKcPersonByPersonId(personId) : null;
    }
    
    /**
     * Gets the Kc Person Service.
     * <p>
     * Currently the inquiry definition in the DD does not allow you to specify a SpringBean therefore
     * injection cannot be used for the KcPersonService.
     * </p>
     * @return the Kc person Service.
     */
    protected KcPersonService getKcPersonService() {
        if (this.kcPersonService == null) {
            this.kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        }
        return this.kcPersonService;
    }
}
