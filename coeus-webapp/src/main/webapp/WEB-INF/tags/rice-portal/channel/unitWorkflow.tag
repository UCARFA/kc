<%--
   - Kuali Coeus, a comprehensive research administration system for higher education.
   - 
   - Copyright 2005-2016 Kuali, Inc.
   - 
   - This program is free software: you can redistribute it and/or modify
   - it under the terms of the GNU Affero General Public License as
   - published by the Free Software Foundation, either version 3 of the
   - License, or (at your option) any later version.
   - 
   - This program is distributed in the hope that it will be useful,
   - but WITHOUT ANY WARRANTY; without even the implied warranty of
   - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   - GNU Affero General Public License for more details.
   - 
   - You should have received a copy of the GNU Affero General Public License
   - along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
