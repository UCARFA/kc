/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.procedures.rule;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.procedures.IacucProtocolStudyGroupLocation;

/**
 * This class hooks Rule to Event in KNS
 */
public class AddProcedureLocationEvent extends KcDocumentEventBaseExtension {

    private IacucProtocolStudyGroupLocation iacucProtocolStudyGroupLocation;
    private IacucProtocolDocument iacucProtocolDocument;
    
    public AddProcedureLocationEvent(IacucProtocolDocument document, IacucProtocolStudyGroupLocation iacucProtocolStudyGroupLocation) { 
        super("Add Procedure Location", "", document);
        this.iacucProtocolStudyGroupLocation = iacucProtocolStudyGroupLocation;
        this.iacucProtocolDocument = document;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public KcBusinessRule getRule() {
        return new AddProcedureLocationRule();
    }

    public IacucProtocolStudyGroupLocation getIacucProtocolStudyGroupLocation() {
        return iacucProtocolStudyGroupLocation;
    }

    public void setIacucProtocolStudyGroupLocation(IacucProtocolStudyGroupLocation iacucProtocolStudyGroupLocation) {
        this.iacucProtocolStudyGroupLocation = iacucProtocolStudyGroupLocation;
    }

    public IacucProtocolDocument getIacucProtocolDocument() {
        return iacucProtocolDocument;
    }

    public void setIacucProtocolDocument(IacucProtocolDocument iacucProtocolDocument) {
        this.iacucProtocolDocument = iacucProtocolDocument;
    }


}
