/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.validation;

import org.kuali.rice.krad.datadictionary.exporter.ExportMap;
import org.kuali.rice.krad.datadictionary.validation.CharacterLevelValidationPattern;

public class IntegerValidationPattern extends CharacterLevelValidationPattern {
    protected boolean allowNegative;
    protected boolean onlyNegative;
    protected boolean omitZero;

    @Override
    protected String getRegexString() {
        StringBuffer regex = new StringBuffer();

        if (isAllowNegative() && !isOnlyNegative()) {
            regex.append("((-?");
        } else if (isOnlyNegative()) {
            regex.append("((-");
        } else {
            regex.append("((");
        }
        if (isOmitZero()) {
            regex.append("[1-9][0-9]*))");
        } else {
            regex.append("[1-9][0-9]*)|[0]*)");
        }

        return regex.toString();
    }

    @Override
    public void extendExportMap(ExportMap exportMap) {
        exportMap.set("type", "numeric");
    }

    public boolean isAllowNegative() {
        return allowNegative;
    }

    public void setAllowNegative(boolean allowNegative) {
        this.allowNegative = allowNegative;
    }

    public boolean isOnlyNegative() {
        return onlyNegative;
    }

    public void setOnlyNegative(boolean onlyNegative) {
        this.onlyNegative = onlyNegative;
    }

    public boolean isOmitZero() {
        return omitZero;
    }

    public void setOmitZero(boolean omitZero) {
        this.omitZero = omitZero;
    }
}
