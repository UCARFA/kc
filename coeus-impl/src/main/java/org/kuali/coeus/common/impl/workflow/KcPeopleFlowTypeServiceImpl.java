/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.workflow;

import org.kuali.rice.core.api.exception.RiceIllegalArgumentException;
import org.kuali.rice.core.api.uif.RemotableAttributeError;
import org.kuali.rice.core.api.uif.RemotableAttributeField;
import org.kuali.rice.kew.api.document.Document;
import org.kuali.rice.kew.api.document.DocumentContent;
import org.kuali.rice.kew.framework.peopleflow.PeopleFlowTypeService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component("kcPeopleFlowTypeService")
public class KcPeopleFlowTypeServiceImpl implements PeopleFlowTypeService {

    @Override
    public List<String> filterToSelectableRoleIds(String kewTypeId, List<String> roleIds) {

        return roleIds;
    }

    @Override
    public Map<String, String> resolveRoleQualifiers(String kewTypeId, String roleId, Document document,
            DocumentContent documentContent) {

        return null;
    }

    @Override
    public List<RemotableAttributeField> getAttributeFields(String kewTypeId) {

        return Collections.emptyList();
    }

    @Override
    public List<RemotableAttributeError> validateAttributes(String kewTypeId, Map<String, String> attributes)
            throws RiceIllegalArgumentException {

        return Collections.emptyList();
    }

    @Override
    public List<RemotableAttributeError> validateAttributesAgainstExisting(String kewTypeId, Map<String, String> newAttributes,
            Map<String, String> oldAttributes) throws RiceIllegalArgumentException {

        return Collections.emptyList();
    }

    @Override
    public List<Map<String, String>> resolveMultipleRoleQualifiers(String arg0, String arg1, Document arg2, DocumentContent arg3) {
        return null;
    }

}
