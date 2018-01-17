<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="disclProjectBean" required="true" type="org.kuali.kra.coi.disclosure.CoiDisclosureProjectBean" %>
<%-- This tag is to highligh the project that are associated with the selected master disclosure --%>
		<jsp:doBody/>
        	         <c:choose>
        	             <c:when test="${disclProjectBean.currentProject}">
        	                <c:set var="style" value="color:yellow;" scope="request"/>
        	             </c:when>
        	             <c:otherwise>
        	                <c:set var="style" value="" scope="request"/>
        	             </c:otherwise>
        	         </c:choose>
		
