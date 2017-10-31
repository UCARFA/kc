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

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.lookup.KcKualiLookupableHelperServiceImpl;
import org.kuali.rice.core.api.criteria.Predicate;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.kim.framework.role.RoleEbo;
import org.kuali.rice.kim.impl.role.RoleBoLite;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static org.kuali.rice.core.api.criteria.PredicateFactory.*;

@Component("unitRoleLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UnitRoleLookupableHelperService extends KcKualiLookupableHelperServiceImpl {

    private static final String KIM_TYPE_ID = "kimTypeId";
    private static final String ACTIVE = "active";
    private static final String ID = "id";
    private static final String NAMESPACE_CODE = "namespaceCode";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String UNIT_HIERARCHY = "unitHierarchy";
    private static final String TRUE = "Y";
    private static final String FALSE = "N";

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {

        final List<Predicate> andPredicates = new ArrayList<>();

        final String id = fieldValues.get(ID);
        if (StringUtils.isNotBlank(id)) {
            andPredicates.add(likeIgnoreCase(ID, id));
        }

        final String namespaceCode = fieldValues.get(NAMESPACE_CODE);
        if (StringUtils.isNotBlank(namespaceCode)) {
            andPredicates.add(likeIgnoreCase(NAMESPACE_CODE, namespaceCode));
        }

        final String name = fieldValues.get(NAME);
        if (StringUtils.isNotBlank(name)) {
            andPredicates.add(likeIgnoreCase(NAME, name));
        }

        final String description = fieldValues.get(DESCRIPTION);
        if (StringUtils.isNotBlank(description)) {
            andPredicates.add(likeIgnoreCase(DESCRIPTION, description));
        }

        andPredicates.add(equal(ACTIVE, true));

        final String unitHierarchy = fieldValues.get(UNIT_HIERARCHY);
        if (TRUE.equals(unitHierarchy)) {
            andPredicates.add(equal(KIM_TYPE_ID, UnitRoleConstants.UNIT_HIERARCHY_TYPE));
        } else if (FALSE.equals(unitHierarchy)) {
            andPredicates.add(equal(KIM_TYPE_ID, UnitRoleConstants.UNIT_TYPE));
        } else {
            andPredicates.add(or(equal(KIM_TYPE_ID, UnitRoleConstants.UNIT_HIERARCHY_TYPE), equal(KIM_TYPE_ID, UnitRoleConstants.UNIT_TYPE)));
        }

        return getDataObjectService().findMatching(RoleBoLite.class, QueryByCriteria.Builder.fromPredicates(andPredicates)).getResults()
                .stream()
                .sorted(Comparator.comparing(RoleEbo::getNamespaceCode).thenComparing(RoleEbo::getName))
                .map(UnitRole::fromRoleBoLite)
                .collect(Collectors.toList());
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }
}
