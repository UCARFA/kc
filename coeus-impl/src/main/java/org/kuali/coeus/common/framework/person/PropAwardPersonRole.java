/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person;

import org.kuali.coeus.sys.api.model.Coded;
import org.kuali.coeus.sys.api.model.IdentifiableNumeric;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;

/**
 * Represents the Proposal Person Role <code>{@link org.kuali.rice.krad.bo.BusinessObject}</code>
 *
 * @see org.kuali.rice.krad.bo.BusinessObject
 * @see org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument
 * @author $Author: gmcgrego $
 * @version $Revision: 1.8 $
 */
@Entity
@Table(name = "EPS_PROP_PERSON_ROLE")
public class PropAwardPersonRole extends KcPersistableBusinessObjectBase implements ContactRole, IdentifiableNumeric, Coded {

    public static final String PRINCIPAL_INVESTIGATOR = "PI";
    
    public static final String MULTI_PI = "MPI";

    public static final String CO_INVESTIGATOR = "COI";

    public static final String KEY_PERSON = "KP";

    public static final String UNIT_SOURCE_SEPARATOR = ",";

    private static final long serialVersionUID = -2184772940618843909L;

    @PortableSequenceGenerator(name = "SEQ_EPS_PROP_PERSON_ROLE")
    @GeneratedValue(generator = "SEQ_EPS_PROP_PERSON_ROLE")
    @Id
    @Column(name = "PROP_PERSON_ROLE_ID")
    private Long id;
    
    @Column(name = "PROP_PERSON_ROLE_CODE")
    private String code;
    
    @Column(name = "SPONSOR_HIERARCHY_NAME")
    private String sponsorHierarchyName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CERTIFICATION_REQUIRED")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean certificationRequired = Boolean.TRUE;
    
    @Column(name="READ_ONLY_ROLE")
    private Boolean readOnly;

    @Column(name = "UNIT_DETAILS_REQUIRED")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean unitDetailsRequired = Boolean.TRUE;

    @Column(name = "AUTO_POPULATE_UNITS")
    private String autoPopulateUnitsCode = UnitPopulationBehavior.PRIMARY.getCode();

    @Column(name = "SELECTED_UNIT_SOURCES")
    private String selectedUnitSources;

    @Override
    public final String getCode() {
        return this.code;
    }

    public final void setCode(String argProposalPersonRoleId) {
        this.code = argProposalPersonRoleId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String argDescription) {
        this.description = argDescription;
    }
    
	public Boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}    

    public Boolean getUnitDetailsRequired() {
        return unitDetailsRequired;
    }

    public void setUnitDetailsRequired(Boolean unitDetailsRequired) {
        this.unitDetailsRequired = unitDetailsRequired;
    }

    public Boolean getCertificationRequired() {
        return certificationRequired;
    }

    public void setCertificationRequired(Boolean certificationRequired) {
        this.certificationRequired = certificationRequired;
    }

    public String getAutoPopulateUnitsCode() {
        return autoPopulateUnitsCode;
    }

    public void setAutoPopulateUnitsCode(String autoPopulateUnitsCode) {
        this.autoPopulateUnitsCode = autoPopulateUnitsCode;
    }

    public UnitPopulationBehavior getUnitPopulationBehavior() {
        return UnitPopulationBehavior.fromCode(getAutoPopulateUnitsCode());
    }

    public String getSelectedUnitSources() {
        return selectedUnitSources;
    }

    public void setSelectedUnitSources(String selectedUnitSources) {
        this.selectedUnitSources = selectedUnitSources;
    }

    @Override
    public String getRoleCode() {
        return getCode();
    }

    @Override
    public String getRoleDescription() {
        return getDescription();
    }

	@Override
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSponsorHierarchyName() {
		return sponsorHierarchyName;
	}

	public void setSponsorHierarchyName(String sponsorHierarchyName) {
		this.sponsorHierarchyName = sponsorHierarchyName;
	}
}
