<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="scopeNames" description="Named scope the sync should apply to. leave empty if you want to apply the global scope." required="false" %>
<%@ attribute name="tabKey" description="tab key for the button" required="false" %>
<%@ attribute name="fullSync" description="Is the sync to be a full sync, or a scoped sync?" required = "false" %>

<c:set var = "mtc" value = "syncAwardTemplate"/>

<c:if test = "${fullSync}">
	<c:set var = "mtc" value = "fullSyncToAwardTemplate"/>
</c:if>

		<html:image property="methodToCall.${mtc}.scopes:${scopeNames}.anchor${tabKey}"
		src='${ConfigProperties.kra.externalizable.images.url}tinybutton-synctotemplate.gif' styleClass="tinybutton"/>
