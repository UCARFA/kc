/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.unit;

import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.coeus.common.framework.unit.crrspndnt.UnitCorrespondent;
import org.kuali.kra.iacuc.bo.IacucUnitCorrespondent;

import java.util.Collection;
import java.util.List;

/**
 * The Unit Service provides a set of queries related to Units.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface UnitService {
    
    /**
     * This method does a case insensitive search keyed on <code>unitNumber</code>, and
     * returns the matching unit object. If there is no match, then <code>null</code> is returned.
     * @param unitNumber
     * @return the unit or null if not found.
     */
    public Unit getUnitCaseInsensitive(String unitNumber);
    
    /**
     * This method returns the Unit name for a given Unit Number.
     * @param unitNumber identifier for the unit
     * @return The name of the unit identified by this number.
     */
    public String getUnitName(String unitNumber);

    /**
     * Get the Unit based upon its unique unit number.
     * 
     * @param unitNumber the unit's unique unit number
     * @return the unit or null if not found.
     */
    public Unit getUnit(String unitNumber);

    Unit getActiveUnit(String unitNumber);

    /**
     * Get the list of immediate sub-units for the given unit.
     * @param unitNumber the number of unit to find sub-units for
     * @return the list of immediate sub-units
     */
    public List<Unit> getSubUnits(String unitNumber);

    /**
     * Get the list of immediate active sub-units for the given unit.
     * @param unitNumber the number of unit to find sub-units for
     * @return the list of immediate sub-units
     */
    public List<Unit> getActiveSubUnits(String unitNumber);
    
    /**
     * Get the list of all of the sub-units for a given unit.
     * @param unitNumber the number of unit to find sub-units for
     * @return the list of all sub-units
     */
    public List<Unit> getAllSubUnits(String unitNumber);
    
    /**
     * 
     * This method returns the unit hierarch the passed in unit.  Including all the parent units, and the unit itself.
     * @param unitNumber
     * @return
     */
    public List<Unit> getUnitHierarchyForUnit(String unitNumber);

    /**
     * Get all of the Units.
     * @return all of the units
     */
    public Collection<Unit> getUnits();
    
    /**
     * 
     * This method to get the sub units for dynamic tree view
     * @param unitNumber
     * @return
     */
    public String getSubUnitsForTreeView(String unitNumber);

    
    /**
     * This method returns the top level unit in a hierarchy.
     * @return the top level unit
     */
    public Unit getTopUnit();
    
    /**
     * 
     * This method is to set up the initial load for unut hierarchy
     * @return
     */
    public String getInitialUnitsForUnitHierarchy();
    
    public String getInitialUnitsForUnitHierarchy(int depth);
    
    public List<UnitAdministrator> retrieveUnitAdministratorsByUnitNumber(String unitNumber);

    /**
     * This method returns a list of UnitCorrespondent
     * objects based on a passed unit number.
     * @param unitNumber identifier for the unit
     * @return list of UnitCorrespondent objects
     * null value is returned if no unit correspondents not found
     */
    public List<UnitCorrespondent> retrieveUnitCorrespondentsByUnitNumber(String unitNumber);

    List<UnitAdministrator> retrieveUnitAdministratorsByUnitNumberAndType(String unitNumber, String typeCode);

    /**
     * 
     * This method returns the tree depth of the entire unit hierarchy tree;
     * @return
     */
    public int getMaxUnitTreeDepth();

    /**
     * This method returns a list of IacucUnitCorrespondent
     * objects based on a passed unit number.
     * @param unitNumber identifier for the unit
     * @return list of IacucUnitCorrespondent objects
     * null value is returned if no unit correspondents not found
     */
    public List<IacucUnitCorrespondent> retrieveIacucUnitCorrespondentsByUnitNumber(String unitNumber);

    boolean appliesToUnit(String agendaQualifierValue, String environmentQualifierValue);



    }
