/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
* This class represents closeout type.
*  Here Close out description and corresponding type codes are getting.
 */
public class CloseoutType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private Integer closeoutTypeCode;

    private String description;


    public CloseoutType() {
    }

 /**.
	 * This is the Getter Method for closeoutTypeCode
	 * @return Returns the closeoutTypeCode.
	 */
	public Integer getCloseoutTypeCode() {
		return closeoutTypeCode;
	}

	/**.
	 * This is the Setter Method for closeoutTypeCode
	 * @param closeoutTypeCode The closeoutTypeCode to set.
	 */
	public void setCloseoutTypeCode(Integer closeoutTypeCode) {
		this.closeoutTypeCode = closeoutTypeCode;
	}

	/**.
	 * This is the Getter Method for description
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**.
	 * This is the Setter Method for description
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}


}
