/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import javax.persistence.*;

import org.kuali.coeus.common.budget.api.personnel.AppointmentTypeContract;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.persistence.ScaleTwoDecimalConverter;


@Entity
@Table(name = "APPOINTMENT_TYPE")
public class AppointmentType extends KcPersistableBusinessObjectBase implements AppointmentTypeContract {

    @Id
    @Column(name = "APPOINTMENT_TYPE_CODE")
    private String appointmentTypeCode;

    @Column(name = "DURATION")
    @Convert(converter = ScaleTwoDecimalConverter.class)
    private ScaleTwoDecimal duration;

    @Column(name = "DESCRIPTION")
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppointmentTypeCode() {
        return appointmentTypeCode;
    }

    public void setAppointmentTypeCode(String appointmentTypeCode) {
        this.appointmentTypeCode = appointmentTypeCode;
    }

    @Override
    public ScaleTwoDecimal getDuration() {
        return duration;
    }

    public void setDuration(ScaleTwoDecimal duration) {
        this.duration = duration;
    }

    @Override
    public String getCode() {
        return getAppointmentTypeCode();
    }
}
