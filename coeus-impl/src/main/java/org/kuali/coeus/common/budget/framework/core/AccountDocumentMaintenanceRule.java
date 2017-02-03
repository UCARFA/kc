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
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.ErrorMessage;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.*;

public class AccountDocumentMaintenanceRule extends KcMaintenanceDocumentRuleBase {

    private static final String SOURCE_ACCOUNT_NUMBER = "accountNumber";
    private static final String ACCOUNT_NUMBER_TITLE = "Account number";
    private static final String NAME_KEY = "document.newMaintainableObject.accountNumber";
    public static final String ALPHA_NUMERIC_VALIDATION_PATTERN_KEY = "error.format.org.kuali.rice.kns.datadictionary.validation.charlevel.AlphaNumericValidationPattern";
    public static final String DESCRIPTION_KEY = "document.newMaintainableObject.description";
    public static final String DESCRIPTION = "description";
    private static final String DESCRIPTION_TITLE = "Account description";


    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        Account account = (Account) document.getDocumentBusinessObject();
        final Map<String, List<ErrorMessage>> errorMessages = getGlobalVariableService().getMessageMap().getErrorMessages();

        ArrayList<ErrorMessage> messages = new ArrayList<>();

        if(Objects.nonNull(errorMessages.get(NAME_KEY))) {

            errorMessages.get(NAME_KEY).remove(new ErrorMessage(ALPHA_NUMERIC_VALIDATION_PATTERN_KEY));
            messages.add(new ErrorMessage(KeyConstants.ALPHA_NUMERIC_ALLOW_UNDERSCORE_DASH_WHITESPACE, ACCOUNT_NUMBER_TITLE));
            errorMessages.put(NAME_KEY, messages);
        }

        if(Objects.nonNull(errorMessages.get(DESCRIPTION_KEY))) {
            messages = new ArrayList<>();
            errorMessages.get(DESCRIPTION_KEY).remove(new ErrorMessage(ALPHA_NUMERIC_VALIDATION_PATTERN_KEY));
            messages.add(new ErrorMessage(KeyConstants.ALPHA_NUMERIC_ALLOW_UNDERSCORE_DASH_WHITESPACE_PERIOD, DESCRIPTION_TITLE));
            errorMessages.put(DESCRIPTION_KEY, messages);
        }

        if (!document.getNewMaintainableObject().getMaintenanceAction().equals(KRADConstants.MAINTENANCE_DELETE_ACTION)) {
            return validate(account);
        }
        return Boolean.TRUE;
    }
    
    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        if (!document.getNewMaintainableObject().getMaintenanceAction().equals(KRADConstants.MAINTENANCE_DELETE_ACTION)) {
            Account costShareSourceAccount = (Account) document.getDocumentBusinessObject();
            return validate(costShareSourceAccount);
        }
        return Boolean.TRUE;
    }

    protected boolean validate(Account account) {
        Map<String, String> pk = new HashMap<>();
        pk.put(SOURCE_ACCOUNT_NUMBER, account.getAccountNumber());
        boolean valid = getBoService().countMatching(Account.class, pk) == 0;
        if (!valid) {
            getGlobalVariableService().getMessageMap().putErrorWithoutFullErrorPath(KRADConstants.MAINTENANCE_NEW_MAINTAINABLE + SOURCE_ACCOUNT_NUMBER,
                    RiceKeyConstants.ERROR_DUPLICATE_ELEMENT, ACCOUNT_NUMBER_TITLE,
                    account.getAccountNumber());
        }

        return valid;
    }
}
