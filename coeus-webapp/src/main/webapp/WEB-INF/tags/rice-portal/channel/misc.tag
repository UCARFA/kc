<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<channel:portalChannelTop channelTitle="Miscellaneous"/>
<div class="body">

   <ul class="chan">
      <li><a href="${ConfigProperties.application.url}/coiProject.do?methodToCall=publishAll" title="Project Push To COI">Project Push To COI</a></li>
      <li><a href="${ConfigProperties.application.url}/authServicePush.do?methodToCall=pushAll" title="Push Users to the Core Auth Service">Push Users to the Core Auth Service</a></li>
      <li><a href="${ConfigProperties.application.url}/addressBookToCorePush.do?methodToCall=pushAll" title="Push Address Book Users to the Core Auth Service">Push Address Book Users to the Core Auth Service</a></li>
      <li><a href="${ConfigProperties.application.url}/groupServicePush.do?methodToCall=pushAll" title="Push Units to the Core Groups Service">Push Units to the Core Groups Service</a></li>
      <li><a href="${ConfigProperties.krad.url}/core/admin/cache?viewId=CacheAdmin-view1&methodToCall=start" title="Cache Admin">Cache Admin</a></li>
      <li><portal:portalLink displayTitle="true" title="Data Dictionary File In Use" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.sys.framework.dd.DataDictionaryFile&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
      <li><portal:portalLink displayTitle="true" title="Data Dictionary Override" url="${ConfigProperties.application.url}/kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.coeus.sys.framework.dd.DataDictionaryOverride&returnLocation=${ConfigProperties.application.url}/portal.do&hideReturnLink=true&docFormKey=88888888" /></li>
   </ul>

</div>
<channel:portalChannelBottom/>
