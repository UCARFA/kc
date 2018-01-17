/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.subcontracting.reporting;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.sql.Date;

// this is a read-only access BO that will be used in computing the expenditure data for small business contracting reports
public class SubcontractingExpenditureCategoryDetails extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = 8329712110358616261L;
    
    private Long id;
    private String awardNumber;
    private ScaleTwoDecimal amount;
    private Date fiscalPeriod;
    
    private boolean largeBusiness;
    private boolean smallBusiness;
    
    private boolean womanOwned;
    private boolean eightADisadvantage; 
    private boolean hubZone;
    private boolean veteranOwned; 
    private boolean serviceDisabledVeteranOwned; 
    private boolean historicalBlackCollege;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAmount(ScaleTwoDecimal amount) {
        this.amount = amount;
    }

    public ScaleTwoDecimal getAmount() {
        return amount;
    }

    public void setFiscalPeriod(Date fiscalPeriod) {
        this.fiscalPeriod = fiscalPeriod;
    }

    public Date getFiscalPeriod() {
        return fiscalPeriod;
    }

    public void setLargeBusiness(boolean largeBusiness) {
        this.largeBusiness = largeBusiness;
    }

    public boolean isLargeBusiness() {
        return largeBusiness;
    }

    public void setSmallBusiness(boolean smallBusiness) {
        this.smallBusiness = smallBusiness;
    }

    public boolean isSmallBusiness() {
        return smallBusiness;
    }

    public void setWomanOwned(boolean womanOwned) {
        this.womanOwned = womanOwned;
    }

    public boolean isWomanOwned() {
        return womanOwned;
    }

    public void setEightADisadvantage(boolean eightADisadvantage) {
        this.eightADisadvantage = eightADisadvantage;
    }

    public boolean isEightADisadvantage() {
        return eightADisadvantage;
    }

    public void setHubZone(boolean hubZone) {
        this.hubZone = hubZone;
    }

    public boolean isHubZone() {
        return hubZone;
    }

    public void setVeteranOwned(boolean veteranOwned) {
        this.veteranOwned = veteranOwned;
    }

    public boolean isVeteranOwned() {
        return veteranOwned;
    }

    public void setServiceDisabledVeteranOwned(boolean serviceDisabledVeteranOwned) {
        this.serviceDisabledVeteranOwned = serviceDisabledVeteranOwned;
    }

    public boolean isServiceDisabledVeteranOwned() {
        return serviceDisabledVeteranOwned;
    }

    public void setHistoricalBlackCollege(boolean historicalBlackCollege) {
        this.historicalBlackCollege = historicalBlackCollege;
    }

    public boolean isHistoricalBlackCollege() {
        return historicalBlackCollege;
    }

    
}
