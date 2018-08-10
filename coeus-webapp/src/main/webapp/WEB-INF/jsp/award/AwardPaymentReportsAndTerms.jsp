<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="awardPaymentReportsAndTerms"
	documentTypeName="AwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="paymentReportsAndTerms"
  	extraTopButtons="${KualiForm.extraTopButtons}" >
 	
 	<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />

	<c:set var="adminModifyAward" value="${KualiForm.editingMode['adminModifyAward']}" scope="request" />
	<c:if test="${adminModifyAward}">
		<c:set var="readOnly" value="true" scope="request" />
	</c:if>

<div align="right">
	<kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
	<kul:help documentTypeName="AwardDocument" pageName="Payment%2C%20Reports%20%26%20Terms" />
</div>

<kra-a:awardPaymentAndInvoices />
<kra-a:awardCgb />
<kra-a:awardReports />
<kra-a:awardTerms />
<kra-a:awardSpecialApproval />
<kra-a:awardCloseout />

<kul:panelFooter />

<SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;
</SCRIPT>
<script language="javascript" src="scripts/kuali_application.js"></script>
<script language="javascript" src="dwr/interface/AwardReportsService.js" ></script>
<script language="javascript" src="dwr/interface/AwardPaymentAndInvoicesService.js" ></script>
<script language="javascript" src="scripts/awardApprovedForeignTravel.js"></script>
<script type="text/javascript">
  jQuery(document).ready(function($) {
	  $('[name*="toggleTabReporting"]').each(function () {
		  var id = $(this).attr('id');
		  $(this).attr('id', id + '-noexpandall');
	  });
  });
</script>
<c:choose>
	<c:when test="${KualiForm.displayRegenerateButton }">
		<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" 
			extraButtonSource="${ConfigProperties.kra.externalizable.images.url}generate-report-tracking.jpg" 
			extraButtonProperty="methodToCall.regenerateReports" extraButtonAlt="Generate Reports" />
	</c:when>
	<c:otherwise>
		<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" />
	</c:otherwise>
</c:choose>
</kul:documentPage>
