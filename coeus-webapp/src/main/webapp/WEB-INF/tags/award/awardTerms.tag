<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="syncPropertyName" value="awardSponsorTerms" />
<c:set var="action" value="awardTemplateSync" />

<kul:tab tabTitle="Terms" defaultOpen="false" tabErrorKey="document.awardList[0].awardSponsorTerms*,document.award.awardTemplate.TERMS_TAB" auditCluster="termsAuditErrors" tabAuditKey="document.termsAuditRules*" useRiceAuditMode="true">
	<div class="tab-container" align="center">
	    <h3>
            <span class="subhead-left">Terms</span>
            <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm" altText="help"/></span>
        </h3>  
        <c:forEach var="sponsorTermType" items="${KualiForm.sponsorTermFormHelper.sponsorTermTypes}" varStatus="sponsorTermTypeIndex">        	        	
			<kra-a:awardTermsTypes index="${sponsorTermTypeIndex.index}" sponsorTermTypeKey="${sponsorTermType.key}" sponsorTermTypeLabel="${sponsorTermType.value}" />
		</c:forEach>
		
		<br/>
		
		<c:if test="${!readOnly}">
		<kra-a:awardSyncButton scopeNames="TERMS_TAB" tabKey="${tabKey}"/>
		</c:if>
	</div>
</kul:tab>

