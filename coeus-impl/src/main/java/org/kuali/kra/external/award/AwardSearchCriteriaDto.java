/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.award;

public class AwardSearchCriteriaDto {

	private String awardId;
	private String awardNumber;
	private String accountNumber;
	private String chartOfAccounts;
	private String principalInvestigatorId;
	private String sponsorCode;
	private String startDate;
	private String startDateLowerBound;
	private String endDate;
	private String endDateLowerBound;
	private String billingFrequency;
	private String awardTotal;

	public String getAwardId() {
		return awardId;
	}
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	public String getAwardNumber() {
		return awardNumber;
	}
	public void setAwardNumber(String awardNumber) {
		this.awardNumber = awardNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getChartOfAccounts() {
		return chartOfAccounts;
	}
	public void setChartOfAccounts(String chartOfAccounts) {
		this.chartOfAccounts = chartOfAccounts;
	}
    public String getPrincipalInvestigatorId() {
        return principalInvestigatorId;
    }
    public void setPrincipalInvestigatorId(String principalInvestigatorId) {
        this.principalInvestigatorId = principalInvestigatorId;
    }
	public String getSponsorCode() {
		return sponsorCode;
	}
	public void setSponsorCode(String sponsorCode) {
		this.sponsorCode = sponsorCode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBillingFrequency() {
		return billingFrequency;
	}
	public void setBillingFrequency(String billingFrequency) {
		this.billingFrequency = billingFrequency;
	}
	public String getAwardTotal() {
		return awardTotal;
	}
	public void setAwardTotal(String awardTotal) {
		this.awardTotal = awardTotal;
	}
	public String getStartDateLowerBound() {
		return startDateLowerBound;
	}
	public void setStartDateLowerBound(String startDateLowerBound) {
		this.startDateLowerBound = startDateLowerBound;
	}
	public String getEndDateLowerBound() {
		return endDateLowerBound;
	}
	public void setEndDateLowerBound(String endDateLowerBound) {
		this.endDateLowerBound = endDateLowerBound;
	}
}
