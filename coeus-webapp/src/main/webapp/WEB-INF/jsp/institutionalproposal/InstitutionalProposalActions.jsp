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
	htmlFormAction="institutionalProposalActions"
	documentTypeName="InstitutionalProposalDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="actions">
  	
  	<div align="right">
        <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
        <kul:help documentTypeName="${KualiForm.documentTypeName}" pageName="Institutional Proposal Actions" />
    </div>

<c:set var="readOnly" value="${KualiForm.editingMode['viewOnly']}" scope="request" />
<c:set var="extraButtons" value="${KualiForm.extraActionsButtons}" scope="request" />
    
<kra:dataValidation auditActivated="${KualiForm.auditActivated}" topTab="true"/>
<kra-ip:institutionalProposalFundedAwards />
<kul:adHocRecipients />
<kra-ip:institutionalProposalPrint />
<kul:routeLog /> 

<kul:panelFooter />	
 
<kul:documentControls transactionalDocument="true"
                      extraButtonSource="${extraButtonSource}"
                      extraButtonProperty="${extraButtonProperty}"
                      extraButtonAlt="${extraButtonAlt}" 
                      extraButtons="${extraButtons}" />

<script language="javascript" src="scripts/kuali_application.js"></script>

</kul:documentPage>
