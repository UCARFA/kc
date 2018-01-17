<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kul:tab tabTitle="Notifications" tabItemCount="" defaultOpen="false" tabErrorKey="">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left"> Disclosure Notifications </span>
        </h3>
        <table id="coiDisclosure-notifications-table" cellpadding="0" cellspacing="0" summary="Coi Disclosure Notifications">
			<tr>
				<th scope="row">Type</th>
				<th align="left">Recipient(s)</th>
				<th align="left">Subject</th>
				<th align="left">Date Sent</th>
			</tr>
			<c:forEach var="disclosureNotification" items="${KualiForm.document.coiDisclosure.filteredNotificationsByDocId}" varStatus="status">
    			<tr>
    				<td>
	                    <a class="viewNotification" id="viewNotification${status.index}" title="${disclosureNotification.notificationType.description}" href="${pageContext.request.contextPath}/coiDisclosure.do?methodToCall=viewDisclosureNotification&notificationId=${disclosureNotification.notificationId}" scrolling="no" noresize>
    				        <c:out value="${disclosureNotification.notificationType.description}" />
						</a>
    				</td>
    				<td>
    				    <c:out value="${disclosureNotification.recipients}" />
    				</td>
    				<td>
    				    <c:out value="${disclosureNotification.subject}" />
    				</td>
    				<td>
    				    <c:out value="${disclosureNotification.updateTimestampString}" />
    				</td>
				</tr>
			</c:forEach>
        </table>
	</div>
</kul:tab>
