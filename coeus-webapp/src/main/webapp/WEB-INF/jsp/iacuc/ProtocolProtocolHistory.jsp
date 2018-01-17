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
	htmlFormAction="iacucProtocolActions"
	documentTypeName="IacucProtocolDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="protocolHistory">
  	
	<script type="text/javascript">
   		var $j = jQuery.noConflict();
   	</script>

	<div align="right"><kul:help documentTypeName="IacucProtocolDocument" pageName="IACUC Protocol Actions" /></div>
	<kra-iacuc:protocolSubmissionAndHistoryViewPrint/>
	<kul:panelFooter />
	<kul:documentControls transactionalDocument="false" suppressRoutingControls="true" />
 
</kul:documentPage>
