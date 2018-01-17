/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is to group disclosure project bean either by event type or by
 * financial entity. Currently we are listing it by projects so that we get to
 * display project details at the top level. 
 * We can regroup this completely by event type if required.
 * If we have to regroup by event type then project details here does not have
 * any effect.
 */
public class CoiGroupedMasterDisclosureBean implements Serializable {


    private static final long serialVersionUID = -5710247175508316897L;
    
    private String disclosureEventType;

    private String projectId;
    private String projectTitle;
    private String dispositionStatus;
    private String disclosureStatus;
    
    private String entityNumber;
    private String entityName;
    
    
    private List<CoiDisclosureProjectBean> allRelatedProjects;

    public CoiGroupedMasterDisclosureBean() {
        setAllRelatedProjects(new ArrayList<CoiDisclosureProjectBean>());
    }

    public List<CoiDisclosureProjectBean> getAllRelatedProjects() {
        return allRelatedProjects;
    }

    public void setAllRelatedProjects(List<CoiDisclosureProjectBean> allRelatedProjects) {
        this.allRelatedProjects = allRelatedProjects;
    }

    public String getDisclosureEventType() {
        return disclosureEventType;
    }

    public void setDisclosureEventType(String disclosureEventType) {
        this.disclosureEventType = disclosureEventType;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getDispositionStatus() {
        return dispositionStatus;
    }

    public void setDispositionStatus(String dispositionStatus) {
        this.dispositionStatus = dispositionStatus;
    }

    public String getDisclosureStatus() {
        return disclosureStatus;
    }

    public void setDisclosureStatus(String disclosureStatus) {
        this.disclosureStatus = disclosureStatus;
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    
}
