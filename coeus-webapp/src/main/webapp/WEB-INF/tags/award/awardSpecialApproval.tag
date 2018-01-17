<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>


<kul:tab tabTitle="Special Approval" defaultOpen="false" tabErrorKey="">
	<div class="tab-container" align="right">
		<h3>
			<span class="subhead-left">Special Approval</span>
		    <span class="subhead-right"><kul:help parameterNamespace="KC-AWARD" parameterDetailType="Document" parameterName="awardSpecialApprovalHelpUrl" altText="help"/></span>      
	</h3>
	
		<kra-a:awardApprovedEquipment />
		<kra-a:awardApprovedForeignTravel />
	</div>
</kul:tab>
