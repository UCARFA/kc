<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ page import="org.kuali.kra.infrastructure.Constants"%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="protocolAttributes" value="${DataDictionary.ProtocolDocument.attributes}" />
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="protocolProtocol"
	documentTypeName="ProtocolDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="protocol">

<script type="text/javascript">
   var $j = jQuery.noConflict();
</script>

  	
<div align="right">
	<kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
	<kul:help documentTypeName="ProtocolDocument" pageName="Protocol" />
</div>
<kul:documentOverview editingMode="${KualiForm.editingMode}" />

<kra-irb:protocolRequiredFields />
<kra-irb:protocolStatusDate />

<c:choose>
	<c:when test="${KualiForm.displayRiskLevelPanel}" > 
		<kra-irb:protocolRiskLevel />
	</c:when>
</c:choose>
<kra-irb:protocolAdditionalInformation />
<kra-irb:protocolLocations />
<kra-irb:protocolFundingSources />
<kra-irb:protocolParticipants />

<kul:panelFooter />
	<c:if test="${readOnly && KualiForm.editingMode['canModify'] && KualiForm.displayEditButton}">
		<c:set var="extraButtonSource" value="${ConfigProperties.kra.externalizable.images.url}buttonsmall_edit_temp.gif"/>
		<c:set var="extraButtonProperty" value="methodToCall.edit"/>
		<c:set var="extraButtonAlt" value="Edit"/>
	</c:if>
	<kul:documentControls 
		transactionalDocument="false"
		suppressRoutingControls="true"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${KualiForm.editingMode['viewOnly']}"
		/>

<SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;

</SCRIPT>

<script language="javascript" src="dwr/interface/ProtocolFundingSourceService.js"></script>
<script language="javascript" src="scripts/kuali_application.js"></script>
</kul:documentPage>
