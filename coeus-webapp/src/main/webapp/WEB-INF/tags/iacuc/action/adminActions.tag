<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<kra:permission value="${KualiForm.actionHelper.canAdministrativelyWithdraw or 
						 KualiForm.actionHelper.canAdministrativelyApprove or
						 KualiForm.actionHelper.canReviewNotRequired or 
						 KualiForm.actionHelper.canAdministrativelyMarkIncomplete}">

	<kul:innerTab tabTitle="Administrative Determination" parentTab="" defaultOpen="false" >
	
		<div class="innerTab-container" align="left">
		   <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
	            <tbody>
		 			 <kra-iacuc-action:adminWithdrawAction />
				     <kra-iacuc-action:adminApproveAction />
		    		 <kra-iacuc-action:adminMarkIncompleteAction />
		    		 <kra-iacuc-action:adminReviewNotRequiredAction />
	            </tbody>
	        </table>
	    </div>
	    
	</kul:innerTab>

</kra:permission>
