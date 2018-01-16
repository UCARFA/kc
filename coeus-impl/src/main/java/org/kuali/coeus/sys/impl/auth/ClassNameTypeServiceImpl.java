/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.auth;

import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kns.kim.permission.PermissionTypeServiceBase;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component("classNameTypeService")
public class ClassNameTypeServiceImpl extends PermissionTypeServiceBase {

    @Override
    protected List<String> getRequiredAttributes() {
        return Collections.singletonList(KcKimAttributes.CLASS_NAME);
    }

    @Override
    protected boolean isCheckRequiredAttributes() {
        return true;
    }

    @Override
    protected boolean performMatch(Map<String, String> inputAttributes, Map<String, String> storedAttributes) {

        if (storedAttributes == null || inputAttributes == null || !storedAttributes.containsKey(KcKimAttributes.CLASS_NAME)) {
            return false;
        }

        final String inputClassName = inputAttributes.get(KcKimAttributes.CLASS_NAME);
        final String storedClassName = storedAttributes.get(KcKimAttributes.CLASS_NAME).replaceAll("\\*", ".*");

        return matches(inputClassName, storedClassName);
    }

    private boolean matches(String s, String regex) {
        return s != null && regex != null && s.matches(regex);
    }
}
