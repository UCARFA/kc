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
	htmlFormAction="awardHome"
	documentTypeName="AwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="home"
  	extraTopButtons="${KualiForm.extraTopButtons}" >
  	
<c:set var="displayKeywordPanel" value="true" />
<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />

<div align="right">
   <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
   <kul:help documentTypeName="AwardDocument" pageName="Award" />
</div>
<kul:documentOverview editingMode="${KualiForm.editingMode}" />
<kra-a:awardFundingProposals />
<kra-a:awardDetailsDates />
<kra-a:awardSubaward />
<kra-a:awardSponsorTemplate />

<c:if test="${displayKeywordPanel}">
<kra-a:awardKeywords />
</c:if>

<kul:panelFooter />

<SCRIPT type="text/javascript">
var kualiForm = document.forms['KualiForm'];
var kualiElements = kualiForm.elements;
</SCRIPT>
<script language="javascript" src="scripts/kuali_application.js"></script>
<script>
  $j = jQuery.noConflict();
</script>
<script language="javascript" src="dwr/interface/SponsorService.js"></script>

<c:if test="${readOnly && KualiForm.document.canModify && KualiForm.displayEditButton}">
	<c:set var="extraButtonSource" value="${ConfigProperties.kra.externalizable.images.url}buttonsmall_edit_temp.gif"/>
	<c:set var="extraButtonProperty" value="methodToCall.editOrVersion"/>
	<c:set var="extraButtonAlt" value="Edit or Version"/>
</c:if>
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" 
						extraButtonSource="${extraButtonSource}" 
						extraButtonProperty="${extraButtonProperty}"
						extraButtonAlt="${extraButtonAlt}" 
					    suppressCancelButton="true"/>

</kul:documentPage>
