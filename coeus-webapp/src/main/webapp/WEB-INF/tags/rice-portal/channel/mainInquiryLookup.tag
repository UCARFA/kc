<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Inquiries and Lookups" />
<div class="body">
<strong>General</strong>
<ul class="chan">
  <li>Grants.gov Opportunity</li>
  <li>Rolodex</li>  
  <li><portal:portalLink displayTitle="true" title="Sponsor" url="${ConfigProperties.kr.url}/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.common.framework.sponsor.Sponsor&docFormKey=88888888&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true" /></li>
  <li>Sponsor Hierarchy</li>
  <li>Organization</li>
  <li>Medusa</li>
</ul>

<strong>Person and Workgroup</strong>
<ul class="chan">
  <li><portal:portalLink displayTitle="true" title="Person" url="${ConfigProperties.kr.url}/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.common.framework.person.KcPerson&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
  <li>Workgroup</li>
</ul>
</div>
<channel:portalChannelBottom />
