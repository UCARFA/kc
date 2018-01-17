<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Awards" />
<div class="body">
	<ul class="chan">
      <li><portal:portalLink displayTitle="false" title="All my Awards" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=search&businessObjectClassName=org.kuali.kra.award.home.Award&docFormKey=88888888&includeCustomActionUrls=true&returnLocation=${ConfigProperties.application.url}/portal.do&projectPersons.fullName=${UserSession.person.firstName}*${UserSession.person.lastName}&hideReturnLink=true">All my Awards</portal:portalLink></li>
      <li><portal:portalLink displayTitle="false" title="Award Report Tracking" url="${ConfigProperties.application.url}/reportTrackingLookup.do?methodToCall=start&businessObjectClassName=org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking&docFormKey=88888888&returnLocation=${ConfigProperties.application.url}/portal.do">Award Report Tracking</portal:portalLink></li>
	</ul>
</div>
<channel:portalChannelBottom />
