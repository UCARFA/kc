/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "EPS_PROP_PERSON_CERT_DETAILS")
@IdClass(ProposalPersonCertificationDetails.ProposalPersonCertificationDetailsId.class)
public class ProposalPersonCertificationDetails extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -4110005875629288373L;
    @Id
    @Column(name = "PROP_PERSON_NUMBER")
    private Integer proposalPersonNumber;

    @Id
    @Column(name = "PROPOSAL_NUMBER")
    private String proposalNumber;

    @Column(name = "CERTIFIED_BY")
    private String certifiedBy;

    @Column(name = "CERTIFIED_TIME")
    private Timestamp certifiedTime;

    @Transient
    private transient String  certifiedPersonName;

    @Transient
    private transient String  certifiedTimeStamp;

    @Transient
    private transient KcPersonService kcPersonService;

    public ProposalPersonCertificationDetails() {
    }

    public ProposalPersonCertificationDetails(Integer proposalPersonNumber, String proposalNumber) {
        this.proposalPersonNumber = proposalPersonNumber;
        this.proposalNumber = proposalNumber;
    }

    public Integer getProposalPersonNumber() {
        return this.proposalPersonNumber;
    }

    public void setProposalPersonNumber(Integer proposalPersonNumber) {
        this.proposalPersonNumber = proposalPersonNumber;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    protected KcPersonService getKcPersonService() {
        if (this.kcPersonService == null) {
            this.kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        }
        return this.kcPersonService;
    }

    public void setKcPersonService(KcPersonService kcPersonService) {
        this.kcPersonService = kcPersonService;
    }

    public String getCertifiedPersonName() {
        if(this.certifiedBy!=null){
            this.certifiedPersonName = getKcPersonService().getKcPersonByPersonId(certifiedBy).getUserName();
        }
        return certifiedPersonName;
    }

    public void setCertifiedPersonName(String certifiedPersonName) {
        this.certifiedPersonName = certifiedPersonName;
    }

    public String getCertifiedTimeStamp() {
        if(this.certifiedTime != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.MM_DD_YYYY_HH_MM_A_DATE_FORMAT);
            certifiedTimeStamp = simpleDateFormat.format(certifiedTime);
        }
        return certifiedTimeStamp;
    }

    public void setCertifiedTimeStamp(String certifiedTimeStamp) {
        this.certifiedTimeStamp = certifiedTimeStamp;
    }

    public String getCertifiedBy() {
        return certifiedBy;
    }

    public void setCertifiedBy(String certifiedBy) {
        this.certifiedBy = certifiedBy;
    }

    public Timestamp getCertifiedTime() {
        return certifiedTime;
    }

    public void setCertifiedTime(Timestamp certifiedTime) {
        this.certifiedTime = certifiedTime;
    }

    public static final class ProposalPersonCertificationDetailsId implements  Serializable, Comparable<ProposalPersonCertificationDetailsId> {

        private Integer proposalPersonNumber;

        private String proposalNumber;

        public Integer getProposalPersonNumber() {
            return this.proposalPersonNumber;
        }

        public void setProposalPersonNumber(Integer proposalPersonNumber) {
            this.proposalPersonNumber = proposalPersonNumber;
        }

        public String getProposalNumber() {
            return this.proposalNumber;
        }

        public void setProposalNumber(String proposalNumber) {
            this.proposalNumber = proposalNumber;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("proposalPersonNumber", this.proposalPersonNumber).append("proposalNumber", this.proposalNumber).toString();
        }

        @Override
        public boolean equals(Object other) {
            if (other == null)
                return false;
            if (other == this)
                return true;
            if (other.getClass() != this.getClass())
                return false;
            final ProposalPersonCertificationDetailsId rhs = (ProposalPersonCertificationDetailsId) other;
            return new EqualsBuilder().append(this.proposalPersonNumber, rhs.proposalPersonNumber).append(this.proposalNumber, rhs.proposalNumber).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(this.proposalPersonNumber).append(this.proposalNumber).toHashCode();
        }

        @Override
        public int compareTo(ProposalPersonCertificationDetailsId other) {
            return new CompareToBuilder().append(this.proposalPersonNumber, other.proposalPersonNumber).append(this.proposalNumber, other.proposalNumber).toComparison();
        }
    }

}