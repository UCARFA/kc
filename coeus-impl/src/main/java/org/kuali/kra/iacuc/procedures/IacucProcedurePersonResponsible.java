/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.procedures;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.iacuc.IacucPersonTraining;
import org.kuali.kra.iacuc.personnel.IacucProtocolPerson;

import java.util.ArrayList;
import java.util.List;

public class IacucProcedurePersonResponsible extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer iacucProcedurePersonResponsibleId; 
    private Integer iacucProtocolStudyGroupId; 
    private Integer protocolPersonId;
    
    private IacucProtocolPerson protocolPerson;
    private List<String> trainingDetails;
    
    private IacucProtocolStudyGroup iacucProtocolStudyGroup; 

    public IacucProcedurePersonResponsible() { 
    } 
    
    public Integer getIacucProcedurePersonResponsibleId() {
        return iacucProcedurePersonResponsibleId;
    }

    public void setIacucProcedurePersonResponsibleId(Integer iacucProcedurePersonResponsibleId) {
        this.iacucProcedurePersonResponsibleId = iacucProcedurePersonResponsibleId;
    }

    public String getPersonId() {
        return getProtocolPerson().getPersonId();
    }

    public void resetPersistenceState() {
        this.setIacucProcedurePersonResponsibleId(null);        
    }

    public String getTrainingDetailsString() {
        String details = new String();
        boolean first = true;
        for(String detail: getTrainingDetails()) {
            if (!first) {
                details += "<br/>";
            }
            details += detail;
            first = false;
        }
        return details;
    }
    
    public List<String> getTrainingDetails() {
        this.trainingDetails = new ArrayList<String>();
        List<IacucPersonTraining> iacucPersonTrainings = getProtocolPerson().getIacucPersonTrainings();
        if (iacucPersonTrainings != null) {
            for(IacucPersonTraining iacucPersonTraining : iacucPersonTrainings) {
                StringBuffer trainingInfo = new StringBuffer();
                trainingInfo.append("Training : " + iacucPersonTraining.getPersonTraining().getTraining().getDescription());
                trainingInfo.append("\r\nSpecies : " + iacucPersonTraining.getIacucSpecies().getSpeciesName());
                trainingInfo.append("\r\nProcedure : " + iacucPersonTraining.getIacucProcedure().getProcedureDescription());
                trainingInfo.append("\r\n");
                this.trainingDetails.add(trainingInfo.toString());
            }
        }
        return trainingDetails;
    }

    public String getPersonResponsibleDescription() {
        return getProtocolPerson().getProcedureQualificationDescription();
    }

    public String getPersonName() {
        return getProtocolPerson().getPersonName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        IacucProcedurePersonResponsible other = (IacucProcedurePersonResponsible) obj;
        if (this.iacucProcedurePersonResponsibleId == null) {
            if (other.iacucProcedurePersonResponsibleId != null) {
                return false;
            }
        } else if (!this.iacucProcedurePersonResponsibleId.equals(other.iacucProcedurePersonResponsibleId)) {
            return false;
        }
        if (this.iacucProtocolStudyGroupId == null) {
            if (other.iacucProtocolStudyGroupId != null) {
                return false;
            }
        } else if (!this.iacucProtocolStudyGroupId.equals(other.iacucProtocolStudyGroupId)) {
            return false;
        }
        if (this.protocolPersonId == null) {
            if (other.protocolPersonId != null) {
                return false;
            }
        } else if (!this.protocolPersonId.equals(other.protocolPersonId)) {
            return false;
        }
        return true;
    }

    public Integer getProtocolPersonId() {
        return protocolPersonId;
    }

    public void setProtocolPersonId(Integer protocolPersonId) {
        this.protocolPersonId = protocolPersonId;
    }

    public IacucProtocolPerson getProtocolPerson() {
        if (this.protocolPerson == null) {
            refreshReferenceObject("protocolPerson");
        }
        return protocolPerson;
    }

    public void setProtocolPerson(IacucProtocolPerson protocolPerson) {
        this.protocolPerson = protocolPerson;
    }

    public Integer getIacucProtocolStudyGroupId() {
        return iacucProtocolStudyGroupId;
    }

    public void setIacucProtocolStudyGroupId(Integer iacucProtocolStudyGroupId) {
        this.iacucProtocolStudyGroupId = iacucProtocolStudyGroupId;
    }

    public IacucProtocolStudyGroup getIacucProtocolStudyGroup() {
        if (iacucProtocolStudyGroup == null) {
            refreshReferenceObject("iacucProtocolStudyGroup");
        }
        return iacucProtocolStudyGroup;
    }

    public void setIacucProtocolStudyGroup(IacucProtocolStudyGroup iacucProtocolStudyGroup) {
        this.iacucProtocolStudyGroup = iacucProtocolStudyGroup;
    }

}
