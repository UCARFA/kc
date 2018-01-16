/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.citi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.bo.Training;

public class PersonTrainingCitiMap extends KcPersistableBusinessObjectBase {
    private Long id;
    private String groupId;
    private String stageNumber;
    private Integer trainingCode;
    private Training training;
    private PersonTrainingCitiCourse personTrainingCitiCourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(String stageNumber) {
        this.stageNumber = stageNumber;
    }

    public Integer getTrainingCode() {
        return trainingCode;
    }

    public void setTrainingCode(Integer trainingCode) {
        this.trainingCode = trainingCode;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonTrainingCitiMap)) return false;

        PersonTrainingCitiMap that = (PersonTrainingCitiMap) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (stageNumber != null ? !stageNumber.equals(that.stageNumber) : that.stageNumber != null) return false;
        return trainingCode != null ? trainingCode.equals(that.trainingCode) : that.trainingCode == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (stageNumber != null ? stageNumber.hashCode() : 0);
        result = 31 * result + (trainingCode != null ? trainingCode.hashCode() : 0);
        return result;
    }

    public PersonTrainingCitiCourse getPersonTrainingCitiCourse() {
        return personTrainingCitiCourse;
    }

    public void setPersonTrainingCitiCourse(PersonTrainingCitiCourse personTrainingCitiCourse) {
        this.personTrainingCitiCourse = personTrainingCitiCourse;
    }
}
