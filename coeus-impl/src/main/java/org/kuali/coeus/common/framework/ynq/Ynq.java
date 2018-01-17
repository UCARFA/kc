/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.ynq;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.kuali.coeus.common.api.ynq.YnqContract;
import org.kuali.kra.bo.KraSortablePersistableBusinessObjectBase;

@Entity
@Table(name = "YNQ")
public class Ynq extends KraSortablePersistableBusinessObjectBase implements YnqContract {

    @Id
    @Column(name = "QUESTION_ID")
    private String questionId;

    @Column(name = "DATE_REQUIRED_FOR")
    private String dateRequiredFor;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;

    @Column(name = "EXPLANATION_REQUIRED_FOR")
    private String explanationRequiredFor;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "NO_OF_ANSWERS")
    private Integer noOfAnswers;

    @Column(name = "QUESTION_TYPE")
    private String questionType;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(orphanRemoval = true, cascade = { CascadeType.ALL })
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID")
    private List<YnqExplanation> ynqExplanations;

    public Ynq() {
        super();
        ynqExplanations = new ArrayList<YnqExplanation>();
    }

    @Override
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public String getDateRequiredFor() {
        return dateRequiredFor;
    }

    public void setDateRequiredFor(String dateRequiredFor) {
        this.dateRequiredFor = dateRequiredFor;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String getExplanationRequiredFor() {
        return explanationRequiredFor;
    }

    public void setExplanationRequiredFor(String explanationRequiredFor) {
        this.explanationRequiredFor = explanationRequiredFor;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public Integer getNoOfAnswers() {
        return noOfAnswers;
    }

    public void setNoOfAnswers(Integer noOfAnswers) {
        this.noOfAnswers = noOfAnswers;
    }

    @Override
    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public List<YnqExplanation> getYnqExplanations() {
        return ynqExplanations;
    }

    public void setYnqExplanations(List<YnqExplanation> ynqExplanations) {
        this.ynqExplanations = ynqExplanations;
    }
}
