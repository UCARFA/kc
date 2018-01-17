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
import org.kuali.kra.iacuc.procedures.IacucProtocolStudyGroupBean;

public class AddProtocolStudyGroupEvent extends KcDocumentEventBaseExtension {

    private IacucProtocolStudyGroupBean procedureBean;
    private Integer procedureBeanIndex;
    
    public AddProtocolStudyGroupEvent(IacucProtocolDocument document, IacucProtocolStudyGroupBean procedureBean, 
            Integer procedureBeanIndex) {
        super("Add Study Group", "", document);
        this.procedureBean = procedureBean;
        this.procedureBeanIndex = procedureBeanIndex;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public KcBusinessRule getRule() {
        return new AddProtocolStudyGroupRule();
    }

    public Integer getProcedureBeanIndex() {
        return procedureBeanIndex;
    }

    public void setProcedureBeanIndex(Integer procedureBeanIndex) {
        this.procedureBeanIndex = procedureBeanIndex;
    }

    public IacucProtocolStudyGroupBean getProcedureBean() {
        return procedureBean;
    }

    public void setProcedureBean(IacucProtocolStudyGroupBean procedureBean) {
        this.procedureBean = procedureBean;
    }

}
