<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="awardAttributes" value="${DataDictionary.Award.attributes}" />

<h3>
	<span class="subhead-left">Miscellaneous Procurement/Purchasing</span>
	<span class="subhead-right">
		<kul:help businessObjectClassName="org.kuali.kra.award.home.Award" altText="help"/>
	</span>
</h3>
	<table border="0" cellpadding="0" cellspacing="0" summary="">
        <tr>
        	<th width="6%"><div align="center">
            	<kul:htmlAttributeLabel attributeEntry="${awardAttributes.subPlanFlag}" noColon="true" /></div></th>
            </div></th>          		
          	<td width="5%">
          	<div align="center">
          		<kul:htmlControlAttribute property="document.awardList[0].subPlanFlag" attributeEntry="${awardAttributes.subPlanFlag}" />
          	</div>
          	</td>
            <th width="6%"><div align="center">
            	<kul:htmlAttributeLabel attributeEntry="${awardAttributes.procurementPriorityCode}" noColon="true" /></div></th>
            </div></th>          		
          	<td width="5%">
          	<div align="center">
          		<kul:htmlControlAttribute property="document.awardList[0].procurementPriorityCode" attributeEntry="${awardAttributes.procurementPriorityCode}" />
          	</div>
          	</td>
        </tr>
    </table>      	
