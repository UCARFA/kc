/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.auth;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.negotiations.document.NegotiationDocument;

/**
 * 
 * This class manages the attributes needed for a negotiation task.
 */
public class NegotiationTask extends Task {
    
    private NegotiationDocument negotiationDocument;

    /**
     * 
     * Constructs a NegotiationTask.java.
     * @param taskName
     * @param negotiation
     */
    public NegotiationTask(String taskName, NegotiationDocument negotiationDocument) {
        super(TaskGroupName.NEGOTIATION, taskName);
        this.negotiationDocument = negotiationDocument;
    }
    
    public NegotiationDocument getNegotiationDocument() {
        return negotiationDocument;
    }

    public void setNegotiationDocument(NegotiationDocument negotiationDocument) {
        this.negotiationDocument = negotiationDocument;
    }    
}
