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
package org.kuali.coeus.propdev.impl.s2s.nih;


import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class ProposalPageValuesFinder extends UifKeyValuesFinderBase {
    public static final ConcreteKeyValue SELECT = new ConcreteKeyValue(StringUtils.EMPTY, "select");
    private PageSectionService pageSectionService;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        for (String section : getPageSectionService().getPageIds()) {
            keyValues.add(new ConcreteKeyValue(section, section));
        }
        keyValues.add(0, SELECT);
        return keyValues;

    }

    public PageSectionService getPageSectionService() {
        if (pageSectionService == null) {
            pageSectionService = KcServiceLocator.getService(PageSectionService.class);
        }
        return pageSectionService;
    }
}

