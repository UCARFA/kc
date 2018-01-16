/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

import java.util.List;

public interface ProtocolNotepadService {

    /**
     * Populate the updateUserFullName transient field in each ProtocolNotepadBase object in the list param. 
     * list.
     * @param protocolNotepads The list of ProtocolNotepadBase objects you wish to populate the updateUserFullName field on.
     */
    void setProtocolNotepadUpdateUsersName(List<ProtocolNotepadBase> protocolNotepads);
    
}
