<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="attachment" required="true" type="org.kuali.coeus.sys.api.model.KcFile"%>

<c:set var="height" value="16"/>
<c:set var="width" value="16"/>

<img src="${krafn:getIconPath(attachment.type)}" height="${height}" width="${width}" alt="${attachment.type}" title="${attachment.type}"/>

