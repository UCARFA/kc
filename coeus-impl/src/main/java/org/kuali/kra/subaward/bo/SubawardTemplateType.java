/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class SubawardTemplateType extends KcPersistableBusinessObjectBase{
    
    private Integer templateTypeCode;

    private String description;

    /**.
    * This is the Getter Method for templateTypeCode
    * @return Returns the templateTypeCode.
    */
    public Integer getTemplateTypeCode() {
        return templateTypeCode;
    }

    /**.
     * This is the Setter Method for templateTypeCode
     * @param templateTypeCode The templateTypeCode to set.
     */
    public void setTemplateTypeCode(Integer templateTypeCode) {
        this.templateTypeCode = templateTypeCode;
    }

    /**.
    * This is the Getter Method for description
    * @return Returns the description.
    */
    public String getDescription() {
        return description;
    }

    /**.
     * This is the Getter Method for description
     * @return Returns the description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
