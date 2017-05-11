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
package org.kuali.coeus.propdev.impl.s2s.nih;


import gov.nih.era.svs.types.ValidationMessage;
import org.apache.commons.lang3.StringUtils;

public final class NihValidationServiceUtils {

    private static final String STACKTRACE_START = "[gov.nih.era.svs.servicehandler.service.SVSServiceImpl.";
    private static final String MSG_DELIMETER = " - ";

    private NihValidationServiceUtils() {
        throw new UnsupportedOperationException("do not call");
    }

    public static String toMessageString(ValidationMessage message) {
        String msg = StringUtils.replaceChars(StringUtils.replaceChars(message.getValidationMessageText(), StringUtils.LF, ""), StringUtils.CR, "");
        if (message.getValidationMessageText().contains(STACKTRACE_START)) {
            msg = message.getValidationMessageText().substring(0, message.getValidationMessageText().indexOf(STACKTRACE_START));
        }

        return (StringUtils.isNotBlank(message.getFormName()) ? (message.getFormName() + MSG_DELIMETER) : "") +
                (StringUtils.isNotBlank(message.getValidationRuleNumber()) ? (message.getValidationRuleNumber() + MSG_DELIMETER) : "") +
                message.getValidationMessageId() + MSG_DELIMETER + msg;
    }
}
