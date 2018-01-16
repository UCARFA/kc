/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.auth.perm.Permissionable;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kns.web.ui.ExtraButton;

import javax.persistence.MappedSuperclass;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BudgetParentDocument<T extends BudgetParent> extends KcTransactionalDocumentBase implements Permissionable {

    /**
     * Looks up and returns the ParameterService.
     * @return the parameter service. 
     */
    protected ParameterService getParameterService() {
        return KcServiceLocator.getService(ParameterService.class);
    }

    /**
     * This method gets the next budget version number for this proposal. We can't use documentNextVersionNumber because that
     * requires a save and we don't want to save the proposal development document before forwarding to the budget document.
     * 
     * @return Integer
     */
    public Integer getNextBudgetVersionNumber() {
        List<? extends Budget> versions = getBudgetParent().getBudgets();
        if (versions.isEmpty()) {
            return 1;
        }
        Collections.sort(versions, new Comparator<Budget>(){
			@Override
			public int compare(Budget o1, Budget o2) {
				return new CompareToBuilder().append(o1.getBudgetVersionNumber(), o2.getBudgetVersionNumber()).toComparison() * -1;
			}
        });
        Budget lastVersion = versions.get(0);
        return lastVersion.getBudgetVersionNumber() + 1;
    }

    public Budget getBudgetDocumentVersion(int selectedLine) {
        return getBudgetParent().getBudgets().get(selectedLine);
    }

    public void updateBudgetDescriptions(List<? extends AbstractBudget> budgetVersions) {
        for (AbstractBudget budgetVersion : budgetVersions) {
            if (budgetVersion.isNameUpdatable() && !StringUtils.isBlank(budgetVersion.getName())) {
                budgetVersion.setNameUpdatable(false);
            }
        }
    }
    
    public abstract Permissionable getBudgetPermissionable();

    public abstract boolean isComplete();

    public abstract ExtraButton configureReturnToParentTopButton();

    public abstract T getBudgetParent();

}
