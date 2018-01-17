<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ page import="java.util.HashMap" %>

<c:set var="protocolAttributes" value="${DataDictionary.ProtocolDocument.attributes}" />
<c:set var="protocolPersonAttributes" value="${DataDictionary.ProtocolPerson.attributes}" />
<c:set var="personAttributes" value="${DataDictionary.Person.attributes}" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="personnel"
	documentTypeName="ProtocolDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="personnel">
  	
  	<div align="right">
		<kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
		<kul:help documentTypeName="ProtocolDocument" pageName="Personnel" />
	</div>

	<c:set var="viewOnly" value="${not KualiForm.personnelHelper.modifyPersonnel}" />
	<kra-irb:protocolAddPersonnelSection/>
	<kra-irb:protocolPersons/>
  <c:if test="${not empty viewOnly && ! viewOnly and fn:length(KualiForm.document.protocolList[0].protocolPersons) > 0}">
  	<c:set var="extraButtonSource" value="${ConfigProperties.kra.externalizable.images.url}buttonsmall_deletesel.gif"/>
  	<c:set var="extraButtonProperty" value="methodToCall.deleteProtocolPerson"/>
  	<c:set var="extraButtonAlt" value="Delete a Person"/>
  </c:if>  
  	<p>
	<kul:documentControls 
		transactionalDocument="false"
		suppressRoutingControls="true"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${viewOnly}"
		/>
	</p>

<script type="text/javascript">
   var $j = jQuery.noConflict();
</script>

<SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;
</SCRIPT>
<script language="javascript" src="scripts/kuali_application.js"></script>
<script language="javascript" src="dwr/interface/UnitService.js"></script>

</kul:documentPage>
