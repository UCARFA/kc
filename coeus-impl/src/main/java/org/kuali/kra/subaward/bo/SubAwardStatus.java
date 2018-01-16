/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class SubAwardStatus extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private Integer subAwardStatusCode;

    private String description;


    public SubAwardStatus() {
    }

    /**.
    * This is the Getter Method for subAwardStatusCode
    * @return Returns the subAwardStatusCode.
    */
  public Integer getSubAwardStatusCode() {
   return subAwardStatusCode;
   }

	/**.
	 * This is the Setter Method for subAwardStatusCode
	 * @param subAwardStatusCode The subAwardStatusCode to set.
	 */
	public void setSubAwardStatusCode(Integer subAwardStatusCode) {
		this.subAwardStatusCode = subAwardStatusCode;
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
