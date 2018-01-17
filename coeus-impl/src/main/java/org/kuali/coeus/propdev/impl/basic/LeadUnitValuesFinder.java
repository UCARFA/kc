/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.basic;

import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Find the Lead Units for a Proposal Development Document.  When a user
 * creates a proposal, they can only create proposals in units in which they 
 * have the CREATE_PROPOSAL permission.  The Unit Authorization Service is
 * queried to determine which units the user has the CREATE_PROPOSAL permission.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class LeadUnitValuesFinder extends UifKeyValuesFinderBase {

    private ProposalDevelopmentService proposalDevelopmentService;
    protected ProposalDevelopmentService getProposalDevelopmentService (){
        if (proposalDevelopmentService == null)
            proposalDevelopmentService = KcServiceLocator.getService(ProposalDevelopmentService.class);
        return proposalDevelopmentService;
    }
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        
        String userId = GlobalVariables.getUserSession().getPrincipalId();
        ProposalDevelopmentService authService = getProposalDevelopmentService();
        List<Unit> userUnits = authService.getUnitsForCreateProposal(userId);

        // Sort the list of units by Unit Number.  If there are lots of units,
        // the sort will make it easier for the user to find when they view
        // the drop-down list in the web page.
        
        Collections.sort(userUnits, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Unit unit1 = (Unit) o1;
                Unit unit2 = (Unit) o2;
                return unit1.getUnitNumber().compareTo(unit2.getUnitNumber());
            }
        });
        
        for (Unit unit : userUnits) {
            keyValues.add(new ConcreteKeyValue(unit.getUnitNumber(), unit.getUnitNumber() + " - " + unit.getUnitName()));
        }

        return keyValues;
    }
}
