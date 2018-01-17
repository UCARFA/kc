/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.unit.sync;


import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.kim.impl.role.RoleBoLite;
import org.kuali.rice.kns.inquiry.KualiInquirableImpl;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.Map;

public class UnitRoleInquirable extends KualiInquirableImpl {

    @Override
    public BusinessObject getBusinessObject(@SuppressWarnings("unchecked") Map fieldValues) {
        final String id = (String) fieldValues.get("id");

        return StringUtils.isNotBlank(id) ? UnitRole.fromRoleBoLite(this.getDataObjectService().find(RoleBoLite.class, id)) : null;
    }
}
