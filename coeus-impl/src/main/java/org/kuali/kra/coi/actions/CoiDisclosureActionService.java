/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.actions;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiDisclosureDocument;
import org.kuali.kra.coi.CoiDisclosureForm;
import org.kuali.kra.coi.CoiUserRole;
import org.kuali.kra.coi.certification.SubmitDisclosureAction;
import org.kuali.rice.kew.api.exception.WorkflowException;

import java.util.List;

/**
 * 
 * This is an interface for methods needed for business logic in disclosure actions page
 */
public interface CoiDisclosureActionService {

    /**
     * 
     * This method implements the business logic for approving disclosure
     * @param coiDisclosure
     * @param coiDisclosureStatusCode
     * @throws WorkflowException 
     */
    void approveDisclosure(CoiDisclosure coiDisclosure, String coiDispositionCode) throws WorkflowException;
    
    /**
     * This method adds a coi reviewer to the disclosure
     * @param mapping
     * @param form
     * @param coiDisclosure
     * @param coiUserRole
     */
    ActionForward addCoiUserRole(ActionMapping mapping, ActionForm form, CoiDisclosure coiDisclosure, CoiUserRole coiUserRole);
    
    /**
     * This method removes a coi reviewer from the disclosure
     * @param mapping
     * @param form
     * @param coiDisclosure
     * @param index
     */
    ActionForward deleteCoiUserRole(ActionMapping mapping, ActionForm form, CoiDisclosure coiDisclosure, int index);

    /**
     * This method submits a disclosure to workflow
     * @param coiDisclosure
     * @param submitDisclosureAction
     */
    void submitToWorkflow(CoiDisclosureDocument coiDisclosureDocument, CoiDisclosureForm coiDisclosureForm, 
                          SubmitDisclosureAction submitDisclosureAction);

    public ActionForward sendCertificationNotifications(CoiDisclosureDocument coiDisclosureDocument, CoiDisclosureForm coiDisclosureForm, 
                                                        SubmitDisclosureAction submitDisclosureAction, ActionMapping mapping);

    void disapproveDisclosure(CoiDisclosure coiDisclosure, String coiDispositionCode) throws WorkflowException, Exception;

    public void tagUserRolesToCompleteReview(List<CoiUserRole> completeUserRoles);
    
    public void completeCoiReview(CoiDisclosure disclosure);
    
    public void updateDisclosureReviewStatus(CoiDisclosure coiDisclosure);
    
    /**
     * This method is to check whether all reviewers have completed their review
     * @param completeUserRoles
     * @return
     */
    public boolean isDisclosureReviewComplete(List<CoiUserRole> completeUserRoles);
    
    public void updateCoiDisclProjectStatus(CoiDisclosure coiDisclosure, String disclosureStatus);
    
    public void updateCoiDisclProjectDisposition(CoiDisclosure coiDisclosure, String dispositionStatus);
    
}
