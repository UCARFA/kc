<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/kr/WEB-INF/jsp/tldHeader.jsp"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="roleName" required="true" %>
<%@ attribute name="userList" required="true" type="java.util.List" %>

<tr>
	<th align="right" valign="middle" width="20%">${roleName}:</th>
    <td id="${id}" align="left" valign="middle">
      	<c:forEach var="name" items="${userList}" varStatus="status"><c:if test="${status.index != 0}">;&nbsp;</c:if>${name}</c:forEach>
		&nbsp;
    </td>
</tr>
