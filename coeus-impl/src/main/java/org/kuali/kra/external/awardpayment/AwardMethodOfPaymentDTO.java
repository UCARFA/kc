/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.awardpayment;

import java.io.Serializable;

public class AwardMethodOfPaymentDTO implements Serializable {

	private static final long serialVersionUID = 492600544085327507L;
	
	private String methodOfPaymentCode;
    private String description;
    
    public AwardMethodOfPaymentDTO() { }
        
	public String getMethodOfPaymentCode() {
		return methodOfPaymentCode;
	}
	public void setMethodOfPaymentCode(String methodOfPaymentCode) {
		this.methodOfPaymentCode = methodOfPaymentCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
