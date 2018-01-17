/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.amendrenew;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.amendrenew.ModifyAmendmentSectionsEventBase;

/**
 * When amendment sections are modified, this event is generated.
 */
@SuppressWarnings("unchecked")
public class ModifyAmendmentSectionsEvent extends ModifyAmendmentSectionsEventBase {

    public ModifyAmendmentSectionsEvent(ProtocolDocumentBase document, String propertyName, ProtocolAmendmentBean amendmentBean) {
        super(document, propertyName, amendmentBean);
    }
    
    @Override
    public ModifyAmendmentSectionsRule getRule() {
        return new ModifyAmendmentSectionsRule();
    }
}
