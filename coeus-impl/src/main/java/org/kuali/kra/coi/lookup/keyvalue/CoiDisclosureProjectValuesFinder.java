/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup.keyvalue;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.kra.coi.*;
import org.kuali.kra.coi.disclosure.CoiDisclosureProjectBean;
import org.kuali.kra.coi.disclosure.MasterDisclosureBean;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;


public class CoiDisclosureProjectValuesFinder extends FormViewAwareUifKeyValuesFinderBase {


    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyLabels = new ArrayList<KeyValue>();
        CoiDisclosureForm coiDisclosureForm = (CoiDisclosureForm) getFormOrView();

        CoiDisclosureDocument coiDisclosureDocument = coiDisclosureForm.getCoiDisclosureDocument();
        CoiDisclosure coiDisclosure = coiDisclosureDocument.getCoiDisclosure();
        String event = coiDisclosure.getEventTypeCode();
        String pid = coiDisclosureForm.getDisclosureHelper().getNewProjectId();


        if (coiDisclosureDocument != null && coiDisclosure != null && !StringUtils.isEmpty(event)) { 
            if (StringUtils.equalsIgnoreCase(event, CoiDisclosureEventType.UPDATE)) {
                addMasterProjects(keyLabels, coiDisclosureForm.getDisclosureHelper().getMasterDisclosureBean());
            } else {
                if (!coiDisclosure.getCoiDisclProjects().isEmpty()) {
                    for (CoiDisclProject project : coiDisclosure.getCoiDisclProjects()) {
                        String projectId = project.getProjectId();
                        keyLabels.add(new ConcreteKeyValue (projectId, project.getEventDescription() 
                                + "--" + project.getProjectName() + "--" + projectId));
                    }
                } 
            }         
        }

        return keyLabels;

    }

    private void addMasterProjects(List<KeyValue> keyLabels, MasterDisclosureBean masterDisclosureBean) {
        addManualProject(keyLabels, masterDisclosureBean.getManualProtocolProjects(), "Manual Protocol --");
        addManualProject(keyLabels, masterDisclosureBean.getManualTravelProjects(), "Manual Travel --");
        addManualProject(keyLabels, masterDisclosureBean.getManualAwardProjects(), "Manual Award --");
        addManualProject(keyLabels, masterDisclosureBean.getManualProposalProjects(), "Manual Proposal --");
        addManualProject(keyLabels, masterDisclosureBean.getOtherManualProjects(), "Manual Other --");
        addAutomaticProject(keyLabels, masterDisclosureBean.getAwardProjects(), "AWARD --");
        addAutomaticProject(keyLabels, masterDisclosureBean.getProtocolProjects(), "PROTOCOL --");
        addAutomaticProject(keyLabels, masterDisclosureBean.getProposalProjects(), "PROPOSAL --");
    }

    private void addManualProject(List<KeyValue> keyLabels, List<CoiDisclosureProjectBean> manualProtocolProjects, String projectLabel) {
        for (CoiDisclosureProjectBean disclProjectBean : manualProtocolProjects) {
            CoiDisclProject disclProject = (CoiDisclProject) disclProjectBean.getCoiDisclProject();
            keyLabels.add(new ConcreteKeyValue(disclProject.getProjectId(), 
                    formatLabel(projectLabel + disclProject.getProjectId(), disclProject.getProjectName())));
        }

    }

    private void addAutomaticProject(List<KeyValue> keyLabels, List<CoiDisclosureProjectBean> automaticProtocolProjects, String projectLabel) {
        for (CoiDisclosureProjectBean disclProjectBean : automaticProtocolProjects) {
            CoiDisclProject coiDisclProject = disclProjectBean.getCoiDisclProject();
            keyLabels.add(new ConcreteKeyValue(coiDisclProject.getProjectId(), 
                    formatLabel(projectLabel + coiDisclProject.getProjectId(),coiDisclProject.getProjectName())));
        }

    }

    protected String formatLabel(String number, String title) {
        return number + "--" + title;
    }

}
