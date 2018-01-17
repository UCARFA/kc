/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.propdev.impl.location.BasicProposalSiteEvent;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;

/**
 * This class handles the "Delete Proposal Site" and "Clear Proposal Site Address" events; it is also a superclass for other rules
 */
public class ProposalSiteRule extends KcTransactionalDocumentRuleBase {

    public boolean processBasicProposalSiteRules(BasicProposalSiteEvent proposalSiteEvent) {
        String siteIndexStr = proposalSiteEvent.getSiteIndex();
        return isIndexValid(siteIndexStr, "Site Index");
    }
    
    protected boolean isIndexValid(String indexStr, String indexName) {
        if (StringUtils.isEmpty(indexStr) || !StringUtils.isNumeric(indexStr)) {
            reportError("newPropLocation.location", KeyConstants.ERROR_PROPOSAL_SITES_INDEX_INVALID_FORMAT, indexName);
            return false;
        }
        return true;
    }
}
