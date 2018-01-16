<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<display:table name="${KualiForm.negotiationNotifications}" export="false" id="row"   
	    class="datatable-100" cellpadding="2" cellspacing="0">
    <display:column property="updateTimestamp" title="Date Created" style="height:20px;"/>
    <display:column property="recipients" title="Recipients"/>
    <display:column property="subject" title="Subject"/>
    <display:column property="message" title="Message"/>
</display:table>
