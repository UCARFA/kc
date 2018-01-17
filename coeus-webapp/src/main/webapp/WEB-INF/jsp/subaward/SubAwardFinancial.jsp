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
	htmlFormAction="subAwardFinancial"
	documentTypeName="SubAwardDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="financial"> 	  	
<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />
	<div align="right">
       <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
       <kul:help parameterNamespace="KC-SUBAWARD" parameterDetailType="Document" parameterName="subAwardFinancialHelpUrl" altText="help"/>
    </div>

<div id="workarea">
<script language="javascript" src="scripts/kuali_application.js"></script>
<script>
jq(document).ready(function() {
	jq('input[name*="addAmountReleased"]').click(function() { openNewWindow('subAwardFinancial','addAmountReleased','','${KualiForm.formKey}','${KualiForm.document.sessionDocument}'); return false; });
});
</script>
	<kra-sub:subAwardHistoryOfChanges/>	
	<kra-sub:subAwardInvoices/>
	<kul:panelFooter />
</div>
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" 
	suppressCancelButton="true" viewOnly="${KualiForm.editingMode['viewOnly']}"
	extraButtons="${KualiForm.extraFinancialButtons}"/>

</kul:documentPage>
