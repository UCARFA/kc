<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%-- member of AwardPaymentReportsAndTerms.jsp --%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="awardPaymentAndInvoiceRequirementsCommentAttributes" value="${DataDictionary.AwardComment.attributes}" />
<c:set var="action" value="awardPaymentReportsAndTerms" />
																			
<kul:tabTop tabTitle="Payment & Invoices" defaultOpen="false" tabErrorKey="document.awardList[0].awardPaymentAndInvoiceRequirementsComments.comments*,document.awardList[0].paymentsAndInvoices.*,document.award.awardTemplate.PAYMENTS_AND_INVOICES_TAB" auditCluster="paymentAndInvoicesAuditErrors" tabAuditKey="document.paymentsAuditRules*">
	<div class="tab-container" align="center">
		<kra-a:awardPaymentAndInvoicesTopPanel />	
		<kra-a:awardReportClasses index="2" reportClassKey="${KualiForm.reportClassForPaymentsAndInvoices.reportClassCode}" reportCodeLabel="* Payment Type"
			reportClassLabel="Payment & Invoice Requirements" defaultOpenForTab="true" noShowHideButton="true" />
		<table border="0" cellpadding="0" cellspacing="0" summary="">
		<tr>
       	    <th width="100" align="right" scope="row"><div align="center">Invoice Instructions:</div></th>
       			<td class="infoline" colspan="10">
           	 		<div align="left">
           	  	 		<kul:htmlControlAttribute property="document.awardList[0].awardPaymentAndInvoiceRequirementsComments.comments" attributeEntry="${awardPaymentAndInvoiceRequirementsCommentAttributes.comments}"/>
           	 		</div>
           		</td>            
       		</tr>
       	</table>
       	
       	
       
		<div align="center">
		</br>
		<c:if test = "${(!readOnly)}">
			<kra-a:awardSyncButton  scopeNames="PAYMENTS_AND_INVOICES_TAB" tabKey="${tabKey}"/>
		</c:if>
		</div>	
       	
       	<br/>
       	
       	<kra-a:awardPaymentSchedule />
	</div>
</kul:tabTop>
