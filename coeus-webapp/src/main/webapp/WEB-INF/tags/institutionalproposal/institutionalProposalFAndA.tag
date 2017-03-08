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

<c:set var="institutionalProposalAttributes" value="${DataDictionary.InstitutionalProposal.attributes}" />
<c:set var="institutionalProposalFandAAttributes" value="${DataDictionary.InstitutionalProposalFandA.attributes}" />
<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />
<c:set var="tabItemCount" value="0" />

<c:forEach var="institutionalProposalFandA" items="${KualiForm.document.institutionalProposal.institutionalProposalFandAs}" varStatus="status">
        <c:set var="tabItemCount" value="${tabItemCount+1}" />
</c:forEach>

<kul:tab tabItemCount="${tabItemCount}" tabTitle="Rates" defaultOpen="false" tabErrorKey="newInstitutionalProposalFandA.*">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left">Rates Distribution List</span>
   			<span class="subhead-right">
   				<kul:help parameterNamespace="KC-IP" parameterDetailType="Document" parameterName="ipDistUnrecoveredFandAHelp" altText="help"/>
			</span>
        </h3>
        <table id="rates-table" cellpadding="0" cellspacing="0" summary="Rates">
			<tr>
				<th scope="row">&nbsp;</th>
				<th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.rateTypeCode}" useShortLabel="true" noColon="true" /></th>
				<th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.startDate}" useShortLabel="true" noColon="true" /></th>
				<th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.instituteRate}" useShortLabel="true" noColon="true"/></th>
				<th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.applicableRate}" useShortLabel="true" noColon="true"/></th>
				<th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.activityTypeCode}" useShortLabel="true" noColon="true"/></th>
				<th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.onOffCampusFlag}" useShortLabel="true" noColon="true"/></th>
                <th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.fiscalYear}" useShortLabel="true" noColon="true"/></th>
                <th><kul:htmlAttributeLabel attributeEntry="${institutionalProposalFandAAttributes.amount}" useShortLabel="true" noColon="true"/></th>

                <c:if test="${!readOnly}"><th><div align="center">Actions</div></th></c:if>
			</tr>
			<tr>
            	<th width="50" align="center" scope="row"><div align="center">Add:</div></th>
            	<td class="infoline">
            	  	<div align="center">
            	  	 	<kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.rateTypeCode" attributeEntry="${institutionalProposalFandAAttributes.rateTypeCode}"/>
            	 	</div>
            	</td>
	            <td class="infoline">
	              	<div width="75" align="center">
	            		<kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.startDate" attributeEntry="${institutionalProposalFandAAttributes.startDate}" />
	              	</div>
	            </td>
	            <td class="infoline">
	            	<div align="center">
            	    	<kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.instituteRate" attributeEntry="${institutionalProposalFandAAttributes.instituteRate}"/>
            	  	</div>
	            </td>
	            <td class="infoline">
	            	<div align="center">
            	    	<kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.applicableRate" attributeEntry="${institutionalProposalFandAAttributes.applicableRate}"/>
            	  	</div>
	            </td>
	            <td class="infoline">
	            	<div align="center">
            	   	 	<kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.activityTypeCode" attributeEntry="${institutionalProposalFandAAttributes.activityTypeCode}"/>
            	  	</div>
	            </td>
	            <td class="infoline">
	            	<div align="center">
            	   	 	<kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.onOffCampusFlag" attributeEntry="${institutionalProposalFandAAttributes.onOffCampusFlag}"/>
            	  	</div>
	            </td>
                <td class="infoline">
                    <div align="center">
                        <kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.fiscalYear" attributeEntry="${institutionalProposalFandAAttributes.fiscalYear}"/>
                    </div>
                </td>
                <td class="infoline">
                    <div align="center">
                        <kul:htmlControlAttribute property="institutionalProposalFandABean.newInstitutionalProposalFandA.amount" attributeEntry="${institutionalProposalFandAAttributes.amount}"/>
                    </div>
                </td>
	            <c:if test="${!readOnly}">
	            <td class="infoline">
	            	<div align=center>
						<html:image property="methodToCall.addFandA.anchor${tabKey}"
						src='${ConfigProperties.kra.externalizable.images.url}tinybutton-add1.gif' styleClass="tinybutton"/>
					</div>
	            </td>
	            </c:if>
          	</tr>
         <c:forEach var="institutionalProposalFandAs" items="${KualiForm.document.institutionalProposal.institutionalProposalFandAs}" varStatus="status">
	             <tr>
					<th width="5%" class="infoline">
						<c:out value="${status.index+1}" />
					</th>
	                <td width="10%" valign="middle">
					<div align="center">
                		<kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].rateTypeCode" attributeEntry="${institutionalProposalFandAAttributes.rateTypeCode}"/>
					</div>
					</td>
	                <td width="20%" valign="middle">
					<div align="center">
                		<kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].startDate" attributeEntry="${institutionalProposalFandAAttributes.startDate}"/>
					</div>
	                </td>
	                <td width="15%" valign="middle">                	
					<div align="center">
                  		<kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].instituteRate" attributeEntry="${institutionalProposalFandAAttributes.instituteRate}"/>
					</div>
					</td>
	                <td width="15%" valign="middle">                	
					<div align="center">
                  		<kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].applicableRate" attributeEntry="${institutionalProposalFandAAttributes.applicableRate}"/>
					</div>
					</td>
	                <td width="15%" valign="middle">
					<div align="center">
	                	<kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].activityTypeCode" attributeEntry="${institutionalProposalFandAAttributes.activityTypeCode}"/>
					</div>
	                </td>
	                <td width="15%" valign="middle">
					<div align="center">
	                	<kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].onOffCampusFlag" attributeEntry="${institutionalProposalFandAAttributes.onOffCampusFlag}"/>
					</div>
	                </td>
                     <td width="15%" valign="middle">
                         <div align="center">
                             <kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].fiscalYear" attributeEntry="${institutionalProposalFandAAttributes.fiscalYear}"/>
                         </div>
                     </td>
                     <td width="15%" valign="middle">
                         <div align="center">
                             <kul:htmlControlAttribute property="document.institutionalProposal.institutionalProposalFandAs[${status.index}].amount" attributeEntry="${institutionalProposalFandAAttributes.amount}"/>
                         </div>
                     </td>
	                <c:if test="${!readOnly}">
					<td width="10%">
					<div align="center">&nbsp;
						<html:image property="methodToCall.deleteFandA.line${status.index}.anchor${currentTabIndex}"
						src='${ConfigProperties.kra.externalizable.images.url}tinybutton-delete1.gif' styleClass="tinybutton"/>
					</div>
	                </td>
	                </c:if>
	            </tr>
        	</c:forEach>
          	<tr>
          		<th colspan="6" align="right" scope="row">Total:</th>
	         	<th align="right">
          			<div align="center">
	                	 $<fmt:formatNumber value="${KualiForm.document.institutionalProposal.totalFandAAmount}" type="currency" currencySymbol="" maxFractionDigits="2" />
	                </div>
	         	</th>
	         	<c:if test="${!readOnly}"><th scope="row">&nbsp;</th></c:if>
          	</tr>
          	
        </table>
   </div>
</kul:tab>
