/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions;

import org.kuali.kra.irb.actions.risklevel.ProtocolRiskLevelBean;

/**
 * Marks a <code>ProtocolActionBean</code> as being able to contain risk level comments.
 */
public interface ProtocolRiskLevelCommentable {
    
    /**
     * Gets the <code>ProtocolRiskLevelBean</code>.
     * @return the <code>ProtocolRiskLevelBean</code>
     */
    ProtocolRiskLevelBean getProtocolRiskLevelBean();

}
