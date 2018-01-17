/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;

public abstract class ProtocolPersonRoleBase extends KcPersistableBusinessObjectBase implements Comparable<ProtocolPersonRoleBase>, MutableInactivatable {


    private static final long serialVersionUID = -4525940858799917386L;

    public static final String ROLE_PRINCIPAL_INVESTIGATOR = "PI";

    public static final String ROLE_CO_INVESTIGATOR = "COI";

    public static final String ROLE_STUDY_PERSONNEL = "SP";
    
    public static final String ROLE_CORRESPONDENT_ADMINISTRATOR = "CA";

    private String protocolPersonRoleId;

    private String description;

    private boolean unitDetailsRequired;

    private boolean affiliationDetailsRequired;

    private boolean trainingDetailsRequired;

    private boolean commentsDetailsRequired;

    private boolean active;

    public ProtocolPersonRoleBase() {
    }

    public String getProtocolPersonRoleId() {
        return protocolPersonRoleId;
    }

    public void setProtocolPersonRoleId(String protocolPersonRoleId) {
        this.protocolPersonRoleId = protocolPersonRoleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUnitDetailsRequired() {
        return unitDetailsRequired;
    }

    public void setUnitDetailsRequired(boolean unitDetailsRequired) {
        this.unitDetailsRequired = unitDetailsRequired;
    }

    public boolean isAffiliationDetailsRequired() {
        return affiliationDetailsRequired;
    }

    public void setAffiliationDetailsRequired(boolean affiliationDetailsRequired) {
        this.affiliationDetailsRequired = affiliationDetailsRequired;
    }

    public boolean isTrainingDetailsRequired() {
        return trainingDetailsRequired;
    }

    public void setTrainingDetailsRequired(boolean trainingDetailsRequired) {
        this.trainingDetailsRequired = trainingDetailsRequired;
    }

    public boolean isCommentsDetailsRequired() {
        return commentsDetailsRequired;
    }

    public void setCommentsDetailsRequired(boolean commentsDetailsRequired) {
        this.commentsDetailsRequired = commentsDetailsRequired;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int compareTo(ProtocolPersonRoleBase other) {
        int result = 0;
        if (other != null) {
            if (description != null && other.description != null) {
                result = description.compareTo(other.getDescription());
            } else if (description == null && other.getDescription() != null) {
                result = 1;
            } else if (description != null && other.getDescription() == null) {
                result = -1;
            } else {
                result = 0;
            }
        }
        return result;
    }
}
