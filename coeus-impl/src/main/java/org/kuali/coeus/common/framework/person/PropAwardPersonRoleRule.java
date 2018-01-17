/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person;


import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcKradMaintenanceDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.maintenance.MaintenanceDocument;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.List;

import static org.kuali.rice.core.api.criteria.PredicateFactory.equal;

public class PropAwardPersonRoleRule extends KcKradMaintenanceDocumentRuleBase {
    private static final String UNIQUE_PERSON_ROLE_ENTRY = "error.unique.person.role.entry";

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        boolean valid = super.processCustomRouteDocumentBusinessRules(document);

        final PropAwardPersonRole propAwardPersonRole = (PropAwardPersonRole) document.getNewMaintainableObject().getDataObject();

        if (PropAwardPersonRole.PI_CODE.equals(propAwardPersonRole.getCode())  ||
                PropAwardPersonRole.COI_CODE.equals(propAwardPersonRole.getCode()) ||
                PropAwardPersonRole.MULTI_PI.equals(propAwardPersonRole.getCode())) {
            if (UnitPopulationBehavior.NONE.getCode().equals(propAwardPersonRole.getAutoPopulateUnitsCode())) {
                putFieldError("dataObject.autoPopulateUnitsCode", KeyConstants.ERROR_INVESTIGATOR_HOME_UNIT_REQUIRED);
                valid = false;
            }
        }

        if (StringUtils.isNotBlank(propAwardPersonRole.getCode())
                && StringUtils.isNotBlank(propAwardPersonRole.getSponsorHierarchyName())
                && !KRADConstants.MAINTENANCE_EDIT_ACTION.equals(document.getNewMaintainableObject().getMaintenanceAction())
                && !KRADConstants.MAINTENANCE_DELETE_ACTION.equals(document.getNewMaintainableObject().getMaintenanceAction())) {


            final List<PropAwardPersonRole> existingPropAwardPersonRoles = getDataObjectService().findMatching(PropAwardPersonRole.class,
                    QueryByCriteria.Builder.fromPredicates(
                            equal("code", propAwardPersonRole.getCode()),
                            equal("sponsorHierarchyName", propAwardPersonRole.getSponsorHierarchyName())
                    )).getResults();


            if (!existingPropAwardPersonRoles.isEmpty()) {
                getGlobalVariableService().getMessageMap().putError("document.newMaintainableObject.dataObject.code", UNIQUE_PERSON_ROLE_ENTRY, "");
                valid = false;
            }
        }

        return valid;
    }
}
