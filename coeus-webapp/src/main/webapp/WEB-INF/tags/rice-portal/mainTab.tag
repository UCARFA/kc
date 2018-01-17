<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/rice-portal/jsp/sys/riceTldHeader.jsp"%>

<c:if test="${ConfigProperties.portal.show.sample.app eq 'true'}">
	<td class="content" valign="top">
	    <mainChannel:sampleTravelApplication />
	</td>
</c:if>
<td class="content" valign="top">
<mainChannel:workflow />
</td>
<td class="content" valign="top">
<mainChannel:notification />
</td>
