/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.bo;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.maintenance.Maintainable;
import org.kuali.rice.kns.web.ui.Field;
import org.kuali.rice.kns.web.ui.Row;
import org.kuali.rice.kns.web.ui.Section;
import org.kuali.rice.krad.service.SequenceAccessorService;

import java.util.List;

/**
 * Maintainable implementation for handling the sequence for Notification Number.
 */
public class NotificationTypeMaintainableImpl extends KraMaintainableImpl {

    private static final long serialVersionUID = 5816092888763754328L;
    
    private static final String NOTIFICATION_TYPE_ID_SEQUENCE_NAME = "SEQ_NOTIFICATION_TYPE_ID";
    private static final String NOTIFICATION_TYPE_SECTION_ID = "Edit Notification Types";
    private static final String NOTIFICATION_TYPE_ID_NAME = "notificationTypeId";
    
    private transient SequenceAccessorService sequenceAccessorService;
    
    @Override
    public void setGenerateDefaultValues(String docTypeName) {
        super.setGenerateDefaultValues(docTypeName);
        
        NotificationType notificationType = (NotificationType) getBusinessObject();
        Long nextNotificationTypeId = getSequenceAccessorService().getNextAvailableSequenceNumber(NOTIFICATION_TYPE_ID_SEQUENCE_NAME, NotificationType.class);
        notificationType.setNotificationTypeId(nextNotificationTypeId);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Section> getSections(MaintenanceDocument document, Maintainable oldMaintainable) {
        List<Section> sections = super.getSections(document, oldMaintainable);
        
        for (Section section : sections) {
            if (StringUtils.equals(section.getSectionId(), NOTIFICATION_TYPE_SECTION_ID)) {
                for (Row row : section.getRows()) {
                    for (Field field : row.getFields()) {
                        if (StringUtils.equals(field.getPropertyName(), NOTIFICATION_TYPE_ID_NAME)) {
                            field.setReadOnly(true);
                        }
                    }
                }
            }
        }

        return sections;
    }
    
    public SequenceAccessorService getSequenceAccessorService() {
        if (sequenceAccessorService == null) {
            sequenceAccessorService = KcServiceLocator.getService(SequenceAccessorService.class);
        }
        return sequenceAccessorService;
    }

    public void setSequenceAccessorService(SequenceAccessorService sequenceAccessorService) {
        this.sequenceAccessorService = sequenceAccessorService;
    }

}
