/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.question;

import java.util.Objects;
import org.kuali.coeus.common.questionnaire.api.question.QuestionExplanationContract;
import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class QuestionExplanation extends KcPersistableBusinessObjectBase implements SequenceAssociate<Question>, QuestionExplanationContract {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long questionId;

    private String explanationType;

    private String explanation;

    private Question sequenceOwner;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public String getExplanationType() {
        return explanationType;
    }

    public void setExplanationType(String explanationType) {
        this.explanationType = explanationType;
    }

    @Override
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
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
        QuestionExplanation questionExplanation = (QuestionExplanation) obj;
        if (Objects.equals(this.questionId, questionExplanation.questionId) && Objects.equals(this.explanationType, questionExplanation.explanationType)) {
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
        result = PRIME * result + (this.explanationType == null ? 0 : this.explanationType.hashCode());
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
