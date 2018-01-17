/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.personnel;

import org.kuali.kra.protocol.personnel.ProtocolPersonRoleMappingBase;

/**
 * This class represents protocol person role mapping business object
 */
public class ProtocolPersonRoleMapping extends ProtocolPersonRoleMappingBase {


    private static final long serialVersionUID = -4525940858799917386L;

    private Integer roleMappingId;

    private String sourceRoleId;

    private String targetRoleId;

    private ProtocolPersonRole sourceRole;

    private ProtocolPersonRole targetRole;

    public ProtocolPersonRoleMapping() {
    }

    @Override
    public Integer getRoleMappingId() {
        return roleMappingId;
    }

    @Override
    public void setRoleMappingId(Integer roleMappingId) {
        this.roleMappingId = roleMappingId;
    }

    @Override
    public String getSourceRoleId() {
        return sourceRoleId;
    }

    @Override
    public void setSourceRoleId(String sourceRoleId) {
        this.sourceRoleId = sourceRoleId;
    }

    @Override
    public String getTargetRoleId() {
        return targetRoleId;
    }

    @Override
    public void setTargetRoleId(String targetRoleId) {
        this.targetRoleId = targetRoleId;
    }

    @Override
    public ProtocolPersonRole getSourceRole() {
        return sourceRole;
    }

    public void setSourceRole(ProtocolPersonRole sourceRole) {
        this.sourceRole = sourceRole;
    }

    @Override
    public ProtocolPersonRole getTargetRole() {
        return targetRole;
    }

    public void setTargetRole(ProtocolPersonRole targetRole) {
        this.targetRole = targetRole;
    }
}
