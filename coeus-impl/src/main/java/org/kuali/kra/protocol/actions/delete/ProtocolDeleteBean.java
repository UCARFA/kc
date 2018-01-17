/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.delete;

import org.kuali.kra.protocol.actions.ProtocolActionBean;

import java.io.Serializable;

/**
 * This class is really just a "form" containing the reason
 * for deleting a protocol/amendment/renewal.
 */
public interface ProtocolDeleteBean extends ProtocolActionBean, Serializable {

    public void setReason(String reason);

    public String getReason();
}
