/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.s2s;


import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.Collections;
import java.util.List;

public class S2sFormConfigRule extends KcMaintenanceDocumentRuleBase {

    private static final String FORM_NAME = "formName";
    private static final String DOCUMENT_NEW_MAINTAINABLE_OBJECT_FORM_NAME = "document.newMaintainableObject.formName";
    private static final String UNIQUE_S2S_FORM_CONFIG_FORM_NAME = "error.unique.s2s.form.config.form.name";

    private DataObjectService dataObjectService;

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        boolean valid = super.processCustomRouteDocumentBusinessRules(document);

        final S2sFormConfiguration s2sFormConfiguration = (S2sFormConfiguration) document.getNewMaintainableObject().getDataObject();

        if (StringUtils.isNotBlank(s2sFormConfiguration.getFormName())
                && !KRADConstants.MAINTENANCE_DELETE_ACTION.equals(document.getNewMaintainableObject().getMaintenanceAction())) {
            final List<S2sFormConfiguration> errors = getDataObjectService().findMatching(S2sFormConfiguration.class,
                    QueryByCriteria.Builder.andAttributes(Collections.singletonMap(FORM_NAME, s2sFormConfiguration.getFormName()))
                            .build())
                    .getResults();
            if (!errors.isEmpty()) {
                final S2sFormConfiguration existingFormConfig = errors.get(0);
                if (existingFormConfig.getFormName().equals(s2sFormConfiguration.getFormName()) && !existingFormConfig.getId().equals(s2sFormConfiguration.getId())) {
                    getGlobalVariableService().getMessageMap().putError(DOCUMENT_NEW_MAINTAINABLE_OBJECT_FORM_NAME,
                            UNIQUE_S2S_FORM_CONFIG_FORM_NAME, "");
                    valid = false;
                }
            }
        }

        return valid;
    }

    public DataObjectService getDataObjectService() {
        if (dataObjectService == null) {
            dataObjectService = KcServiceLocator.getService(DataObjectService.class);
        }

        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }
}
