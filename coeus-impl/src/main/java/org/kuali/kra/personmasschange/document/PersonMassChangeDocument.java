/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.document;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.personmasschange.bo.PersonMassChange;
import org.kuali.kra.personmasschange.service.PersonMassChangeService;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.framework.postprocessor.DocumentRouteStatusChange;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PersonMassChangeDocument extends KcTransactionalDocumentBase implements Serializable {

    public static final String DOCUMENT_TYPE_CODE = "PMC";
    
    private static final long serialVersionUID = 4841496352465715699L;


    private List<PersonMassChange> personMassChangeList;
    
    private transient PersonMassChangeService personMassChangeService;
    
    public PersonMassChangeDocument() {
        personMassChangeList = new ArrayList<PersonMassChange>();
        PersonMassChange newPersonMassChange = new PersonMassChange();
        newPersonMassChange.setPersonMassChangeDocument(this);
        personMassChangeList.add(newPersonMassChange);
    }
    
    @Override
    public String getDocumentTypeCode() {
        return DOCUMENT_TYPE_CODE;
    }

    public List<PersonMassChange> getPersonMassChangeList() {
        return personMassChangeList;
    }

    public void setPersonMassChangeList(List<PersonMassChange> personMassChangeList) {
        this.personMassChangeList = personMassChangeList;
    }

    public PersonMassChange getPersonMassChange() {
        return personMassChangeList.isEmpty() ? null : personMassChangeList.get(0);
    }

    public void setPersonMassChange(PersonMassChange personMassChange) {
        personMassChangeList.set(0, personMassChange);
    }
    
    @Override
    public void doRouteStatusChange(DocumentRouteStatusChange statusChangeEvent) {
        executeAsLastActionUser(() -> {
            super.doRouteStatusChange(statusChangeEvent);

            if (isFinal(statusChangeEvent)) {
                getPersonMassChangeService().performPersonMassChange(getPersonMassChange());
            }
            return null;
        });
    }
    
    private boolean isFinal(DocumentRouteStatusChange statusChangeEvent) {
        return StringUtils.equals(KewApiConstants.ROUTE_HEADER_FINAL_CD, statusChangeEvent.getNewRouteStatus());
    }
    
    @Override
    public boolean isProcessComplete() {
        boolean isComplete = false;
        
        if (getDocumentHeader().hasWorkflowDocument()) {
            if ( getDocumentHeader().getWorkflowDocument().isFinal()) {
                isComplete = true;
            }
        }
           
        return isComplete;
    }
    
    public PersonMassChangeService getPersonMassChangeService() {
        if (personMassChangeService == null) {
            personMassChangeService = KcServiceLocator.getService(PersonMassChangeService.class);
        }
        return personMassChangeService;
    }
    
    public void setPersonMassChangeService(PersonMassChangeService personMassChangeService) {
        this.personMassChangeService = personMassChangeService;
    }

    @Override
    public List<? extends DocumentCustomData> getDocumentCustomData() {
        return new ArrayList();
    }

    @Override
    public String getDocumentBoNumber() {
        return getPersonMassChange().getPersonMassChangeId()+"";
    }
    
}
