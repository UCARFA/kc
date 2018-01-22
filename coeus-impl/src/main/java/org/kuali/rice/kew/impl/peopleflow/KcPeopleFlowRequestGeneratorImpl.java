/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.rice.kew.impl.peopleflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kuali.coeus.common.framework.workflow.KcAttributeCapablePeopleFlowTypeService;
import org.kuali.rice.kew.api.document.Document;
import org.kuali.rice.kew.api.document.DocumentContent;
import org.kuali.rice.kew.framework.peopleflow.PeopleFlowTypeService;
import org.kuali.rice.kew.routeheader.DocumentRouteHeaderValue;
import org.kuali.rice.kew.routeheader.DocumentRouteHeaderValueContent;

public class KcPeopleFlowRequestGeneratorImpl extends PeopleFlowRequestGeneratorImpl {


    @Override
    protected List<Map<String, String>> loadRoleQualifiers(Context context, String roleId) {
        PeopleFlowTypeService peopleFlowTypeService = context.getPeopleFlowTypeService();
        List<Map<String, String>> roleQualifierList = new ArrayList<Map<String, String>>();

        if (peopleFlowTypeService instanceof KcAttributeCapablePeopleFlowTypeService) {
            Document document = DocumentRouteHeaderValue.to(context.getRouteContext().getDocument());
            DocumentRouteHeaderValueContent content = new DocumentRouteHeaderValueContent(document.getDocumentId());
            content.setDocumentContent(context.getRouteContext().getDocumentContent().getDocContent());
            DocumentContent documentContent = DocumentRouteHeaderValueContent.to(content);

            Map<String, String> roleQualifiers = ((KcAttributeCapablePeopleFlowTypeService) peopleFlowTypeService).resolveRoleQualifiers(
                    context.getPeopleFlow(), roleId, document, documentContent);
            if (roleQualifiers != null) {
                roleQualifierList.add(roleQualifiers);
            }
        }
        roleQualifierList.addAll(super.loadRoleQualifiers(context, roleId));

        return roleQualifierList;
    }

}
