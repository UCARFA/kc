/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.print;

import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.AbstractPrint;
import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.sponsor.form.SponsorFormTemplate;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the implementation for printing Print Certification
 * Report. It generates XML that conforms with Certification Report XSD, fetches
 * XSL style-sheets applicable to this XML, returns XML and XSL for any consumer
 * that would use this XML and XSls for any purpose like report generation, PDF
 * streaming etc.
 */
@Component("proposalSponsorFormsPrint")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProposalSponsorFormsPrint extends AbstractPrint {
	private static final String LOCAL_PRINT_FORM_SPONSOR_CODE ="LOCAL_PRINT_FORM_SPONSOR_CODE";

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("nihResearchAndRelatedXmlStream")
    private NIHResearchAndRelatedXmlStream nihResearchAndRelatedXmlStream;

    @Autowired
    @Qualifier("proposalDevelopmentXmlStream")
	private ProposalDevelopmentXmlStream proposalDevelopmentXmlStream;

	@Autowired
	@Qualifier("parameterService")
    private ParameterService parameterService;

	@Override
    public Map<String,Source> getXSLTemplateWithBookmarks() {
		Map<String,Source> sourceMap = new LinkedHashMap<>();
		List<SponsorFormTemplate> printFormTemplates = (List<SponsorFormTemplate>)getReportParameters().get(ProposalDevelopmentPrintingServiceImpl.SELECTED_TEMPLATES);
		for (SponsorFormTemplate sponsorFormTemplate : printFormTemplates) {
		    SponsorFormTemplate sponsorTemplate = getBusinessObjectService().findBySinglePrimaryKey(SponsorFormTemplate.class,
		            sponsorFormTemplate.getSponsorFormTemplateId());
		    sourceMap.put(sponsorFormTemplate.getPageDescription(),new StreamSource(new ByteArrayInputStream(sponsorTemplate.getAttachmentContent())));
        }
		return sourceMap;
	}

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

	public ProposalDevelopmentXmlStream getProposalDevelopmentXmlStream() {
		return proposalDevelopmentXmlStream;
	}

	public void setProposalDevelopmentXmlStream(
			ProposalDevelopmentXmlStream proposalDevelopmentXmlStream) {
		this.proposalDevelopmentXmlStream = proposalDevelopmentXmlStream;
	}
	
	@Override
	public Map<String, XmlObject> renderXML() throws PrintingException {
		DevelopmentProposal developmentProposal=(DevelopmentProposal) getPrintableBusinessObject();
		if (developmentProposal.getSponsorCode().equals(getProposalParameterValue(LOCAL_PRINT_FORM_SPONSOR_CODE))){
			setXmlStream(proposalDevelopmentXmlStream);
		} else {
			setXmlStream(nihResearchAndRelatedXmlStream);
		}
			
		return super.renderXML();
	}
	
	private String getProposalParameterValue(String param) {
		return getParameterService().getParameterValueAsString(
				ProposalDevelopmentDocument.class, param);
	}

	public ParameterService getParameterService() {
		return parameterService;
	}

	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

	public NIHResearchAndRelatedXmlStream getNihResearchAndRelatedXmlStream() {
		return nihResearchAndRelatedXmlStream;
	}

	public void setNihResearchAndRelatedXmlStream(
			NIHResearchAndRelatedXmlStream nihResearchAndRelatedXmlStream) {
		this.nihResearchAndRelatedXmlStream = nihResearchAndRelatedXmlStream;
	}
}
