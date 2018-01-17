/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.lookup.keyvalue;

import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kim.api.KimConstants;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the values finder for the role qualifiers field in notifications
 */
public class NotificationModuleRoleQualifierValuesFinder extends UifKeyValuesFinderBase {


    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> documentList = new ArrayList<KeyValue>();
        documentList.add(new ConcreteKeyValue(KcKimAttributes.UNIT_NUMBER, "Unit Number"));
        documentList.add(new ConcreteKeyValue("protocolLeadUnitNumber", "Unit Number (Online Review)"));
        documentList.add(new ConcreteKeyValue(KcKimAttributes.PROTOCOL, "Protocol Number"));
        documentList.add(new ConcreteKeyValue(KcKimAttributes.SUBUNITS, "Descend Heirarchy"));
        documentList.add(new ConcreteKeyValue("submissionId", "Submission Id"));
        documentList.add(new ConcreteKeyValue("protocolOnlineReviewId", "Protocol Online Review Id"));
        documentList.add(new ConcreteKeyValue("negotiation", "Negotiation Id"));
        documentList.add(new ConcreteKeyValue("coiDisclosureId", "Disclosure Id"));
        documentList.add(new ConcreteKeyValue(KcKimAttributes.PROPOSAL, "Proposal"));
        documentList.add(new ConcreteKeyValue(KcKimAttributes.AWARD, "Award"));
        documentList.add(new ConcreteKeyValue(KimConstants.AttributeConstants.DOCUMENT_NUMBER, "Document Number"));
        
        return documentList;
    }

}
