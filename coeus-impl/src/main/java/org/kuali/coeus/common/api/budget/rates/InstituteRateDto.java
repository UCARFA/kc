/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api.budget.rates;

import java.util.Date;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import com.codiform.moo.annotation.Property;

public class InstituteRateDto {

	private Long id;
    private String fiscalYear;
    private Boolean onOffCampusFlag;
    private String rateClassCode;
    private String rateTypeCode;
    @Property(translate = true)
    private Date startDate;
    private ScaleTwoDecimal instituteRate;
    private String unitNumber;
	private String activityTypeCode;
	
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
	public String getRateTypeCode() {
		return rateTypeCode;
	}
	public void setRateTypeCode(String rateTypeCode) {
		this.rateTypeCode = rateTypeCode;
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
	public String getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	public String getActivityTypeCode() {
		return activityTypeCode;
	}
	public void setActivityTypeCode(String activityTypeCode) {
		this.activityTypeCode = activityTypeCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
