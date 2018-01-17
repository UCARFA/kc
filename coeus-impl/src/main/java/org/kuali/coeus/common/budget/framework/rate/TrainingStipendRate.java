/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.rate;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.common.budget.api.rate.TrainingStipendRateContract;

import java.sql.Date;

public class TrainingStipendRate extends KcPersistableBusinessObjectBase implements TrainingStipendRateContract {

    private Long id;

    private String careerLevel;

    private int experienceLevel;

    private ScaleTwoDecimal stipendRate;

    private Date effectiveDate;

    private String description;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCareerLevel() {
        return careerLevel;
    }

    public void setCareerLevel(String level) {
        this.careerLevel = level;
    }

    @Override
    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int level) {
        this.experienceLevel = level;
    }

    @Override
    public ScaleTwoDecimal getStipendRate() {
        return stipendRate;
    }

    public void setStipendRate(ScaleTwoDecimal rate) {
        this.stipendRate = rate;
    }

    @Override
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
