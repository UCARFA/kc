<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="channelTitle" required="true" %>
<%@ attribute name="channelUrl" required="true" %>
<%@ attribute name="selectedTab" required="true" %>

<c:choose>
  <c:when test='${!empty channelTitle && !empty channelUrl}'>
	  <c:if test="${!empty param.backdoorId}">
	  	<c:set var="channelUrl" value="${channelUrl}?backdoorId=${param.backdoorId}&methodToCall.login=1"/>
	  </c:if>
	  <div id="iframe_portlet_container_div">
	  	<portal:iframePortletContainer channelTitle="${channelTitle}" channelUrl="${channelUrl}" />
	  </div>
  </c:when>
  <c:otherwise>
  <div class="container-fluid body-container">
	<table border="0" width="100%"  cellspacing="0" cellpadding="0" id="iframe_portlet_container_table">
	   	<tr valign="top" bgcolor="#FFFFFF">
      		<td width="15" class="leftback-focus">&nbsp;</td>
	 		<c:choose>
	 		  <%-- then default to tab based actions if they are not focusing in --%>
	          <c:when test='${selectedTab == "portalMaintenanceBody"}'>
	              <portal:portalMaintenanceBody />
	          </c:when>
	          <c:when test='${selectedTab == "portalSystemAdminBody"}'>
	              <portal:portalSystemAdminBody />
	          </c:when>
	          
	          <%-- as backup go to the main menu index --%>
	          <c:otherwise>
	            <portal:portalMaintenanceBody />
	          </c:otherwise>
	        </c:choose>
       </tr>
    </table>
    </div>
  </c:otherwise>
</c:choose>

 <div class="footerbevel">&nbsp;</div>
 <div id="footer-copyright">
   <bean:message key="app.copyright" />
   <div class="footer-build">${ConfigProperties.version} (${ConfigProperties.datasource.ojb.platform})</div>
 </div>
