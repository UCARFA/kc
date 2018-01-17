/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiReviewer;
import org.kuali.kra.coi.CoiUserRole;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class CoiDisclosureReviewsLookupableHelper extends CoiDisclosureLookupableHelperBase {


    private static final long serialVersionUID = 5482769028074271782L;

    @Override
    public List<? extends BusinessObject> getLookupSpecificSearchResults(Map<String, String> fieldValues) {
        List<CoiDisclosure> allDisclosures = (List<CoiDisclosure>) super.getResults(fieldValues);
        List<CoiDisclosure> coiDisclosureReviews = new ArrayList<CoiDisclosure>();
        String currentUser = GlobalVariables.getUserSession().getPrincipalName();
        
        for (CoiDisclosure disclosure : allDisclosures) {
            List<CoiUserRole> userRoles = disclosure.getCoiUserRoles();
            for (CoiUserRole userRole : userRoles) {
                if (StringUtils.equalsIgnoreCase(userRole.getReviewerCode(), CoiReviewer.ASSIGNED_REVIEWER)) {
                    // userId is really the username . This should probably be "fixed" at some point.
                    if (StringUtils.equalsIgnoreCase(currentUser, userRole.getUserId()) && !userRole.isReviewCompleted()) {
                        coiDisclosureReviews.add(disclosure);
                    }
                }
            }
        }
        return coiDisclosureReviews;
    }
    
    @Override
    protected boolean isAuthorizedForCoiLookups() {
        return true;
    }
}
