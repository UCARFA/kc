/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.closeout;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class represets the CloseoutReportType business object.
 */
public class CloseoutReportType extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -1825249905096558223L;

    private String closeoutReportCode;

    private String description;


    public CloseoutReportType() {
    }

    /**
     * Gets the closeoutReportCode attribute. 
     * @return Returns the closeoutReportCode.
     */
    public String getCloseoutReportCode() {
        return closeoutReportCode;
    }

    /**
     * Sets the closeoutReportCode attribute value.
     * @param closeoutReportCode The closeoutReportCode to set.
     */
    public void setCloseoutReportCode(String closeoutReportCode) {
        this.closeoutReportCode = closeoutReportCode;
    }

    /**
     * Gets the description attribute. 
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description attribute value.
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((closeoutReportCode == null) ? 0 : closeoutReportCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof CloseoutReportType)) return false;
        final CloseoutReportType other = (CloseoutReportType) obj;
        if (closeoutReportCode == null) {
            if (other.closeoutReportCode != null) return false;
        } else if (!closeoutReportCode.equals(other.closeoutReportCode)) return false;
        return true;
    }
}
