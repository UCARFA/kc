/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

public interface NarrativeAuthZService {

    /**
     * Gets the default narrative right for a user.  The default narrative
     * right is the highest right that a user can have based upon his/her
     * permissions.
     * 
     * @param userId the user's unique username
     * @param doc the Proposal Development Document
     * @return the user's default narrative right
     */
    public NarrativeRight getDefaultNarrativeRight(String userId, ProposalDevelopmentDocument doc);
    
    /**
     * Gets the default narrative right for a user.  The default narrative
     * right is the highest right that a user can have based upon his/her
     * role.
     *
     * @param roleName the proposal role for the user
     * @return the user's default narrative right
     */
    public NarrativeRight getDefaultNarrativeRight(String roleName);
}
