<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:tab tabTitle="Print" defaultOpen="false" tabErrorKey="document.fillme*">
         
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left">Print</span>
        </h3>
        <kra-ip:printNotice />
        <kra:printReports requestUri="/institutionalProposalActions.do"/>
    </div> 
</kul:tab>
