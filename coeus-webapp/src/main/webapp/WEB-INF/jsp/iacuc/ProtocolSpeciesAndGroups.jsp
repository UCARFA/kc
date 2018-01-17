<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>


<c:set var="protocolSpeciesList" value="${KualiForm.document.protocol.iacucProtocolSpeciesList}" />
<c:set var="protocolSpeciesAttributes" value="${DataDictionary.IacucProtocolSpecies.attributes}" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="iacucProtocolSpeciesAndGroups"
	documentTypeName="IacucProtocolDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="speciesAndGroups">

  	<div align="right">
		<kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
		<kul:help documentTypeName="${KualiForm.docTypeName}" pageName="Species/Groups" />
	</div>
  	
	<div id="workarea">
		<kra-iacuc:speciesAndGroups businessObjectClassName="org.kuali.kra.iacuc.species.IacucProtocolSpecies"
		                            protocolSpeciesAttributes="${protocolSpeciesAttributes}"
		                            collectionReference="${protocolSpeciesList}"
		                            collectionProperty="document.protocolList[0].iacucProtocolSpeciesList"
		                            action="iacucProtocolSpeciesAndGroups" />
		<kul:panelFooter />
	</div>


	<script type="text/javascript">
	   var $j = jQuery.noConflict();
	</script>
	
	<SCRIPT type="text/javascript">
	var kualiForm = document.forms['KualiForm'];
	var kualiElements = kualiForm.elements;
	</SCRIPT>
	<script language="javascript" src="scripts/kuali_application.js"></script>

	<kul:documentControls transactionalDocument="false" suppressRoutingControls="true" />
</kul:documentPage>
