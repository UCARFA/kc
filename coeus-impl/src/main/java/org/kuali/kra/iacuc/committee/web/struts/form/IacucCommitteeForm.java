/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.web.struts.form;

import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.web.struts.form.CommitteeFormBase;
import org.kuali.coeus.common.committee.impl.web.struts.form.CommitteeHelperBase;
import org.kuali.rice.kew.api.WorkflowDocument;
import org.kuali.rice.kns.web.ui.HeaderField;
import org.springframework.util.CollectionUtils;

public class IacucCommitteeForm extends CommitteeFormBase {


    private static final long serialVersionUID = 5623611578157741521L;

    @Override
    protected CommitteeHelperBase getNewCommitteeHelperInstanceHook(CommitteeFormBase committeeForm) {
        return new IacucCommitteeHelper((IacucCommitteeForm)committeeForm);
    }

    @Override
    protected String getDefaultDocumentTypeName() {
        return "CommonCommitteeDocument";
    }
    
    @Override
    public void populateHeaderFields(WorkflowDocument workflowDocument) {
        super.populateHeaderFields(workflowDocument);
        CommitteeDocumentBase committeeDoc = getCommitteeDocument();

        getDocInfo().set(4, new HeaderField("DataDictionary.KraAttributeReferenceDummy.attributes.committeeId", (committeeDoc == null || CollectionUtils.isEmpty(committeeDoc.getCommitteeList())) ? null : committeeDoc.getCommittee().getCommitteeId()));
        getDocInfo().set(5, new HeaderField("DataDictionary.KraAttributeReferenceDummy.attributes.committeeName", getCommitteeNameForHeaderDisplay(committeeDoc)));
    }



}
