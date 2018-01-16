/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.hierarchy;


import java.util.Arrays;

public class ProposalHierarchyErrorWarningDto {
    private boolean severe;
    private String errorKey;
    private String[] errorParameters;

    /**
     * Constructs a ProposalHierarchyErrorDto.
     * @param errorKey
     * @param errorParameters
     */
    public ProposalHierarchyErrorWarningDto(String errorKey, boolean severe, String... errorParameters) {
        this.errorKey = errorKey;
        this.errorParameters = errorParameters;
        this.severe = severe;
    }

    /**
     * Gets the severe attribute.
     * @return Returns the severe.
     */
    public boolean isSevere() {
        return severe;
    }

    /**
     * Sets the errorKey attribute value.
     * @param severe The severe to set.
     */
    public void setSevere(boolean severe) {
        this.severe = severe;
    }

    /**
     * Gets the errorKey attribute. 
     * @return Returns the errorKey.
     */
    public String getErrorKey() {
        return errorKey;
    }

    /**
     * Sets the errorKey attribute value.
     * @param errorKey The errorKey to set.
     */
    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    /**
     * Gets the errorParms attribute. 
     * @return Returns the errorParameters.
     */
    public String[] getErrorParameters() {
        return errorParameters;
    }

    /**
     * Sets the errorParameters attribute value.
     * @param errorParameters The errorParameters to set.
     */
    public void setErrorParameters(String... errorParameters) {
        this.errorParameters = errorParameters;
    }

    @Override
    public String toString() {
        return "ProposalHierarchyErrorWarningDto{" +
                "severe=" + severe +
                ", errorKey='" + errorKey + '\'' +
                ", errorParameters=" + Arrays.toString(errorParameters) +
                '}';
    }
}
