/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.protocol.funding;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * Represents the event for saving a ProtocolBase Funding Source.
 */
public class SaveProtocolFundingSourceLinkEvent extends KcDocumentEventBaseExtension {
    
    private List<ProtocolFundingSourceBase> protocolFundingSources;
    
    private List<ProtocolFundingSourceBase> deletedProtocolFundingSources;
    
    /**
     * Constructs a SaveProtocolFundingSourceEvent.
     * 
     * @param errorPathPrefix
     * @param document
     * @param protocolFundingSources
     */
    public SaveProtocolFundingSourceLinkEvent(Document document, List<ProtocolFundingSourceBase> protocolFundingSources, 
        List<ProtocolFundingSourceBase> deletedProtocolFundingSources) {
        
        super("saving protocol funding sources to document " + getDocumentId(document), Constants.EMPTY_STRING, document);
        this.protocolFundingSources = protocolFundingSources;
        this.deletedProtocolFundingSources = deletedProtocolFundingSources;
    }

    public List<ProtocolFundingSourceBase> getProtocolFundingSources() {
        return protocolFundingSources;
    }

    public void setProtocolFundingSources(List<ProtocolFundingSourceBase> protocolFundingSources) {
        this.protocolFundingSources = protocolFundingSources;
    }

    public List<ProtocolFundingSourceBase> getDeletedProtocolFundingSources() {
        return deletedProtocolFundingSources;
    }

    public void setDeletedProtocolFundingSources(List<ProtocolFundingSourceBase> deletedProtocolFundingSources) {
        this.deletedProtocolFundingSources = deletedProtocolFundingSources;
    }

    @Override
    public KcBusinessRule<SaveProtocolFundingSourceLinkEvent> getRule() {
        return new SaveProtocolFundingSourceLinkRule();
    }
    
}
