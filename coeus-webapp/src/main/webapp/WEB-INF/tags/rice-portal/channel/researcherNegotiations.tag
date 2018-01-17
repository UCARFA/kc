<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Negotiations" />
<div class="body">
  <ul class="chan">
    <li><portal:portalLink displayTitle="false" title='All My Negotiations' url='${ConfigProperties.application.url}/kr/lookup.do?methodToCall=search&businessObjectClassName=org.kuali.kra.negotiations.bo.Negotiation&docFormKey=88888888&includeCustomActionUrls=true&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&associatedNegotiable.piName=${UserSession.person.firstName}*${UserSession.person.lastName}&searchCriteriaEnabled=true'>All My Negotiations</portal:portalLink></li>
  </ul>
</div>
<channel:portalChannelBottom />
