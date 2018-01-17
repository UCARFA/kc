/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.web.krad;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.krad.uif.component.BindingInfo;

public class KcBindingInfo extends BindingInfo {

    public static String getParentBindingInfo(BindingInfo bindingInfo) {
        String formedBindingPath = "";

        if (!bindingInfo.isBindToForm() && StringUtils.isNotBlank(bindingInfo.getBindingObjectPath())) {
            formedBindingPath = bindingInfo.getBindingObjectPath();
        }

        if (StringUtils.isNotBlank(bindingInfo.getBindByNamePrefix())) {
            if (!bindingInfo.getBindByNamePrefix().startsWith("[") && StringUtils.isNotBlank(formedBindingPath)) {
                formedBindingPath += ".";
            }
            formedBindingPath += bindingInfo.getBindByNamePrefix();
        }

        return formedBindingPath;
    }
}
