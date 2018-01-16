/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import java.util.ArrayList;
import java.util.List;

import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BudgetAuditRuleBase {

	@Autowired
	@Qualifier("globalVariableService")
	private GlobalVariableService globalVariableService;
	
	protected List<AuditError> getAuditErrors(BudgetConstants.BudgetAuditRules auditRule, boolean auditError) {
		return getAuditCluster(auditRule, auditError).getAuditErrorList();
	}
	
	protected List<AuditError> getAuditErrors(BudgetConstants.BudgetAuditRules auditRule, String appendLabel, boolean auditError) {
        AuditCluster auditCluster = getAuditCluster(auditRule, false);
        auditCluster.setLabel(auditCluster.getLabel().concat(appendLabel));
		return auditCluster.getAuditErrorList();
	}
	
	protected AuditCluster getAuditCluster(BudgetConstants.BudgetAuditRules auditRule, boolean auditError) {
		String auditKey = auditRule.getWarningKey();
		String auditCategory = Constants.AUDIT_WARNINGS;
		
		if(auditError) {
			auditKey = auditRule.getErrorKey();
			auditCategory = Constants.AUDIT_ERRORS;
		}
		
        AuditCluster auditCluster = getGlobalVariableService().getAuditErrorMap().get(auditKey);
        if (auditCluster == null) {
            List<AuditError> auditErrors = new ArrayList<>();
            auditCluster = new AuditCluster(auditRule.getLabel(), auditErrors, auditCategory);
            getGlobalVariableService().getAuditErrorMap().put(auditKey, auditCluster);
        }
        return auditCluster;
	}
	
	protected GlobalVariableService getGlobalVariableService() {
		return globalVariableService;
	}

	public void setGlobalVariableService(GlobalVariableService globalVariableService) {
		this.globalVariableService = globalVariableService;
	}

}


