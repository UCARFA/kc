/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo.rule;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.bo.NsfCode;
import org.kuali.rice.kns.document.MaintenanceDocument;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;
import static org.kuali.coeus.sys.framework.util.CollectionUtils.entry;
import static org.kuali.coeus.sys.framework.util.CollectionUtils.entriesToMap;


public class NsfCodeMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {

    @Override
    protected boolean processCustomSaveDocumentBusinessRules(MaintenanceDocument document) {
        boolean valid = super.processCustomSaveDocumentBusinessRules(document);

        final NsfCode newNsfCode = (NsfCode) document.getNewMaintainableObject().getBusinessObject();
        if (StringUtils.isNotBlank(newNsfCode.getNsfCode()) && newNsfCode.getYear() != null)  {
            final Collection<NsfCode> nsfCodes = getBoService().findMatching(NsfCode.class,
                    Stream.<Map.Entry<String, Object>>of(entry("nsfCode", newNsfCode.getNsfCode()), entry("year", newNsfCode.getYear()))
                            .collect(entriesToMap()));

            if (!nsfCodes.isEmpty()) {
                final NsfCode existing = nsfCodes.iterator().next();
                if (!existing.getNsfSequenceNumber().equals(newNsfCode.getNsfSequenceNumber())) {
                    putFieldError("nsfCode", "error.nsf.code.duplicate.code.year", new String[] {newNsfCode.getNsfCode(), newNsfCode.getYear().toString()});
                    valid = false;
                }
            }
        }

        return valid;
    }
}
