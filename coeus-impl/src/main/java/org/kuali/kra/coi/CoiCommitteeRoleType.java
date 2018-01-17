/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class implements the membership role object.
 * 
 * @author Kuali Research Administration Team (kc.dev@kuali.org)
 */
public class CoiCommitteeRoleType extends KcPersistableBusinessObjectBase {
    private String roleTypeCode; 
    private String description; 
    
    public CoiCommitteeRoleType() { 

    }    
    
    public void setRoleTypeCode(String roleTypeCode) {
        this.roleTypeCode = roleTypeCode;
    }

    public String getRoleTypeCode() {
        return roleTypeCode;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }  
   
}
