/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.kra.protocol.actions.submit.ValidProtocolActionActionBase;

/**
 * This class represents the action follow up mapping as it exists in coeus.
 * A follow up action is mapped to an action via this bo.  When the user takes the action
 * protocolActionTypeCode they will be prompted to complete each of the actions associated with it 
 * via this object.  The properties protocolActionTypeCode, actionNumber, and followUpActionCode form
 * a unique key on the underlying table.
 * 
 */
public class IacucValidProtocolActionAction extends ValidProtocolActionActionBase {


    private static final long serialVersionUID = 920783769885103992L;

}
