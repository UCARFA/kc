<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="permissionsUserAttributes" value="${DataDictionary.PermissionsUser.attributes}" />
<c:set var="modifyPermissions" value="${KualiForm.permissionsHelper.modifyPermissions && (empty DocumentPessimisticLockMessages)}" />
  
<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionName}Permissions"
	documentTypeName="${KualiForm.docTypeName}"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="permissions">

    <div align="right">
        <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
        <kul:help documentTypeName="${KualiForm.docTypeName}" pageName="Permissions" />
    </div>

    <kra-protocol:protocolPermissionsPage 
           name="${KualiForm.actionName}" 
           modifyPermissions="${modifyPermissions}"
           permissionsUserAttributes="${permissionsUserAttributes}"
           />
  	
</kul:documentPage>
