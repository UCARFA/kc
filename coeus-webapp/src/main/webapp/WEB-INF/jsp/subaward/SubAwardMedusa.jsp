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
	htmlFormAction="subAwardMedusa"
	documentTypeName="SubAwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="medusa">

<kul:tabTop tabTitle="Medusa" defaultOpen="true" tabErrorKey="">
<kra-m:medusa helpParameterNamespace="KC-SUBAWARD" helpParameterDetailType="Document" helpParameterName="subAwardMedusaHelpUrl" />

</kul:tabTop>
<kul:panelFooter />
<c:choose>
	<c:when test="${not KualiForm.editingMode['viewOnly']}">
		<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" />
	</c:when>
	<c:otherwise>
		<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" viewOnly= "true" suppressCancelButton="true" />
	</c:otherwise>
</c:choose>

	<script type="text/javascript" src="scripts/medusaView.js"></script>	
	
</kul:documentPage>
