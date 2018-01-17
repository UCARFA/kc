<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ tag import="org.kuali.coeus.sys.framework.service.KcServiceLocator" %>
<%@ tag import="org.kuali.coeus.common.framework.motd.MessageOfTheDayService" %>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="motd" value="<%= (KcServiceLocator.getService(MessageOfTheDayService.class)).getMessagesOfTheDay() %>" scope="page"/>
<c:if test="${!empty pageScope.motd}">
	<channel:portalChannelTop channelTitle="Messages Of The Day" />
	<c:set var = "printed" value = "false"/>
	<c:forEach items = "${pageScope.motd}" var = "msg">
	    	<c:set var= "printed" value = "true"/>
			<div class="body">
        		<strong><c:out value="${msg.message}"  /></strong>
        	</div>
   </c:forEach>
	<c:if test = "${!printed}">
	    <div class = "body">No messages today.</div>
	</c:if>
    <channel:portalChannelBottom />
</c:if>
