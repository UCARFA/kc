<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/kr/WEB-INF/jsp/tldHeader.jsp"%>
<%@ attribute name="roleName" required="true" %>
<%@ attribute name="permissions" required="true" type="java.util.List" %>

<div class="tab-container" align="center" style="margin:0px; padding:0px; border-width:0px">
	<h3>
    	<span class="subhead-left">${roleName}</span>
 	</h3>
 
 	<table cellpadding="0" cellspacing="0" summary="">
    	<c:forEach var="permission" items="${permissions}" varStatus="status">
    		<tr>
				<th align="right" valign="middle" width="40%">${permission.name}:</th>
    			<td align="left" valign="middle">${permission.description}</td>
    		</tr>
	    </c:forEach>
    </table>
</div>
