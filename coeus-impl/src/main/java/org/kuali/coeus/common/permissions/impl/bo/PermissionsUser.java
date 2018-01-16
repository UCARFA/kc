/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.bo;

import org.apache.commons.lang3.StringUtils;
import org.kuali.rice.krad.bo.BusinessObjectBase;

/**
 * A <b>PermissionsUser</b> is used for the form on the Permissions tab
 * web page for entering a new user.  When a user's userName and role are
 * entered on the web page, the data is written to an instance of this
 * class.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
@SuppressWarnings("serial")
public class PermissionsUser extends BusinessObjectBase {
    
    private String userId = "";
    private String userName = "";
    private String fullName = "";
    private String roleName = "";
    private String unitNumber = "";
    private String unitName = "";
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getRoleName() {
        return roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getUnitNumber() {
        return unitNumber;
    }
    
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
    
    public String getUnitName() {
        return unitName;
    }
    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    @Override
    public void refresh() {
        // do nothing
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        
        PermissionsUser user = (PermissionsUser) obj;
        return StringUtils.equals(this.userId, user.userId) 
            && StringUtils.equals(this.userName, user.userName) 
            && StringUtils.equals(this.roleName, user.roleName)
            && StringUtils.equals(this.unitNumber, user.unitNumber)
            && StringUtils.equals(this.unitName, user.unitNumber);
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
        result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
        result = prime * result + ((unitNumber == null) ? 0 : unitNumber.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }
    
}
