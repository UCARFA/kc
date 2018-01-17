<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="readOnly" value="${!KualiForm.committeeHelper.modifyCommittee}"  scope="request" />

<kul:documentPage 
    showDocumentInfo="true"
	htmlFormAction="iacucCommitteeMembership" 
	documentTypeName="CommonCommitteeDocument"
	renderMultipart="false" 
	showTabButtons="true" 
	auditCount="0"
	headerDispatch="${KualiForm.headerDispatch}"
	headerTabActive="committeeMembership">

	<div align="right"><kul:help documentTypeName="CommonCommitteeDocument" pageName="Members" /></div>
 
    <kra-committee:committeeAddMembershipSection readOnly="${readOnly}" />
    
    <kra-committee:committeeMemberships readOnly="${readOnly}"
    researchAreaReference = "org.kuali.kra.iacuc.IacucResearchArea" 
    membershipRoleValuesFinderClassName="org.kuali.kra.iacuc.committee.keyvalue.IacucMembershipRoleValuesFinder"/>

    <c:if test="${!readOnly && fn:length(KualiForm.document.committee.committeeMemberships) > 0}">
        <c:set var="extraButtonSource" value="${ConfigProperties.kra.externalizable.images.url}buttonsmall_deletesel.gif"/>
        <c:set var="extraButtonProperty" value="methodToCall.deleteCommitteeMembership"/>
        <c:set var="extraButtonAlt" value="Delete a Person"/>
    </c:if>  

	<kul:documentControls 
	    transactionalDocument="false"
		suppressRoutingControls="false"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		viewOnly="${KualiForm.editingMode['viewOnly']}" />

	<script type="text/javascript">
        var kualiForm = document.forms['KualiForm'];
        var kualiElements = kualiForm.elements;
    </script>
	<script language="javascript" src="dwr/interface/UnitService.js"></script>
</kul:documentPage>
