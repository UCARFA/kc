<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%-- member of AwardNotesAndAttachments.jsp --%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="adminModifyAward" value="${KualiForm.editingMode['adminModifyAward']}" scope="request" />
<c:set var="limitEditableCommentTypes" value='<%=org.kuali.rice.coreservice.framework.CoreFrameworkServiceLocator.getParameterService().getParameterValueAsBoolean("KC-AWARD", "Document", "LIMIT_EDITABLE_COMMENT_TYPES")%>' />
<c:set var="editableCommentTypes" value='<%=org.kuali.rice.coreservice.framework.CoreFrameworkServiceLocator.getParameterService().getParameterValueAsString("KC-AWARD", "Document", "EDITABLE_COMMENT_TYPES")%>' />

<kul:tabTop tabTitle="Comments" defaultOpen="false" tabErrorKey="document.awardList[0].awardComment[*">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left">Comments</span>
    		<span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.award.home.AwardComment" altText="help"/></span>
        </h3>
		<c:forEach var="commentType" items="${KualiForm.awardCommentBean.awardCommentScreenDisplayTypes}" varStatus="commentTypeIndex">
			<c:if test="${limitEditableCommentTypes && adminModifyAward}">
				<c:set var="readOnly" value="true" scope="request" />
				<c:forEach var="editableCommentType" items="${editableCommentTypes}" >
					<c:if test="${commentType.commentTypeCode == editableCommentType && readOnly}">
						<c:set var="readOnly" value="false" scope="request" />
					</c:if>
				</c:forEach>
			</c:if>
			<kra-a:awardCommentsTypes index="${commentTypeIndex.index}" commentTypeDescription="${commentType.description}" commentTypeCode="${commentType.commentTypeCode}" awardId="${KualiForm.document.award.awardId}"/>
		</c:forEach>
		
		<br/>
		
		 <c:if test="${(!readOnly)}">
			<kra-a:awardSyncButton  scopeNames="COMMENTS_TAB" tabKey="${tabKey}"/>		
		 </c:if>
 	</div>
</kul:tabTop>
