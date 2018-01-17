/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class CoiDisclosureStatus extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -204509679832775700L;
  
    public static final String IN_PROGRESS = "1";
    public static final String ROUTED_FOR_REVIEW = "2";
    public static final String APPROVED = "3";
    public static final String DISAPPROVED = "4";

    private String coiDisclosureStatusCode;

    private String description;

    public String getCoiDisclosureStatusCode() {
        return coiDisclosureStatusCode;
    }

    public void setCoiDisclosureStatusCode(String coiDisclosureStatusCode) {
        this.coiDisclosureStatusCode = coiDisclosureStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
