/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import edu.mit.irb.irbnamespace.CorrespondenceDocument;
import edu.mit.irb.irbnamespace.CorrespondenceDocument.Correspondence;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.protocol.actions.print.CorrespondenceXmlStreamBase;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to populate the xml beans objects for Correspondence schema elements in irb.xsd
 */
public class CorrespondenceXmlStream extends CorrespondenceXmlStreamBase {
    private ProtocolXmlStream protocolXmlStream;
    @Override
    public Map<String, XmlObject> generateXmlStream(KcPersistableBusinessObjectBase printableBusinessObject, Map<String, Object> reportParameters) {
        Protocol protocol = (Protocol)printableBusinessObject;
        ProtocolSubmission protocolSubmission = protocol.getProtocolSubmission();
        String scheduleId=null;
        Integer submissionNumber = null;
        if(protocolSubmission!=null){
            CommitteeScheduleBase committeeSchedule = protocolSubmission.getCommitteeSchedule();
            scheduleId = committeeSchedule!=null?committeeSchedule.getScheduleId():null;
            submissionNumber = protocolSubmission.getSubmissionNumber();
        }
        CorrespondenceDocument correspondenceDocument = CorrespondenceDocument.Factory.newInstance();
        correspondenceDocument.setCorrespondence(getCorrespondence(protocol, scheduleId, submissionNumber));
        Map<String,XmlObject> correspondenceStreamMap = new HashMap<String, XmlObject>();
        correspondenceStreamMap.put("Correspondence", correspondenceDocument);
        return correspondenceStreamMap;
    }

    public Correspondence getCorrespondence(Protocol protocol,String scheduleId,Integer submissionNumber) {
      Correspondence correspondence = Correspondence.Factory.newInstance();
      correspondence.setCurrentDate(getDateTimeService().getCurrentCalendar());
      ProtocolXmlStream protocolStream = getProtocolXmlStream();
     if (submissionNumber==null || submissionNumber.intValue() <= 0){    
        correspondence.setProtocol(protocolStream.getProtocol(protocol)) ;
     }else{
         correspondence.setProtocol(protocolStream.getProtocol(protocol, submissionNumber)) ;
     }    
     correspondence.setCurrentDate(getDateTimeService().getCurrentCalendar());
      return correspondence ;
      
    }

    /**
     * Sets the protocolXmlStream attribute value.
     * @param protocolXmlStream The protocolXmlStream to set.
     */
    public void setProtocolXmlStream(ProtocolXmlStream protocolXmlStream) {
        this.protocolXmlStream = protocolXmlStream;
    }

    /**
     * Gets the protocolXmlStream attribute. 
     * @return Returns the protocolXmlStream.
     */
    public ProtocolXmlStream getProtocolXmlStream() {
        return protocolXmlStream;
    }
}
