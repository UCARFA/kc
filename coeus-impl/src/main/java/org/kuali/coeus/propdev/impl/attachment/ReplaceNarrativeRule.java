/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;


/**
 * Interface for adding proposal narratives
 *
 * @author kualidev@oncourse.iu.edu
 * @version 1.0
 */
public interface ReplaceNarrativeRule extends AddNarrativeRule {
    
    /**
     * Rule invoked upon replacing a proposal attachment within a
     * <code>{@link org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument}</code>
     *
     * @return boolean
     */
    public boolean processReplaceNarrativeBusinessRules(ReplaceNarrativeEvent replaceNarrativeEvent);
}
