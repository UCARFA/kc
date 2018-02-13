/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.award.notification;

import org.kuali.coeus.common.notification.impl.NotificationRenderer;
import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.exception.UnknownRoleException;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.kim.bo.KcKimAttributes;

import static org.kuali.coeus.common.impl.unit.UnitHierarchyRoleTypeServiceImpl.DESCENDS_HIERARCHY_N;
import static org.kuali.coeus.common.impl.unit.UnitHierarchyRoleTypeServiceImpl.DESCENDS_HIERARCHY_Y;

public class AwardUnitHierarchyDescendingNotificationContext extends AwardNotificationContext {

    private static final long serialVersionUID = 995420625420293267L;

    private boolean descendsHierarchy;

    public AwardUnitHierarchyDescendingNotificationContext(Award award, String actionTypeCode, String contextName, NotificationRenderer renderer, String forwardName) {
        super(award, actionTypeCode, contextName, renderer, forwardName);
    }

    public AwardUnitHierarchyDescendingNotificationContext(Award award, String actionTypeCode, String contextName) {
        super(award, actionTypeCode, contextName);
    }

    public AwardUnitHierarchyDescendingNotificationContext(Award award, String actionTypeCode, String contextName, String forwardName) {
        super(award, actionTypeCode, contextName, forwardName);
    }

    public void populateRoleQualifiers(NotificationTypeRecipient notificationRecipient) throws UnknownRoleException {
        super.populateRoleQualifiers(notificationRecipient);

        if (getNotificationModuleRoleService().getNotificationModuleRolesForKimRole(getModuleCode(), notificationRecipient.getRoleName())
                .stream().flatMap(moduleRole -> moduleRole.getRoleQualifiers().stream())
                .anyMatch(moduleQualifier -> KcKimAttributes.SUBUNITS.equals(moduleQualifier.getQualifier()))) {
            notificationRecipient.getRoleQualifiers().put(KcKimAttributes.SUBUNITS, getDescendsHierarchyAttributeValues());
        }
    }

    protected String getDescendsHierarchyAttributeValues() {
        return isDescendsHierarchy() ? DESCENDS_HIERARCHY_Y : DESCENDS_HIERARCHY_N;
    }

    public boolean isDescendsHierarchy() {
        return descendsHierarchy;
    }

    public void setDescendsHierarchy(boolean descendsHierarchy) {
        this.descendsHierarchy = descendsHierarchy;
    }
}
