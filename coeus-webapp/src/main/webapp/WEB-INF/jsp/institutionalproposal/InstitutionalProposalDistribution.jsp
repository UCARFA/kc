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

<c:set var="readOnly" value="${KualiForm.editingMode['viewOnly']}" scope="request" />

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="institutionalProposalDistribution"
	documentTypeName="InstitutionalProposalDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="distribution">

    <c:set var="lifecycleRatesFlowthruEnabled" value="${KualiForm.lifecycleRatesFlowthruEnabled}" />

    <div align="right">
       <kra:shortUrl shortUrl="${KualiForm.shortUrl}"/>
       <kul:help documentTypeName="InstitutionalProposalDocument" pageName="Distribution" />
    </div>

<kra-ip:institutionalProposalCostShare/>
<c:choose>
    <c:when test="${lifecycleRatesFlowthruEnabled}">
        <kra-ip:institutionalProposalFAndA />
    </c:when>
    <c:otherwise>
        <kra-ip:institutionalProposalUnrecoveredFAndA />
    </c:otherwise>
</c:choose>

<kul:panelFooter />	
 
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" suppressCancelButton="true"/>
<script language="javascript" src="scripts/kuali_application.js"></script>

</kul:documentPage>
