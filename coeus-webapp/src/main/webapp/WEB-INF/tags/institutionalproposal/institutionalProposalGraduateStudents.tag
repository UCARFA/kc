<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="institutionalProposalAttributes" value="${DataDictionary.InstitutionalProposal.attributes}" />


<kul:tab tabTitle="Graduate Students" defaultOpen="false" tabErrorKey="document.institutionalProposalList[0].gradStud*" auditCluster="graduateStudentAuditErrors" tabAuditKey="document.graduateStudentAuditRules*" useRiceAuditMode="true">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left">Graduate Students</span>
      		<span class="subhead-right"><kul:help parameterNamespace="KC-IP" parameterDetailType="Document" parameterName="graduateStudentsHelpUrl" altText="help"/></span>
        </h3>
        <table id="Graduate-Students" cellpadding="0" cellspacing="0" summary="Graduate Students">
        	<tr>
        		<th width="300" align="right">
        		<div align="right"><kul:htmlAttributeLabel attributeEntry="${institutionalProposalAttributes.gradStudHeadcount}" /></div>
            	</th>
            	<td>
            	  	<div align="left">
            	  	 	<kul:htmlControlAttribute property="document.institutionalProposal.gradStudHeadcount" attributeEntry="${institutionalProposalAttributes.gradStudHeadcount}"/>
            	 	</div>
            	</td>
            	<th width="300" align="right" scope="row">
				     <div align="right"><kul:htmlAttributeLabel attributeEntry="${institutionalProposalAttributes.gradStudPersonMonths}" /></div>
				</th>
            	<td>
            	  	<div align="left">
            	  	 	<kul:htmlControlAttribute property="document.institutionalProposal.gradStudPersonMonths" attributeEntry="${institutionalProposalAttributes.gradStudPersonMonths}"/>
            	 	</div>
            	</td>
            </tr>
       	</table>
  	</div>
</kul:tab>
