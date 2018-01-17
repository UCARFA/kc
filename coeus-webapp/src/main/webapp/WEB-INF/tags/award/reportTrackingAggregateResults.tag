<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="reportTrackingAttributes" value="${DataDictionary.ReportTracking.attributes}" />

<div id="workarea" class="tab-container reportTrackingResults">			  
	${kfunc:registerEditableProperty(KualiForm, "groupByResultIndex")}
	<c:if test="${not empty KualiForm.groupedByResults}">
		<script>jq(document).ready(function() { toggleSearchTable(jq('.showHideSearch')); });showPrint();</script>
		<div class="resort"><html:image property="methodToCall.search" src="${ConfigProperties.kra.externalizable.images.url}buttonsmall-sorttable.gif" style="display:none;" styleClass="tinybutton resort"/></div>
		<table cellpadding="0" cellspacing="0" class="GroupBy">
			<thead><tr class="GroupBy">
				<th>&nbsp;</th>
				<c:forEach items="${KualiForm.groupedByDisplayFields}" var="col">
					<th class="draggableColumn GroupBy"><kul:htmlAttributeLabel attributeEntry="${reportTrackingAttributes[col]}" noColon="true" readOnly="true"/><div style="display:none;"><c:out value="${col}"/></div></th>
				</c:forEach>
				<th>Count</th>
				<c:if test="${KualiForm.currentView.viewName =='PI View'}">
				<th>Actions</th>
				</c:if>
			</tr></thead>
			<c:forEach items="${KualiForm.groupedByResults}" var="resultLine" varStatus="ctr">
				<tr class="aggregateResult GroupBy">
			    	<td><a class="showHideLink showLink">show and hide details</a><div style="display:none;" title="none"><c:out value="${ctr.index}"/></div></td>
					<c:forEach items="${KualiForm.groupedByDisplayFields}" var="col">
						<td>
							<bean:write name="KualiForm" property="groupedByResults[${ctr.index}].${col}"/>
						</td>
					</c:forEach>
					<td><c:out value="${resultLine['itemCount']}"/></td>
					<c:if test="${KualiForm.currentView.viewName =='PI View'}">
					<td> 
					
					<html:image
							styleId="printReportTracking.line${status.index}"
							property="methodToCall.printReportTracking.line${ctr.index}.anchor${currentTabIndex}"
							src='${ConfigProperties.kra.externalizable.images.url}tinybutton-print.gif'
							styleClass="tinybutton" 
							onclick="javascript: openNewWindow('reportTrackingLookup','printReportTracking','${ctr.index}',${KualiForm.formKey},'true'); return false"/>
					</td>
					</c:if>
				</tr>
				<tr class="detailRow" style="display: none;">
				<c:choose>
				 <c:when test="${KualiForm.currentView.viewName =='PI View'}">
			  		<td colspan="${fn:length(KualiForm.groupedByDisplayFields)+3}">
			    		<div></div>
			  		</td>
			  		</c:when><c:otherwise>
			  		<td colspan="${fn:length(KualiForm.groupedByDisplayFields)+2}">
			    		<div></div>
			  		</td>
			  		</c:otherwise></c:choose>
				</tr>
			</c:forEach>
		</table>
		<div class="resort"><html:image property="methodToCall.search" src="${ConfigProperties.kra.externalizable.images.url}buttonsmall-sorttable.gif" style="display:none;" styleClass="tinybutton resort"/></div>
	</c:if>
</div>
