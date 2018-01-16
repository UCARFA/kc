<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="readOnly" value="${!KualiForm.customDataHelper.modifyCustomData}" scope="request" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionName}CustomData"
	documentTypeName="${KualiForm.docTypeName}"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="customData">
  	
  	<div align="right">
       <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
       <kul:help parameterNamespace="KC-IACUC" parameterDetailType="Document" parameterName="iacucProtocolCustomDataHelp" altText="Help"/>
    </div>

	<kra-customdata:customDataTab excludeInactive="true" />
	<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" />

</kul:documentPage>
