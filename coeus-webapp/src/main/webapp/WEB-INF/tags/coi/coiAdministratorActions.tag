<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>


<c:set var="disclosureReviewCompleted" value="${KualiForm.disclosureActionHelper.disclosureReviewComplete}" />
<kul:tab tabTitle="Administrator Actions" defaultOpen="false" tabErrorKey="coiAdminActionErrors">
		<c:if test="${not KualiForm.document.coiDisclosureList[0].currentDisclosure}">
            <kra-coi:addCoiReviewerAction />
            <kra:permission value="${KualiForm.disclosureHelper.canUpdateFEStatusAdmin}">
            	<kra-coi:coiProjectsFinancialEntity/>
            </kra:permission>
            <c:if test="${disclosureReviewCompleted}">
	            <kra-coi:disclosureReviewStatusAction/>
            </c:if>
            <c:if test="${!KualiForm.document.viewOnly}">
            <kra-coi:approveAction />
            </c:if>
        </c:if>    
</kul:tab>
