<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="expendituresInDateRangeAttributes" value="${DataDictionary.SubcontractingExpenditureCategoryAmountsInDateRange.attributes}" />
<div class="tab-container" align="center">
  	<h3>
  		<span class="subhead-left">Within A Date Range</span>
  		<span class="subhead-right">
			<kul:help businessObjectClassName="org.kuali.kra.award.subcontracting.reporting.SubcontractingExpenditureCategoryAmountsByDateRange" altText="help" />
		</span>
	</h3>
	<table cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td class="infoline">
				<div align="left">
					From award expenditure details between:
						<kul:htmlAttributeLabel attributeEntry="${expendituresInDateRangeAttributes.rangeStartDate}" />
           		    	<kul:htmlControlAttribute property="rangeStartDate" attributeEntry="${expendituresInDateRangeAttributes.rangeStartDate}" />
              		    	-
           		    	<kul:htmlAttributeLabel attributeEntry="${expendituresInDateRangeAttributes.rangeEndDate}" />
           		    	<kul:htmlControlAttribute property="rangeEndDate" attributeEntry="${expendituresInDateRangeAttributes.rangeEndDate}" />           
	 					<html:image property="methodToCall.regenerateExpenditureDataInDateRange" src='${ConfigProperties.kra.externalizable.images.url}tinybutton-regenerate.gif' styleClass="tinybutton" /> 
				</div>
			</td>
		</tr>
	</table>
</div>
