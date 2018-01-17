/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.service.KeyValuesService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class finds Project Roles for an Institutional Proposal contact
 */
public abstract class InstitutionalProposalContactsProjectRoleValuesFinder extends FormViewAwareUifKeyValuesFinderBase {

    private static final String EMPTY_STR = "";
    private static final String KEY_VALUES_SERVICE_NAME = "keyValuesService";

    @Override
    public List<KeyValue> getKeyValues() {
        return buildKeyValues(getKeyValuesService().findAll(getRoleType()));
    }


    protected KeyValuesService getKeyValuesService() {
        return (KeyValuesService) KcServiceLocator.getService(KEY_VALUES_SERVICE_NAME);
    }

    protected abstract Class<? extends ContactRole> getRoleType();
    
    /*
     * Build the pairs
     */
    private List<KeyValue> buildKeyValues(Collection<? extends ContactRole> contactRoles) {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        addEmptyKeyValuePair(keyValues);
        for (ContactRole role: contactRoles) {
            keyValues.add(new ConcreteKeyValue(role.getRoleCode(), role.getRoleDescription()));
        }
        return keyValues;
    }

    /**
     * This method adds an empty role in the selection
     * @param keyValues
     */
    protected void addEmptyKeyValuePair(List<KeyValue> keyValues) {
        keyValues.add(new ConcreteKeyValue(EMPTY_STR, EMPTY_STR));
    }

}
