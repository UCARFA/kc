<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="styleClass" value="${KualiForm.committeeHelper.scheduleData.styleClasses}" />
<c:set var="kraAttributeReferenceDummyAttributes" value="${DataDictionary.KraAttributeReferenceDummy.attributes}" />
<c:set var="committeeScheduleAttributeReferenceDummy" value="${DataDictionary.CommitteeScheduleAttributeReferenceDummy.attributes}" />

<div id="calendar_yearly_table" style="${styleClass['YEARLY']}">

	<html:radio property="committeeHelper.scheduleData.yearlySchedule.yearOption" value="XDAY" styleClass="radio"></html:radio>
	&nbsp;Every&nbsp;
	
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.selectedOption1Month"  attributeEntry="${committeeScheduleAttributeReferenceDummy.month}" />
	
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.day" attributeEntry="${committeeScheduleAttributeReferenceDummy.intValue}" />
	&nbsp;of every&nbsp;
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.option1Year" attributeEntry="${committeeScheduleAttributeReferenceDummy.intValue}" />
	&nbsp;year(s)
	<hr size="1" noshade>
	
	<html:radio property="committeeHelper.scheduleData.yearlySchedule.yearOption" value="CMPLX" styleClass="radio"></html:radio>
	&nbsp;The&nbsp;
	
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.selectedMonthsWeek" attributeEntry="${committeeScheduleAttributeReferenceDummy.monthsWeek}" />
	
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.selectedDayOfWeek"  attributeEntry="${committeeScheduleAttributeReferenceDummy.weekDay}" />
	
	&nbsp;of&nbsp;
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.selectedOption2Month"  attributeEntry="${committeeScheduleAttributeReferenceDummy.month}" />
	
	&nbsp;of every&nbsp;
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.option2Year" attributeEntry="${committeeScheduleAttributeReferenceDummy.intValue}" />
	&nbsp;year(s)
	
	<hr size="1" noshade>
	Ending on
	<kul:htmlControlAttribute property="committeeHelper.scheduleData.yearlySchedule.scheduleEndDate" 
	                									attributeEntry="${kraAttributeReferenceDummyAttributes.genericDate}" />  
	</span>
</div>
