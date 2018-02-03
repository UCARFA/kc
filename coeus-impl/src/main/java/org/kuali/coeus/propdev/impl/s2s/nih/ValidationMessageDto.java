/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.s2s.nih;

import java.util.Objects;

public class ValidationMessageDto {

    private String validationSubApplicationGroupID;
    private String validationSubApplicationID;
    private String validationRuleNumber;
    private String validationSeverityCode;
    private String validationMessageText;
    private int validationMessageId;
    private String formName;

    public String getValidationSubApplicationGroupID() {
        return validationSubApplicationGroupID;
    }

    public void setValidationSubApplicationGroupID(String validationSubApplicationGroupID) {
        this.validationSubApplicationGroupID = validationSubApplicationGroupID;
    }

    public String getValidationSubApplicationID() {
        return validationSubApplicationID;
    }

    public void setValidationSubApplicationID(String validationSubApplicationID) {
        this.validationSubApplicationID = validationSubApplicationID;
    }

    public String getValidationRuleNumber() {
        return validationRuleNumber;
    }

    public void setValidationRuleNumber(String validationRuleNumber) {
        this.validationRuleNumber = validationRuleNumber;
    }

    public String getValidationSeverityCode() {
        return validationSeverityCode;
    }

    public void setValidationSeverityCode(String validationSeverityCode) {
        this.validationSeverityCode = validationSeverityCode;
    }

    public String getValidationMessageText() {
        return validationMessageText;
    }

    public void setValidationMessageText(String validationMessageText) {
        this.validationMessageText = validationMessageText;
    }

    public int getValidationMessageId() {
        return validationMessageId;
    }

    public void setValidationMessageId(int validationMessageId) {
        this.validationMessageId = validationMessageId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationMessageDto that = (ValidationMessageDto) o;
        return validationMessageId == that.validationMessageId &&
                Objects.equals(validationSubApplicationGroupID, that.validationSubApplicationGroupID) &&
                Objects.equals(validationSubApplicationID, that.validationSubApplicationID) &&
                Objects.equals(validationRuleNumber, that.validationRuleNumber) &&
                Objects.equals(validationSeverityCode, that.validationSeverityCode) &&
                Objects.equals(validationMessageText, that.validationMessageText) &&
                Objects.equals(formName, that.formName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(validationSubApplicationGroupID, validationSubApplicationID, validationRuleNumber, validationSeverityCode, validationMessageText, validationMessageId, formName);
    }
}
