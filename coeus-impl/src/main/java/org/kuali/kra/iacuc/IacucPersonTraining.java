/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.common.framework.person.attr.PersonTraining;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.procedures.IacucProcedure;

public class IacucPersonTraining extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer iacucPersonTrainingId; 
    private Integer personTrainingId; 
    private String personId; 
    private Integer speciesCode; 
    private Integer procedureCode; 
    
    private PersonTraining personTraining; 
    private IacucSpecies iacucSpecies; 
    private IacucProcedure iacucProcedure;


    private transient KcPersonService kcPersonService;

    public IacucPersonTraining() { 

    } 
    
    public Integer getIacucPersonTrainingId() {
        return iacucPersonTrainingId;
    }

    public void setIacucPersonTrainingId(Integer iacucPersonTrainingId) {
        this.iacucPersonTrainingId = iacucPersonTrainingId;
    }

    public Integer getPersonTrainingId() {
        return personTrainingId;
    }

    public void setPersonTrainingId(Integer personTrainingId) {
        this.personTrainingId = personTrainingId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(Integer speciesCode) {
        this.speciesCode = speciesCode;
    }

    public Integer getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(Integer procedureCode) {
        this.procedureCode = procedureCode;
    }

    public PersonTraining getPersonTraining() {
        if(personTraining == null) {
            this.refreshReferenceObject("personTraining");
        }
        return personTraining;
    }

    public void setPersonTraining(PersonTraining personTraining) {
        this.personTraining = personTraining;
    }

    public IacucSpecies getIacucSpecies() {
        if(iacucSpecies == null) {
            refreshReferenceObject("iacucSpecies");
        }
        return iacucSpecies;
    }

    public void setIacucSpecies(IacucSpecies iacucSpecies) {
        this.iacucSpecies = iacucSpecies;
    }

    public IacucProcedure getIacucProcedure() {
        if(iacucProcedure == null) {
            refreshReferenceObject("iacucProcedure");
        }
        return iacucProcedure;
    }

    public void setIacucProcedure(IacucProcedure iacucProcedure) {
        this.iacucProcedure = iacucProcedure;
    }
    
    public KcPerson getPerson() {
        return getKcPersonService().getKcPersonByPersonId(personId);
    }

    protected KcPersonService getKcPersonService() {
        if (this.kcPersonService == null) {
            this.kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        }
        return this.kcPersonService;
    }
}
