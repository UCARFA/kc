<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:tab tabTitle="Summary" defaultOpen="false" tabErrorKey="">

	<div class="tab-container" align="left">
		<h3>
   			<span class="subhead-left">Summary</span>
   			<span class="subhead-right">
   				<kul:help parameterNamespace="KC-PROTOCOL" parameterDetailType="Document" parameterName="protocolSummaryAndHistoryHelp" altText="Help"/>
			</span>
       </h3>
		<kra-irb:protocolSummaryPanel />
    </div>	    
</kul:tab>
