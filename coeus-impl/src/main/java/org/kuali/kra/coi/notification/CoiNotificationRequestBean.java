/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notification;

import org.kuali.kra.coi.CoiDisclosure;

import java.io.Serializable;

public class CoiNotificationRequestBean implements Serializable {

    private CoiDisclosure coiDisclosure;
    private String actionType;
    private String description;
    private String docNumber;

    public CoiNotificationRequestBean(CoiDisclosure coiDisclosure, String actionType, String description) {
        this.coiDisclosure = coiDisclosure;
        this.actionType = actionType;
        this.description = description;
    }
    
    public CoiNotificationRequestBean(CoiDisclosure coiDisclosure, String actionType, String description, String docNumber) {
        this(coiDisclosure, actionType, description);
        this.docNumber = docNumber;
    }
    
    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }

    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

}
