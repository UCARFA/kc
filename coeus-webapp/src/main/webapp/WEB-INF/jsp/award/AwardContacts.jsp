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
	htmlFormAction="awardContacts"
	documentTypeName="AwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="contacts"
  	extraTopButtons="${KualiForm.extraTopButtons}" >

<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />
<c:set var="adminModifyAward" value="${KualiForm.editingMode['adminModifyAward']}" scope="request" />

<c:if test="${adminModifyAward}">
	<c:set var="readOnly" value="true" scope="request" />
</c:if>

<%-- modeled after ProposalDevelopmentKeyPersonnel.jsp --%>
<div align="right">
    <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
    <kul:help documentTypeName="AwardDocument" pageName="Contacts" />
</div>

<div id="workarea">
	<kra-a:awardProjectPersonnel />
	<kra-a:awardUnitContacts />
	<c:if test="${adminModifyAward && KualiForm.editingMode['fullEntry']}">
		<c:set var="readOnly" value="false" scope="request" />
	</c:if>
	<kra-a:awardSponsorContacts />
	<c:if test="${adminModifyAward}">
		<c:set var="readOnly" value="true" scope="request" />
	</c:if>
	<kra-a:awardCentralAdministrationContacts />
	<kul:panelFooter />
</div>



<SCRIPT type="text/javascript">
	var kualiForm = document.forms['KualiForm'];
	var kualiElements = kualiForm.elements;
</SCRIPT>
<script language="javascript" src="scripts/kuali_application.js"></script>
<script language="javascript" src="dwr/interface/SponsorService.js"></script>

<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true" />

</kul:documentPage>
