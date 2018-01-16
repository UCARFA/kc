<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ page import="org.kuali.kra.infrastructure.Constants"%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="negotiationAttributes" value="${DataDictionary.NegotiationDocument.attributes}" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="negotiationNegotiation"
	documentTypeName="NegotiationDocument"
	renderMultipart="true"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="negotiation">
  	
<script type="text/javascript"> 
   var $jq = jQuery.noConflict();
</script>
<script type="text/javascript" src="scripts/medusaView.js"></script>  	
  	
<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}"/>
<c:set var="medusaLink" value="${KualiForm.methodToCall eq 'medusa'}"/>
<div align="right">
    <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
    <kul:help documentTypeName="NegotiationDocument" pageName="Negotiation" />
</div>
<kul:documentOverview editingMode="${KualiForm.editingMode}" />

 <kra-negotiation:negotiation />

 <c:if test="${fn:length(KualiForm.customDataHelper.customAttributeGroups) > 0}">
 <kul:tab tabTitle="Custom Data" defaultOpen="false" tabErrorKey="customDataHelper.customDataList*" useRiceAuditMode="false">
 <kra-negotiation:NegotiationCustomDataTab readOnly="${readOnly}"/>
 </kul:tab>
  </c:if>
  
 <kra-negotiation:negotiationActivities />
  
<kul:tab tabTitle="Medusa" defaultOpen="${medusaLink}" tabErrorKey="">
<kra-m:medusa helpParameterNamespace="KC-NEGOTIATION" helpParameterDetailType="Document" helpParameterName="negotiationMedusaHelp" />
</kul:tab>



<kul:panelFooter />
    <c:if test="${readOnly}">
        <c:set var="extraButtonSource" value="${ConfigProperties.kra.externalizable.images.url}buttonsmall_edit_temp.gif"/>
        <c:set var="extraButtonProperty" value="methodToCall.edit"/>
        <c:set var="extraButtonAlt" value="Edit or Version"/>
    </c:if>
	<kul:documentControls 
		transactionalDocument="true"
		suppressRoutingControls="true"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${!KualiForm.editingMode['create'] && !KualiForm.editingMode['modify'] && !KualiForm.editingMode['modify_activity']}"
		/>

</kul:documentPage>
