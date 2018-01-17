/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.propdev.api.location.CongressionalDistrictContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;

import javax.persistence.*;

/**
 * This class represents a congressional district. A congressional district consists of a two-letter
 * state code and a district number, although it is represented by a single string.
 */
@Entity
@Table(name = "EPS_PROP_CONG_DISTRICT")
public class CongressionalDistrict extends KcPersistableBusinessObjectBase implements CongressionalDistrictContract {

    public static final int DISTRICT_NUMBER_LENGTH = 3;

    private static final long serialVersionUID = 9043098848918407500L;

    @PortableSequenceGenerator(name = "SEQ_CONG_DISTRICT_ID_KRA")
    @GeneratedValue(generator = "SEQ_CONG_DISTRICT_ID_KRA")
    @Id
    @Column(name = "CONG_DISTRICT_ID")
    private Long id;

    @ManyToOne(cascade = { CascadeType.REFRESH })
    @JoinColumns({ @JoinColumn(name = "PROPOSAL_NUMBER", referencedColumnName = "PROPOSAL_NUMBER"), @JoinColumn(name = "SITE_NUMBER", referencedColumnName = "SITE_NUMBER") })
    private ProposalSite proposalSite;

    @Column(name = "CONG_DISTRICT")
    private String congressionalDistrict;
    
    @Transient
    private String newState;
    
    @Transient
    private String newDistrictNumber;

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getCongressionalDistrict() {
        return congressionalDistrict;
    }

    public void setCongressionalDistrict(String stateCode, String districtNumber) {
        setCongressionalDistrict(stateCode + "-" + districtNumber);
    }

    public void setCongressionalDistrict(String congressionalDistrict) {
        this.congressionalDistrict = congressionalDistrict;
    }

	public String getNewState() {
		return newState;
	}

	public void setNewState(String newState) {
		this.newState = newState;
	}

	public String getNewDistrictNumber() {
		if (StringUtils.isNumeric(newDistrictNumber)) {
            newDistrictNumber = StringUtils.leftPad(newDistrictNumber, CongressionalDistrict.DISTRICT_NUMBER_LENGTH, "0");
        }
		return newDistrictNumber;
	}

	public void setNewDistrictNumber(String newDistrictNumber) {
		this.newDistrictNumber = newDistrictNumber;
	}

	public ProposalSite getProposalSite() {
		return proposalSite;
	}

	public void setProposalSite(ProposalSite proposalSite) {
		this.proposalSite = proposalSite;
	}

    @Override
    public Integer getSiteNumber(){
        if (getProposalSite() != null){
            return getProposalSite().getSiteNumber();
        }
        return null;
    }

    @Override
    public String getProposalNumber(){
        if (getProposalSite() != null){
            if (getProposalSite().getDevelopmentProposal() != null){
                return getProposalSite().getDevelopmentProposal().getProposalNumber();
            }
        }
        return null;
    }
}
