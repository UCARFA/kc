/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;
import org.kuali.kra.bo.CostShareType;

import java.sql.Date;

public class AwardCostShareDto {

    private Long awardCostShareId;

    private String projectPeriod;

    private ScaleTwoDecimal costSharePercentage;

    private Integer costShareTypeCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date verificationDate;

    private ScaleTwoDecimal costShareMet;

    private String source;

    private String destination;

    private ScaleTwoDecimal commitmentAmount;

    private CostShareType costShareType;

    public Long getAwardCostShareId() {
        return awardCostShareId;
    }

    public void setAwardCostShareId(Long awardCostShareId) {
        this.awardCostShareId = awardCostShareId;
    }

    public String getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(String projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    public ScaleTwoDecimal getCostSharePercentage() {
        return costSharePercentage;
    }

    public void setCostSharePercentage(ScaleTwoDecimal costSharePercentage) {
        this.costSharePercentage = costSharePercentage;
    }

    public Integer getCostShareTypeCode() {
        return costShareTypeCode;
    }

    public void setCostShareTypeCode(Integer costShareTypeCode) {
        this.costShareTypeCode = costShareTypeCode;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public ScaleTwoDecimal getCostShareMet() {
        return costShareMet;
    }

    public void setCostShareMet(ScaleTwoDecimal costShareMet) {
        this.costShareMet = costShareMet;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ScaleTwoDecimal getCommitmentAmount() {
        return commitmentAmount;
    }

    public void setCommitmentAmount(ScaleTwoDecimal commitmentAmount) {
        this.commitmentAmount = commitmentAmount;
    }

    public CostShareType getCostShareType() {
        return costShareType;
    }

    public void setCostShareType(CostShareType costShareType) {
        this.costShareType = costShareType;
    }
}
