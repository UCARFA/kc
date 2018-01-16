<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="readOnly" required="false" %>

<c:set var="ipReviewActivityAttributes" value="${DataDictionary.IntellectualPropertyReviewActivity.attributes}" />

<kul:tab tabTitle="Activities" defaultOpen="false" tabErrorKey="">

<div class="tab-container" align="center">

<h3>
    <span class="subhead-left">Activities</span>
    <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.institutionalproposal.ipreview.IntellectualPropertyReviewActivity" altText="help"/></span>
</h3>

<table summary="" align="center" cellpadding="0" cellspacing="0">
    <tbody>
        <tr>
            <th>&nbsp;</th>
            <th><kul:htmlAttributeLabel attributeEntry="${ipReviewActivityAttributes.ipReviewActivityTypeCode}" /></th>
            <th><kul:htmlAttributeLabel attributeEntry="${ipReviewActivityAttributes.activityDate}" /></th>
            <th><kul:htmlAttributeLabel attributeEntry="${ipReviewActivityAttributes.comments}" /></th>
        </tr>
        <c:forEach var="activity" items="${KualiForm.document.institutionalProposal.proposalIpReviewJoin.intellectualPropertyReview.ipReviewActivities}" varStatus="status"> 
        <tr>
            <th><c:out value="${activity.activityNumber}" /></td>
            <td><c:out value="${activity.ipReviewActivityType.description}" /></td>
            <td><c:out value="${activity.activityDate}" /></td>
            <td><c:out value="${activity.comments}" /></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

</div>
	
</kul:tab>
