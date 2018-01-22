/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.person;


import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPerson;

import java.io.Serializable;

public class AddEmployeePiHelper implements Serializable {

    private String personId;
    private transient KcPerson kcPerson;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public KcPerson getKcPerson() {
        if (StringUtils.isNotBlank(personId) && (kcPerson == null || !personId.equals(kcPerson.getPersonId()))) {
            kcPerson = KcPerson.fromPersonId(personId);
        }

        return kcPerson;
    }

    public void setKcPerson(KcPerson kcPerson) {
        this.kcPerson = kcPerson;
    }
}
