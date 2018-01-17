<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<div id="tabs">
	<dl class="tabul">
    	<c:set var="activeTabName" value="${KualiForm.iacucProtocolProceduresHelper.currentProcedureDetailTab.displayName}"/>
		<c:forEach var="procedureTab" items="${KualiForm.iacucProtocolProceduresHelper.procedureNavigationTabs}" varStatus="status">
        	<c:set var="displayTabName" value="${procedureTab.displayName}"/>
            <c:set var="methodName" value="${procedureTab.methodName}"/>
            <c:set var="currentTab" value="${activeTabName eq displayTabName}" /> 
  			<c:choose>
  				<c:when test="${currentTab}">
  					<dt class="licurrent">
  				</c:when>
  				<c:otherwise>
  					<dt>
  				</c:otherwise>
  			</c:choose>
  			<span class="tabright ${currentTab ? 'tabcurrent' : ''}">
  				<html:submit value="${displayTabName}" property="methodToCall.${methodName}.anchor${tabKey}"  alt="${displayName}" disabled="false"  />
  			</span></dt>
		</c:forEach>
 	</dl>
</div>



