/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.rules;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.lookup.keyvalue.CommitteeIdValuesFinderBase;
import org.kuali.coeus.common.committee.impl.rules.CommitteeDocumentRuleBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.document.CommonCommitteeDocument;
import org.kuali.kra.iacuc.committee.lookup.keyvalue.IacucCommitteeIdValuesFinder;

public class IacucCommitteeDocumentRule extends CommitteeDocumentRuleBase {

    @Override
    protected Class<? extends CommitteeBase> getCommitteeBOClassHook() {
        return IacucCommittee.class;
    }

    @Override
    protected CommitteeIdValuesFinderBase getNewCommitteeIdValuesFinderInstanceHook() {
        return new IacucCommitteeIdValuesFinder();        
    }

    @Override
    protected Class<? extends CommitteeDocumentBase> getCommitteeDocumentBOClassHook() {
        return CommonCommitteeDocument.class;
    }

}
