<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<script type="text/javascript">
	var saveButtonClicked = false;
	jq(document).ready(function() {
		jq(".viewQualificationsLink").fancybox();
    });
</script>

<c:set var="parentTabName" value="" />

<c:set var="summaryBySpecies" value="${KualiForm.iacucProtocolProceduresHelper.summaryGroupedBySpecies}"/>
<c:set var="currentSummaryDisplay" value="(Summary Displayed by Group)" />
<c:if test="${summaryBySpecies}">
	<c:set var="currentSummaryDisplay" value="(Summary Displayed by Species)" />
</c:if>

	<kul:innerTab tabTitle="Summary" parentTab="${parentTabName}" defaultOpen="true" tabErrorKey="" useCurrentTabIndexAsKey="true">
  			<b>View Summary by : </b>
			    <html:image property="methodToCall.summaryByGroup" title="Summary by group"
					src='${ConfigProperties.kra.externalizable.images.url}tinybutton-group.gif' styleClass="tinybutton"/>
			    <html:image property="methodToCall.summaryBySpecies" title="Summary by species"
					src='${ConfigProperties.kra.externalizable.images.url}tinybutton-species.gif' styleClass="tinybutton"/>
            <br>
	        	<c:out value="${currentSummaryDisplay}"/>
  			<span class="subhead-right"><kul:help parameterNamespace="KC-IACUC" parameterDetailType="Document"
                                                  parameterName="iacucProtocolProcedureSummaryHelp" altText="Help"/>
            </span>
		    <c:forEach items="${KualiForm.document.protocolList[0].iacucProtocolStudyGroupSpeciesList}" var="procedureSpecies" varStatus="status">
			    <c:set var="tabTitle" value="${procedureSpecies.iacucSpecies.speciesName}" />
			    <c:set var="studyProcedureCollectionReference" value="${procedureSpecies.responsibleProcedures}" />
			    <c:set var="totalSpeciesCount" value="${procedureSpecies.totalSpeciesCount}" />
  			    <c:choose>
  				    <c:when test="${summaryBySpecies}">
					    <c:set var="tabTitle" value="${procedureSpecies.iacucSpecies.speciesName}" />
  				    </c:when>
  				    <c:otherwise>
						<c:set var="tabTitle" value="${procedureSpecies.groupAndSpecies}" />
  				    </c:otherwise>
  			    </c:choose>
 			    <kra-iacuc:procedureSummaryGrouped
 				    groupIndex="${status.index}"
            	    tabTitle="${tabTitle}"
            	    totalSpeciesCount="${totalSpeciesCount}"
                    studyProcedureCollectionReference="${studyProcedureCollectionReference}"/>
		    </c:forEach>
	</kul:innerTab>

