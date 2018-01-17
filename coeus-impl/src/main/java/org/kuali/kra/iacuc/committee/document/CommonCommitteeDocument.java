/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.document;

import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;

import java.util.ArrayList;
import java.util.List;

public class CommonCommitteeDocument extends CommitteeDocumentBase<CommonCommitteeDocument, IacucCommittee, IacucCommitteeSchedule> {


    private static final long serialVersionUID = 7253898081493879835L;

    @Override
    protected CommonCommitteeDocument getThisHook() {
        return this;
    }

    @Override
    protected IacucCommittee getNewCommitteeInstanceHook() {
        return new IacucCommittee();
    }

    @Override
    protected IacucCommitteeService getCommitteeService() {
        return KcServiceLocator.getService(IacucCommitteeService.class);
    }

    @Override
    public List<? extends DocumentCustomData> getDocumentCustomData() {
        return new ArrayList<>();
    }

}
