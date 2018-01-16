<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="masterDisclosureProjects" required="true" type="java.util.List" description="A List of active or inactive FE" %>
<%@ attribute name="boLocation" required="true" description="Location of the disclosure projects list on the form." %>
<%@ attribute name="projectDivNamePrefix" required="true" description="name for project related div" %>
<%@ attribute name="projectListName" required="true" description="Project list name in master bean" %>
<%@ attribute name="parentTab" required="true" description="Parent Tab for any tabs created within this tag." %>
<%@ attribute name="disclosureGroupedByEvent" required="true" description="Boolean to check if project is grouped by event or entity" %>
<%@ attribute name="groupedEntityNumber" required="true" description="Entity number - valid only if grouped by entity" %>
              
                                  

<div <c:if test="${hidden}">style="display:none;"</c:if>>                                  
            <c:forEach var="disclProjectBean" items="${masterDisclosureProjects}" varStatus="status">
                    <kra-coi:projectStyle disclProjectBean="${disclProjectBean}"/>                    
                    <kra-coi:projectHeader disclProject="${disclProjectBean.coiDisclProject}" boLocation="${boLocation}[${status.index}].coiDisclProject"/>                    
                    <kra-coi:feStatusReview disclProjectBean="${disclProjectBean}" projectDivNamePrefix="${projectDivNamePrefix}"  idx="${status.index}" projectListName="${projectListName}"
                    disclosureGroupedByEvent="${disclosureGroupedByEvent}"
				    groupedEntityNumber="${groupedEntityNumber}"/>
            </c:forEach> 
 </div>         

