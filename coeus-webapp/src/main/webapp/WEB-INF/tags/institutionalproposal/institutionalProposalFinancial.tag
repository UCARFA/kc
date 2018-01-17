<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="institutionalProposalAttributes" value="${DataDictionary.InstitutionalProposal.attributes}" />


<kul:tab tabTitle="Financial" defaultOpen="false" tabErrorKey="document.institutionalProposalList[0].requestedStartDateInitial,document.institutionalProposalList[0].requestedStartDateTotal,document.institutionalProposalList[0].requestedStartDateInitial,document.institutionalProposalList[0].totalDirectCostInitial,document.institutionalProposalList[0].requestedEndDateInitial,document.institutionalProposalList[0].totalDirectCostTotal,document.institutionalProposalList[0].totalIndirectCostInitial,document.institutionalProposalList[0].totalIndirectCostTotal,document.institutionalProposal.currentAccountNumber">
	<!-- Institution -->

<div class="tab-container" align="center">

<h3>
	<span class="subhead-left">Account Info</span>
    <span class="subhead-right"><kul:help parameterNamespace="KC-IP" parameterDetailType="Document" parameterName="accountInfoHelpUrl" altText="help"/></span>
</h3>
<table cellpAdding="0" cellspacing="0" summary="">
  	<tr>
    	<th width="400">
    		<div align="right"><kul:htmlAttributeLabel attributeEntry="${institutionalProposalAttributes.currentAccountNumber}" /></div>
    	</th>
    	<td>
    		<kul:htmlControlAttribute property="document.institutionalProposal.currentAccountNumber" attributeEntry="${institutionalProposalAttributes.currentAccountNumber}" />
    	</td>
  	</tr>
  </table>
 </div>
 
<div class="tab-container" align="center">

<h3>
	<span class="subhead-left">Project Periods and Amounts</span>
    <span class="subhead-right"><kul:help parameterNamespace="KC-IP" parameterDetailType="Document" parameterName="projectPeriodsAndAmountsHelpUrl" altText="help"/></span>
</h3>
<table cellpAdding="0" cellspacing="0" summary="">
	<tr>
		<th width="350" scope="row">&nbsp;</th>
		<th width="300" align="center"><div align="center">Initial Period</div></th>
		<th width="300" align="center"><div align="center">Total Period</div></th>
		<th rowspan="6">
			&nbsp;
		</th>
	</tr>
  	<tr>
    	<th>
    		<div align="right"><kul:htmlAttributeLabel attributeEntry="${institutionalProposalAttributes.requestedStartDateInitial}" /></div>
    	</th>
    	<td>
    		<div align="right">
				<kul:htmlControlAttribute property="document.institutionalProposalList[0].requestedStartDateInitial" attributeEntry="${institutionalProposalAttributes.requestedStartDateInitial}" />
			</div>
		</td>
    	<td>
    		<div align="right">
				<kul:htmlControlAttribute property="document.institutionalProposalList[0].requestedStartDateTotal" attributeEntry="${institutionalProposalAttributes.requestedStartDateTotal}"/>
			</div>
		</td>
  	</tr>
  	<tr>
    	<th>
    		<div align="right"><kul:htmlAttributeLabel attributeEntry="${institutionalProposalAttributes.requestedEndDateInitial}" /></div>
    	</th>
    	<td>
    		<div align="right">
				<kul:htmlControlAttribute property="document.institutionalProposalList[0].requestedEndDateInitial" attributeEntry="${institutionalProposalAttributes.requestedEndDateInitial}" />
			</div>
		</td>
    	<td>
    		<div align="right">
				<kul:htmlControlAttribute property="document.institutionalProposalList[0].requestedEndDateTotal" attributeEntry="${institutionalProposalAttributes.requestedEndDateTotal}"/>
			</div>
		</td>
  	</tr>
  	<tr>
    	<th>
    		<div align="right"><kul:htmlAttributeLabel attributeEntry="${institutionalProposalAttributes.totalDirectCostInitial}" /></div>
    	</th>
    	<td>
    		<div align="right">
    			<kul:htmlControlAttribute property="document.institutionalProposalList[0].totalDirectCostInitial" attributeEntry="${institutionalProposalAttributes.totalDirectCostInitial}" styleClass="amount"/>
			</div>
		</td>
    	<td>
    		<div align="right">
    			<kul:htmlControlAttribute property="document.institutionalProposalList[0].totalDirectCostTotal" attributeEntry="${institutionalProposalAttributes.totalDirectCostTotal}" styleClass="amount"/>
			</div>
		</td>
  	</tr>
  	<tr>
    	<th>
    		<div align="right"><kul:htmlAttributeLabel attributeEntry="${institutionalProposalAttributes.totalIndirectCostInitial}" /></div>
    	</th>
    	<td>
    		<div align="right">
    			<kul:htmlControlAttribute property="document.institutionalProposalList[0].totalIndirectCostInitial" attributeEntry="${institutionalProposalAttributes.totalIndirectCostInitial}" styleClass="amount"/>
    		</div>	
		</td>
    	<td>
    		<div align="right">
    			<kul:htmlControlAttribute property="document.institutionalProposalList[0].totalIndirectCostTotal" attributeEntry="${institutionalProposalAttributes.totalIndirectCostTotal}" styleClass="amount"/>
    		</div>	
		</td>
  	</tr>
  	<tr>
    	<th>
    		<div align="right">Total All Cost:</div></th>
    	</th>
    	<th>
    		<div align="right">
    			$<fmt:formatNumber value="${KualiForm.institutionalProposalDocument.institutionalProposal.totalInitialCost}" type="currency" currencySymbol="" maxFractionDigits="2" />
    		</div>
		</th>
    	<th>
    		<div align="right">
    			$<fmt:formatNumber value="${KualiForm.institutionalProposalDocument.institutionalProposal.totalCost}" type="currency" currencySymbol="" maxFractionDigits="2" />
    		</div>
		</th>
  	</tr>  
</table>
</div>
<div class="tab-container" align="center">
		<html:image property="methodToCall.recalculateTotals.anchor${tabKey}"
		src='${ConfigProperties.kra.externalizable.images.url}tinybutton-recalculate.gif' styleClass="tinybutton"/>
   </div>     
</kul:tab>

