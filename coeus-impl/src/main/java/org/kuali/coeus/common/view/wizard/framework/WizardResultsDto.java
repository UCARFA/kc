/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.view.wizard.framework;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.rice.kim.impl.role.RoleBo;

public class WizardResultsDto {
    private boolean selected;
    private RoleBo role;
    private Rolodex rolodex;
    private KcPerson kcPerson;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public RoleBo getRole() {
        return role;
    }

    public void setRole(RoleBo role) {
        this.role = role;
    }

    public Rolodex getRolodex() {
        return rolodex;
    }

    public void setRolodex(Rolodex rolodex) {
        this.rolodex = rolodex;
    }

    public KcPerson getKcPerson() {
        return kcPerson;
    }

    public void setKcPerson(KcPerson kcPerson) {
        this.kcPerson = kcPerson;
    }
}
