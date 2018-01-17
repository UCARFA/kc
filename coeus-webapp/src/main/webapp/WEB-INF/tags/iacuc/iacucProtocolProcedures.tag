<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:tab tabTitle="Procedure Details" defaultOpen="true" tabErrorKey="" >
    <div class="tab-container" id="horz-tab-links" align="center">
    	<kra-iacuc:protocolProcedureDetailsTab/>
		<c:set var="protocolStudyGroups" value="${KualiForm.document.protocol.iacucProtocolStudyGroupBeans}" />
		<kra-iacuc:protocolProcedureDetails businessObjectClassName="org.kuali.kra.iacuc.IacucProtocol"
		                            collectionReference="${protocolStudyGroups}"
		                            collectionProperty="document.protocolList[0].iacucProtocolStudyGroupBeans"/>
    </div>
</kul:tab>    	 	
		                            
