/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.propdev.impl.lock.ProposalLockService;
import org.kuali.kra.authorization.KraAuthorizationConstants;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.authorization.AuthorizationConstants;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.service.impl.PessimisticLockServiceImpl;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.ObjectUtils;

import java.util.Iterator;
import java.util.Map;

public class InstitutionalProposalLockServiceImpl extends PessimisticLockServiceImpl implements ProposalLockService {

    /**
     * This method is used to check if the given parameters warrant a new lock to be created for the given user. This method
     * utilizes the {@link #isEntryEditMode(java.util.Map.Entry)} method.
     * 
     * @param document -
     *            document to verify lock creation against
     * @param editMode -
     *            edit modes list to check for 'entry type' edit modes
     * @param user -
     *            user the lock will be 'owned' by
     * @return true if the given edit mode map has at least one 'entry type' edit mode... false otherwise
     */
    @SuppressWarnings("unchecked")
    @Override
    protected boolean isLockRequiredByUser(Document document, Map editMode, Person user) {
        //String activeLockRegion = (String) GlobalVariables.getUserSession().retrieveObject(KraAuthorizationConstants.ACTIVE_LOCK_REGION);
        
         //check for entry edit mode
        for (Iterator iterator = editMode.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (isEntryEditMode(entry)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to check if the given {@link Map.Entry} is an 'entry type' edit mode and that the value is set to
     * signify that this user has that edit mode available to them
     * 
     * @param entry -
     *            the {@link Map.Entry} object that contains an edit mode such as the ones returned but
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    protected boolean isEntryEditMode(Map.Entry entry) {
        if (AuthorizationConstants.EditMode.FULL_ENTRY.equals(entry.getKey())
                || KraAuthorizationConstants.ProposalEditMode.ADD_NARRATIVES.equals(entry.getKey())
                || KraAuthorizationConstants.ProposalEditMode.MODIFY_PERMISSIONS.equals(entry.getKey())
                || KraAuthorizationConstants.ProposalEditMode.MODIFY_PROPOSAL.equals(entry.getKey())
                || KraAuthorizationConstants.BudgetEditMode.MODIFY_BUDGET.equals(entry.getKey())
                || "addBudget".equals(entry.getKey()) 
                ) {
            String fullEntryEditModeValue = (String)entry.getValue();
            return ((ObjectUtils.isNotNull(fullEntryEditModeValue)) && StringUtils.equalsIgnoreCase(KRADConstants.KUALI_DEFAULT_TRUE_VALUE, fullEntryEditModeValue));

        }
        return false;
    }
    
}
