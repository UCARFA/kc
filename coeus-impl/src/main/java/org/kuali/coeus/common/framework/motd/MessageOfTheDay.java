/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.motd;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

public class MessageOfTheDay extends KcPersistableBusinessObjectBase implements MutableInactivatable {

    private static final long serialVersionUID = 5649376154094364142L;

    private Long messageOfTheDayId;

    private String message;

    private boolean active;

    private Long displayOrder;

    public Long getMessageOfTheDayId() {
        return messageOfTheDayId;
    }

    public void setMessageOfTheDayId(Long messageOfTheDayId) {
        this.messageOfTheDayId = messageOfTheDayId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Long displayOrder) {
        this.displayOrder = displayOrder;
    }
}
