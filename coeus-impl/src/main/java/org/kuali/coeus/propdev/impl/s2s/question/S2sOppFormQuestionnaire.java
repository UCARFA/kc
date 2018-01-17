/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.question;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class S2sOppFormQuestionnaire extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -2249378225351572499L;

    private Long s2sOppFormQuestionnaireId;

    private String oppNameSpace;

    private String formName;

    private Long questionnaireId;

    public static final String OPP_NAMESPACE_FIELD = "oppNameSpace";

    public static final String FORM_NAME_FIELD = "formName";

    /**
     * Gets the s2SOppFormQuestionnaireMapId attribute. 
     * @return Returns the s2SOppFormQuestionnaireMapId.
     */
    public Long getS2sOppFormQuestionnaireId() {
        return s2sOppFormQuestionnaireId;
    }

    /**
     * Sets the s2SOppFormQuestionnaireMapId attribute value.
     * @param s2sOppFormQuestionnaireId The s2SOppFormQuestionnaireMapId to set.
     */
    public void setS2sOppFormQuestionnaireId(Long s2sOppFormQuestionnaireId) {
        this.s2sOppFormQuestionnaireId = s2sOppFormQuestionnaireId;
    }

    /**
     * Gets the oppNameSpace attribute. 
     * @return Returns the oppNameSpace.
     */
    public String getOppNameSpace() {
        return oppNameSpace;
    }

    /**
     * Sets the oppNameSpace attribute value.
     * @param oppNameSpace The oppNameSpace to set.
     */
    public void setOppNameSpace(String oppNameSpace) {
        this.oppNameSpace = oppNameSpace;
    }

    /**
     * Gets the formName attribute. 
     * @return Returns the formName.
     */
    public String getFormName() {
        return formName;
    }

    /**
     * Sets the formName attribute value.
     * @param formName The formName to set.
     */
    public void setFormName(String formName) {
        this.formName = formName;
    }

    /**
     * Gets the questionnaireId attribute. 
     * @return Returns the questionnaireId.
     */
    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    /**
     * Sets the questionnaireId attribute value.
     * @param questionnaireId The questionnaireId to set.
     */
    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}
