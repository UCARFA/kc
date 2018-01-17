/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class represents the ValidFrequencyBase business object.
 */
public class ValidFrequencyBase extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -2875079003137515732L;

    private Integer validFrequencyBaseId;

    private String frequencyCode;

    private String frequencyBaseCode;

    private Frequency frequency;

    private FrequencyBase frequencyBase;


    public ValidFrequencyBase() {
        super();
    }

    /**
     * 
     * Constructs a ValidFrequencyBase.java.
     * @param frequencyCode
     */
    public ValidFrequencyBase(String frequencyCode, String frequencyBaseCode) {
        super();
        this.frequencyCode = frequencyCode;
        this.frequencyBaseCode = frequencyBaseCode;
    }


    public Integer getValidFrequencyBaseId() {
        return validFrequencyBaseId;
    }

    /**
     * 
     * @param validFrequencyBaseId
     */
    public void setValidFrequencyBaseId(Integer validFrequencyBaseId) {
        this.validFrequencyBaseId = validFrequencyBaseId;
    }


    public String getFrequencyCode() {
        return frequencyCode;
    }

    /**
     * 
     * @param frequencyCode
     */
    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
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


    public Frequency getFrequency() {
        return frequency;
    }

    /**
     * 
     * @param frequency
     */
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }


    public FrequencyBase getFrequencyBase() {
        return frequencyBase;
    }

    /**
     * 
     * @param frequencyBase
     */
    public void setFrequencyBase(FrequencyBase frequencyBase) {
        this.frequencyBase = frequencyBase;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((frequencyBaseCode == null) ? 0 : frequencyBaseCode.hashCode());
        result = PRIME * result + ((frequencyCode == null) ? 0 : frequencyCode.hashCode());
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
        if (!(obj instanceof ValidFrequencyBase)) {
            return false;
        }
        return equals((ValidFrequencyBase) obj);
    }

    /**
     * 
     * Convenience method for equality of ValidFrequencyBase
     * @param validFrequencyBase
     * @return
     */
    public boolean equals(ValidFrequencyBase validFrequencyBase) {
        if (frequencyBaseCode == null) {
            if (validFrequencyBase.frequencyBaseCode != null) {
                return false;
            }
        } else if (!frequencyBaseCode.equals(validFrequencyBase.frequencyBaseCode)) {
            return false;
        }
        if (frequencyCode == null) {
            if (validFrequencyBase.frequencyCode != null) {
                return false;
            }
        } else if (!frequencyCode.equals(validFrequencyBase.frequencyCode)) {
            return false;
        }
        return true;
    }
}
