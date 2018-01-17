/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.correction;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.personnel.ProtocolPersonBase;
import org.kuali.rice.core.api.util.xml.XmlJotter;
import org.kuali.rice.ken.api.service.SendNotificationService;
import org.kuali.rice.ken.util.Util;
import org.kuali.rice.krad.util.GlobalVariables;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

public abstract class AdminCorrectionServiceImplBase implements AdminCorrectionService {
    private SendNotificationService sendNotificationService;
    private List<String> notificationTemplates;
    private static final String DOC_LINK = "<a title=\"\" target=\"_self\" href=\"../kew/DocHandler.do?command=displayDocSearchView&amp;docId=";
    
    @Override
    public void sendCorrectionNotification(ProtocolBase protocol, AdminCorrectionBean adminCorrectionBean) throws Exception {
        String adminCorrectionNotificationTemplate = notificationTemplates.get(0);
        InputStream is = this.getClass().getResourceAsStream(adminCorrectionNotificationTemplate);
        Document notificationRequestDocument;

        try {
            notificationRequestDocument = Util.parse(new InputSource(is), false, false, null);
            Element recipientUser = (Element) notificationRequestDocument.getElementsByTagName("user").item(0);
            ProtocolPersonBase principalInvestigator = protocol.getPrincipalInvestigator();
            if (!principalInvestigator.isNonEmployee()) {
                recipientUser.setTextContent(principalInvestigator.getPerson().getUserName());
            } else {
                recipientUser.setTextContent(principalInvestigator.getRolodex().getFullName());
            }

            Element sender = (Element) notificationRequestDocument.getElementsByTagName("sender").item(0);
            sender.setTextContent(GlobalVariables.getUserSession().getPrincipalName());

            Element message = (Element) notificationRequestDocument.getElementsByTagName("message").item(0);
            message.setTextContent("The IRB ProtocolBase " + DOC_LINK + protocol.getProtocolDocument().getDocumentNumber() + "\">" 
                    + protocol.getProtocolNumber() + "</a> has administrative correction made to it. <br/>" 
                    + " Comments : " + adminCorrectionBean.getComments());

            Element title = (Element) notificationRequestDocument.getElementsByTagName("title").item(0);
            title.setTextContent("Administrative Correction has been made to ProtocolBase " + protocol.getProtocolNumber());

            Element sendDateTime = (Element) notificationRequestDocument.getElementsByTagName("sendDateTime").item(0);
            sendDateTime.setTextContent(Util.toXSDDateTimeString(Calendar.getInstance().getTime()));
        }
        finally {
            if (is != null) {
                is.close();
            }
        }

        String XML = XmlJotter.jotNode(notificationRequestDocument, true);
        //Waiting for rice KEN bootstrap to be corrected
        sendNotificationService.invoke(XML);
    }

    public void setSendNotificationService(SendNotificationService sendNotificationService) {
        this.sendNotificationService = sendNotificationService;
    }

    public void setNotificationTemplates(List<String> notificationTemplates) {
        this.notificationTemplates = notificationTemplates;
    }


}
