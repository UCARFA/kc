/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person.attr;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.attr.PersonTraining;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.maintenance.Maintainable;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.kns.web.ui.Field;
import org.kuali.rice.kns.web.ui.Row;
import org.kuali.rice.kns.web.ui.Section;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * This class is to initialize for person training maintenance document.
 */
public class PersonTrainingMaintainableImpl extends KraMaintainableImpl {
    private static final String COLUMN = ":";

    /**
     * This is a hook for initializing the BO from the maintenance framework. It initializes the {@link Explanation}s collection.
     * 
     * @param generateDefaultValues true for initialization
     */
    @Override
    public void setGenerateDefaultValues(String docTypeName) {
        initTrainingNumber();
        super.setGenerateDefaultValues(docTypeName);
    }

    /**
     * This is just trying to populate training number for person training
     * 
     * @see org.kuali.core.maintenance.KualiMaintainableImpl#getCoreSections(org.kuali.core.maintenance.Maintainable)
     */
    @Override
    public List<Section> getCoreSections(MaintenanceDocument document, Maintainable oldMaintainable) {
        if (!document.getNewMaintainableObject().getMaintenanceAction().equals(KRADConstants.MAINTENANCE_EDIT_ACTION)) {
            if (document.getDocumentHeader().getWorkflowDocument().isSaved() || document.getDocumentHeader().getWorkflowDocument().isInitiated()) {
            initTrainingNumber();
            }
        }
        return super.getCoreSections(document, oldMaintainable);
    }

    /**
     * Gets the {@link PersonTrainin}
     * 
     * @return
     */
    public PersonTraining getPersonTraining() {
        return (PersonTraining) getBusinessObject();
    }

    /**
     * Method to initialize PersonTraining with next training number.
     * 
     */
    private void initTrainingNumber() {
        if (getPersonTraining().getPersonTrainingId() == null) {
            Integer trainingNumber = 1;
            if (StringUtils.isNotBlank(getPersonTraining().getPersonId())) {
                Map fieldValues = new HashMap();
                fieldValues.put("personId", getPersonTraining().getPersonId());
                List<PersonTraining> personTrainings = (List<PersonTraining>) KNSServiceLocator.getBusinessObjectService().findMatching(
                        PersonTraining.class, fieldValues);
                if (!personTrainings.isEmpty()) {
                    trainingNumber = personTrainings.size() + 1;
                }
            }
            getPersonTraining().setTrainingNumber(trainingNumber);
        }
    }

    @Override
    public List getSections(MaintenanceDocument document, Maintainable oldMaintainable) {
        List<Section> sections = super.getSections(document, oldMaintainable);
        String keyName = "personId";
        for (Section section : sections) {
            for (Row row : section.getRows()) {
                for (Field field : row.getFields()) {
                    if ("personId".equals(field.getPropertyName())) {
                        if (document.isEdit()) {
                            field.setReadOnly(true);
                        } else {
                            field.setFieldConversions(keyName + COLUMN + field.getPropertyName());
                            field.setLookupParameters(field.getPropertyName() + COLUMN + keyName);
                            field.setInquiryParameters(field.getPropertyName() + COLUMN + keyName);
                            field.setQuickFinderClassNameImpl(KcPerson.class.getName());
                            field.setFieldDirectInquiryEnabled(true);
                        }
                    }
                }
            }
        }
        return sections;
    }

}
