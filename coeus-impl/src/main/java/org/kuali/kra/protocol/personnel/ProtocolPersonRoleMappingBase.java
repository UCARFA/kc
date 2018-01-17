/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * This class represents protocol person role mapping business object
 */
public abstract class ProtocolPersonRoleMappingBase extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -4525940858799917386L;

    private Integer roleMappingId;

    private String sourceRoleId;

    private String targetRoleId;

    private ProtocolPersonRoleBase sourceRole;

    private ProtocolPersonRoleBase targetRole;

    public ProtocolPersonRoleMappingBase() {
    }

    public Integer getRoleMappingId() {
        return roleMappingId;
    }

    public void setRoleMappingId(Integer roleMappingId) {
        this.roleMappingId = roleMappingId;
    }

    public String getSourceRoleId() {
        return sourceRoleId;
    }

    public void setSourceRoleId(String sourceRoleId) {
        this.sourceRoleId = sourceRoleId;
    }

    public String getTargetRoleId() {
        return targetRoleId;
    }

    public void setTargetRoleId(String targetRoleId) {
        this.targetRoleId = targetRoleId;
    }

    public ProtocolPersonRoleBase getSourceRole() {
        return sourceRole;
    }

    public void setSourceRole(ProtocolPersonRoleBase sourceRole) {
        this.sourceRole = sourceRole;
    }

    public ProtocolPersonRoleBase getTargetRole() {
        return targetRole;
    }

    public void setTargetRole(ProtocolPersonRoleBase targetRole) {
        this.targetRole = targetRole;
    }
}
