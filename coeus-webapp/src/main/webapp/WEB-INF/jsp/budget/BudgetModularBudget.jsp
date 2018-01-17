<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="readOnly" value="${not KualiForm.editingMode['modifyBudgets'] && ( not parentReadOnlyFlag )}" scope="request" />


<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="${KualiForm.actionPrefix}ModularBudget"
	documentTypeName="${KualiForm.docTypeName}"
  	headerDispatch="${KualiForm.headerDispatch}"
  	showTabButtons="true"
  	headerTabActive="modularBudget"
  	extraTopButtons="${KualiForm.extraTopButtons}">
  	
  	<div align="right"><kul:help documentTypeName="BudgetDocument" pageName="Modular Budget" /></div>
	
	<kra:uncollapsable tabTitle="Select Modular Budget Period">
  		<div align="center">
			<label for="modularSelectedPeriod">Budget Period:
	  			<html:select property="modularSelectedPeriod">
    				<html:option value="0">View All</html:option>
    				<c:forEach var="budgetPeriod" items="${KualiForm.document.budget.budgetPeriods}" varStatus="status">
	      				<html:option value="${budgetPeriod.budgetPeriod}">${budgetPeriod.budgetPeriod}: ${budgetPeriod.dateRange}</html:option>
    				</c:forEach>
  				</html:select>
			</label>
          	<br/><br/>
          	<span><html:image property="methodToCall.updateView" src='${ConfigProperties.kra.externalizable.images.url}tinybutton-updateview.gif' styleClass="tinybutton"/></span>
        </div>
	</kra:uncollapsable>
	<br/>
	
	<kra-b:budgetModular periodNum="${KualiForm.modularSelectedPeriod}"/>
	<c:set var="extraButtonSource" value="" scope="request" />
	<c:set var="extraButtonProperty" value="" scope="request" />
	<c:set var="extraButtonAlt" value="" scope="request" />
	<c:if test="${KualiForm.editingMode['modifyBudgets'] && KualiForm.document.budget.budgetStatus != '1'}">
		<c:set var="extraButtonSource" value="${ConfigProperties.kra.externalizable.images.url}buttonsmall_sync.gif" scope="request" />
	    <c:set var="extraButtonProperty" value="methodToCall.sync" scope="request" />
		<c:set var="extraButtonAlt" value="" scope="request" />
	</c:if>
	
	<kul:documentControls 
		transactionalDocument="false"
		suppressRoutingControls="true"
		viewOnly="${KualiForm.editingMode['viewOnly']}"
		extraButtonSource="${extraButtonSource}"
		extraButtonProperty="${extraButtonProperty}"
		extraButtonAlt="${extraButtonAlt}"
		suppressCancelButton="true"
		/>

</kul:documentPage>
