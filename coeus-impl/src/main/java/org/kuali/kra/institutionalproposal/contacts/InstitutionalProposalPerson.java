/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.rolodex.NonOrganizationalRolodex;
import org.kuali.coeus.common.framework.person.PropAwardPersonRole;
import org.kuali.coeus.common.framework.person.PropAwardPersonRoleService;
import org.kuali.coeus.common.framework.sponsor.Sponsorable;
import org.kuali.coeus.propdev.impl.person.creditsplit.CreditSplitConstants;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.bo.AbstractProjectPerson;
import org.kuali.coeus.common.framework.rolodex.PersonRolodex;
import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

import java.util.*;

public class InstitutionalProposalPerson extends InstitutionalProposalContact implements PersonRolodex, AbstractProjectPerson {


    private static final long serialVersionUID = -5406431014745059361L;

    private ScaleTwoDecimal academicYearEffort;

    private ScaleTwoDecimal calendarYearEffort;

    private boolean faculty;

    private ScaleTwoDecimal summerEffort;

    private ScaleTwoDecimal totalEffort;

    private String keyPersonRole;

    private List<InstitutionalProposalPersonUnit> units;
    private transient ParameterService parameterService;

    private List<InstitutionalProposalPersonCreditSplit> creditSplits;
    private Boolean includeInCreditAllocation;

    private transient PropAwardPersonRoleService propAwardPersonRoleService;

    public InstitutionalProposalPerson() {
        super();
        init();
    }

    public InstitutionalProposalPerson(NonOrganizationalRolodex rolodex, ContactRole contactRole) {
        super(rolodex, contactRole);
        init();
    }

    public InstitutionalProposalPerson(KcPerson person, ContactRole role) {
        super(person, role);
        init();
    }

    public void setIncludeInCreditAllocation(Boolean includeInCreditAllocation) {
        this.includeInCreditAllocation = includeInCreditAllocation;
    }

    /**
     * @param creditSplit
     */
    public void add(InstitutionalProposalPersonCreditSplit creditSplit) {
        creditSplits.add(creditSplit);
        creditSplit.setInstitutionalProposalPerson(this);
    }

    public void add(InstitutionalProposalPersonUnit institutionalProposalPersonUnit) {
        units.add(institutionalProposalPersonUnit);
        institutionalProposalPersonUnit.setInstitutionalProposalPerson(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List buildListOfDeletionAwareLists() {
        List managedLists = super.buildListOfDeletionAwareLists();
        managedLists.add(getUnits());
        return managedLists;
    }

    /**
     * Gets the academicYearEffort attribute. 
     * @return Returns the academicYearEffort.
     */
    public ScaleTwoDecimal getAcademicYearEffort() {
        return academicYearEffort;
    }

    /**
     * Gets the calendarYearEffort attribute. 
     * @return Returns the calendarYearEffort.
     */
    public ScaleTwoDecimal getCalendarYearEffort() {
        return calendarYearEffort;
    }

    /**
     * @param index
     * @return
     */
    public InstitutionalProposalPersonCreditSplit getCreditSplit(int index) {
        return creditSplits.get(index);
    }


    public List<InstitutionalProposalPersonCreditSplit> getCreditSplits() {
        return creditSplits;
    }

    /**
     * Gets the summerEffort attribute. 
     * @return Returns the summerEffort.
     */
    public ScaleTwoDecimal getSummerEffort() {
        return summerEffort;
    }

    /**
     * Gets the totalEffort attribute. 
     * @return Returns the totalEffort.
     */
    public ScaleTwoDecimal getTotalEffort() {
        return totalEffort;
    }

    /**
     * @param index
     * @return
     */
    public InstitutionalProposalPersonUnit getUnit(int index) {
        return units.get(index);
    }

    /**
     * Gets the units attribute. 
     * @return Returns the units.
     */
    public List<InstitutionalProposalPersonUnit> getUnits() {
        return units;
    }

    /**
     * This method determines if person is CO-I
     * @return
     */
    public boolean isCoInvestigator() {
        return StringUtils.equals(getContactRoleCode(), ContactRole.COI_CODE);
    }

    /**
     * Gets the faculty attribute. 
     * @return Returns the faculty.
     */
    public boolean isFaculty() {
        return faculty;
    }

    /**
     * This method determines if person is KeyPerson
     * @return
     */
    public boolean isKeyPerson() {
        return StringUtils.equals(getContactRoleCode(), ContactRole.KEY_PERSON_CODE);
    }


    @Override
    public boolean isPrincipalInvestigator() {
        return StringUtils.equals(getContactRoleCode(), ContactRole.PI_CODE);
    }
    
    @Override
    public boolean isMultiplePi() {
    	return StringUtils.equals(getContactRoleCode(), PropAwardPersonRole.MULTI_PI);
    }

    /**
     * Sets the academicYearEffort attribute value.
     * @param academicYearEffort The academicYearEffort to set.
     */
    public void setAcademicYearEffort(ScaleTwoDecimal academicYearEffort) {
        this.academicYearEffort = academicYearEffort;
    }

    /**
     * Sets the calendarYearEffort attribute value.
     * @param calendarYearEffort The calendarYearEffort to set.
     */
    public void setCalendarYearEffort(ScaleTwoDecimal calendarYearEffort) {
        this.calendarYearEffort = calendarYearEffort;
    }

    /**
     * Sets the creditSplits attribute value.
     * @param creditSplits The creditSplits to set.
     */
    public void setCreditSplits(List<InstitutionalProposalPersonCreditSplit> creditSplits) {
        this.creditSplits = creditSplits;
    }

    /**
     * This method will initialize required credit splits and populate them with 
     * default values of 100%.
     */
    @SuppressWarnings("unchecked")
    public void initializeDefaultCreditSplits() {
        List<InvestigatorCreditType> creditTypes = (List<InvestigatorCreditType>) this.getBusinessObjectService().findAll(InvestigatorCreditType.class);
        for (InvestigatorCreditType creditType : creditTypes) {
            InstitutionalProposalPersonCreditSplit creditSplit = new InstitutionalProposalPersonCreditSplit(creditType, new ScaleTwoDecimal(0));
            this.add(creditSplit);
        }
    }

    /**
     * Sets the faculty attribute value.
     * @param faculty The faculty to set.
     */
    public void setFaculty(boolean faculty) {
        this.faculty = faculty;
    }

    /**
     * Sets the summerEffort attribute value.
     * @param summerEffort The summerEffort to set.
     */
    public void setSummerEffort(ScaleTwoDecimal summerEffort) {
        this.summerEffort = summerEffort;
    }

    /**
     * Sets the totalEffort attribute value.
     * @param totalEffort The totalEffort to set.
     */
    public void setTotalEffort(ScaleTwoDecimal totalEffort) {
        this.totalEffort = totalEffort;
    }

    /**
     * Sets the units attribute value.
     * @param units The units to set.
     */
    public void setUnits(List<InstitutionalProposalPersonUnit> units) {
        this.units = units;
    }

    @Override
    public String toString() {
        final StringBuilder id = new StringBuilder();
        if (getContact() != null && getContact().getIdentifier() != null) {
          id.append(getContact().getIdentifier().toString());
        }
        final StringBuilder name = new StringBuilder();
        if (getContact() != null && getContact().getFullName() != null) {
          name.append(getContact().getFullName());
        }
        return String.format("%s:%s", id.toString(), name.toString());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class getContactRoleType() {
        return PropAwardPersonRole.class;
    }
    
    @Override
    protected Map<String, Object> getContactRoleIdentifierMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", getRoleCode());
        map.put("sponsorHierarchyName", getPropAwardPersonRoleService().getSponsorHierarchy(getInstitutionalProposal().getSponsorCode()));
        return map;
     }
    
    protected void init() {
        units = new ArrayList<InstitutionalProposalPersonUnit>();
        creditSplits = new ArrayList<InstitutionalProposalPersonCreditSplit>();
    }

    @Override
    public String getProjectRole() {
        return getContactRole().getRoleDescription();
    }

    @Override
    public boolean isOtherSignificantContributorFlag() {
        return false;
    }

    public String getKeyPersonRole() {
        return keyPersonRole;
    }

    public void setKeyPersonRole(String keyPersonRole) {
        this.keyPersonRole = keyPersonRole;
    }

    @Override
    public void resetPersistenceState() {
        this.setInstitutionalProposalContactId(null);
    }

    @Override
    public Sponsorable getParent() {
        return this.getInstitutionalProposal();
    }

	@Override
    public String getInvestigatorRoleDescription() {
		return getContactRole().getRoleDescription();
	}
	
    @Override
    public ContactRole refreshContactRole() {
    	if (StringUtils.isNotBlank(getRoleCode()) && getParent() != null && StringUtils.isNotBlank(getParent().getSponsorCode())) {
    		contactRole = getPropAwardPersonRoleService().getRole(getRoleCode(), getParent().getSponsorCode());
    	} else {
    		contactRole = null;
    	}
    	return contactRole;
    }

	@Override
    protected PropAwardPersonRoleService getPropAwardPersonRoleService() {
		if (propAwardPersonRoleService == null) {
			propAwardPersonRoleService = KcServiceLocator.getService(PropAwardPersonRoleService.class);
		}
		return propAwardPersonRoleService;
	}

	@Override
    public void setPropAwardPersonRoleService(
			PropAwardPersonRoleService propAwardPersonRoleService) {
		this.propAwardPersonRoleService = propAwardPersonRoleService;
	}

	@Override
	public Integer getOrdinalPosition() {
		return 0;
	}
	
	@Override
	public boolean isInvestigator() {
		return isPrincipalInvestigator() || isMultiplePi() || isCoInvestigator();
	}

    @Override
    public String getLastName() {
        String lastName = null;
        if (getPerson() != null) {
            lastName = getPerson().getLastName();
        } else if (getRolodex() != null) {
            lastName = getRolodex().getLastName();
        }
        return lastName;
    }

    public Boolean getIncludeInCreditAllocation() {
        if (includeInCreditAllocation == null) {
            includeInCreditAllocation = defaultIncludeInCreditAllocation(roleCode);
        }
        return includeInCreditAllocation;
    }

    public Boolean defaultIncludeInCreditAllocation(String proposalPersonRoleId) {
        final Collection<String> roles = getParameterService().getParameterValuesAsString(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT,
                Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, CreditSplitConstants.CREDIT_SPLIT_OPT_IN_DEFAULT_ROLES);
        return StringUtils.isNotBlank(proposalPersonRoleId) && roles.contains(proposalPersonRoleId);
    }

    public ParameterService getParameterService() {
        if(parameterService == null) {
            parameterService = KcServiceLocator.getService(ParameterService.class);
        }
        return parameterService;
    }

}
