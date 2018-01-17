<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>


<kul:tab tabTitle="Disclosure Action" defaultOpen="false" tabErrorKey="">
	<div class="tab-container"  align="center">
		<h3> 
			<span class="subhead-left">Disclosure Actions</span>
			<span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.coi.CoiDisclosureStatus" altText="help"/></span>
		</h3>
		<c:if test="${not KualiForm.document.coiDisclosureList[0].currentDisclosure}">
            <kra-coi:approveAction />
        </c:if>    
	</div>


      
</kul:tab>
