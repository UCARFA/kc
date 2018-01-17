/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.api.KimConstants;
import org.kuali.rice.krad.util.GlobalVariables;


public class CoiNotificationRoleQualifierServiceImpl implements CoiNotificationRoleQualifierService {

    private CoiDisclosure coiDisclosure;
    
    @Override
    public String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier) {
        String qName = qualifier.getQualifier();

        if (StringUtils.equalsIgnoreCase(qName, KimConstants.AttributeConstants.DOCUMENT_NUMBER)) {
            return coiDisclosure.getCoiDisclosureDocument().getDocumentNumber();
        } else if (StringUtils.equalsIgnoreCase(qName, "coiDisclosureId")) {
            return coiDisclosure.getCoiDisclosureId().toString();
        } else if (StringUtils.equals(qName, KcKimAttributes.UNIT_NUMBER)) {
            if (coiDisclosure == null) {
                // no disclosure, so we must be sending a FE notification
                KcPerson reporter = KcPerson.fromPersonId(GlobalVariables.getUserSession().getPrincipalId());
                final Unit unit = reporter.getUnit();
                if (unit != null) {
                  return unit.getUnitNumber();
                }
            } else {
                return coiDisclosure.getLeadUnitNumber();
            }
        } else if (StringUtils.equals(qName, KcKimAttributes.SUBUNITS)) {
            return "*";
        }
        
        return null;
    }

    @Override
    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }

    @Override
    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }

}
