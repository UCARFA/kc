<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="reportTrackingAttributes" value="${DataDictionary.ReportTracking.attributes}" />

<div style="display:none;"><div id="customSelection">
	<html:image property="methodToCall.updateView"
		src="${ConfigProperties.kra.externalizable.images.url}tinybutton-updateview.gif" styleClass="tinybutton"
		onclick="jq.fancybox.close(); return false;"/><br/>			
	<jsp:useBean id="paramMap" class="java.util.HashMap"/>  
	<c:forEach items="${krafn:getOptionList('org.kuali.kra.award.paymentreports.ReportTrackingViewValuesFinder', paramMap)}" var="option">
		<html:radio property="currentViewIndex" value="${option.key}" onchange="toggleCustomView(this);">${option.value}</html:radio>
	</c:forEach>
	<table id="customViewColumnSelection">
		<tr>
			<th>Columns</th>
			<th>Group</th>
			<th>Detail</th>
		</tr>
		<c:forEach items="${KualiForm.reportTrackingViews.allFields}" var="col" varStatus="ctr">
			<tr>
  				<th><kul:htmlAttributeLabel attributeEntry="${reportTrackingAttributes[col]}" noColon="true" readOnly="true"/></th>
				<td><c:set var="propertyName" value="customGroupByFields"/><html:multibox property="${propertyName}"><c:out value="${col}"/></html:multibox>${kfunc:registerEditableProperty(KualiForm, propertyName)}</td>
				<td><c:set var="propertyName" value="customDetailFields"/><html:multibox property="${propertyName}" value="${col}"/>${kfunc:registerEditableProperty(KualiForm, propertyName)}</td>
			</tr>
		</c:forEach>
		<tr>
  			<td colspan="3">
				<html:image property="methodToCall.resetCustomView"
					src="${ConfigProperties.kra.externalizable.images.url}tinybutton-resetcustomview.gif" styleClass="tinybutton"
					onclick="jq('#onChangeViewClose').attr('name', 'methodToCall.resetCustomView'); jq.fancybox.close(); return false;"/>
	  		</td>
		</tr>
	</table>
	<html:image property="methodToCall.updateView"
		src="${ConfigProperties.kra.externalizable.images.url}tinybutton-updateview.gif" styleClass="tinybutton"
		onclick="jq.fancybox.close(); return false;"/> 
</div></div>
