/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.print;

import org.kuali.coeus.common.framework.print.PrintingException;
import org.kuali.coeus.common.framework.sponsor.form.SponsorFormTemplate;
import org.kuali.coeus.common.framework.sponsor.form.SponsorFormTemplateList;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;

import java.util.List;
import java.util.Map;

/**
 * This class provides the means for printing reports related to Proposal Development. It has
 * the capability to provide a PDF document of various reports related to Proposal Development
 * like Print Certification, Proposal etc.
 * 
 * @author
 * 
 */
public interface ProposalDevelopmentPrintingService {

	public static final String PRINT_CERTIFICATION_REPORT = "Print Certification";
    public static final String PRINT_PROPOSAL_SPONSOR_FORMS = "Print Proposal Sponsor Forms";
    public static final String SELECTED_TEMPLATES = "Selected Templates";
    public static final String PRINT_CERTIFICATION_PERSON = "Print Certification Person";

    /**
	 * This method generates the required report and returns the PDF stream as
	 * {@link AttachmentDataSource}.
	 * 
	 * @param printableBusinessObject
	 *            Document data using which report is generated
	 * @param reportName
	 *            report to be generated
	 * @param reportParameters
	 *            {@link Map} of parameters required for report generation
	 * @return {@link AttachmentDataSource} which contains the byte array of the
	 *         generated PDF
	 * @throws PrintingException
	 *             if any errors occur during report generation
	 */
	AttachmentDataSource printProposalDevelopmentReport(
			KcPersistableBusinessObjectBase printableBusinessObject, String reportName,
			Map<String, Object> reportParameters) throws PrintingException;

    /**
     * 
     * This method is to get templates for generic sponsor code.
     * 
     * @param sponsorFormTemplates
     *            list of SponsorFormTemplateList.
     * @param sponsorCode
     *            code for the sponsor.
     */
    void populateSponsorForms(
            List<SponsorFormTemplateList> sponsorFormTemplates,
            String sponsorCode);

    /**
     * 
     * This method is used to get the sponsor form template form template list.
     * 
     * @param sponsorFormTemplateLists
     *            list of SponsorFormTemplateList.
     * @return List&lt;SponsorFormTemplate&gt; list of SponsorFormTemplate
     *         corresponding to the SponsorFormTemplateList object.
     */
    List<SponsorFormTemplate> getSponsorFormTemplates(
            List<SponsorFormTemplateList> sponsorFormTemplateLists);
	
    AttachmentDataSource printPersonCertificationQuestionnaire(List<ProposalPerson> person) throws PrintingException;
	
}
