/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.apache.commons.collections4.CollectionUtils;
import org.kuali.kra.coi.CoiDiscDetail;
import org.kuali.kra.coi.CoiDisclProject;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.notesandattachments.attachments.CoiDisclosureAttachment;
import org.kuali.kra.coi.notesandattachments.notes.CoiDisclosureNotepad;
import org.kuali.kra.coi.questionnaire.DisclProjectQuestionnaireHelper;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CoiDisclosureProjectBean implements Serializable {

    private static final long serialVersionUID = -100427824220789523L;
    private CoiDisclProject coiDisclProject;
    private CoiDisclosure coiDisclosure;
    private String projectName;
    private String projectId;
    private Date approvalDate; 
    private List<CoiDisclosureAttachment> projectDiscAttachments;
    private List<CoiDisclosureNotepad> projectDiscNotepads;
    private DisclProjectQuestionnaireHelper projectQuestionnaireHelper;
    private boolean excludeFE; 

    public CoiDisclosureProjectBean() {
        coiDisclProject = new CoiDisclProject();
        projectDiscAttachments = new ArrayList<CoiDisclosureAttachment> ();
        projectDiscNotepads = new ArrayList<CoiDisclosureNotepad> ();
    }
    
    public CoiDisclProject getCoiDisclProject() {
        return coiDisclProject;
    }

    public void setCoiDisclProject(CoiDisclProject coiDisclProject) {
        this.coiDisclProject = coiDisclProject;
    }

    public CoiDisclosure getCoiDisclosure() {
        if (coiDisclosure == null) {
            coiDisclosure = getOriginalCoiDisclosure();
        }
        return coiDisclosure;
    }

    private CoiDisclosure getOriginalCoiDisclosure() {
        List<CoiDiscDetail> projectDiscDetails = coiDisclProject.getCoiDiscDetails();
        if (CollectionUtils.isNotEmpty(projectDiscDetails)) {
            if (projectDiscDetails.get(0).getOriginalCoiDisclosure() == null) {
                return projectDiscDetails.get(0).getCoiDisclosure();
            } else {
                return projectDiscDetails.get(0).getOriginalCoiDisclosure();
            }
        } else {
            return null;
        }
    }
    
    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }


    public String getProjectName() {
        if(getCoiDisclosure().isAnnualEvent() || getCoiDisclosure().isUpdateEvent()) {
            return null;
        }else {
            return projectName;
        }
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public boolean isCurrentProject() {
        List<CoiDiscDetail> projectDiscDetails = coiDisclProject.getCoiDiscDetails();
        if (CollectionUtils.isNotEmpty(projectDiscDetails)) {
            return projectDiscDetails.get(0).getOriginalCoiDisclosure() == null;
        } else {
            return false;
        }
    }

    public String getProjectId() {
        if(getCoiDisclosure().isAnnualEvent() || getCoiDisclosure().isUpdateEvent()) {
            return null;
        }else {
            return projectId;
        }
    }


    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    public Date getApprovalDate() {
        return approvalDate;
    }


    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }


    public List<CoiDisclosureAttachment> getProjectDiscAttachments() {
        return projectDiscAttachments;
    }


    public void setProjectDiscAttachments(List<CoiDisclosureAttachment> projectDiscAttachments) {
        this.projectDiscAttachments = projectDiscAttachments;
    }


    public List<CoiDisclosureNotepad> getProjectDiscNotepads() {
        return projectDiscNotepads;
    }


    public void setProjectDiscNotepads(List<CoiDisclosureNotepad> projectDiscNotepads) {
        this.projectDiscNotepads = projectDiscNotepads;
    }


    public boolean isExcludeFE() {
        return excludeFE;
    }


    public void setExcludeFE(boolean excludeFE) {
        this.excludeFE = excludeFE;
    }

    public DisclProjectQuestionnaireHelper getProjectQuestionnaireHelper() {
        return projectQuestionnaireHelper;
    }  

    public void setProjectQuestionnaireHelper(DisclProjectQuestionnaireHelper projectQuestionnaireHelper) {
        this.projectQuestionnaireHelper = projectQuestionnaireHelper;
    }
    
    public void populateAnswers(CoiDisclosure originalDisclosure) {
        projectQuestionnaireHelper = new DisclProjectQuestionnaireHelper(coiDisclProject, coiDisclProject.getCoiDisclosure(), originalDisclosure);
        projectQuestionnaireHelper.populateAnswers();
    }
    
    public void versionDisclosureAnswers(CoiDisclosure originalDisclosure) {
        projectQuestionnaireHelper = new DisclProjectQuestionnaireHelper(coiDisclProject, coiDisclProject.getCoiDisclosure(), originalDisclosure);
        projectQuestionnaireHelper.versionAnswers();
    }
    
    
    public List<AnswerHeader> getAnswerHeaders() {
        return this.getProjectQuestionnaireHelper().getAnswerHeaders();
    }

}
