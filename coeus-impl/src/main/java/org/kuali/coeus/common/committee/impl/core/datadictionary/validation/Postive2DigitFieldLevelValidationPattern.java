/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.core.datadictionary.validation;

import org.kuali.rice.krad.datadictionary.validation.FieldLevelValidationPattern;

public class Postive2DigitFieldLevelValidationPattern extends FieldLevelValidationPattern {

    private static final long serialVersionUID = -3023572453587788065L;

    @Override
    protected String getPatternTypeName() {
        return "postivenonzero";
    }
    
    @Override
    protected String getRegexString() {
        return "^[1-9][0-9]?";
    }

}
