/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.rice.krad.rules.rule.event.DocumentEvent;

/**
 * Event triggered when a protocol unit state is modified on a 
 * <code>{@link ProtocolDocumentBase}</code>
 *
 */
public interface ProtocolUnitEvent extends DocumentEvent {
    /**
     * @return <code>{@link ProtocolUnitBase}</code> that triggered this event.
     */
    public ProtocolUnitBase getProtocolUnit();
    
    public int getPersonIndex();

}
