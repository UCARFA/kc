<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Workflow" />
<div class="body">
  <ul class="chan">
    <li><portal:portalLink displayTitle="false" title='Workflow Services' url='${ConfigProperties.krad.url}/lookup?methodToCall=start&dataObjectClassName=org.kuali.rice.kew.impl.peopleflow.PeopleFlowBo&showMaintenanceLinks=true&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true'>People Flow</portal:portalLink></li>
    <li><portal:portalLink displayTitle="false" title='Workflow Services' url='${ConfigProperties.workflow.url}/Preferences.do'>Preferences</portal:portalLink></li>
    <li><portal:portalLink displayTitle="false" title='Workflow Services' url='${ConfigProperties.workflow.url}/RoutingReport.do'>Routing Report</portal:portalLink></li>
    <li><portal:portalLink displayTitle="false" title='Workflow Services' url='${ConfigProperties.kr.url}/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.rice.kew.rule.RuleBaseValues&docFormKey=88888888&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true'>Rules</portal:portalLink></li>
    <li><portal:portalLink displayTitle="false" title='Workflow Services' url='${ConfigProperties.workflow.url}/RuleQuickLinks.do'>Rule QuickLinks</portal:portalLink></li>
  </ul>
</div>
<channel:portalChannelBottom />
