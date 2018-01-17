/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.unit.admin;

import org.kuali.coeus.common.api.unit.admin.UnitAdministratorTypeContract;
import org.kuali.coeus.common.framework.unit.UnitContactType;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;

/**
 * This class models the UnitAdministratorType
 */
@Entity
@Table(name = "UNIT_ADMINISTRATOR_TYPE")
public class UnitAdministratorType extends KcPersistableBusinessObjectBase implements ContactRole, UnitAdministratorTypeContract {

    public static final String ADMINISTRATIVE_OFFICER_TYPE_CODE = "1";

    public static final String OSP_ADMINISTRATOR_TYPE_CODE = "2";

    public static final String UNIT_HEAD_TYPE_CODE = "3";

    public static final String DEAN_VP_TYPE_CODE = "4";

    public static final String OTHER_INDIVIDUAL_TO_NOTIFY_TYPE_CODE = "5";

    public static final String GRANTS_GOV_PROPOSAL_CONTACT_TYPE_CODE = "6";

    public static final String ADMINISTRATIVE_CONTACT_TYPE_CODE = "7";

    public static final String FINANCIAL_CONTACT_TYPE_CODE = "8";


    private static final long serialVersionUID = -8872381393239718701L;

    @Id
    @Column(name = "UNIT_ADMINISTRATOR_TYPE_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MULTIPLES_FLAG")
    @Convert(converter = BooleanYNConverter.class)
    private Boolean multiplesFlag;

    @Column(name = "DEFAULT_GROUP_FLAG")
    private String defaultGroupFlag;

    @Transient
    private UnitContactType unitContactType;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getRoleCode() {
        return getCode();
    }

    @Override
    public String getRoleDescription() {
        return getDescription();
    }


    public UnitContactType getUnitContactType() {
        return unitContactType;
    }

    /**
     * @param unitContactType
     */
    public void setUnitContactType(UnitContactType unitContactType) {
        this.unitContactType = unitContactType;
    }

    /**
     * Gets the multiplesFlag attribute. 
     * @return Returns the multiplesFlag.
     */
    public Boolean getMultiplesFlag() {
        return multiplesFlag;
    }

    /**
     * Sets the multiplesFlag attribute value.
     * @param multiplesFlag The multiplesFlag to set.
     */
    public void setMultiplesFlag(Boolean multiplesFlag) {
        this.multiplesFlag = multiplesFlag;
    }

    /**
     * Gets the defaultGroupFlag attribute. 
     * @return Returns the defaultGroupFlag.
     */
    public String getDefaultGroupFlag() {
        return defaultGroupFlag;
    }

    /**
     * Sets the defaultGroupFlag attribute value.
     * @param defaultGroupFlag The defaultGroupFlag to set.
     */
    public void setDefaultGroupFlag(String defaultGroupFlag) {
        this.defaultGroupFlag = defaultGroupFlag;
    }
}
