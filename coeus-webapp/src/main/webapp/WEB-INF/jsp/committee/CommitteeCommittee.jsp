<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ page import="org.kuali.kra.infrastructure.Constants"%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="committeeAttributes" value="${DataDictionary.CommitteeDocument.attributes}" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="committeeCommittee"
	documentTypeName="CommitteeDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="committee">
 
<script type="text/javascript">
	var $j = jQuery.noConflict();
</script>

<div align="right">
	<kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
	<kul:help documentTypeName="CommitteeDocument" pageName="Committee" />
</div>
<kul:documentOverview editingMode="${KualiForm.editingMode}" />
<kra-committee:committee />
<kra-committee:committeeResearchAreas researchAreaReference = "org.kuali.kra.irb.ResearchArea"/>

<kul:panelFooter />
	<c:if test="${readOnly && KualiForm.editingMode['canModify']}">
		<c:set var="extraButtonSource" value="${ConfigProperties.kra.externalizable.images.url}buttonsmall_edit_temp.gif"/>
		<c:set var="extraButtonProperty" value="methodToCall.edit"/>
		<c:set var="extraButtonAlt" value="Edit"/>
	</c:if>
	<kul:documentControls 
		transactionalDocument="false"
		suppressRoutingControls="false"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${KualiForm.editingMode['viewOnly']}"
		/>





<SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;
</SCRIPT>

<script language="javascript" src="dwr/interface/UnitService.js"></script>
<script>
loadUnitNameTo('document.committeeList[0].homeUnitNumber','document.committee.homeUnitName');
</script>
</kul:documentPage>
