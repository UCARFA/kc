/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.test;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.correspondence.BatchCorrespondence;
import org.kuali.kra.irb.correspondence.BatchCorrespondenceDetail;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondence;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceType;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailBase;
import org.kuali.kra.service.impl.adapters.BusinessObjectServiceAdapter;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class CommitteeTestHelper {

    public static class MockBusinessObjectService extends BusinessObjectServiceAdapter {
        @Override
        @SuppressWarnings("unchecked")
        public PersistableBusinessObject findByPrimaryKey(Class clazz, Map identifiers) {
            if (clazz.equals(BatchCorrespondence.class)) {
                String batchCorrespondenceTypeCode = (String) identifiers.get("batchCorrespondenceTypeCode");
                return getBatchCorrespondence(batchCorrespondenceTypeCode);
            }
            
            return null;
        }
        
        private BatchCorrespondence getBatchCorrespondence(String batchCorrespondenceTypeCode) {    
            BatchCorrespondence batchCorrespondence = new BatchCorrespondence();
            batchCorrespondence.setBatchCorrespondenceTypeCode(batchCorrespondenceTypeCode);
            batchCorrespondence.setBatchCorrespondenceDetails(new ArrayList<BatchCorrespondenceDetailBase>());
            if (StringUtils.equals(batchCorrespondenceTypeCode, Constants.PROTOCOL_RENEWAL_REMINDERS)) {
                batchCorrespondence.setDescription("Protocol Renewal Reminders");
                batchCorrespondence.setSendCorrespondence(BatchCorrespondence.SEND_CORRESPONDENCE_BEFORE_EVENT);
                batchCorrespondence.setFinalActionDay(0);
                batchCorrespondence.setFinalActionCorrespType("300");
                batchCorrespondence.setFinalActionTypeCode(null);
                batchCorrespondence.getBatchCorrespondenceDetails().add(initBatchCorrespondenceDetail(batchCorrespondenceTypeCode, "20", 60));
                batchCorrespondence.getBatchCorrespondenceDetails().add(initBatchCorrespondenceDetail(batchCorrespondenceTypeCode, "21", 15));
            } else {
                batchCorrespondence.setDescription("Reminder to IRB Notifications");
                batchCorrespondence.setSendCorrespondence(BatchCorrespondence.SEND_CORRESPONDENCE_AFTER_EVENT);
                batchCorrespondence.setFinalActionDay(30);
                batchCorrespondence.setFinalActionCorrespType(null);
                batchCorrespondence.setFinalActionTypeCode("24");
                batchCorrespondence.getBatchCorrespondenceDetails().add(initBatchCorrespondenceDetail(batchCorrespondenceTypeCode, "23", 15));
            }
            
            return batchCorrespondence;
        }
        
        private BatchCorrespondenceDetail initBatchCorrespondenceDetail(String batchCorrespondenceTypeCode, String protoCorrespTypeCode, int daysToEvent) {
            BatchCorrespondenceDetail batchCorrespondenceDetail = new BatchCorrespondenceDetail();
            batchCorrespondenceDetail.setBatchCorrespondenceTypeCode(batchCorrespondenceTypeCode);
            batchCorrespondenceDetail.setProtoCorrespTypeCode(protoCorrespTypeCode);
            batchCorrespondenceDetail.setDaysToEvent(daysToEvent);
            batchCorrespondenceDetail.setProtocolCorrespondenceType(initProtocolCorrespondenceType(protoCorrespTypeCode));
            return batchCorrespondenceDetail;
        }
        
        private ProtocolCorrespondenceType initProtocolCorrespondenceType(String protocolCorrespondenceTypeCode) {
            ProtocolCorrespondenceType protocolCorrespondenceType = new ProtocolCorrespondenceType();
            protocolCorrespondenceType.setProtoCorrespTypeCode(protocolCorrespondenceTypeCode);
            switch (Integer.parseInt(protocolCorrespondenceTypeCode)) {
                case 20 :
                    protocolCorrespondenceType.setDescription("Renewal Reminder Letter #1");
                    break;
                case 21 :
                    protocolCorrespondenceType.setDescription("Renewal Reminder Letter #2");
                    break;
                case 22 :
                    protocolCorrespondenceType.setDescription("Renewal Reminder Letter #3");
                    break;
                case 23 :
                    protocolCorrespondenceType.setDescription("Reminder to IRB Notification #1");
                    break;
                case 24 :
                    protocolCorrespondenceType.setDescription("Reminder to IRB Notification #2");
                    break;
                case 25 :
                    protocolCorrespondenceType.setDescription("Reminder to IRB Notification #3");
                    break;
            }

            return protocolCorrespondenceType;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Collection findMatching(Class clazz, Map indentifiers) {
            if (clazz.equals(ProtocolCorrespondence.class)) {
                return new ArrayList();
            }
            
            return null;
        }
        
        @Override
        public PersistableBusinessObject save(PersistableBusinessObject bo) {
            return bo;
        }
 
    }
}
