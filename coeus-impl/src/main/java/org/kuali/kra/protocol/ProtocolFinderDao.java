/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.protocol;

import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

import java.util.List;


/**
 * The ProtocolFinderDao is used to find protocols.
 */
public interface ProtocolFinderDao {

    /**
     * Find the current protocol given a protocolNumber.  The
     * current protocol is the one with the highest sequence number.
     * @param protocolNumber
     * @return the protocol or null if not found
     */
    ProtocolBase findCurrentProtocolByNumber(String protocolNumber);
    
    /**
     * 
     * This method all protocol submission belong to this protocolNumber.  also include amendment and renewal of this protocol.
     * @param protocolNumber
     * @param submissionNumber
     * @return
     */
    List<ProtocolSubmissionBase> findProtocolSubmissions(String protocolNumber, int submissionNumber);

    /**
     * 
     * This method is to find all the versioned protocols, amendments, renewals with this protocolNumber.
     * @param protocolNumber
     * @return
     */
    List<ProtocolBase> findProtocols(String protocolNumber);
}
