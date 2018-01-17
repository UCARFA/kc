<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="readOnly" required="false" %>

<div id="workarea">
	<c:set var="fieldCount" value="0" />
	<c:forEach items="${KualiForm.customDataHelper.customAttributeGroups}" var="customAttributeGroup" varStatus="groupStatus">
	   	<c:set var="fullName" value="${customAttributeGroup.key}" />
			<kra-customdata:customData fullName="${fullName}" fieldCount="${fieldCount}" 
			customAttributeGroups="${KualiForm.customDataHelper.customAttributeGroups}"
			customDataList="${KualiForm.customDataHelper.customDataList}"
			customDataListPrefix="customDataHelper.customDataList"
			readOnly="${readOnly}"/>
	   	<c:set var="fieldCount" value="${fieldCount + fn:length(customAttributeGroup.value)}" />
	</c:forEach>
</div>
