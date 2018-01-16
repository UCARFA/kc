<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="reportTrackingReadOnly" value="${!KualiForm.permissionsHelper.maintainAwardReportTracking }"/>
<kul:tab tabTitle="Reports" defaultOpen="false"
	tabErrorKey="document.awardList[0].awardReportTermItems,document.award.awardTemplate.REPORTS_TAB,methodToCall.selectAllMultEdit.AwardReportTermItemsIndex*,methodToCall.selectNoneMultiEdit.AwardReportTermItemsIndex*,awardReportTerm"
	auditCluster="reportsAuditErrors"
	tabAuditKey="document.reportTermsAuditRules*" useRiceAuditMode="true">
	<div class="tab-container" align="right">
		<h3>
			<span class="subhead-left">Report Classes</span>            
			<span class="subhead-right"><kul:help parameterNamespace="KC-AWARD" parameterDetailType="Document" parameterName="awardReportsHelpUrl" altText="help"/></span>      
		</h3>

		<c:forEach var="reportClass" items="${KualiForm.reportClasses}"
			varStatus="reportClassIndex">
			<c:if
				test="${KualiForm.reportClassForPaymentsAndInvoices.reportClassCode != reportClass.key}">
				<kra-a:awardReportClasses index="${reportClassIndex.index}"
					reportClassKey="${reportClass.key}"
					reportClassLabel="${reportClass.value}"
					reportCodeLabel="* Report Type" />
			</c:if>
		</c:forEach>
		<br/> <br/>
		<kra-a:awardReportsMiscellaneousProcurementPurchasing />
		<div align="center">

			</br>
			<c:if test="${(!readOnly)}">
				<kra-a:awardSyncButton scopeNames="REPORTS_TAB" tabKey="${tabKey}" />
				<br/>
			</c:if>
			<c:if test="${!reportTrackingReadOnly && readOnly}">
				<html:image property="methodToCall.save" 
					src='${ConfigProperties.kra.externalizable.images.url}tinybutton-apply.gif' 
					alt="Save Report Tracking" onclick="" styleClass="tinybutton"/>
			</c:if>
		</div>
	</div>

</kul:tab>
