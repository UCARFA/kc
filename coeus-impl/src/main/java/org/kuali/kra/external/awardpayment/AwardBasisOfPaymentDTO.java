/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.awardpayment;

import java.io.Serializable;

public class AwardBasisOfPaymentDTO implements Serializable {

	private static final long serialVersionUID = -7293109685985758125L;
	
	private String basisOfPaymentCode;
    private String description;
    
    public AwardBasisOfPaymentDTO() { }
    
	public String getBasisOfPaymentCode() {
		return basisOfPaymentCode;
	}
	public void setBasisOfPaymentCode(String basisOfPaymentCode) {
		this.basisOfPaymentCode = basisOfPaymentCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}
