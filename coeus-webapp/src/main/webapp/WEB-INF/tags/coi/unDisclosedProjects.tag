<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="disclosureProjects" required="true" type="java.util.List" description="A List of active or inactive FE" %>
<%@ attribute name="boLocation" required="true" description="Location of the disclosure projects list on the form." %>
<%@ attribute name="projectDivNamePrefix" required="true" description="name for project related div" %>
<%@ attribute name="projectListName" required="true" description="Project list name in master bean" %>
<%@ attribute name="idx" required="true" description="Coi disl project list index" %>
              
                                  

<div <c:if test="${hidden}">style="display:none;"</c:if>>                                  
	<c:forEach var="disclProjectBean" items="${disclosureProjects}" varStatus="status">
		<kra-coi:coiFinancialEntity disclProject="${disclProjectBean.coiDisclProject}"  idx="${status.index}" boLocation="${boLocation}[${status.index}]"
		projectDivNamePrefix="${projectDivNamePrefix}" projectIndex="${idx}" projectListName="${projectListName}"/>	            
    </c:forEach> 
 </div>         

