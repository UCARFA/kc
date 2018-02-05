/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.nih;

import org.apache.commons.lang3.StringUtils;

public final class NihValidationServiceUtils {

    private static final String STACKTRACE_START = "[gov.nih.era.svs.servicehandler.service.SVSServiceImpl.";
    private static final String MSG_DELIMETER = " - ";

    private NihValidationServiceUtils() {
        throw new UnsupportedOperationException("do not call");
    }

    public static String toMessageString(ValidationMessageDto message) {
        String msg = StringUtils.replaceChars(StringUtils.replaceChars(message.getValidationMessageText(), StringUtils.LF, " "), StringUtils.CR, "");
        if (message.getValidationMessageText().contains(STACKTRACE_START)) {
            msg = message.getValidationMessageText().substring(0, message.getValidationMessageText().indexOf(STACKTRACE_START));
        }

        return (StringUtils.isNotBlank(message.getFormName()) ? (message.getFormName() + MSG_DELIMETER) : "") +
                (StringUtils.isNotBlank(message.getValidationRuleNumber()) ? (message.getValidationRuleNumber() + MSG_DELIMETER) : "") +
                message.getValidationMessageId() + MSG_DELIMETER + msg;
    }
}
