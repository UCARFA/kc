/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.kra.bo.Training;

import java.sql.Timestamp;

public class PersonTraining extends KcPersistableBusinessObjectBase implements MutableInactivatable {

    private Integer personTrainingId;

    private String personId;

    private Integer trainingNumber;

    private Integer trainingCode;

    private Timestamp dateRequested;

    private Timestamp dateSubmitted;

    private Timestamp dateAcknowledged;

    private Timestamp followupDate;

    private String score;

    private String comments;

    private boolean active;

    private Training training;

    private transient KcPersonService kcPersonService;

    public PersonTraining() {
    }

    public Integer getPersonTrainingId() {
        return personTrainingId;
    }

    public void setPersonTrainingId(Integer personTrainingId) {
        this.personTrainingId = personTrainingId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getTrainingNumber() {
        return trainingNumber;
    }

    public void setTrainingNumber(Integer trainingNumber) {
        this.trainingNumber = trainingNumber;
    }

    public Integer getTrainingCode() {
        return trainingCode;
    }

    public void setTrainingCode(Integer trainingCode) {
        this.trainingCode = trainingCode;
    }

    public Timestamp getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Timestamp dateRequested) {
        this.dateRequested = dateRequested;
    }

    public Timestamp getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Timestamp dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public Timestamp getDateAcknowledged() {
        return dateAcknowledged;
    }

    public void setDateAcknowledged(Timestamp dateAcknowledged) {
        this.dateAcknowledged = dateAcknowledged;
    }

    public Timestamp getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(Timestamp followupDate) {
        this.followupDate = followupDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public KcPerson getPerson() {
        return getKcPersonService().getKcPersonByPersonId(personId);
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    protected KcPersonService getKcPersonService() {
        if (this.kcPersonService == null) {
            this.kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        }
        return this.kcPersonService;
    }
}
