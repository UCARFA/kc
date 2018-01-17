<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="System" />
<div class="body">
  <ul class="chan">
    <li>Employee Status</li>
    <li>Employee Type</li>
    <li><portal:portalLink displayTitle="true" title="Messages Of The Day" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.common.framework.motd.MessageOfTheDay&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
    <li><portal:portalLink displayTitle="true" title="Person Extended Attributes" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.common.framework.person.attr.KcPersonExtendedAttributes&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
    <li><portal:portalLink displayTitle="true" title="Unit Role Sync Configuration"
                           url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.common.framework.unit.sync.UnitRoleSync&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888"/></li>
    <li><a href="${ConfigProperties.application.url}/unitRoleSync.do?methodToCall=syncAll" title="Execute Unit Role Sync Process">Execute Unit Role
      Sync Process</a></li>
    <li><portal:portalLink displayTitle="true" title="Document Configuration Hierarchy" url="${ConfigProperties.kew.url}/RuleQuickLinks.do?methodToCall=start&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
    <li>System Options</li>
    <li>
      <portal:portalLink displayTitle="true" title="Database Schema Information" url="${ConfigProperties.application.url}/schemaspy/index.html" />
      <a href="${ConfigProperties.application.url}/schemaspy/_schema.xml">
        <img border="0" alt="XML" src="static/images/tinybutton-viewxml.gif" class="tinybutton">
      </a>
    </li>
    <c:if test="${krafn:isGrm() && krafn:getConfigValueAsBoolean('legacy.coeus.kc.schemaspy.enabled')}">
      <li>
        <portal:portalLink displayTitle="true" title="Legacy Coeus Database Schema Information" url="${ConfigProperties.application.url}/legacyCoeusSchemaspy/index.html" />
        <a href="${ConfigProperties.application.url}/legacyCoeusSchemaspy/_schema.xml">
          <img border="0" alt="XML" src="static/images/tinybutton-viewxml.gif" class="tinybutton">
        </a>
      </li>
    </c:if>
    <li><portal:portalLink displayTitle="true" title="Monitoring" url="${ConfigProperties.application.url}/monitoring/jm" /></li>
    <li><portal:portalLink displayTitle="true" title="ActiveMQ Message Queue" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.sys.impl.mq.ActiveMqMessage&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
    <li><portal:portalLink displayTitle="true" title="Serializable Session Attribute" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.sys.impl.session.ser.SerializableSessionAttribute&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
    <li><portal:portalLink displayTitle="true" title="Serializable User Session Attribute" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.sys.impl.session.ser.SerializableUserSessionAttribute&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
    <li><portal:portalLink displayTitle="true" title="Serializable KRAD Form" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.sys.impl.session.ser.SerializableKradForm&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
  </ul>
</div>
<channel:portalChannelBottom />
