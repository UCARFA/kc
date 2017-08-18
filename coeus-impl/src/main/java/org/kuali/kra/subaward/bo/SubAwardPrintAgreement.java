/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.rice.krad.bo.BusinessObjectBase;

public class SubAwardPrintAgreement extends BusinessObjectBase{

    private String fdpAgreement;
    private String fdpModification;
    private String fundingSource;
    private String subawardTemplateAttachment;
    private Boolean selectToPrint;
    private Boolean attachment3A;
    private Boolean attachment3BPage2;
    private Boolean attachment3B;
    private Boolean attachment4;
    private String awardNo;
    private String fdpType;
    private Boolean afosrSponsor;
    private Boolean amrmcSponsor;
    private Boolean amraaSponsor;
    private Boolean aroSponsor;
    private Boolean doeSponsor;
    private Boolean epaSponsor;
    private Boolean nasaSponsor;
    private Boolean nihSponsor;
    private Boolean nsfSponsor;
    private Boolean onrSponsor;
    private Boolean usdaSponsor;

    public Boolean getAttachment4() {
        return attachment4;
    }

    public void setAttachment4(Boolean attachment4) {
        this.attachment4 = attachment4;
    }

    public Boolean getAttachment3A() {
        return attachment3A;
    }

    public void setAttachment3A(Boolean attachment3a) {
        attachment3A = attachment3a;
    }

    public Boolean getAttachment3BPage2() {
        return attachment3BPage2;
    }

    public void setAttachment3BPage2(Boolean attachment3bPage2) {
        attachment3BPage2 = attachment3bPage2;
    }

    public Boolean getAttachment3B() {
        return attachment3B;
    }

    public void setAttachment3B(Boolean attachment3b) {
        attachment3B = attachment3b;
    }

    
    public SubAwardPrintAgreement() {
        initialize();
    }     

    public void initialize() {
        setFdpType("fdpAgreement");        
    }

    public String getFdpType() {
        return fdpType;
    }

    public void setFdpType(String fdpType) {
        this.fdpType = fdpType;
    }

    public String getAwardNo() {
        return awardNo;
    }

    public void setAwardNo(String awardNo) {
        this.awardNo = awardNo;
    }

    public String getFdpAgreement() {
        return fdpAgreement;
    }

    public void setFdpAgreement(String fdpAgreement) {
        this.fdpAgreement = fdpAgreement;
    }

    public String getFdpModification() {
        return fdpModification;
    }

    public void setFdpModification(String fdpModification) {
        this.fdpModification = fdpModification;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public String getSubawardTemplateAttachment() {
        return subawardTemplateAttachment;
    }

    public void setSubawardTemplateAttachment(String subawardTemplateAttachment) {
        this.subawardTemplateAttachment = subawardTemplateAttachment;
    }

    public Boolean getSelectToPrint() {
        return selectToPrint;
    }

    public void setSelectToPrint(Boolean selectToPrint) {
        this.selectToPrint = selectToPrint;
    }

    private void setAllItems(Boolean value) {
        attachment3A = true;
        attachment3BPage2 = true;
        attachment3B = true;
    }

    public Boolean getAfosrSponsor() {
        return afosrSponsor;
    }

    public void setAfosrSponsor(Boolean afosrSponsor) {
        this.afosrSponsor = afosrSponsor;
    }

    public Boolean getAmrmcSponsor() {
        return amrmcSponsor;
    }

    public void setAmrmcSponsor(Boolean amrmcSponsor) {
        this.amrmcSponsor = amrmcSponsor;
    }

    public Boolean getAmraaSponsor() {
        return amraaSponsor;
    }

    public void setAmraaSponsor(Boolean amraaSponsor) {
        this.amraaSponsor = amraaSponsor;
    }

    public Boolean getAroSponsor() {
        return aroSponsor;
    }

    public void setAroSponsor(Boolean aroSponsor) {
        this.aroSponsor = aroSponsor;
    }

    public Boolean getDoeSponsor() {
        return doeSponsor;
    }

    public void setDoeSponsor(Boolean doeSponsor) {
        this.doeSponsor = doeSponsor;
    }

    public Boolean getEpaSponsor() {
        return epaSponsor;
    }

    public void setEpaSponsor(Boolean epaSponsor) {
        this.epaSponsor = epaSponsor;
    }

    public Boolean getNasaSponsor() {
        return nasaSponsor;
    }

    public void setNasaSponsor(Boolean nasaSponsor) {
        this.nasaSponsor = nasaSponsor;
    }

    public Boolean getNihSponsor() {
        return nihSponsor;
    }

    public void setNihSponsor(Boolean nihSponsor) {
        this.nihSponsor = nihSponsor;
    }

    public Boolean getNsfSponsor() {
        return nsfSponsor;
    }

    public void setNsfSponsor(Boolean nsfSponsor) {
        this.nsfSponsor = nsfSponsor;
    }

    public Boolean getOnrSponsor() {
        return onrSponsor;
    }

    public void setOnrSponsor(Boolean onrSponsor) {
        this.onrSponsor = onrSponsor;
    }

    public Boolean getUsdaSponsor() {
        return usdaSponsor;
    }

    public void setUsdaSponsor(Boolean usdaSponsor) {
        this.usdaSponsor = usdaSponsor;
    }

    public void selectAllItems() {
        setAllItems(true);
    }

    public void deselectAllItems() {
        setAllItems(false);
    }

    @Override
    public void refresh() {
        //no op
    }
}
