/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.notifications;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.kra.negotiations.bo.Negotiation;

public class NegotiationNotificationRoleQualifierServiceImpl implements NegotiationNotificationRoleQualifierService {

    private Negotiation negotiation;

    @Override
    public String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier) {
        String result = null;
        if (StringUtils.equals(qualifier.getQualifier(), "negotiation")) {
            if (negotiation.getNegotiationId() != null) {
                result = negotiation.getNegotiationId().toString();
            }
        }
        else if (StringUtils.equals(qualifier.getQualifier(), KcKimAttributes.UNIT_NUMBER)) {
            if (negotiation.getAssociatedDocument() != null) {
                result = negotiation.getAssociatedDocument().getLeadUnitNumber();
            }
        } 
        return result;
    }

    @Override
    public Negotiation getNegotiation() {
        return negotiation;
    }


    @Override
    public void setNegotiation(Negotiation negotiation) {
        this.negotiation = negotiation;
    }

}
