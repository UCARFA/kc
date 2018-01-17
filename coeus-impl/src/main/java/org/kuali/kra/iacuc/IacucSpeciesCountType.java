/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class IacucSpeciesCountType extends KcPersistableBusinessObjectBase {
    
    private static final long serialVersionUID = 1L;

    private Integer speciesCountCode; 
    private String description; 
    
    
    public IacucSpeciesCountType() { 

    } 
    
    public Integer getSpeciesCountCode() {
        return speciesCountCode;
    }

    public void setSpeciesCountCode(Integer speciesCountCode) {
        this.speciesCountCode = speciesCountCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.speciesCountCode == null) ? 0 : this.speciesCountCode.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
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
        IacucSpeciesCountType other = (IacucSpeciesCountType) obj;
        if (this.speciesCountCode == null) {
            if (other.speciesCountCode != null) {
                return false;
            }
        } else if (!this.speciesCountCode.equals(other.speciesCountCode)) {
            return false;
        }
        if (this.description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!this.description.equals(other.description)) {
            return false;
        }
        return true;
    }
    
}
