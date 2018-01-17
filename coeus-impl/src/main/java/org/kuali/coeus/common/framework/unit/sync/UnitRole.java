/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.unit.sync;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kim.impl.role.RoleBoLite;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.data.DataObjectService;

public class UnitRole implements BusinessObject {

    private String id;
    private String namespaceCode;
    private String name;
    private String description;
    private String kimTypeId;
    private boolean active;

    private transient DataObjectService dataObjectService;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamespaceCode() {
        return namespaceCode;
    }

    public void setNamespaceCode(String namespaceCode) {
        this.namespaceCode = namespaceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKimTypeId() {
        return kimTypeId;
    }

    public void setKimTypeId(String kimTypeId) {
        this.kimTypeId = kimTypeId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isUnitHierarchy() {
        return UnitRoleConstants.UNIT_HIERARCHY_TYPE.equals(getKimTypeId());
    }

    @Override
    public void refresh() {
        if (StringUtils.isNotBlank(id)) {
            final RoleBoLite bo = getDataObjectService().find(RoleBoLite.class, id);
            if (bo != null) {
                id = bo.getId();
                namespaceCode = bo.getNamespaceCode();
                name = bo.getName();
                description = bo.getDescription();
                kimTypeId = bo.getKimTypeId();
                active = bo.isActive();
            } else {
                namespaceCode = null;
                name = null;
                description = null;
                kimTypeId = null;
                active = false;
            }
        }
    }

    public static UnitRole fromRoleBoLite(RoleBoLite role) {
        final UnitRole unitRole = new UnitRole();
        unitRole.setId(role.getId());
        unitRole.setNamespaceCode(role.getNamespaceCode());
        unitRole.setName(role.getName());
        unitRole.setDescription(role.getDescription());
        unitRole.setKimTypeId(role.getKimTypeId());
        unitRole.setActive(role.isActive());
        return unitRole;
    }

    @Override
    public String toString() {
        return "UnitRole{" +
                "id='" + id + '\'' +
                ", namespaceCode='" + namespaceCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", kimTypeId='" + kimTypeId + '\'' +
                ", active=" + active +
                '}';
    }

    public DataObjectService getDataObjectService() {
        if (dataObjectService == null) {
            dataObjectService = KcServiceLocator.getService(DataObjectService.class);
        }
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }
}
