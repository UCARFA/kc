<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="syncChangeAttrs" value="${DataDictionary.AwardSyncChange.attributes}" />
<c:set var="syncStatusAttrs" value="${DataDictionary.AwardSyncStatus.attributes}" />
<c:set var="syncLogAttrs" value="${DataDictionary.AwardSyncLog.attributes}" />

<c:set var="syncStatusAwardNumber" value="${KualiForm.awardSyncBean.statusAwardNumber}"/>
    <h3>Sync Details for ${syncStatusAwardNumber}</h3>
    <table cellpadding="0" cellspacing="0" style="width:100%" class="resultsTable">
        <c:set var="awardStatus" value="${KualiForm.awardSyncBean.awardStatuses[syncStatusAwardNumber]}"/>
	    <c:if test="${not empty awardStatus.changeLogs}">
	      <tr>
	        <th rowspan="${fn:length(awardStatus.changeLogs)+1}">Actions</th>
	        <th><kul:htmlAttributeLabel attributeEntry="${syncChangeAttrs.syncType}" noColon="true"/></th>
	        <th><kul:htmlAttributeLabel attributeEntry="${syncChangeAttrs.objectDesc}" noColon="true"/></th>
	        <th><kul:htmlAttributeLabel attributeEntry="${syncChangeAttrs.dataDesc}" noColon="true"/></th>
	        <th><kul:htmlAttributeLabel attributeEntry="${syncLogAttrs.status}" noColon="true"/></th>
	      </tr>
	      <c:forEach items="${awardStatus.changeLogs}" var="log">
	        <tr>
	          <td><c:out value="${log.change.type.syncDesc}"/></td>
	          <td><c:out value="${log.change.objectDesc}"/></td>
	          <td><c:out value="${log.change.dataDesc}"/></td>
	          <td><c:out value="${log.status}"/></td>
	        </tr>
	      </c:forEach>
	    </c:if>
	    <c:if test="${not empty awardStatus.validationLogs}">
			<tr>
			  <th rowspan="${fn:length(awardStatus.validationLogs)+1}">Validation Messages</th>
			  <th colspan="4"><kul:htmlAttributeLabel attributeEntry="${syncLogAttrs.status}" noColon="true"/></th></tr>
			<c:forEach items="${awardStatus.validationLogs}" var="log">
			  <tr><td colspan="4"><c:out value="${log.status}"/></td></tr>
			</c:forEach>   
	    </c:if>
	</table>
<kul:csrf />