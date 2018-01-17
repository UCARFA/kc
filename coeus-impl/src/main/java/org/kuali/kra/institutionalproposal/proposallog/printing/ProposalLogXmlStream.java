/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog.printing;

import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.print.stream.xml.XmlStream;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.institutionalproposal.proposallog.ProposalLog;
import org.kuali.kra.institutionalproposal.proposallog.service.ProposalLogPrintingService;
import org.kuali.kra.printing.schema.*;
import org.kuali.rice.core.api.datetime.DateTimeService;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * This class will contain all common methods that can be used across Proposal
 * Development XML generator streams . All those report XML stream
 * implementations need to extend and use the functions defined in this class.
 * 
 */
public class ProposalLogXmlStream implements XmlStream {
	
	private DateTimeService dateTimeService;

    /**
     * This method generates XML for Print Certification Report. It uses data
     * passed in {@link org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase} for populating the XML nodes. The
     * XMl once generated is returned as {@link XmlObject}
     * 
     * @param printableBusinessObject
     *            using which XML is generated
     * @param reportParameters
     *            parameters related to XML generation
     * @return {@link XmlObject} representing the XML
     * @throws PrintingException
     *             in case of any errors occur during XML generation.
     */
    @Override
    public Map<String, XmlObject> generateXmlStream(
            KcPersistableBusinessObjectBase printableBusinessObject, Map<String, Object> reportParameters) {
        Map<String, XmlObject> xmlObjectList = new LinkedHashMap<>();
        ProposalLog proposalLog = (ProposalLog)reportParameters.get(ProposalLogPrintingService.PROPOSAL_LOG_KEY);
        proposalLog.refreshNonUpdateableReferences();
        ProposalLogDocument proposalLogDocument = ProposalLogDocument.Factory.newInstance();
        ProposalLogDocument.ProposalLog printProposalLog = ProposalLogDocument.ProposalLog.Factory.newInstance();
        printProposalLog.setProposalNumber(proposalLog.getProposalNumber());
        printProposalLog.setProposalTitle(proposalLog.getTitle());
        printProposalLog.setStatus(proposalLog.getProposalLogStatus().getDescription());
        printProposalLog.setComments(proposalLog.getComments());
        printProposalLog.setUpdateUser(proposalLog.getUpdateUser());
        printProposalLog.setUpdateTimeStamp(dateTimeService.toDateString(proposalLog.getUpdateTimestamp()));
        printProposalLog.setPI(getPrincipalInvestigator(proposalLog));
        
        
        ProposalLogLeadUnit unit = ProposalLogLeadUnit.Factory.newInstance();
        unit.setUnitNumber(proposalLog.getLeadUnit());
        if (proposalLog.getUnit() != null) {
            unit.setUnitName(proposalLog.getUnit().getUnitName());
        }
     
        printProposalLog.setLeadUnit(unit);
        
        ProposalLogSponsor sponsor = ProposalLogSponsor.Factory.newInstance();
        sponsor.setSponsorCode(proposalLog.getSponsorCode());
        sponsor.setSponsorName(proposalLog.getSponsorName());
        printProposalLog.setSponsor(sponsor);
        
        ProposalLogProposalType type = ProposalLogProposalType.Factory.newInstance();
        type.setProposalTypeCode(proposalLog.getProposalTypeCode());
        if (proposalLog.getProposalType() != null) {
            type.setProposalTypeDesc(proposalLog.getProposalType().getDescription());
        }
        printProposalLog.setProposalType(type);
        
        proposalLogDocument.setProposalLog(printProposalLog);
        xmlObjectList.put("proposalLog", proposalLogDocument);
        return xmlObjectList;
    }
    
    private ProposalLogPrincipalInvestigator getPrincipalInvestigator(ProposalLog proposalLog) {
        ProposalLogPrincipalInvestigator pi = ProposalLogPrincipalInvestigator.Factory.newInstance();
        KcPerson person = proposalLog.getPerson();
        pi.setFirstName(person.getFirstName());
        pi.setMiddleName(person.getMiddleName());
        pi.setLastName(person.getLastName());
        pi.setFullName(person.getFullName());
        pi.setPersonID(person.getPersonId());
        return pi;
    }

    public DateTimeService getDateTimeService() {
        return dateTimeService;
    }

    public void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

}
