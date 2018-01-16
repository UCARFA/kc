<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="awardAttributes" value="${DataDictionary.AwardDocument.attributes}" />
<c:set var="awardApprovedSubawardAttributes" value="${DataDictionary.AwardTemplate.attributes}" />
<c:set var="syncPropertyName" value="awardSponsorTerms" />
<c:set var="action" value="awardTemplateSync" />

<kul:tab tabTitle="Sponsor Term Template" defaultOpen="false" tabErrorKey="document.award.awardTemplate*">
	<div class="tab-container" align="center">
	    <html:image property="methodToCall.syncAwardTemplate.syncPropertyName${syncPropertyName}.anchor${tabKey}"
		src='${ConfigProperties.kra.externalizable.images.url}tinybutton-synctotemplate.gif' styleClass="tinybutton"/>
	</div>
</kul:tab>
