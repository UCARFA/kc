/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * Defines the fields for a Protocol Person Mass Change.
 */
public class ProtocolPersonMassChange extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -1385372093731302793L;
    
    private long protocolPersonMassChangeId;
    private long personMassChangeId;
    private boolean investigator;
    private boolean keyStudyPerson;
    private boolean correspondents;
    private boolean reviewer;
    
    private PersonMassChange personMassChange;

    public long getProtocolPersonMassChangeId() {
        return protocolPersonMassChangeId;
    }

    public void setProtocolPersonMassChangeId(long protocolPersonMassChangeId) {
        this.protocolPersonMassChangeId = protocolPersonMassChangeId;
    }

    public long getPersonMassChangeId() {
        return personMassChangeId;
    }

    public void setPersonMassChangeId(long personMassChangeId) {
        this.personMassChangeId = personMassChangeId;
    }

    public boolean isInvestigator() {
        return investigator;
    }
    
    public void setInvestigator(boolean investigator) {
        this.investigator = investigator;
    }
    
    public boolean isKeyStudyPerson() {
        return keyStudyPerson;
    }
    
    public void setKeyStudyPerson(boolean keyStudyPerson) {
        this.keyStudyPerson = keyStudyPerson;
    }
    
    public boolean isCorrespondents() {
        return correspondents;
    }
    
    public void setCorrespondents(boolean correspondents) {
        this.correspondents = correspondents;
    }
    
    public boolean isReviewer() {
        return reviewer;
    }
    
    public void setReviewer(boolean reviewer) {
        this.reviewer = reviewer;
    }
    
    public PersonMassChange getPersonMassChange() {
        return personMassChange;
    }

    public void setPersonMassChange(PersonMassChange personMassChange) {
        this.personMassChange = personMassChange;
    }
    
    /**
     * Determines whether this Person Mass Change is required.
     * 
     * @return true if any of the fields are true, false otherwise
     */
    public boolean requiresChange() {
        return investigator || keyStudyPerson || correspondents || reviewer;
    }

}
