/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
