/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.rolodex;

import java.io.Serializable;

import org.kuali.coeus.common.framework.contact.Contactable;
import org.kuali.coeus.common.framework.rolodex.Rolodex;

/**
 * Special Business Object for NonOrganizational types of <code>{@link Rolodex}</code> instances.
 * 
 */
public class NonOrganizationalRolodex extends Rolodex implements Contactable {
    private static final long serialVersionUID = -4699230471690515157L;

    @Override
    public Serializable getIdentifier() {
        return getRolodexId();
    }


    public void setIdentifier(Serializable identifier) {
        setRolodexId((Integer) identifier);
    }

    @Override
    public String getContactOrganizationName() {
        return getOrganization();
    }

    @Override
    public String getOrganizationIdentifier() {
        return getOwnedByUnit();
    }
}
