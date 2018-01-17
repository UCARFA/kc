/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.print.util;

import org.kuali.coeus.common.committee.impl.print.CommitteeReportType;
import org.kuali.coeus.common.framework.print.PrintConstants;
import org.kuali.coeus.propdev.impl.print.ProposalDevelopmentPrintingService;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingType;
import org.kuali.kra.award.printing.AwardPrintType;
import org.kuali.coeus.common.budget.framework.print.BudgetPrintType;
import org.kuali.kra.coi.print.CoiDisclosureType;
import org.kuali.kra.institutionalproposal.printing.InstitutionalProposalPrintType;
import org.kuali.kra.institutionalproposal.proposallog.service.ProposalLogPrintingService;
import org.kuali.kra.irb.actions.print.ProtocolPrintType;
import org.kuali.kra.negotiations.printing.NegotiationActivityPrintType;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.kra.subaward.reporting.printing.SubAwardPrintType;
import org.kuali.rice.kns.util.WebUtils;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class PrintingUtils {

	private static String XSL_CONTEXT_DIR = "/org/kuali/kra/printing/stylesheet";
	private static final String XSL_BUDGET_SUMMARY = "BudgetSummaryReport.xsl";
	private static final String XSL_BUDGET_SALARY = "BudgetSalary.xsl";
	private static final String XSL_BUDGET_TOTAL = "BudgetSummaryTotalPage.xsl";
	private static final String XSL_BUDGET_CUMULATIVE = "CumulativeSummary.xsl";
	private static final String XSL_INDUSTRIAL_BUDGET = "IndstlBudgetSummary.xsl";
	private static final String XSL_BUDGET_COSTSHARING_SUMMARY = "CostSharingBudgetSummary.xsl";
	private static final String XSL_AWARD_NOTICE = "AwardNotice.xsl";
	private static final String XSL_AWARD_DELTA = "AwardModification.xsl";
    private static final String XSL_AWARD_BUDGET_HIERARCHY = "awardBudgetHierarchy.xsl";
    private static final String XSL_AWARD_BUDGET_HISTORY_TRANSACTION = "awardBudgetModification.xsl";
    private static final String XSL_AWARD_TEMPLATE = "awardTemplate.xsl";
    private static final String XSL_MONEY_AND_END_DATES_HISTORY = "awardMoneyAndEndDatesHistory.xsl";
    private static final String XSL_PRINT_CERTIFICATION = "printCertification.xsl";
	private static final String XSL_CURRENT_REPORT = "CurrentSupport.xsl";
	private static final String XSL_PENDING_REPORT = "PendingSupport.xsl";
	private static final String XSL_INSTITUTIONAL_PROPOSAL_REPORT = "instituteProposal.xsl";
    private static final String XSL_COMMITTEE_ROSTER = "CommitteeRoster.xsl";
    private static final String XSL_FUTURE_SCHEDULED_MEETINGS = "CommitteeFutureScheduledMeetings.xsl";
	private static final String XSL_PROPOSAL_LOG_REPORT = "proposalLog.xsl";
	private static final String  XSL_PRINT_NEGOTIATION_ACTIVITY_REPORT ="NegotiationActivityReport.xsl";
	private static final String XSL_PRINT_SUB_AWARD_SF_294_REPORT ="294.xsl";
	private static final String XSL_PRINT_SUB_AWARD_SF_295_REPORT ="295.xsl";
	private static final String XSL_COI_APPROVED_DISCLOSURE = "ApprovedDisclosure.xsl";
    private static final String XSL_AWARD_REPORT_TRACKING = "AwardReportingRequirements.xsl";
    private static final String XSL_SUB_AWARD_FDP_AGREEMENT = "FDP_Template_Agreement.xsl";
    private static final String XSL_SUB_AWARD_FDP_MODIFICATION = "FDP_Modification_Template.xsl";

    private PrintingUtils() {
    	throw new UnsupportedOperationException("do not call");
	}

	/**
	 * This method fetches the stylesheet for a given report and returns it as a
	 * {@link Source} in an {@link List}
	 * 
	 * @param reportType
	 *            report for which stylesheet is to be fetched
	 * @return {@link List} of stylesheet {@link Source}
	 */

	public static List<Source> getXSLTforReport(String reportType) {
		String xsl = null;
		if (reportType.equals(AwardPrintType.AWARD_NOTICE_REPORT
				.getAwardPrintType())) {
			xsl = XSL_AWARD_NOTICE;
		} else if (reportType.equals(AwardPrintType.AWARD_DELTA_REPORT
				.getAwardPrintType())) {
			xsl = XSL_AWARD_DELTA;
		} else if (reportType.equals(AwardPrintType.AWARD_BUDGET_HIERARCHY
                .getAwardPrintType())) {
            xsl = XSL_AWARD_BUDGET_HIERARCHY;
        } else if (reportType.equals(AwardPrintType.AWARD_BUDGET_HISTORY_TRANSACTION
                .getAwardPrintType())) {
            xsl = XSL_AWARD_BUDGET_HISTORY_TRANSACTION;
        } else if (reportType.equals(AwardPrintType.AWARD_TEMPLATE
                .getAwardPrintType())) {
            xsl = XSL_AWARD_TEMPLATE;
        } else if (reportType.equals(AwardPrintType.MONEY_AND_END_DATES_HISTORY
                .getAwardPrintType())) {
            xsl = XSL_MONEY_AND_END_DATES_HISTORY;
        } else if (reportType.equals(BudgetPrintType.BUDGET_SUMMARY_REPORT
				.getBudgetPrintType())) {
			xsl = XSL_BUDGET_SUMMARY;
		} else if (reportType.equals(BudgetPrintType.BUDGET_SALARY_REPORT
				.getBudgetPrintType())) {
			xsl = XSL_BUDGET_SALARY;
		} else if (reportType.equals(BudgetPrintType.BUDGET_TOTAL_REPORT
				.getBudgetPrintType())) {
			xsl = XSL_BUDGET_TOTAL;
		} else if (reportType
				.equals(BudgetPrintType.BUDGET_SUMMARY_TOTAL_REPORT
						.getBudgetPrintType())) {
			xsl = XSL_BUDGET_TOTAL;
		} else if (reportType
				.equals(BudgetPrintType.INDUSTRIAL_CUMULATIVE_BUDGET_REPORT
						.getBudgetPrintType())) {
			xsl = XSL_BUDGET_TOTAL;
		} else if (reportType.equals(BudgetPrintType.BUDGET_CUMULATIVE_REPORT
				.getBudgetPrintType())) {
			xsl = XSL_BUDGET_CUMULATIVE;
		} else if (reportType.equals(BudgetPrintType.INDUSTRIAL_BUDGET_REPORT
				.getBudgetPrintType())) {
			xsl = XSL_INDUSTRIAL_BUDGET;
		} else if (reportType
				.equals(BudgetPrintType.BUDGET_COST_SHARE_SUMMARY_REPORT
						.getBudgetPrintType())) {
			xsl = XSL_BUDGET_COSTSHARING_SUMMARY;
		} else if (reportType
				.equals(PrintConstants.CURRENT_REPORT_TYPE)) {
			xsl = XSL_CURRENT_REPORT;
		} else if (reportType
				.equals(PrintConstants.PENDING_REPORT_TYPE)) {
			xsl = XSL_PENDING_REPORT;
		} else if (reportType
				.equals(InstitutionalProposalPrintType.INSTITUTIONAL_PROPOSAL_REPORT
						.getInstitutionalProposalPrintType())) {
			xsl = XSL_INSTITUTIONAL_PROPOSAL_REPORT;
		} else if (reportType.equals(ProposalLogPrintingService.PROPOSAL_LOG_REPORT_TYPE)) {
		    xsl = XSL_PROPOSAL_LOG_REPORT;
		} else if (reportType
				.equals(ProposalDevelopmentPrintingService.PRINT_CERTIFICATION_REPORT)) {
			xsl = XSL_PRINT_CERTIFICATION;
		}  else if (reportType.equals(CoiDisclosureType.APPROVED_DISCLOSURE_TYPE.getCoiDisclosureType())) {
            xsl = XSL_COI_APPROVED_DISCLOSURE;
        } 
		else if (reportType.equals(CommitteeReportType.ROSTER.getCommitteeReportType())) {
            xsl = XSL_COMMITTEE_ROSTER;
        } else if (reportType.equals(CommitteeReportType.FUTURE_SCHEDULED_MEETINGS.getCommitteeReportType())) {
            xsl = XSL_FUTURE_SCHEDULED_MEETINGS;
        } 
        else if (reportType.equals(ReportTrackingType.
                AWARD_REPORT_TRACKING.getReportTrackingType())) {
            xsl = XSL_AWARD_REPORT_TRACKING;
        } 
        else if (reportType
                .equals(NegotiationActivityPrintType.NEGOTIATION_ACTIVITY_REPORT
                        .getNegotiationActivityPrintType())) {
            xsl = XSL_PRINT_NEGOTIATION_ACTIVITY_REPORT;
        }
        else if (reportType
                .equals(SubAwardPrintType.SUB_AWARD_SF_294_PRINT_TYPE
                        .getSubAwardPrintType())) {
            xsl = XSL_PRINT_SUB_AWARD_SF_294_REPORT;
        }
        else if (reportType
                .equals(SubAwardPrintType.SUB_AWARD_SF_295_PRINT_TYPE
                        .getSubAwardPrintType())) {
            xsl = XSL_PRINT_SUB_AWARD_SF_295_REPORT;
        }else if (reportType
                .equals(SubAwardPrintType.SUB_AWARD_FDP_TEMPLATE
                        .getSubAwardPrintType())) {
            xsl = XSL_SUB_AWARD_FDP_AGREEMENT;
        }
        else if (reportType
                .equals(SubAwardPrintType.SUB_AWARD_FDP_MODIFICATION
                        .getSubAwardPrintType())) {
            xsl = XSL_SUB_AWARD_FDP_MODIFICATION;
        }
        else if (ProtocolPrintType.getReportTypes().contains(reportType)) {
            for (ProtocolPrintType protocolPrintType : ProtocolPrintType.values()) {
                if (reportType.equals(protocolPrintType.getProtocolPrintType())) {
                    xsl = protocolPrintType.getTemplate();
                    break;
                }
            }
        }

		Source src = new StreamSource(PrintingUtils.class
				.getResourceAsStream(XSL_CONTEXT_DIR + "/" + xsl));

		ArrayList<Source> sourceList = new ArrayList<>();
		sourceList.add(src);
		return sourceList;
	}

    public static List<Source> getXSLTforReportTemplate(String reportTemplate) {
        Source src = new StreamSource(PrintingUtils.class
                .getResourceAsStream(XSL_CONTEXT_DIR + "/" + reportTemplate));
        ArrayList<Source> sourceList = new ArrayList<>();
        sourceList.add(src);
        return sourceList;
    }

    public static void streamToResponse(AttachmentDataSource attachmentDataSource,
            HttpServletResponse response) throws Exception {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream(attachmentDataSource.getData().length)) {
            baos.write(attachmentDataSource.getData());
            WebUtils.saveMimeOutputStreamAsFile(response, attachmentDataSource.getType(), baos, attachmentDataSource.getName());

        }
    }

    public static void streamToResponse(byte[] fileContents, String fileName, String fileContentType, HttpServletResponse response) throws Exception {
        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream(fileContents.length)) {
            baos.write(fileContents);
            WebUtils.saveMimeOutputStreamAsFile(response, fileContentType, baos, fileName);
        }
    }
}
