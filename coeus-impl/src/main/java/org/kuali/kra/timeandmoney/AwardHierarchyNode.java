/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney;

import java.util.Objects;
import org.kuali.kra.award.awardhierarchy.AwardHierarchy;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.sql.Date;

public class AwardHierarchyNode extends AwardHierarchy { 
    
    private Date currentFundEffectiveDate;
    private Date obligationExpirationDate;
    private Date finalExpirationDate;
    private Date projectStartDate;
    private ScaleTwoDecimal anticipatedTotalAmount;
    private ScaleTwoDecimal anticipatedTotalDirect;
    private ScaleTwoDecimal anticipatedTotalIndirect;
    private ScaleTwoDecimal antDistributableAmount;
    private ScaleTwoDecimal amountObligatedToDate;
    private ScaleTwoDecimal obligatedTotalDirect;
    private ScaleTwoDecimal obligatedTotalIndirect;
    private ScaleTwoDecimal obliDistributableAmount;
    private String leadUnitName;
    private String principalInvestigatorName;
    private String accountNumber;
    private Integer awardStatusCode;
    private String title;
    private Long awardId;
    private Boolean awardDocumentFinalStatus;
    private String awardDocumentNumber;
    private Boolean hasChildren;
    
    //transient
    private boolean populatedFromClient;
    

    public AwardHierarchyNode() {
        anticipatedTotalAmount = new ScaleTwoDecimal("0");
        antDistributableAmount = new ScaleTwoDecimal("0");
        amountObligatedToDate = new ScaleTwoDecimal("0");
        obliDistributableAmount = new ScaleTwoDecimal("0");
        anticipatedTotalDirect = new ScaleTwoDecimal("0");
        anticipatedTotalIndirect = new ScaleTwoDecimal("0");
        obligatedTotalDirect = new ScaleTwoDecimal("0");
        obligatedTotalIndirect = new ScaleTwoDecimal("0");
    }

    /**
     * Gets the currentFundEffectiveDate attribute. 
     * @return Returns the currentFundEffectiveDate.
     */
    public Date getCurrentFundEffectiveDate() {
        return currentFundEffectiveDate;
    }

    /**
     * Sets the currentFundEffectiveDate attribute value.
     * @param currentFundEffectiveDate The currentFundEffectiveDate to set.
     */
    public void setCurrentFundEffectiveDate(Date currentFundEffectiveDate) {
        this.currentFundEffectiveDate = currentFundEffectiveDate;
    }

    /**
     * Gets the obligationExpirationDate attribute. 
     * @return Returns the obligationExpirationDate.
     */
    public Date getObligationExpirationDate() {
        return obligationExpirationDate;
    }

    /**
     * Sets the obligationExpirationDate attribute value.
     * @param obligationExpirationDate The obligationExpirationDate to set.
     */
    public void setObligationExpirationDate(Date obligationExpirationDate) {
        this.obligationExpirationDate = obligationExpirationDate;
    }

    /**
     * Gets the finalExpirationDate attribute. 
     * @return Returns the finalExpirationDate.
     */
    public Date getFinalExpirationDate() {
        return finalExpirationDate;
    }

    /**
     * Sets the finalExpirationDate attribute value.
     * @param finalExpirationDate The finalExpirationDate to set.
     */
    public void setFinalExpirationDate(Date finalExpirationDate) {
        this.finalExpirationDate = finalExpirationDate;
    }

    /**
     * Gets the anticipatedTotalAmount attribute. 
     * @return Returns the anticipatedTotalAmount.
     */
    public ScaleTwoDecimal getAnticipatedTotalAmount() {
        if(anticipatedTotalAmount == null){
            setAnticipatedTotalAmount(new ScaleTwoDecimal(0));
        }
        return anticipatedTotalAmount;
    }

    /**
     * Sets the anticipatedTotalAmount attribute value.
     * @param anticipatedTotalAmount The anticipatedTotalAmount to set.
     */
    public void setAnticipatedTotalAmount(ScaleTwoDecimal anticipatedTotalAmount) {
        this.anticipatedTotalAmount = anticipatedTotalAmount;
    }

    /**
     * Gets the antDistributableAmount attribute. 
     * @return Returns the antDistributableAmount.
     */
    public ScaleTwoDecimal getAntDistributableAmount() {
        if(antDistributableAmount == null){
            setAntDistributableAmount(new ScaleTwoDecimal(0));
        }
        return antDistributableAmount;
    }
    
    @Override
    public String getAwardNumber() {
        return super.getAwardNumber();
    }

    /**
     * Sets the antDistributableAmount attribute value.
     * @param antDistributableAmount The antDistributableAmount to set.
     */
    public void setAntDistributableAmount(ScaleTwoDecimal antDistributableAmount) {
        this.antDistributableAmount = antDistributableAmount;
    }

    /**
     * Gets the amountObligatedToDate attribute. 
     * @return Returns the amountObligatedToDate.
     */
    public ScaleTwoDecimal getAmountObligatedToDate() {
        if(amountObligatedToDate == null){
            setAmountObligatedToDate(new ScaleTwoDecimal(0));
        }
        return amountObligatedToDate;
    }

    /**
     * Sets the amountObligatedToDate attribute value.
     * @param amountObligatedToDate The amountObligatedToDate to set.
     */
    public void setAmountObligatedToDate(ScaleTwoDecimal amountObligatedToDate) {
        this.amountObligatedToDate = amountObligatedToDate;
    }

    /**
     * Gets the obliDistributableAmount attribute. 
     * @return Returns the obliDistributableAmount.
     */
    public ScaleTwoDecimal getObliDistributableAmount() {
        if(obliDistributableAmount == null){
            setObliDistributableAmount(new ScaleTwoDecimal(0));
        }
        return obliDistributableAmount;
        //return getAward().calculateObligatedDistributedAmountTotal();
    }

    /**
     * Sets the obliDistributableAmount attribute value.
     * @param obliDistributableAmount The obliDistributableAmount to set.
     */
    public void setObliDistributableAmount(ScaleTwoDecimal obliDistributableAmount) {
        this.obliDistributableAmount = obliDistributableAmount;
    }

    /**
     * Gets the leadUnitName attribute. 
     * @return Returns the leadUnitName.
     */
    public String getLeadUnitName() {
        return leadUnitName;
    }

    /**
     * Sets the leadUnitName attribute value.
     * @param leadUnitName The leadUnitName to set.
     */
    public void setLeadUnitName(String leadUnitName) {
        this.leadUnitName = leadUnitName;
    }

    /**
     * Gets the principalInvestigatorName attribute. 
     * @return Returns the principalInvestigatorName.
     */
    public String getPrincipalInvestigatorName() {
        return principalInvestigatorName;
    }

    /**
     * Sets the principalInvestigatorName attribute value.
     * @param principalInvestigatorName The principalInvestigatorName to set.
     */
    public void setPrincipalInvestigatorName(String principalInvestigatorName) {
        this.principalInvestigatorName = principalInvestigatorName;
    }

    /**
     * Gets the accountNumber attribute. 
     * @return Returns the accountNumber.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the accountNumber attribute value.
     * @param accountNumber The accountNumber to set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the awardStatusCode attribute. 
     * @return Returns the awardStatusCode.
     */
    public Integer getAwardStatusCode() {
        return awardStatusCode;
    }

    /**
     * Sets the awardStatusCode attribute value.
     * @param awardStatusCode The awardStatusCode to set.
     */
    public void setAwardStatusCode(Integer awardStatusCode) {
        this.awardStatusCode = awardStatusCode;
    }

    /**
     * Gets the projectStartDate attribute. 
     * @return Returns the projectStartDate.
     */
    public Date getProjectStartDate() {
        return projectStartDate;
    }

    /**
     * Sets the projectStartDate attribute value.
     * @param projectStartDate The projectStartDate to set.
     */
    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }
    
    

    /**
     * Gets the anticipatedTotalDirect attribute. 
     * @return Returns the anticipatedTotalDirect.
     */
    public ScaleTwoDecimal getAnticipatedTotalDirect() {
        return (anticipatedTotalDirect != null) ? anticipatedTotalDirect : new ScaleTwoDecimal(0.0);
    }

    /**
     * Sets the anticipatedTotalDirect attribute value.
     * @param anticipatedTotalDirect The anticipatedTotalDirect to set.
     */
    public void setAnticipatedTotalDirect(ScaleTwoDecimal anticipatedTotalDirect) {
        this.anticipatedTotalDirect = anticipatedTotalDirect;
    }

    /**
     * Gets the anticipatedTotalIndirect attribute. 
     * @return Returns the anticipatedTotalIndirect.
     */
    public ScaleTwoDecimal getAnticipatedTotalIndirect() {
        return (anticipatedTotalIndirect != null) ? anticipatedTotalIndirect : new ScaleTwoDecimal(0.0);
    }

    /**
     * Sets the anticipatedTotalIndirect attribute value.
     * @param anticipatedTotalIndirect The anticipatedTotalIndirect to set.
     */
    public void setAnticipatedTotalIndirect(ScaleTwoDecimal anticipatedTotalIndirect) {
        this.anticipatedTotalIndirect = anticipatedTotalIndirect;
    }

    /**
     * Gets the obligatedTotalDirect attribute. 
     * @return Returns the obligatedTotalDirect.
     */
    public ScaleTwoDecimal getObligatedTotalDirect() {
        return (obligatedTotalDirect != null) ? obligatedTotalDirect : new ScaleTwoDecimal(0.0);
    }

    /**
     * Sets the obligatedTotalDirect attribute value.
     * @param obligatedTotalDirect The obligatedTotalDirect to set.
     */
    public void setObligatedTotalDirect(ScaleTwoDecimal obligatedTotalDirect) {
        this.obligatedTotalDirect = obligatedTotalDirect;
    }

    /**
     * Gets the obligatedTotalIndirect attribute. 
     * @return Returns the obligatedTotalIndirect.
     */
    public ScaleTwoDecimal getObligatedTotalIndirect() {
        return (obligatedTotalIndirect != null) ? obligatedTotalIndirect : new ScaleTwoDecimal(0.0);
    }

    /**
     * Sets the obligatedTotalIndirect attribute value.
     * @param obligatedTotalIndirect The obligatedTotalIndirect to set.
     */
    public void setObligatedTotalIndirect(ScaleTwoDecimal obligatedTotalIndirect) {
        this.obligatedTotalIndirect = obligatedTotalIndirect;
    }

    /**
     * Gets the title attribute. 
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title attribute value.
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the awardId attribute. 
     * @return Returns the awardId.
     */
    public Long getAwardId() {
        return awardId;
    }

    /**
     * Sets the awardId attribute value.
     * @param awardId The awardId to set.
     */
    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }
    
    public Boolean isAwardDocumentFinalStatus() {
        if(awardDocumentFinalStatus == null){
            setAwardDocumentFinalStatus(new Boolean(false)); 
        }
        return awardDocumentFinalStatus;
    }
    
    public void setAwardDocumentFinalStatus(Boolean awardDocumentStatus) {
        this.awardDocumentFinalStatus = awardDocumentStatus;
    }

    public String getAwardDocumentNumber() {
        return awardDocumentNumber;
    }

    public void setAwardDocumentNumber(String awardDocumentNumber) {
        this.awardDocumentNumber = awardDocumentNumber;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
    
    @Override
    public boolean equals(Object other) {
        return equals((AwardHierarchyNode) other);
    }
    
    /**
     * 
     * This method implements equals using ObjectUtils.equals method for each member variable.
     * @param other
     * @return
     */
    public boolean equals(AwardHierarchyNode other) {
        boolean retVal = other != null && Objects.equals(getCurrentFundEffectiveDate(), other.getCurrentFundEffectiveDate())
                && Objects.equals(obligationExpirationDate, other.getObligationExpirationDate())
                && Objects.equals(finalExpirationDate, other.getFinalExpirationDate())
                && Objects.equals(projectStartDate, other.getProjectStartDate())
                && Objects.equals(anticipatedTotalAmount, other.getAnticipatedTotalAmount())
                && Objects.equals(anticipatedTotalIndirect, other.getAnticipatedTotalIndirect())
                && Objects.equals(anticipatedTotalDirect, other.getAnticipatedTotalDirect())
                && Objects.equals(antDistributableAmount, other.getAntDistributableAmount())
                && Objects.equals(amountObligatedToDate, other.getAmountObligatedToDate())
                && Objects.equals(obligatedTotalDirect, other.getObligatedTotalDirect())
                && Objects.equals(obligatedTotalIndirect, other.getObligatedTotalIndirect())
                && Objects.equals(obliDistributableAmount, other.getObliDistributableAmount())
                && Objects.equals(leadUnitName, other.getLeadUnitName())
                && Objects.equals(principalInvestigatorName, other.getPrincipalInvestigatorName())
                && Objects.equals(accountNumber, other.getAccountNumber())
                && Objects.equals(awardStatusCode, other.getAwardStatusCode())
                && Objects.equals(title, other.getTitle())
                && Objects.equals(awardId, other.getAwardId())
                && Objects.equals(awardDocumentFinalStatus, other.isAwardDocumentFinalStatus())
                && Objects.equals(awardDocumentNumber, other.getAwardDocumentNumber())
                && Objects.equals(getHasChildren(), other.getHasChildren());
        return retVal;
    }

    public boolean isPopulatedFromClient() {
        return populatedFromClient;
    }

    public void setPopulatedFromClient(boolean populatedFromClient) {
        this.populatedFromClient = populatedFromClient;
    }
}
