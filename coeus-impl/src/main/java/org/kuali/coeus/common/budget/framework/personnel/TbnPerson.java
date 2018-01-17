/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import javax.persistence.*;

import org.kuali.coeus.common.budget.api.personnel.TbnPersonContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

@Entity
@Table(name = "TBN")
public class TbnPerson extends KcPersistableBusinessObjectBase implements TbnPersonContract, MutableInactivatable {

    @Id
    @Column(name = "TBN_ID")
    private String tbnId;

    @Column(name = "PERSON_NAME")
    private String personName;

    @Column(name = "JOB_CODE")
    private String jobCode;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanYNConverter.class)
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "JOB_CODE", referencedColumnName = "JOB_CODE", insertable = false, updatable = false)
    private JobCode jobCodeReference;
    
    @Transient
    private int quantity;

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    @Override
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getTbnId() {
        return tbnId;
    }

    public void setTbnId(String tbnId) {
        this.tbnId = tbnId;
    }

    @Override
    public JobCode getJobCodeReference() {
        return jobCodeReference;
    }

    public void setJobCodeReference(JobCode jobCodeReference) {
        this.jobCodeReference = jobCodeReference;
    }

    @Override
    public String getId() {
        return getTbnId();
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
