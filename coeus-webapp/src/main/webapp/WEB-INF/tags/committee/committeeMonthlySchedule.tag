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

	<div id="calendar_monthly_table" style="${styleClass['MONTHLY']}">
                     
    	<html:radio property="committeeHelper.scheduleData.monthlySchedule.monthOption" value="XDAYANDXMONTH" styleClass="radio"></html:radio>
                     
        	&nbsp;Day&nbsp;		
        	<kul:htmlControlAttribute property="committeeHelper.scheduleData.monthlySchedule.day" attributeEntry="${committeeScheduleAttributeReferenceDummy.intValue}" />				                           
                     
            &nbsp;of every&nbsp;
            <kul:htmlControlAttribute property="committeeHelper.scheduleData.monthlySchedule.option1Month" attributeEntry="${committeeScheduleAttributeReferenceDummy.intValue}" />                      
            &nbsp;month(s)
            <hr size="1" noshade>
                  
   		<html:radio property="committeeHelper.scheduleData.monthlySchedule.monthOption" value="XDAYOFWEEKANDXMONTH" styleClass="radio"></html:radio>
                    
        	&nbsp;The&nbsp;
			<kul:htmlControlAttribute property="committeeHelper.scheduleData.monthlySchedule.selectedMonthsWeek" attributeEntry="${committeeScheduleAttributeReferenceDummy.monthsWeek}" />
			
			<kul:htmlControlAttribute property="committeeHelper.scheduleData.monthlySchedule.selectedDayOfWeek"  attributeEntry="${committeeScheduleAttributeReferenceDummy.weekDay}" />

			&nbsp;of every&nbsp;
            <kul:htmlControlAttribute property="committeeHelper.scheduleData.monthlySchedule.option2Month" attributeEntry="${committeeScheduleAttributeReferenceDummy.intValue}" />
            &nbsp;month(s)
            <hr size="1" noshade>
            Ending on
            <kul:htmlControlAttribute property="committeeHelper.scheduleData.monthlySchedule.scheduleEndDate" 
	                									attributeEntry="${kraAttributeReferenceDummyAttributes.genericDate}" /> 
            </span>
	</div>
