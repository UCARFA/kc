/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.genericactions;

import org.kuali.kra.irb.actions.correspondence.AbstractProtocolActionsCorrespondence;

/**
 * 
 * This class deals with the template and the printing for one of the Generic protocol actions.
 */
public class ProtocolGenericCorrespondence extends AbstractProtocolActionsCorrespondence {

    public static final long serialVersionUID = 1235567880;
    
    private String protocolActionType;
    
    /**
     * 
     * Constructs a ProtocolGenericCorrespondence.java.
     * @param protocolActionType
     */
    public ProtocolGenericCorrespondence(String protocolActionType) {
        this.protocolActionType = protocolActionType;
    }
    
    @Override
    public String getProtocolActionType() {
        return this.protocolActionType;
    }

}
