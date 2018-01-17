<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/kr/WEB-INF/jsp/tldHeader.jsp"%>

<%@ attribute name="softErrorKey" required="true" description="this is the errorKey with which the soft error (warning) was registered by the rule" %>

<c:set var="softErrorList" value="${KualiForm.softErrors[pageScope.softErrorKey]}" />
<c:if test="${not empty softErrorList}">
	<fmt:setBundle basename="ApplicationResources" />
	<div align="left" style="color:navy; padding-left:6pt; padding-top:2pt; padding-bottom:2pt;background-color: #e4e4e4;">
		<c:forEach var="softError" items="${softErrorList}" varStatus="status">
			<li style="padding-left: 2pt;">
				<fmt:message key="${softError.errorKey}">
					<c:if test="${not empty softError.errorParms}">
						<c:forEach var="parm" items="${softError.errorParms}">
							<fmt:param value="${parm}"/>
						</c:forEach>
					</c:if>
				</fmt:message>
			</li>
		</c:forEach>
		<br/>
	</div>
</c:if>

