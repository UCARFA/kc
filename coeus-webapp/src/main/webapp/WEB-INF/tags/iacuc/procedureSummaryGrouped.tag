<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="groupIndex" required="true" 
              description="Summary group index" %>
<%@ attribute name="tabTitle" required="true" 
              description="Title for this group" %>
<%@ attribute name="totalSpeciesCount" required="true" 
              description="Total species count for this group" %>
<%@ attribute name="studyProcedureCollectionReference" required="true" type="java.util.List" 
              description="The object reference to the collection that holds all procedure details" %>


<kul:innerTab tabTitle="${tabTitle}" tabItemCount="${totalSpeciesCount}" parentTab="${parentTabName}" defaultOpen="false" tabErrorKey="" useCurrentTabIndexAsKey="true">
	<c:forEach items="${studyProcedureCollectionReference}" var="studyProcedure" varStatus="procedureIndex">
	<div style="border:1px solid #999; padding:0px; margin:15px; margin-left:30px;">
    	<div align="left"  style="width:100%; background-color:#CCC; padding:0px; margin:0px; border-bottom:1px solid #999; height:21px; min-width:750px;">
        	<div style="float:left; width:600px; padding:3px; height:15px;">
            	<strong>
                	<c:out value="${studyProcedure.iacucProcedureCategory.procedureCategory}"/> : 
                  	<c:out value="${studyProcedure.iacucProcedure.procedureDescription}"/> 
                 </strong>
                 </div>
                 <div style="float:right; width:125px; border-left:1px solid #999; padding:3px; height:15px;">
                 	Count: <c:out value="${studyProcedure.speciesCount}"/>
                 </div>
				</div>
                <div align="left" style="border:1px solid #999; padding:10px; margin-top:10px; margin-bottom:10px; margin-right:10px; margin-left:20px; background-image:url('../BFN/images/black05.png');">
                    <strong>Custom Data</strong><br />
					<c:set var="customStudyGroupId" value="0" />
					<c:forEach items="${studyProcedure.iacucProtocolStudyCustomDataList}" var="procedureCustomData" varStatus="customDataIndex">
                 		<c:if test="${customStudyGroupId ne procedureCustomData.iacucProtocolStudyGroupId}">
							<c:set var="customStudyGroupId" value="${procedureCustomData.iacucProtocolStudyGroupId}" />
	                 		<c:if test="${!customDataIndex.first}">
								</br>
	                 		</c:if>
						</c:if>
                 		<c:out value="${procedureCustomData.iacucProcedureCategoryCustomData.label}"/> :  
                 		<c:out value="${procedureCustomData.value}"/> <br/> 
                    </c:forEach>
                </div>
                <div align="left" style="border:1px solid #999; padding:10px; margin-top:10px; margin-bottom:10px; margin-right:10px; margin-left:20px;">
                    <strong>Procedure Personnel</strong><br />
					<c:forEach items="${studyProcedure.iacucProtocolStudyGroupPersons}" var="procedurePerson" varStatus="personIndex">
                 		<c:out value="${procedurePerson.protocolPerson.personName}"/> <br /> 
                     	Trained : <c:out value="${procedurePerson.protocolPerson.personTrainedStatus}"/> <br/>
						<a href="#qualification-div${groupIndex}${procedureIndex.index}${personIndex.index}" class="viewQualificationsLink" >
				    		<img src="${ConfigProperties.kra.externalizable.images.url}tinybutton-viewqualifications.gif" alt="View Qualifications" class="tinybutton addButton" />
						</a>		               	
						<br/><br/>
                        <div style="display: none;">
                            <div id="qualification-div${groupIndex}${procedureIndex.index}${personIndex.index}" >
                                <div style="text-align:center; background-color:#666; color:#FFF;" align="center"><strong>Qualification</strong></div></br>
                                <c:out value="${procedurePerson.protocolPerson.procedureQualificationDescription}"/> <br />
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div align="left" style="border:1px solid #999; padding:10px; margin-top:10px; margin-bottom:10px; margin-right:10px; margin-left:20px;">
                    <strong>Locations</strong><br />
					<c:forEach items="${studyProcedure.iacucProtocolStudyGroupLocations}" var="procedureLocationDetail" varStatus="locationIndex">
                 		Location Type: <c:out value="${procedureLocationDetail.iacucLocationType.location}"/> <br /> 
                 		Location Name: <c:out value="${procedureLocationDetail.iacucLocationName.locationName}"/> <br /> 
                 		Room: <c:out value="${procedureLocationDetail.locationRoom}"/> <br /> 
                 		Description: <c:out value="${procedureLocationDetail.studyGroupLocationDescription}"/> <br />
                 		<br/><br/> 
                    </c:forEach>
                </div>
		</div>
	</c:forEach>
</kul:innerTab>
