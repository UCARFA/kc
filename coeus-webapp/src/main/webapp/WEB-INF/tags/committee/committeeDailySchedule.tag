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

<%-- Daily --%>
	<div id="calendar_daily_table" style="${styleClass['DAILY']}">
         <html:radio property="committeeHelper.scheduleData.dailySchedule.dayOption" value="XDAY"  styleClass="radio">
         	 Every&nbsp;
         	 <kul:htmlControlAttribute property="committeeHelper.scheduleData.dailySchedule.day" attributeEntry="${committeeScheduleAttributeReferenceDummy.intValue}" />                       
 	         &nbsp;day(s)</html:radio>
         <hr size="1" noshade>
                        
         <html:radio property="committeeHelper.scheduleData.dailySchedule.dayOption" value="WEEKDAY" styleClass="radio">
             Every weekday </html:radio>
         
         <hr size="1" noshade>
             Ending on      
         <kul:htmlControlAttribute property="committeeHelper.scheduleData.dailySchedule.scheduleEndDate" 
	                									attributeEntry="${kraAttributeReferenceDummyAttributes.genericDate}" />
		 </span>
	</div>
<%-- END Daily --%>
