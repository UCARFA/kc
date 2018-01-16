/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.correction;

import org.kuali.kra.protocol.actions.ProtocolEditableBean;

public interface AdminCorrectionBean extends ProtocolEditableBean {
    
    public String getComments();
    
    public void setComments(String comments);
    
    public boolean isApplyCorrection();
    
    public void setApplyCorrection(boolean applyCorrection);
    
    public boolean isAmendmentRenewalOutstanding();
    
}
