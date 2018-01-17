/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;

import org.kuali.rice.krad.bo.BusinessObjectBase;

import java.util.List;

/**
 * The RolePersons BO is simply a role name with a list of the
 * Persons in that role.
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class RolePersons extends BusinessObjectBase {
    
   
    private List<String> approver;
    private List<String> aggregator;
    private List<String> narrativewriter;
    private List<String> budgetcreator;
    private List<String> viewer;
    
    
  
    @Override
    public void refresh() {
        // do nothing
    }

   

    public List<String> getapprover() {
        return approver;
    }

    public void setapprover(List<String> approver) {
        this.approver = approver;
    }

    public List<String> getAggregator() {
        return aggregator;
    }

    public void setAggregator(List<String> aggregator) {
        this.aggregator = aggregator;
    }

    public List<String> getNarrativewriter() {
        return narrativewriter;
    }

    public void setNarrativewriter(List<String> narrativewriter) {
        this.narrativewriter = narrativewriter;
    }

    public List<String> getBudgetcreator() {
        return budgetcreator;
    }

    public void setBudgetcreator(List<String> budgetcreator) {
        this.budgetcreator = budgetcreator;
    }

    public List<String> getViewer() {
        return viewer;
    }

    public void setViewer(List<String> viewer) {
        this.viewer = viewer;
    }
}
