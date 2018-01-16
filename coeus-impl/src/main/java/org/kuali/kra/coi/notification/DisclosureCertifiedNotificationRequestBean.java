/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notification;

import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiUserRole;
import org.kuali.kra.infrastructure.Constants;

import java.util.List;

public class DisclosureCertifiedNotificationRequestBean extends CoiNotificationRequestBean {


    private static final long serialVersionUID = 1675582315061417093L;
    public List<CoiUserRole> coiDisclosureReviewers;

    public DisclosureCertifiedNotificationRequestBean(CoiDisclosure coiDisclosure, List<CoiUserRole> coiDisclosureReviewers) {
        super(coiDisclosure, Constants.DISCLOSURE_CERTIFIED_NOTIFICATION, "Disclosure Certified");        
        this.coiDisclosureReviewers = coiDisclosureReviewers;
    }

    public List<CoiUserRole> getCoiDisclosureReviewers() {
        return coiDisclosureReviewers;
    }

    public void setCoiDisclosureReviewers(List<CoiUserRole> coiDisclosureReviewers) {
        this.coiDisclosureReviewers = coiDisclosureReviewers;
    }

}
