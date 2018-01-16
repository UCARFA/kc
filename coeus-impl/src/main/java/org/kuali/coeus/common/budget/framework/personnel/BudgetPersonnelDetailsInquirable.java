/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import org.kuali.rice.kns.inquiry.KualiInquirableImpl;
import org.kuali.rice.kns.web.ui.Section;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.List;

public class BudgetPersonnelDetailsInquirable extends KualiInquirableImpl {
   
    @Override
    public List<Section> getSections(BusinessObject bo) {
        List<Section> sections = super.getSections(bo);
        BudgetPersonnelDetails budgetPersonnelDetails = ((BudgetPersonnelDetails) bo);
        budgetPersonnelDetails.refreshReferenceObject("budgetPerson");
        
        for(Section section: sections) {
            section.setSectionTitle(section.getSectionTitle() + " - " + budgetPersonnelDetails.getBudgetPerson().getPersonName() + " ");
        }
        
        return sections;
    }
} 
