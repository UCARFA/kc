/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.actions;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.coi.CoiUserRole;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

public class AddCoiReviewerRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<AddCoiReviewerEvent> {
    
    private transient KcPersonService kcPersonService;
    
    public AddCoiReviewerRule() {
        kcPersonService = KcServiceLocator.getService(KcPersonService.class);
    }

    @Override
    public boolean processRules(AddCoiReviewerEvent event) {
        return validateRequired(event) && validateNonDuplicate(event);
    }
    
    private boolean validateRequired(AddCoiReviewerEvent event) {
        boolean valid = false;
        if (StringUtils.isNotBlank(event.getCoiUserRole().getUserId())
                && getKcPersonService().getKcPersonByUserName(event.getCoiUserRole().getUserId()) != null) {
            valid = true;
        } else {
            GlobalVariables.getMessageMap().putError("disclosureActionHelper.newCoiUserRole.userId", 
                    KeyConstants.ERROR_REQUIRED, new String[] { "User Name" });  
        }
        
        return valid;
    }

    private boolean validateNonDuplicate(AddCoiReviewerEvent event) {
        boolean valid = true;
        if (CollectionUtils.isNotEmpty(event.getCoiDisclosure().getCoiUserRoles())) {
            for (CoiUserRole userRole : event.getCoiDisclosure().getCoiUserRoles()) {
                if (StringUtils.equalsIgnoreCase(userRole.getUserId(), event.getCoiUserRole().getUserId())) {
                    valid = false;
                    GlobalVariables.getMessageMap().putError("disclosureActionHelper.newCoiUserRole.userId", 
                            "error.duplicate.entry", new String[] { "User Name" });                    
                    break;
                }
            }
        }
        return valid;
    }

    protected KcPersonService getKcPersonService() {
        if (kcPersonService == null) {
            kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        }
        return kcPersonService;
    }

    public void setKcPersonService(KcPersonService kcPersonService) {
        this.kcPersonService = kcPersonService;
    }
}
