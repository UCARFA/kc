<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="awardAttributes" value="${DataDictionary.Award.attributes}" />
<c:set var="awardPreAwardAuthorizationCommentAttributes" value="${DataDictionary.AwardComment.attributes}" />
<c:set var="action" value="awardTimeAndMoney" />

<kul:tab tabTitle="Preaward Authorizations" defaultOpen="false" tabErrorKey="document.awardList[0].preAwardAuthorizedAmount,document.awardList[0].preAwardEffectiveDate,document.awardList[0].awardPreAwardSponsorAuthorizationComment.comments">
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left">Sponsor Authorization</span>
    		<span class="subhead-right">
    			<kul:help parameterNamespace="KC-AWARD" parameterDetailType="Document" parameterName="awardSponsorAuthHelp" altText="help"/>
			</span>
        </h3>
        <table id="Pre-Award-Authorizations" cellpadding="0" cellspacing="0" summary="Pre Award Authorizations">
        	<tr>
            	<th width="250" align="right" scope="row"><div align="right">Authorized Amount:</div></th>
            	<td>
            	  	<div align="left">
            	  	 	$<kul:htmlControlAttribute property="document.awardList[0].preAwardAuthorizedAmount" attributeEntry="${awardAttributes.preAwardAuthorizedAmount}" styleClass="amount"/>
            	 	</div>
            	</td>
            </tr>
            <tr>
            	<th width="250" align="right" scope="row"><div align="right">Effective Date:</div></th>
            	<td>
            	  	<div align="left">
            	  	 	<kul:htmlControlAttribute property="document.awardList[0].preAwardEffectiveDate" attributeEntry="${awardAttributes.preAwardEffectiveDate}" />
            	 	</div>
            	</td>
             </tr>
             <tr>
             	<th width="250" align="right" scope="row"><div align="right">Comments:</div></th>
        	 	<td class="infoline">
            	 	<div align="left">
            	  	 	<kul:htmlControlAttribute property="document.awardList[0].awardPreAwardSponsorAuthorizationComment.comments" attributeEntry="${awardPreAwardAuthorizationCommentAttributes.comments}"/>
            	 	</div>
             	</td>
             </tr>
         </table>
    </div>
    
    <div class="tab-container" align="center">
        <div class="left-errmsg-tab">
            <kul:errors keyMatch="document.awardList[0].preAwardInstitutionalAuthorizedAmount,document.awardList[0].preAwardInstitutionalEffectiveDate,document.awardList[0].awardPreAwardInstitutionalAuthorizationComment.comments"/>
            <br/>
        </div>
    	<h3>
    		<span class="subhead-left">Institutional Authorization</span>
    		<span class="subhead-right">
    			<kul:help parameterNamespace="KC-AWARD" parameterDetailType="Document" parameterName="awardInstitutionalAuthHelp" altText="help"/>
			</span>
        </h3>
        <table id="Pre-Award-Authorizations" cellpadding="0" cellspacing="0" summary="Pre Award Authorizations">
        	<tr>
            	<th width="250" align="right" scope="row"><div align="right">Authorized Amount:</div></th>
            	<td>
            	  	<div align="left">
            	  	 	$<kul:htmlControlAttribute property="document.awardList[0].preAwardInstitutionalAuthorizedAmount" attributeEntry="${awardAttributes.preAwardInstitutionalAuthorizedAmount}" styleClass="amount"/>
            	 	</div>
            	</td>
            </tr>
            <tr>
            	<th width="250" align="right" scope="row"><div align="right">Effective Date:</div></th>
            	<td>
            	  	<div align="left">
            	  	 	<kul:htmlControlAttribute property="document.awardList[0].preAwardInstitutionalEffectiveDate" attributeEntry="${awardAttributes.preAwardInstitutionalEffectiveDate}" />
            	 	</div>
            	</td>
             </tr>
             <tr>
             	<th width="250" align="right" scope="row"><div align="right">Comments:</div></th>
        	 	<td class="infoline">
            	 	<div align="left">
            	  	 	<kul:htmlControlAttribute property="document.awardList[0].awardPreAwardInstitutionalAuthorizationComment.comments" attributeEntry="${awardPreAwardAuthorizationCommentAttributes.comments}"/>
            	 	</div>
             	</td>
             </tr>
         </table>
    </div>
</kul:tab>
