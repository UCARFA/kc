/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.api.KimConstants;

/**
 * Implements the AwardNotificationRoleQualifierService.
 */
public class AwardNotificationRoleQualifierServiceImpl implements AwardNotificationRoleQualifierService {

    private Award award;
    
    @Override
    public String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier) {
        String roleQualifierValue = null;
        if (StringUtils.equals(qualifier.getQualifier(), KcKimAttributes.AWARD)) {
            roleQualifierValue = award.getAwardId().toString();
        }
        else if (StringUtils.equals(qualifier.getQualifier(), KcKimAttributes.UNIT_NUMBER)) {
            if (award.getUnitNumber() != null) {
                roleQualifierValue = award.getUnitNumber();
            }
        } else if (StringUtils.equals(qualifier.getQualifier(), KimConstants.AttributeConstants.DOCUMENT_NUMBER)) {
            roleQualifierValue = award.getAwardDocument().getDocumentNumber();
        }
        return roleQualifierValue;
    }

    @Override
    public Award getAward() {
        return award;
    }
    
    @Override
    public void setAward(Award award) {
        this.award = award;
    }

}
