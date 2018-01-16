/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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

