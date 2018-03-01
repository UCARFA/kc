/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.award.dto;


import com.codiform.moo.annotation.Property;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kuali.coeus.common.api.RateClassDto;
import org.kuali.coeus.common.api.RateTypeDto;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;

public class BudgetRateDto {
    private String activityTypeCode;
    private ScaleTwoDecimal applicableRate;
    private String fiscalYear;
    private Boolean onOffCampusFlag;
    private String rateClassCode;
    @JsonIgnore
    @Property(translate = true)
    private RateClassDto rateClass;
    private String rateTypeCode;
    @JsonIgnore
    @Property(translate = true)
    private RateTypeDto rateType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date startDate;
    private ScaleTwoDecimal instituteRate;


    public String getActivityTypeCode() {
        return activityTypeCode;
    }

    public void setActivityTypeCode(String activityTypeCode) {
        this.activityTypeCode = activityTypeCode;
    }

    public ScaleTwoDecimal getApplicableRate() {
        return applicableRate;
    }

    public void setApplicableRate(ScaleTwoDecimal applicableRate) {
        this.applicableRate = applicableRate;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Boolean getOnOffCampusFlag() {
        return onOffCampusFlag;
    }

    public void setOnOffCampusFlag(Boolean onOffCampusFlag) {
        this.onOffCampusFlag = onOffCampusFlag;
    }

    public String getRateClassCode() {
        return rateClassCode;
    }

    public void setRateClassCode(String rateClassCode) {
        this.rateClassCode = rateClassCode;
    }
    @JsonProperty
    public RateClassDto getRateClass() {
        return rateClass;
    }
    @JsonIgnore
    public void setRateClass(RateClassDto rateClass) {
        this.rateClass = rateClass;
    }

    public String getRateTypeCode() {
        return rateTypeCode;
    }

    public void setRateTypeCode(String rateTypeCode) {
        this.rateTypeCode = rateTypeCode;
    }
    @JsonProperty
    public RateTypeDto getRateType() {
        return rateType;
    }
    @JsonIgnore
    public void setRateType(RateTypeDto rateType) {
        this.rateType = rateType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ScaleTwoDecimal getInstituteRate() {
        return instituteRate;
    }

    public void setInstituteRate(ScaleTwoDecimal instituteRate) {
        this.instituteRate = instituteRate;
    }
}