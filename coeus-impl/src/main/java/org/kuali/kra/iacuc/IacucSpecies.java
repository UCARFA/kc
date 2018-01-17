/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IacucSpecies extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer speciesCode; 
    private String speciesName; 
    
    public IacucSpecies() { 

    } 
    
    public Integer getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(Integer speciesCode) {
        this.speciesCode = speciesCode;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.speciesCode == null) ? 0 : this.speciesCode.hashCode());
        result = prime * result + ((this.speciesName == null) ? 0 : this.speciesName.hashCode());
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        IacucSpecies other = (IacucSpecies) obj;
        if (this.speciesCode == null) {
            if (other.speciesCode != null) {
                return false;
            }
        } else if (!this.speciesCode.equals(other.speciesCode)) {
            return false;
        }
        if (this.speciesName == null) {
            if (other.speciesName != null) {
                return false;
            }
        } else if (!this.speciesName.equals(other.speciesName)) {
            return false;
        }
        return true;
    }

    
}
