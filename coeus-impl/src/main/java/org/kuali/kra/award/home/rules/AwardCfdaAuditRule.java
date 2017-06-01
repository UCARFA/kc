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
package org.kuali.kra.award.home.rules;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;

import java.util.ArrayList;
import java.util.List;

public class AwardCfdaAuditRule implements DocumentAuditRule {

    public static final String HOME_PAGE_AUDIT_WARNINGS = "homePageAuditWarnings";
    private GlobalVariableService globalVariableService;

    @Override
    public boolean processRunAuditBusinessRules(Document document) {
        AwardDocument awardDocument = (AwardDocument) document;
        final String cfdaNumber = awardDocument.getAward().getCfdaNumber();
        if(!isValidCfda(cfdaNumber)) {
            getAuditWarnings(HOME_PAGE_AUDIT_WARNINGS, Constants.AUDIT_WARNINGS).add(
                    new AuditError(Constants.DOCUMENT_AWARD_CFDA_NUMBER, KeyConstants.CFDA_INVALID,
                            Constants.MAPPING_AWARD_HOME_PAGE + "." + Constants.MAPPING_AWARD_HOME_DETAILS_AND_DATES_PAGE_ANCHOR, new String[]{cfdaNumber}));

        }
        return true;
    }

    public boolean isValidCfda(String cfdaNumber) {
        return StringUtils.isBlank(cfdaNumber) || cfdaNumber.matches(Constants.CFDA_REGEX);
    }

    protected List<AuditError> getAuditWarnings(String key, String severity) {
        if (!getGlobalVariableService().getAuditErrorMap().containsKey(key)) {
            getGlobalVariableService().getAuditErrorMap().put(key, new AuditCluster(Constants.MAPPING_AWARD_HOME_DETAILS_AND_DATES_PAGE_NAME, new ArrayList<AuditError>(), severity));
        }
        return getGlobalVariableService().getAuditErrorMap().get(key).getAuditErrorList();

    }

    public GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }
        return globalVariableService;
    }

}
