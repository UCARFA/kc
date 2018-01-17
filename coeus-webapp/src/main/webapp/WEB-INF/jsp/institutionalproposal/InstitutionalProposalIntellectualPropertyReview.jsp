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
	htmlFormAction="institutionalProposalIntellectualPropertyReview"
	documentTypeName="InstitutionalProposalDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="intellectualPropertyReview">
  	
  	<div align="right">
        <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
        <kul:help documentTypeName="InstitutionalProposalDocument" pageName="Intellectual Property Review" />
    </div>

<kra-ip:institutionalProposalReviewData />
<kra-ip:institutionalProposalActivities />

<kul:panelFooter />	

<div id="globalbuttons" class="globalbuttons">
    <html:image src="${ConfigProperties.kra.externalizable.images.url}buttonsmall_editipreview.gif" styleClass="globalbuttons" property="methodToCall.editIntellectualPropertyReview" title="Edit IP Review" alt="Edit Intellectual Property Review"
    onclick="javascript: openNewWindow('institutionalProposalIntellectualPropertyReview','editIntellectualPropertyReview','','${KualiForm.formKey}','${KualiForm.document.sessionDocument}');return false" />
    <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_reload.gif" styleClass="globalbuttons" property="methodToCall.reload" title="reload" alt="reload" onclick="excludeSubmitRestriction=true"/>
    <c:if test="${!empty KualiForm.documentActions[Constants.KUALI_ACTION_CAN_CLOSE]}">
        <html:image src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_close.gif" styleClass="globalbuttons" property="methodToCall.close" title="close" alt="close"/>
    </c:if>
</div>
                
<script language="javascript" src="scripts/kuali_application.js"></script>

</kul:documentPage>
