/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.questionnaire;

import org.kuali.kra.coi.CoiDisclProject;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;

public class DisclProjectQuestionnaireHelper extends DisclosureQuestionnaireHelper {

    private CoiDisclosure originalDisclosure;
    private CoiDisclProject coiDisclProject;
    
    public DisclProjectQuestionnaireHelper(CoiDisclProject coiDisclProject, CoiDisclosure coiDisclosure, CoiDisclosure originalDisclosure) {
        super(coiDisclosure);
        this.coiDisclProject = coiDisclProject;
        this.originalDisclosure = originalDisclosure;
    }

    @Override
    public ModuleQuestionnaireBean getModuleQnBean() {
        return new DisclosureModuleQuestionnaireBean(originalDisclosure, getCoiDisclProject(), 
                getCoiDisclosure().getCoiDisclosureDocument().getDocumentHeader().hasWorkflowDocument() ? getCoiDisclosure().getCoiDisclosureDocument().getDocumentHeader().getWorkflowDocument().isApproved() : false);
    }

    public CoiDisclProject getCoiDisclProject() {
        return coiDisclProject;
    }

    public void setCoiDisclProject(CoiDisclProject coiDisclProject) {
        this.coiDisclProject = coiDisclProject;
        setCoiDisclosure(coiDisclProject.getCoiDisclosure());
    }

    public void preSave(CoiDisclosure coiDisclosure) {
        setCoiDisclosure(coiDisclosure);
        super.preSave();
    }

    public CoiDisclosure getOriginalDisclosure() {
        return originalDisclosure;
    }

    public void setOriginalDisclosure(CoiDisclosure originalDisclosure) {
        this.originalDisclosure = originalDisclosure;
    }    

}
