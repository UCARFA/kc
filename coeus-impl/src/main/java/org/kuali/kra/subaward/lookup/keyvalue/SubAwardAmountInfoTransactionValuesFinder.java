/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.lookup.keyvalue;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubAwardAmountInfoTransactionValuesFinder extends FormViewAwareUifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return Stream.concat(Stream.of(ValuesFinderUtils.getSelectOption()),
                ((SubAwardDocument) getDocument()).getSubAward().getAllSubAwardAmountInfos()
                .stream()
                .filter(info -> StringUtils.isNotEmpty(info.getModificationTypeCode()))
                .filter(info -> info.getEffectiveDate() != null)
                .peek(info -> {
                    if (info.getModificationType() == null) {
                        info.refreshReferenceObject("modificationType");
                    }
                })
                .map(info -> new ConcreteKeyValue(info.getSubAwardAmountInfoId().toString(),
                        info.getModificationType().getDescription() + " - " + sdf.format(info.getEffectiveDate()))))
                .collect(Collectors.toList());
    }
}
