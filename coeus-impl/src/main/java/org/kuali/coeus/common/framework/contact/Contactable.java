/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.contact;

import java.io.Serializable;

import org.kuali.coeus.common.framework.unit.Unit;

/**
 * This interface defines behaviors for identifying an associated contact 
 */
public interface Contactable {
    /**
     * This method returns the serializable identifier of the contact. May return null if no identifier has yet been assigned.
     * @return
     */
    Serializable getIdentifier();

    /**
     * This method returns the full name of the contact. May be null
     * @return
     */
    String getFullName();
    
    /**
     * This method returns the associated unit
     * @return
     */
    Unit getUnit();
    
    /**
     * This method returns the contact's organization name. May be the unit name or something different. Also, may return null.
     * @return
     */
    String getContactOrganizationName();
    
    /**
     * This method returns the contact's associated unit number.  This is commonly referred to as homeUnit is many places in KC.
     * @return
     */
    String getOrganizationIdentifier();
    
    /**
     * This method returns the contact's e-mail address. May return null.
     * @return
     */
    String getEmailAddress();
    
    /**
     * This method returns the contact's phone number. May return null.
     * @return
     */
    String getPhoneNumber();


    String getFirstName();


    String getLastName();
}
