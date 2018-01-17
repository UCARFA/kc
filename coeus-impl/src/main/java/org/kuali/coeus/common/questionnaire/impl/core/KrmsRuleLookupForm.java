/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl.core;

import org.kuali.rice.kns.web.struts.form.KualiDocumentFormBase;

public class KrmsRuleLookupForm extends KualiDocumentFormBase  {

    private static final long serialVersionUID = -2680524221259987683L;
    private String ruleId;
    private String fieldId;

    public KrmsRuleLookupForm() {
        super();
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }


}
