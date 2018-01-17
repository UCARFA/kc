<#--
   - Copyright © 2005-2018 Kuali, Inc.
   - All Rights Reserved
   - You may use and modify this code under the terms of the Kuali, Inc.
   - Pre-Release License Agreement. You may not distribute it.
   -
   - You should have received a copy of the Kuali, Inc. Pre-Release License
   - Agreement with this file. If not, please write to license@kuali.co.
-->
<#macro backdoor>

    <#if UserSession??>
      <div class="backdoor">
	    <#if UserSession.backdoorInUse>        
          Backdoor Id <b>${UserSession.principalName}</b> is in use
      	</#if>
        <#if UserSession.objectMap.AUTH_SERVICE_FILTER_AUTHED_USER??
      	    && UserSession.objectMap.AUTH_SERVICE_FILTER_AUTHED_USER.actualUser??>
      		CoreAuth User <b>${UserSession.objectMap.AUTH_SERVICE_FILTER_AUTHED_USER.actualUser}</b> is proxied
        </#if>
      </div>
    </#if>

</#macro>