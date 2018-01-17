<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="topTab" required="true" type="java.lang.Boolean" description="is this the top tab on the page" %>
<c:set var="usageSectionId" value="<%=org.kuali.kra.infrastructure.Constants.COI_NOTEPAD_DISCLOSURE_REVIEWER_SECTION_ID%>" />
<c:if test="${topTab == true}">
	<%--instead of using kul:tabTop tag just define the workarea div - this gets around an unbalanced tag problem when using conditional tags --%>
	<div id="workarea">
</c:if>


<c:set var="disclosureAssignedToReviewer" value="${KualiForm.disclosureActionHelper.disclosureAssignedToReviewer}" />

<kul:tabTop tabTitle="Reviewer Actions" defaultOpen="false" tabErrorKey="disclosureActionHelper.newCoiUserRole.*, coiNotesAndAttachmentsHelper.newCoiDisclosureAttachment.*, coiNotesAndAttachmentsHelper.newCoiDisclosureNotepad.*">
	<kra-coi:coiNotes usageSectionId = "${usageSectionId}"/>
	<kra-coi:coiAttachments usageSectionId = "${usageSectionId}"/>
    <c:if test="${disclosureAssignedToReviewer}">
		<kra-coi:completeCoiReviewerAction/>
    </c:if>
</kul:tabTop>

