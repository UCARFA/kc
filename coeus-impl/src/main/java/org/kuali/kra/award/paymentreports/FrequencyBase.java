/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

/**
 * 
 * This class represents the FrequencyBase business object and is mapped
 * with FREQUENCY_BASE table.
 */
public class FrequencyBase extends KcPersistableBusinessObjectBase implements MutableInactivatable {


    private static final long serialVersionUID = 5406416029670950959L;

    private String frequencyBaseCode;

    private String description;

    private String regenerationTypeName;

    private boolean active;


    public FrequencyBase() {
        regenerationTypeName = ReportRegenerationType.REGEN.name();
    }

    public String getFrequencyBaseCode() {
        return frequencyBaseCode;
    }

    /**
     * 
     * @param frequencyBaseCode
     */
    public void setFrequencyBaseCode(String frequencyBaseCode) {
        this.frequencyBaseCode = frequencyBaseCode;
    }


    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((frequencyBaseCode == null) ? 0 : frequencyBaseCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FrequencyBase)) {
            return false;
        }
        return equals((FrequencyBase) obj);
    }

    /**
     * 
     * Convenience method for equality of FrequencyBase
     * @param frequencyBase
     * @return
     */
    public boolean equals(FrequencyBase frequencyBase) {
        if (frequencyBaseCode == null) {
            if (frequencyBase.frequencyBaseCode != null) {
                return false;
            }
        } else if (!frequencyBaseCode.equals(frequencyBase.frequencyBaseCode)) {
            return false;
        }
        return true;
    }

    public ReportRegenerationType getReportRegenerationType() {
        if (StringUtils.isNotBlank(getRegenerationTypeName())) {
            return ReportRegenerationType.valueOf(getRegenerationTypeName());
        } else {
            return null;
        }
    }

    public void setReportRegenerationType(ReportRegenerationType type) {
        if (type != null) {
            setRegenerationTypeName(type.name());
        } else {
            setRegenerationTypeName(null);
        }
    }

    public String getRegenerationTypeName() {
        return regenerationTypeName;
    }

    public void setRegenerationTypeName(String regenerationTypeName) {
        this.regenerationTypeName = regenerationTypeName;
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
