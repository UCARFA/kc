/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;

import java.util.List;

public  abstract class DisclosureReporter extends KcPersistableBusinessObjectBase {

    private transient KcPersonService kcPersonService;
    private transient KcPerson reporter;
    private int selectedUnit;

    
    public abstract String getPersonId();
 //   public abstract void setPersonId(String personId);
    public abstract List<? extends DisclosureReporterUnit> getDisclosureReporterUnits();

    public KcPerson getReporter() {
        if (reporter == null && getPersonId() != null) {
            reporter = getKcPersonService().getKcPersonByPersonId(getPersonId());
        }
        return reporter;
    }

    /**
     * Gets the KC Person Service.
     * 
     * @return KC Person Service.
     */
    protected KcPersonService getKcPersonService() {
        if (this.kcPersonService == null) {
            this.kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        }

        return this.kcPersonService;
    }

    public int getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(int selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

}
