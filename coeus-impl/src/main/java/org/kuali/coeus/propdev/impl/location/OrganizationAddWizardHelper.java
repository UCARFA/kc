/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.coeus.common.framework.rolodex.Rolodex;

public class OrganizationAddWizardHelper implements Serializable {

    private Map<String, String> lookupFieldValues;
    private Map<String, String> newOrganizationFieldValues;
    private List<Rolodex> results;      
   
	public OrganizationAddWizardHelper() {
        lookupFieldValues = new HashMap<String, String>();
        results = new ArrayList<Rolodex>();
        newOrganizationFieldValues = new HashMap<String, String>();
    }
    
    public void reset() {
        lookupFieldValues.clear();
        results.clear();       
    } 
    
    public List<Rolodex> getResults() {
		return results;
	}

	public void setResults(List<Rolodex> results) {
		this.results = results;
	}

	public Map<String, String> getLookupFieldValues() {
        return lookupFieldValues;
    }

    public void setLookupFieldValues(Map<String, String> lookupFieldValues) {
        this.lookupFieldValues = lookupFieldValues;
    }

	public Map<String, String> getNewOrganizationFieldValues() {
		return newOrganizationFieldValues;
	}

	public void setNewOrganizationFieldValues(
			Map<String, String> newOrganizationFieldValues) {
		this.newOrganizationFieldValues = newOrganizationFieldValues;
	}
	
}
