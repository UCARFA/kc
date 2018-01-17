/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.certification;

import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiUserRole;
import org.kuali.kra.coi.actions.DisclosureActionHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is really just a "form" for submitting a protocol for review in the Submit for Review Action.
 */
public class SubmitDisclosureAction implements Serializable {

    private static final long serialVersionUID = -4712974868607781787L;

    private DisclosureActionHelper disclosureActionHelper;
    private boolean javascriptEnabled;
    
    /**
     * Constructs a SubmitDisclosureAction.
     * 
     * @param disclosureActionHelper Reference back to the action helper for this bean
     */
    public SubmitDisclosureAction(DisclosureActionHelper disclosureActionHelper) {
        this.disclosureActionHelper = disclosureActionHelper;
    }

    public DisclosureActionHelper getActionHelper() {
        return disclosureActionHelper;
    }

    public void setDisclosureActionHelper(DisclosureActionHelper disclosureActionHelper) {
        this.disclosureActionHelper = disclosureActionHelper;
    }

    public CoiDisclosure getDisclosure() {
        return getActionHelper().getCoiDisclosure();
    }

    public boolean getJavascriptEnabled() {
        return javascriptEnabled;
    }

    public void setJavascriptEnabled(boolean javascriptEnabled) {
        this.javascriptEnabled = javascriptEnabled;
    }

    public List<CoiUserRole> getReviewers() {
        List<CoiUserRole>list = new ArrayList<CoiUserRole>();
        for (CoiUserRole userRole: getDisclosure().getCoiUserRoles()) {
            if ("COI Reviewer".equals(userRole.getRoleName())) {
                list.add(userRole);
            }
        }        
        return list;
    }

}
