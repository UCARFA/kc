/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.question;

import java.util.Objects;
import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class QuestionMultiChoice extends KcPersistableBusinessObjectBase implements SequenceAssociate<Question> {

    private Long id;
    private Long questionId;
    private String prompt;
    private String description;
    private Question sequenceOwner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        QuestionMultiChoice questionMultiChoice = (QuestionMultiChoice) obj;
        if (Objects.equals(this.questionId, questionMultiChoice.questionId) && Objects.equals(this.prompt, questionMultiChoice.prompt) && Objects.equals(this.description, questionMultiChoice.description)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (this.questionId == null ? 0 : this.questionId.hashCode());
        result = PRIME * result + (this.prompt == null ? 0 : this.prompt.hashCode());
        result = PRIME * result + (this.description == null ? 0 : this.description.hashCode());
        return result;
    }

    @Override
    public Question getSequenceOwner() {
        return this.sequenceOwner;
    }

    @Override
    public void setSequenceOwner(Question newlyVersionedOwner) {
        this.sequenceOwner = newlyVersionedOwner;
    }

    @Override
    public Integer getSequenceNumber() {
        return this.sequenceOwner.getSequenceNumber();
    }

    @Override
    public void resetPersistenceState() {
        this.id = null;
    }
}
