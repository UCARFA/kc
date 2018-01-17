<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<kul:page lookup="true" docTitle="Rates" transactionalDocument="true" htmlFormAction="${KualiForm.actionPrefix}Personnel">
<script language="javascript" src="scripts/kuali_application.js"></script>
<kra-b:budgetPersonnelRates />  
<kul:panelFooter />

<kra:section permission="modifyBudgets">
<table id="buttons-table" width="100%" cellpadding=0 cellspacing=0 summary="" style="border:none">
<tr>
	<td>
	<div id="globalbuttons" class="globalbuttons" align="center">
	<input type="image" styleId="closeRates" name="close"
		src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_close.gif"
		class="globalbuttons" title="close" alt="close" onclick="javascript: window.close();return false;"></div>
	</td>
</tr>
</table>
</kra:section>

</kul:page>
