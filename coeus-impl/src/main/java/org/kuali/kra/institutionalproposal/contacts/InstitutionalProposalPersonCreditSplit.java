/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.coeus.propdev.impl.person.creditsplit.CreditSplit;
import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.HashMap;
import java.util.Map;

public class InstitutionalProposalPersonCreditSplit extends KcPersistableBusinessObjectBase implements CreditSplit, SequenceAssociate<InstitutionalProposal> {


    private static final long serialVersionUID = 994819927148154584L;

    private static final String INV_CREDIT_TYPE_CODE_FIELD_NAME = "code";

    private Long institutionalProposalPersonCreditSplitId;

    private InstitutionalProposalPerson institutionalProposalPerson;

    private ScaleTwoDecimal credit;

    private InvestigatorCreditType investigatorCreditType;

    // OJB Hacks  
    private String invCreditTypeCode;

    private Long institutionalProposalContactId;


    public InstitutionalProposalPersonCreditSplit() {
    }

    InstitutionalProposalPersonCreditSplit(InvestigatorCreditType investigatorCreditType, ScaleTwoDecimal credit) {
        setInvestigatorCreditType(investigatorCreditType);
        setCredit(credit);
    }

    /**
     * Gets the institutionalProposalContactId attribute. 
     * @return Returns the institutionalProposalContactId.
     */
    public Long getInstitutionalProposalContactId() {
        return institutionalProposalContactId;
    }

    /**
     * Gets the institutionalProposalPerson attribute. 
     * @return Returns the institutionalProposalPerson.
     */
    public InstitutionalProposalPerson getInstitutionalProposalPerson() {
        return institutionalProposalPerson;
    }

    /**
     * Gets the institutionalProposalPersonCreditSplitId attribute. 
     * @return Returns the institutionalProposalPersonCreditSplitId.
     */
    public Long getInstitutionalProposalPersonCreditSplitId() {
        return institutionalProposalPersonCreditSplitId;
    }

    /**
     * Gets the value of credit
     *
     * @return the value of credit
     */
    @Override
    public ScaleTwoDecimal getCredit() {
        return this.credit != null ? this.credit : new ScaleTwoDecimal(0);
    }

    /**
     * Gets the value of invCreditTypeCode
     *
     * @return the value of invCreditTypeCode
     */
    @Override
    public String getInvCreditTypeCode() {
        refreshInvestigatorCreditTypeIfNeeded();
        return invCreditTypeCode;
    }

    /**
     * Gets the investigatorCreditType attribute. 
     * @return Returns the investigatorCreditType.
     */
    public InvestigatorCreditType getInvestigatorCreditType() {
        refreshInvestigatorCreditTypeIfNeeded();
        return investigatorCreditType;
    }

    /**
     * Sets the institutionalProposalContactId attribute value.
     * @param institutionalProposalContactId The institutionalProposalContactId to set.
     */
    public void setInstitutionalProposalContactId(Long institutionalProposalContactId) {
        this.institutionalProposalContactId = institutionalProposalContactId;
    }

    /**
     * Sets the institutionalProposalPerson attribute value.
     * @param institutionalProposalPerson The institutionalProposalPerson to set.
     */
    public void setInstitutionalProposalPerson(InstitutionalProposalPerson institutionalProposalPerson) {
        this.institutionalProposalPerson = institutionalProposalPerson;
        this.institutionalProposalContactId = institutionalProposalPerson != null ? institutionalProposalPerson.getInstitutionalProposalContactId() : null;
    }

    /**
     * Sets the institutionalProposalPersonCreditSplitId attribute value.
     * @param institutionalProposalPersonCreditSplitId The institutionalProposalPersonCreditSplitId to set.
     */
    public void setInstitutionalProposalPersonCreditSplitId(Long institutionalProposalPersonCreditSplitId) {
        this.institutionalProposalPersonCreditSplitId = institutionalProposalPersonCreditSplitId;
    }

    /**
     * Sets the value of credit
     *
     * @param argCredit Value to assign to this.credit
     */
    @Override
    public void setCredit(ScaleTwoDecimal argCredit) {
        this.credit = argCredit;
    }

    /**
     * Sets the value of invCreditTypeCode
     *
     * @param argInvCreditTypeCode Value to assign to this.invCreditTypeCode
     */
    @Override
    public void setInvCreditTypeCode(String argInvCreditTypeCode) {
        this.invCreditTypeCode = argInvCreditTypeCode;
    }

    /**
     * Sets the investigatorCreditType attribute value.
     * @param investigatorCreditType The investigatorCreditType to set.
     */
    public void setInvestigatorCreditType(InvestigatorCreditType investigatorCreditType) {
        this.investigatorCreditType = investigatorCreditType;
        this.invCreditTypeCode = investigatorCreditType != null ? investigatorCreditType.getCode() : null;
    }


    protected BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }

    /**
     * This method lazy-loads the InvestigatorCreditType
     */
    private void refreshInvestigatorCreditTypeIfNeeded() {
        if (invCreditTypeCode != null && (investigatorCreditType == null || !invCreditTypeCode.equals(investigatorCreditType.getCode()))) {
            Map<String, Object> keyMap = new HashMap<String, Object>();
            keyMap.put(INV_CREDIT_TYPE_CODE_FIELD_NAME, invCreditTypeCode);
            investigatorCreditType = (InvestigatorCreditType) getBusinessObjectService().findByPrimaryKey(InvestigatorCreditType.class, keyMap);
        }
    }

    @Override
    public InstitutionalProposal getSequenceOwner() {
        return getInstitutionalProposalPerson() != null ? getInstitutionalProposalPerson().getInstitutionalProposal() : null;
    }

    @Override
    public void setSequenceOwner(InstitutionalProposal newlyVersionedOwner) {
        if (getInstitutionalProposalPerson() != null) {
            getInstitutionalProposalPerson().setInstitutionalProposal(newlyVersionedOwner);
        }
    }

    @Override
    public Integer getSequenceNumber() {
        return getInstitutionalProposalPerson() != null ? getInstitutionalProposalPerson().getSequenceNumber() : 0;
    }

    @Override
    public void resetPersistenceState() {
        this.institutionalProposalPersonCreditSplitId = null;
    }
}
