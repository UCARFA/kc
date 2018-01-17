/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.instprop.impl.api;

import com.codiform.moo.annotation.CollectionProperty;

import org.kuali.coeus.sys.framework.rest.ResponseResults;

import java.util.Collection;

public class InstitutionalProposalResults extends ResponseResults {
    @CollectionProperty(source="results", itemClass=InstitutionalProposalSummaryDto.class)
    private Collection<InstitutionalProposalSummaryDto> institutionalProposals;

    public Collection<InstitutionalProposalSummaryDto> getInstitutionalProposals() {
        return institutionalProposals;
    }

    public void setInstitutionalProposals(Collection<InstitutionalProposalSummaryDto> institutionalProposals) {
        this.institutionalProposals = institutionalProposals;
    }
}
