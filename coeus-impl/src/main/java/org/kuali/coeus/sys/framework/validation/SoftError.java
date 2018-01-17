/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.validation;

import java.io.Serializable;
import java.util.Arrays;

/**
 * This class is used to report a soft error (i.e. a warning)
 */
public class SoftError implements Serializable {
    private static final long serialVersionUID = 4044942237931712580L;
    
    private String errorKey;
    private String[] errorParms;
    
    /**
     * Constructs a SoftError
     * @param errorkey
     * @param errorParms
     */
    public SoftError(String errorkey, String[] errorParms) {
        this.errorKey = errorkey;
        this.errorParms = errorParms;
    }

    /**
     * Gets the errorKey attribute. 
     * @return Returns the errorKey.
     */
    public String getErrorKey() {
        return errorKey;
    }

    /**
     * Gets the errorParms attribute. 
     * @return Returns the errorParms.
     */
    public String[] getErrorParms() {
        return errorParms;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((errorKey == null) ? 0 : errorKey.hashCode());
        result = PRIME * result + Arrays.hashCode(errorParms);
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
        if (!(obj instanceof SoftError)) {
            return false;
        }
        SoftError other = (SoftError) obj;
        if (errorKey == null) {
            if (other.errorKey != null) {
                return false;
            }
        } else if (!errorKey.equals(other.errorKey)) {
            return false;
        }
        if (!Arrays.equals(errorParms, other.errorParms)) {
            return false;
        }
        return true;
    }
    
    
}
