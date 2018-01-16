/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.apache.commons.collections4.CollectionUtils;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubAwardFundingSource extends SubAwardAssociate {

	private static final long serialVersionUID = 1L;
	private static final String AWARD_NUMBER = "awardNumber";
	private static final String AWARD_SEQUENCE_STATUS = "awardSequenceStatus";
	private static final String SEQUENCE_NUMBER = "sequenceNumber";

	private Integer subAwardFundingSourceId;
    private Long subAwardId; 
    private String subAwardCode;
    private Long awardId;

    private String accountNumber;

    private Integer statusCode;

    private String sponsorCode;
    
    private String sponsorName;

    private Award award;

	private transient Award activeAward;

    private ScaleTwoDecimal amountObligatedToDate;

    private Date obligationExpirationDate;

    private String awardNumber;

    private AwardAmountInfo awardAmountInfo;

	private transient BusinessObjectService businessObjectService;

    public SubAwardFundingSource() { 

    }

    public SubAwardFundingSource(Award award) { 
        this();
        this.award = award;
        this.award.setAwardNumber("");
    }

	public Integer getSubAwardFundingSourceId() {
		return subAwardFundingSourceId;
	}

	public void setSubAwardFundingSourceId(Integer subAwardFundingSourceId) {
		this.subAwardFundingSourceId = subAwardFundingSourceId;
	}

	@Override
    public Long getSubAwardId() {
		return subAwardId;
	}

	@Override
    public void setSubAwardId(Long subAwardId) {
		this.subAwardId = subAwardId;
	}

	@Override
    public String getSubAwardCode() {
		return subAwardCode;
	}

	@Override
    public void setSubAwardCode(String subAwardCode) {
		this.subAwardCode = subAwardCode;
	}

	public Long getAwardId() {
		return awardId;
	}

	public void setAwardId(Long awardId) {
		this.awardId = awardId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getSponsorCode() {
		return sponsorCode;
	}

	public void setSponsorCode(String sponsorCode) {
		this.sponsorCode = sponsorCode;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public Award getAward() {
		if ((award == null || award.getAwardId() == null) && awardId != null) {
			refreshReferenceObject("award");
		}

		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public Award getActiveAward() {
		if (getAward() != null) {
			Map<String,Object> criteria = new HashMap<>();
			criteria.put(AWARD_NUMBER, award.getAwardNumber());
			criteria.put(AWARD_SEQUENCE_STATUS, VersionStatus.ACTIVE.toString());
			List<Award> awards = (List<Award>) getBusinessObjectService().findMatchingOrderBy(Award.class, criteria, SEQUENCE_NUMBER, false);
			if (CollectionUtils.isNotEmpty(awards)) {
				activeAward = awards.get(0);
			}
		}
		return activeAward;
	}

	public void setActiveAward(Award activeAward) {
		this.activeAward = activeAward;
	}

	public ScaleTwoDecimal getAmountObligatedToDate() {
		return amountObligatedToDate;
	}

	public void setAmountObligatedToDate(ScaleTwoDecimal amountObligatedToDate) {
		this.amountObligatedToDate = amountObligatedToDate;
	}

	public Date getObligationExpirationDate() {
		return obligationExpirationDate;
	}

	public void setObligationExpirationDate(Date obligationExpirationDate) {
		this.obligationExpirationDate = obligationExpirationDate;
	}

	public String getAwardNumber() {
		return awardNumber;
	}

	public void setAwardNumber(String awardNumber) {
		this.awardNumber = awardNumber;
	}

	public AwardAmountInfo getAwardAmountInfo() {
		return awardAmountInfo;
	}

	public void setAwardAmountInfo(AwardAmountInfo awardAmountInfo) {
		this.awardAmountInfo = awardAmountInfo;
	}

	@Override
    public void resetPersistenceState() {
        this.subAwardFundingSourceId = null;
    }

	protected BusinessObjectService getBusinessObjectService(){
		if (businessObjectService == null) {
			businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
		}
		return businessObjectService;
	}
}
