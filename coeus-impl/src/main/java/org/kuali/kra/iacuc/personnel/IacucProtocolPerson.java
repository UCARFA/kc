/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.personnel;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucPersonTraining;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.procedures.IacucProcedurePersonResponsible;
import org.kuali.kra.iacuc.procedures.IacucProtocolProcedureService;
import org.kuali.kra.iacuc.procedures.IacucProtocolSpeciesStudyGroup;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.protocol.personnel.ProtocolPersonBase;

import java.util.ArrayList;
import java.util.List;


public class IacucProtocolPerson extends ProtocolPersonBase {

    private static final long serialVersionUID = 6676849646094141708L;
    private String procedureQualificationDescription;
    private List<IacucPersonTraining> iacucPersonTrainings;
    
    private static final String PERSON_TRAINED_TRUE = "Yes";
    private static final String PERSON_TRAINED_FALSE = "No";
    
    private List<IacucProcedurePersonResponsible> iacucProcedurePersonResponsibleList;
    
    /* 
     * List of protocol studies and related procedures grouped by species
     * This collection is populated during protocol procedure actions
     */
    private List<IacucProtocolSpeciesStudyGroup> procedureDetails;
    
    private boolean allProceduresSelected;
    
    public IacucProtocolPerson() {
        super();
        setIacucPersonTrainings(new ArrayList<IacucPersonTraining>());
    }

    @Override
    protected String getModuleNamespace() {
        return Constants.MODULE_NAMESPACE_IACUC;
    }

    public IacucProtocol getIacucProtocol() {
        return (IacucProtocol) getProtocol();
    }

    public String getProcedureQualificationDescription() {
        return procedureQualificationDescription;
    }

    public void setProcedureQualificationDescription(String procedureQualificationDescription) {
        this.procedureQualificationDescription = procedureQualificationDescription;
    }

    public List<IacucPersonTraining> getIacucPersonTrainings() {
        return iacucPersonTrainings;
    }

    public void setIacucPersonTrainings(List<IacucPersonTraining> iacucPersonTrainings) {
        this.iacucPersonTrainings = iacucPersonTrainings;
    }
    
    public String getPersonTrainedStatus() {
        return getIacucPersonTrainings().size() > 0 ? PERSON_TRAINED_TRUE : PERSON_TRAINED_FALSE;
    }

    @Override
    protected void postLoad() {
        super.postLoad();
        setIacucPersonTrainings(getIacucProtocolProcedureService().getIacucPersonTrainingDetails(getPersonId()));
    }

    @Override
    protected void postPersist() {
        super.postPersist();
        setIacucPersonTrainings(getIacucProtocolProcedureService().getIacucPersonTrainingDetails(getPersonId()));
    }
    
    protected IacucProtocolProcedureService getIacucProtocolProcedureService() {
        return (IacucProtocolProcedureService) KcServiceLocator.getService("iacucProtocolProcedureService");
    }

    public List<IacucProtocolSpeciesStudyGroup> getProcedureDetails() {
        return procedureDetails;
    }

    public void setProcedureDetails(List<IacucProtocolSpeciesStudyGroup> procedureDetails) {
        this.procedureDetails = procedureDetails;
    }

    public boolean isAllProceduresSelected() {
        return allProceduresSelected;
    }

    public void setAllProceduresSelected(boolean allProceduresSelected) {
        this.allProceduresSelected = allProceduresSelected;
    }

    public List<IacucProcedurePersonResponsible> getIacucProcedurePersonResponsibleList() {
        return iacucProcedurePersonResponsibleList;
    }

    public void setIacucProcedurePersonResponsibleList(List<IacucProcedurePersonResponsible> iacucProcedurePersonResponsibleList) {
        this.iacucProcedurePersonResponsibleList = iacucProcedurePersonResponsibleList;
    }

}
