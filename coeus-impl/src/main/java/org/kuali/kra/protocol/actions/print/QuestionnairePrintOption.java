/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import java.io.Serializable;

/**
 * 
 * This class is a bean for questionnaire print options.  It is used 
 * Questionnaire print option in protocol print.
 */
public class QuestionnairePrintOption implements Serializable {

    private static final long serialVersionUID = -2388949517675336400L;
    private Long questionnaireId;
    private Integer questionnaireSeqId;
    private String label;
    private String questionnaireName;
    private String itemKey;
    private String subItemKey;
    private String subItemCode;
    private boolean selected;
    private boolean questionnaireActive;

    
    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getSubItemKey() {
        return subItemKey;
    }

    public void setSubItemKey(String subItemKey) {
        this.subItemKey = subItemKey;
    }

    public String getSubItemCode() {
        return subItemCode;
    }

    public void setSubItemCode(String subItemCode) {
        this.subItemCode = subItemCode;
    }

    public Integer getQuestionnaireSeqId() {
        return questionnaireSeqId;
    }

    public void setQuestionnaireSeqId(Integer questionnaireSeqId) {
        this.questionnaireSeqId = questionnaireSeqId;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName;
    }

    public boolean isQuestionnaireActive() {
        return questionnaireActive;
    }

    public void setQuestionnaireActive(boolean questionnaireActive) {
        this.questionnaireActive = questionnaireActive;
    }


}
