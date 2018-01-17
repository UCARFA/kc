<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:page lookup="false" 
          docTitle="Subcontracting Expenditures Data Generation" 
          transactionalDocument="false"
          renderMultipart="false" 
          htmlFormAction="subcontractingExpendituresDataGeneration">

	<div id="workarea">

		<kul:tab tabTitle="Subcontracting Category Expenditure Data Generator Admin"
		         defaultOpen="true"
		         alwaysOpen="false"
		         transparentBackground="true" 
		         useCurrentTabIndexAsKey="true"
		         tabErrorKey="rangeStartDate*, rangeEndDate*">
		         
		        <kra-a:subcontractingExpendituresForAllDates />	        
				<kra-a:subcontractingExpendituresWithinDateRange />
						
		</kul:tab>
		
	    <kul:panelFooter />

	</div>	

</kul:page>
	
