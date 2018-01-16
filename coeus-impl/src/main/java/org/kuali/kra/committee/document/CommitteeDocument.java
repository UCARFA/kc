/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.committee.document;

import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.framework.custom.DocumentCustomData;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.service.CommitteeService;

import java.util.ArrayList;
import java.util.List;

public class CommitteeDocument extends CommitteeDocumentBase<CommitteeDocument, Committee, CommitteeSchedule> {


    private static final long serialVersionUID = -2248266592790548394L;

    @Override
    protected CommitteeDocument getThisHook() {
        return this;
    }

    @Override
    protected Committee getNewCommitteeInstanceHook() {
        return new Committee();
    }

    @Override
    protected CommitteeService getCommitteeService() {
        return KcServiceLocator.getService(CommitteeService.class);
    }

    @Override
    public List<? extends DocumentCustomData> getDocumentCustomData() {
        return new ArrayList<>();
    }

}
