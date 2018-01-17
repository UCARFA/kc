/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.print;

import edu.mit.coeus.xml.iacuc.CorrespondenceDocument;
import edu.mit.coeus.xml.iacuc.CorrespondenceType;
import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.actions.print.CorrespondenceXmlStreamBase;
import org.kuali.kra.protocol.actions.print.ProtocolXmlStreamBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

import java.util.HashMap;
import java.util.Map;

public class IacucCorrespondenceXmlStream extends CorrespondenceXmlStreamBase {
    
    private ProtocolXmlStreamBase protocolXmlStream;
    @Override
    public Map<String, XmlObject> generateXmlStream(KcPersistableBusinessObjectBase printableBusinessObject, Map<String, Object> reportParameters) {
        IacucProtocol protocol = (IacucProtocol) printableBusinessObject;
        ProtocolSubmissionBase protocolSubmission = protocol.getProtocolSubmission();
        String scheduleId = null;
        Integer submissionNumber = null;
        if (protocolSubmission != null) {
            CommitteeScheduleBase committeeSchedule = protocolSubmission.getCommitteeSchedule();
            scheduleId = committeeSchedule != null ? committeeSchedule.getScheduleId() : null;
            submissionNumber = protocolSubmission.getSubmissionNumber();
        }
       
        CorrespondenceDocument correspondenceDocument = CorrespondenceDocument.Factory.newInstance();
        correspondenceDocument.setCorrespondence(getCorrespondence(protocol, scheduleId, submissionNumber));
        Map<String,XmlObject> correspondenceStreamMap = new HashMap<String, XmlObject>();
        correspondenceStreamMap.put("Correspondence", correspondenceDocument);
        return correspondenceStreamMap;
        
    }

    public CorrespondenceType getCorrespondence(IacucProtocol  protocol, String scheduleId, Integer submissionNumber) {
        CorrespondenceType correspondence = CorrespondenceType.Factory.newInstance();
        correspondence.setCurrentDate(getDateTimeService().getCurrentCalendar());
        ProtocolXmlStreamBase protocolStream = getProtocolXmlStream();
        if (submissionNumber == null || submissionNumber.intValue() <= 0) {
            correspondence.setProtocol(((IacucProtocolXmlStream) protocolStream).getProtocol(protocol));
        } else {
            correspondence.setProtocol(((IacucProtocolXmlStream) protocolStream).getProtocol(protocol, submissionNumber));
        }    
        correspondence.setCurrentDate(getDateTimeService().getCurrentCalendar());
        return correspondence;
      
    }

    /**
     * Sets the protocolXmlStream attribute value.
     * @param protocolXmlStream The protocolXmlStream to set.
     */
    public void setProtocolXmlStream(ProtocolXmlStreamBase protocolXmlStream) {
        this.protocolXmlStream = protocolXmlStream;
    }

    /**
     * Gets the protocolXmlStream attribute. 
     * @return Returns the protocolXmlStream.
     */
    public ProtocolXmlStreamBase getProtocolXmlStream() {
        return protocolXmlStream;
    }

}
