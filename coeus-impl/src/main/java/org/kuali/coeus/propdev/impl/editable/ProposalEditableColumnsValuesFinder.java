/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;

import org.kuali.coeus.sys.framework.keyvalue.KeyValueFinderService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.propdev.impl.editable.ProposalColumnsToAlter;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.List;
/**
 * Finds the set of editable Proposal Fields.  See
 * the method <code>getKeyValues()</code> for a full description.
 * 
 * @author KRADEV team
 */

public class ProposalEditableColumnsValuesFinder extends UifKeyValuesFinderBase {
    KeyValueFinderService keyValueFinderService= (KeyValueFinderService) KcServiceLocator.getService("keyValueFinderService");

    @Override
    public List<KeyValue> getKeyValues() {
        return keyValueFinderService.getKeyValues(ProposalColumnsToAlter.class, "columnName", "columnLabel");
    }
}
