<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
    <c:set var="committeeScheduleAttendanceAttributes" value="${DataDictionary.CommitteeScheduleAttendance.attributes}" />
    <table id="memberAbsent-table" cellpadding=0 cellspacing=0 class="datatable" summary="View/edit member absent">
        <tr>
            <td colspan="4" class="tab-subhead1">Members Absent or Available: ${fn:length(KualiForm.meetingHelper.memberAbsentBeans)}</td>
        </tr>
    
    	<%-- Header --%>
    	<tr>
    		<kul:htmlAttributeHeaderCell literalLabel="&nbsp;" scope="col" />
    		<kul:htmlAttributeHeaderCell attributeEntry="${committeeScheduleAttendanceAttributes.personName}" scope="col" />
				<c:if test="${!readOnly}">
					<kul:htmlAttributeHeaderCell literalLabel="Actions" scope="col" />
				</c:if>
			</tr>
			<%-- Header --%>
			
			<%-- Existing data --%>
    	<c:forEach var="memberAbsentBean" items="${KualiForm.meetingHelper.memberAbsentBeans}" varStatus="status">
	        <tr>
			    <th class="infoline">
					<c:out value="${status.index+1}" />
				</th>
	            <td align="left" valign="middle">
	                <div align="left"> ${memberAbsentBean.attendance.personName} </div>
				</td>
                <c:if test="${!readOnly}">
					<td>
						<div align=center>&nbsp;					
							<html:image property="methodToCall.presentVoting.line${status.index}.anchor${currentTabIndex}"
										src='${ConfigProperties.kra.externalizable.images.url}tinybutton-presentvoting.gif' styleClass="tinybutton"/>
							<html:image property="methodToCall.presentOther.line${status.index}.anchor${currentTabIndex}"
										src='${ConfigProperties.kra.externalizable.images.url}tinybutton-presentother.gif' styleClass="tinybutton"/>
						</div>
		             </td>
		        </c:if>
	        </tr>
        </c:forEach>        	
			<%-- Existing data --%>
			        				
    </table>
        
