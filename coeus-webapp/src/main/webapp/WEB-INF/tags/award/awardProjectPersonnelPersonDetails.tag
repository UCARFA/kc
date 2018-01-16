<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%-- Member of awardProjectPersonnel.tag --%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="awardContact" required="true" type="org.kuali.kra.award.contacts.AwardPerson" %>
<%@ attribute name="awardContactRowStatusIndex" required="true" %>
<c:set var="keypersonrole" value="<%=org.kuali.kra.infrastructure.Constants.KEY_PERSON_ROLE%>" />
<c:set var="coirole" value="<%=org.kuali.kra.infrastructure.Constants.CO_INVESTIGATOR_ROLE%>" />

<c:set var="awardPersonAttributes" value="${DataDictionary.AwardPerson.attributes}" />

<kul:innerTab tabTitle="Person Details" parentTab="${awardContact.fullName}" defaultOpen="false" 
                          useCurrentTabIndexAsKey="true" 
                          tabErrorKey="document.awardList[0].projectPersons[${awardContactRowStatusIndex}].k*,document.awardList[0].projectPersons[${awardContactRowStatusIndex}].t*,document.awardList[0].projectPersons[${awardContactRowStatusIndex}].a*,document.awardList[0].projectPersons[${awardContactRowStatusIndex}].s*,document.awardList[0].projectPersons[${awardContactRowStatusIndex}].ca*">
	<table cellpadding="0" cellspacing="0" summary="Project Personnel Details">

        <c:choose>
            <c:when test="${KualiForm.creditSplitOptInEnabled == true}">
                <tr>
                    <th class="infoline">
                        <div align="right">
                            <kul:htmlAttributeLabel attributeEntry="${awardPersonAttributes.includeInCreditAllocation}" useShortLabel="true" noColon="false" />
                        </div>
                    </th>
                    <td>
                        <kul:htmlControlAttribute property="document.awardList[0].projectPersons[${awardContactRowStatusIndex}].includeInCreditAllocation"
                                          attributeEntry="${awardPersonAttributes.includeInCreditAllocation}" />
                    </td>
                    <th class="infoline">&nbsp;</th>
                    <td>&nbsp;</td>
                </tr>
            </c:when>
        </c:choose>
		<tr>
			<th class="infoline">
				<div align="right">
					<kul:htmlAttributeLabel attributeEntry="${awardPersonAttributes.faculty}" useShortLabel="true" noColon="false" />
				</div>
			</th>
			<td>
				<kul:htmlControlAttribute property="document.awardList[0].projectPersons[${awardContactRowStatusIndex}].faculty" 
											attributeEntry="${awardPersonAttributes.faculty}" />
			</td>
			<th class="infoline">
				<div align="right">
					<kul:htmlAttributeLabel attributeEntry="${awardPersonAttributes.academicYearEffort}" useShortLabel="true" noColon="false" />
				</div>
			</th>
			<td>
				<kul:htmlControlAttribute property="document.awardList[0].projectPersons[${awardContactRowStatusIndex}].academicYearEffort" 
											attributeEntry="${awardPersonAttributes.academicYearEffort}" styleClass="amount"/>
			</td>
		</tr>
		<tr>
			<th class="infoline">
				<div align="right">
					<kul:htmlAttributeLabel attributeEntry="${awardPersonAttributes.totalEffort}" useShortLabel="true" noColon="false" />
				</div>
			</th>
			<td>
				<kul:htmlControlAttribute property="document.awardList[0].projectPersons[${awardContactRowStatusIndex}].totalEffort" 
											attributeEntry="${awardPersonAttributes.totalEffort}" styleClass="amount"/>
			</td>
			<th class="infoline">
				<div align="right">
					<kul:htmlAttributeLabel attributeEntry="${awardPersonAttributes.summerEffort}" useShortLabel="true" noColon="false" />
				</div>
			</th>
			<td>
				<kul:htmlControlAttribute property="document.awardList[0].projectPersons[${awardContactRowStatusIndex}].summerEffort" 
											attributeEntry="${awardPersonAttributes.summerEffort}" styleClass="amount"/>
			</td>
		</tr>
		<tr>

            <th class="infoline">&nbsp;</th>
            <td>&nbsp;</td>

			<th class="infoline">
				<div align="right">
					<kul:htmlAttributeLabel attributeEntry="${awardPersonAttributes.calendarYearEffort}" useShortLabel="true" noColon="false" />
				</div>
			</th>
			<td>
				<kul:htmlControlAttribute property="document.awardList[0].projectPersons[${awardContactRowStatusIndex}].calendarYearEffort" 
											attributeEntry="${awardPersonAttributes.calendarYearEffort}" styleClass="amount"/>
			</td>
		</tr>	            				
	</table>
</kul:innerTab>
