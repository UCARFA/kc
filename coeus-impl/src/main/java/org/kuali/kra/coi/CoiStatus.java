/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class CoiStatus extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1957357011310589190L;

    private String coiStatusCode;

    private String description;

    public CoiStatus() {
    }

    public String getCoiStatusCode() {
        return coiStatusCode;
    }

    public void setCoiStatusCode(String coiStatusCode) {
        this.coiStatusCode = coiStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
