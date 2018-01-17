<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ page import="org.kuali.kra.infrastructure.Constants"%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="committeeAttributes" value="${DataDictionary.CommonCommitteeDocument.attributes}" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="iacucCommitteeCommittee"
	documentTypeName="CommonCommitteeDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="committee">

<div align="right"><kul:help documentTypeName="CommonCommitteeDocument" pageName="Committee" /></div>
<kul:documentOverview editingMode="${KualiForm.editingMode}" />

<kra-committee:committee cmtAttributes="${DataDictionary.IacucCommittee.attributes}" />
<kra-committee:committeeResearchAreas researchAreaReference = "org.kuali.kra.iacuc.IacucResearchArea"/>

<kul:panelFooter />
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
