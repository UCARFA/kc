<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="protocolAttributes" required="true" type="java.util.Map" %>
<%@ attribute name="protocolPersonAttributes" required="true" type="java.util.Map" %>
<%@ attribute name="personAttributes" required="true" type="java.util.Map" %>
<%@ attribute name="protocolUnitsAttributes" required="true" type="java.util.Map" %>
<%@ attribute name="unitAttributes" required="true" type="java.util.Map" %>
<%@ attribute name="protocolAttachmentPersonnelAttributes" required="true" type="java.util.Map" %>
<%@ attribute name="attachmentFileAttributes" required="true" type="java.util.Map" %>
<%@ attribute name="optionListClass" required="true" %>
<%@ attribute name="protocolAttachmentTypeByGroupValuesFinder" required="true" %>

<c:set var="displayCoiDisclosureStatus" value="${KualiForm.displayCoiDisclosureStatus}" />
<c:set var="coiDisclosureStatuses" value="${KualiForm.disclosureProjectStatuses}" />
<c:set var="coiDispositionViewEnabled" value="${KualiForm.coiDispositionViewEnabled}" />
<c:set var="projectStatusEnabled" value="${KualiForm.displayCoiProjectStatus}" />

<div id="workarea">
<c:forEach items="${KualiForm.document.protocolList[0].protocolPersons}" var="person" varStatus="status">
    <c:set var="protocolPersonProperty" value="document.protocolList[0].protocolPersons[${status.index}]" />
    <c:if test="${not KualiForm.personnelHelper.protocolFinal || KualiForm.document.protocolList[0].correctionMode}">
        <c:set var="leftSideHtmlProperty" value="${protocolPersonProperty}.delete" />
    </c:if>
    <c:set var="personUnitRequired" value="${person.protocolPersonRole.unitDetailsRequired}" />
    <c:set var="transparent" value="false" />

    <c:if test="${status.first}">
      <c:set var="transparent" value="true" />
    </c:if> 
    	<c:set var="descri" value="${person.protocolPersonRole.description}" />
	<c:set var="personIndex" value="${status.index}" />

    <c:choose>
        <c:when test="${displayCoiDisclosureStatus}">
            <c:forEach items="${coiDisclosureStatuses}" var="projectStatus">
                <c:choose>
                    <c:when test="${KualiForm.document.protocolList[0].protocolPersons[personIndex].genericId eq projectStatus.userId}">
                        <c:set var="descri" value="${descri}<br><b><font color=\"#999999\">COI Annual Disclosure Status: </font></b>${projectStatus.annualDisclosureStatus}" />
                    <c:choose>
                        <c:when test="${projectStatusEnabled}">
                            <c:set var="descri" value="${descri}<br><b><font color=\"#999999\">COI Project Status: </font></b>${projectStatus.status}" />
                        </c:when>
                    </c:choose>
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${coiDispositionViewEnabled && KualiForm.document.protocolList[0].protocolPersons[personIndex].canViewDisclosureDisposition}">
            <c:forEach items="${coiDisclosureStatuses}" var="projectStatus">
                <c:choose>
                    <c:when test="${KualiForm.document.protocolList[0].protocolPersons[personIndex].genericId eq projectStatus.userId}">
                        <c:set var="descri" value="${descri}<br><b><font color=\"#999999\">COI Disposition Status:</font></b>${projectStatus.disposition}" />
                    </c:when>
                </c:choose>
            </c:forEach>
        </c:when>
    </c:choose>


    <kul:tab tabTitle="${fn:substring(person.personName, 0, 22)}"
			 tabErrorKey="document.protocolList[0].protocolPersons[${personIndex}]*"
			 auditCluster="personnelAuditErrors" 
			 tabAuditKey="document.protocolList[0].protocolPersons[${personIndex}].*" 
			 useRiceAuditMode="true"
	         tabDescription="${descri}"
	         leftSideHtmlProperty="${leftSideHtmlProperty}" 
	         leftSideHtmlAttribute="${protocolPersonAttributes.delete}" 
	     	 leftSideHtmlDisabled="false" 
	         defaultOpen="${hasErrors}" 
			 useCurrentTabIndexAsKey="true"
	         transparentBackground="${transparent}">
        <div class="tab-container" align="center">
		    <div id="workarea">
				<h3>
					<span class="subhead-left"><bean:write name="KualiForm" property="${protocolPersonProperty}.personName"/></span>
				    <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.protocol.personnel.ProtocolPerson" altText="help"/></span>
				</h3>
				<kra-protocol:personDetailsSection personIndex="${status.index}" protocolPerson="${protocolPersonProperty}" protocolPersonAttributes="${protocolPersonAttributes}" optionListClass="${optionListClass}"/>
				<kra-protocol:personContactInformationSection personIndex="${status.index}" protocolPerson="${protocolPersonProperty}" personAttributes="${personAttributes}"/>
  				<kra-protocol:personAttachmentSection personIndex="${status.index}" protocolPerson="${protocolPersonProperty}" protocolAttachmentTypeByGroupValuesFinder="${protocolAttachmentTypeByGroupValuesFinder}" protocolAttachmentPersonnelAttributes="${protocolAttachmentPersonnelAttributes}"/>
  				<c:if test="${personUnitRequired}">
					<kra-protocol:personUnitsSection personIndex="${status.index}" protocolPerson="${protocolPersonProperty}" protocolUnitsAttributes="${protocolUnitsAttributes}" unitAttributes="${unitAttributes}"/>
  				</c:if>
			</div>
		 </div>
	</kul:tab>
 </c:forEach>

<c:if test="${fn:length(KualiForm.document.protocolList[0].protocolPersons) > 0}">
    <kul:panelFooter />
</c:if>

</div>
