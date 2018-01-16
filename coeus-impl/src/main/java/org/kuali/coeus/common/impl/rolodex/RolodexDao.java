/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rolodex;

import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.common.framework.rolodex.NonOrganizationalRolodex;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.List;
import java.util.Map;

/**
 * Data Access Object for special needs of <code>{@link Rolodex}</code> like the <code>{@link NonOrganizationalRolodex}</code>
 * 
 * @see org.kuali.coeus.common.framework.rolodex.Rolodex
 * @see org.kuali.coeus.common.framework.rolodex.NonOrganizationalRolodex
 */
public interface RolodexDao {

    /**
     * Search using the PersistanceBroker for <code>{@link Rolodex}</code> instances that have first, middle, and/or last names.
     * 
     * @param fieldValues Search criteria by object attribute
     * @param usePrimaryKeys indicates whether to simplify the search due to criteria restricted to primary keys
     * @return Collection of <code>{@link Rolodex}</code> instances
     */
    public List<? extends BusinessObject> getNonOrganizationalRolodexResults(Map fieldValues, boolean usePrimaryKeys);
}
