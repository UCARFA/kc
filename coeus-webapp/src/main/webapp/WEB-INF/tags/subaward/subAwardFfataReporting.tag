<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<%@ attribute name="renderMultipart" required="false" %>

<c:set var="subAwardFfataReportingAttributes" value="${DataDictionary.SubAwardFfataReporting.attributes}" />
<c:set var="action" value="subAward" />

<c:set var="newSubAwardFfataReporting" value="${KualiForm.newSubAwardFfataReporting}" />

<kul:tab tabTitle="FFATA Reporting" defaultOpen="${KualiForm.document.subAwardList[0].defaultOpen}" tabErrorKey="newSubAwardFfataReporting*" auditCluster="" tabAuditKey="" useRiceAuditMode="true">
    <script>
        $j(document).ready(function() {
            $j('input[name*="downloadFfataReportAttachment"]').hide();
            $j('input[name*="downloadFfataReportAttachment"]').click(function() {excludeSubmitRestriction = true;});
            $j('a.attachmentLink').click(function() { $j(this).siblings('input[name*="downloadFfataReportAttachment"]').click(); });
        });
    </script>
	<div class="tab-container" align="center">
    	<h3>
    		<span class="subhead-left"> FFATA Reporting</span>
    			<div align="right"><kul:help parameterNamespace="KC-SUBAWARD" parameterDetailType="Document" parameterName="subAwardHomeHelpUrl" altText="help"/></div>
        </h3>

        <table cellpadding=0 cellspacing=0 summary="">
            <tbody class="addline">
            <tr>
                <th><div align="left">&nbsp;</div></th>
                <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFfataReportingAttributes.subAwardAmountInfoId}" /></div></th>
                <th><div align="center">&nbsp;</div></th>
                <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFfataReportingAttributes.otherTransactionDescription}" /></div></th>
                <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFfataReportingAttributes.dateSubmitted}" /></div></th>
                <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFfataReportingAttributes['submitter.fullName']}" forceRequired="true" /></div></th>
                <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFfataReportingAttributes.comments}" /></div></th>
                <th><div align="center"><kul:htmlAttributeLabel attributeEntry="${subAwardFfataReportingAttributes.fileName}" /></div></th>
                <kul:htmlAttributeHeaderCell literalLabel="Actions" scope="col"/>
            </tr>
                <tr>
                    <th class="infoline" >
                        Add:
                    </th>
                    <td align="center">
                        <div align="center">
                            <kul:htmlControlAttribute property="newSubAwardFfataReporting.subAwardAmountInfoId" attributeEntry="${subAwardFfataReportingAttributes.subAwardAmountInfoId}" readOnly="${readOnly}"/>
                        </div>
                    </td>
                    <td align="center" style="font-weight: bold;">
                        <div align="center">
                            OR
                        </div>
                    </td>
                    <td>
                        <div align="center">
                            <kul:htmlControlAttribute property="newSubAwardFfataReporting.otherTransactionDescription" attributeEntry="${subAwardFfataReportingAttributes.otherTransactionDescription}" readOnly="${readOnly}"/>
                        </div>
                    </td>
                    <td>
                        <div align="center">
                            <kul:htmlControlAttribute property="newSubAwardFfataReporting.dateSubmitted" attributeEntry="${subAwardFfataReportingAttributes.dateSubmitted}" readOnly="${readOnly}"/>
                        </div>
                    </td>
                    <td>
                        <div align="center">
                            <c:if test="${!readOnly}">
                                <kul:htmlControlAttribute property="newSubAwardFfataReporting.submitter.userName" readOnly="${readOnly}"
                                                      onblur="loadContactPersonName('newSubAwardFfataReporting.submitter.userName',
                                                                'submitter.fullName',
                                                                'na',
                                                                'na',
                                                                'na',
                                                                'sub.submitterId.div');"
                                                      attributeEntry="${subAwardFfataReportingAttributes.submitterId}"/>
                            </c:if>
                            <c:if test="${readOnly}">
                                ${KualiForm.newSubAwardFfataReporting.submitter.userName}
                            </c:if>

                        <c:if test="${!readOnly}">
                            <kul:lookup boClassName="org.kuali.coeus.common.framework.person.KcPerson" fieldConversions="personId:newSubAwardFfataReporting.submitterId,fullName:newSubAwardFfataReporting.submitter.fullName" anchor="${tabKey}" />
                        </c:if>
                        <kul:directInquiry boClassName="org.kuali.coeus.common.framework.person.KcPerson" inquiryParameters="newSubAwardFfataReporting.submitterId:personId" anchor="${tabKey}" />

                        <br/><span id="submitter.fullName"><c:out value="${KualiForm.newSubAwardFfataReporting.submitter.fullName}"/>&nbsp;</span>
                        <html:hidden styleId ="sub.submitterId.div" property="newSubAwardFfataReporting.submitterId" />
                        ${kfunc:registerEditableProperty(KualiForm, "newSubAwardFfataReporting.submitterId")}
                    </div>
                    </td>

                    <td align="center">
                        <div align="center">
                            <kul:htmlControlAttribute property="newSubAwardFfataReporting.comments" attributeEntry="${subAwardFfataReportingAttributes.comments}" readOnly="${readOnly}"/>
                        </div>
                    </td>
                    <td align="center">
                        <div align="center">
                            <c:if test="${!readOnly}">
                                <html:file property="newSubAwardFfataReporting.newFile"  />
                            </c:if>
                            <c:if test="${readOnly}">
                                <kul:htmlControlAttribute property="newSubAwardFfataReporting.fileName" attributeEntry="${subAwardFfataReportingAttributes.fileName}" readOnly="true"/>
                            </c:if>
                        </div>
                    </td>
                    <td class="infoline" rowspan="1">
                        <div align="center">
                            <c:if test="${!readOnly}">
                                <html:image property="methodToCall.addFfataReport.anchor${tabKey}"
                                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-add1.gif'
                                        styleClass="tinybutton addButton"/>
                            </c:if>
                        </div>
                    </td>
                </tr>


                <c:forEach var="reporting" items="${KualiForm.document.subAwardList[0].subAwardFfataReporting}" varStatus="status">

                    <tr>
                        <td align="right" class="tab-subhead" scope="row">
                            <div align="center">
                                ${status.index + 1}
                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                <kul:htmlControlAttribute property="document.subAwardList[0].subAwardFfataReporting[${status.index}].subAwardAmountInfoId" readOnly="true" attributeEntry="${subAwardFfataReportingAttributes.subAwardAmountInfoId}" />
                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                &nbsp;
                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                <kul:htmlControlAttribute property="document.subAwardList[0].subAwardFfataReporting[${status.index}].otherTransactionDescription" readOnly="true" attributeEntry="${subAwardFfataReportingAttributes.otherTransactionDescription}"/>
                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                <kul:htmlControlAttribute property="document.subAwardList[0].subAwardFfataReporting[${status.index}].dateSubmitted" readOnly="true" attributeEntry="${subAwardFfataReportingAttributes.dateSubmitted}" datePicker="false"/>
                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                <kul:htmlControlAttribute property="document.subAwardList[0].subAwardFfataReporting[${status.index}].submitter.fullName" readOnly="true" attributeEntry="${subAwardFfataReportingAttributes['submitter.fullName']}"/>
                                <kul:directInquiry boClassName="org.kuali.coeus.common.framework.person.KcPerson" inquiryParameters="document.subAwardList[0].subAwardFfataReporting[${status.index}].submitterId:personId" anchor="${tabKey}" />
                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                <kul:htmlControlAttribute property="document.subAwardList[0].subAwardFfataReporting[${status.index}].comments" readOnly="true" attributeEntry="${subAwardFfataReportingAttributes.comments}"/>
                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                <c:if test="${reporting.fileName!=null}">
                                    <a href="#" class="attachmentLink">
                                        <kra:fileicon attachment="${reporting}" />
                                        <kul:htmlControlAttribute
                                                property="document.subAwardList[0].subAwardFfataReporting[${status.index}].fileName"
                                                readOnly="true"
                                                attributeEntry="${subAwardFfataReportingAttributes.fileName}" />
                                    </a>
                                    <html:image property="methodToCall.downloadFfataReportAttachment.line${status.index}.anchor${currentTabIndex}"
                                                src='${ConfigProperties.kra.externalizable.images.url}tinybutton-view.gif' styleClass="tinybutton" />
                                </c:if>	                            </div>
                        </td>
                        <td class="tab-subhead">
                            <div align="center">
                                <c:if test="${!readOnly}">
                                    <html:image property="methodToCall.deleteFfataReport.line${status.index}.anchor${currentTabIndex}"
                                                src='${ConfigProperties.kra.externalizable.images.url}tinybutton-delete1.gif' styleClass="tinybutton"/>
                                </c:if>
                                <c:if test="${readOnly}">&nbsp;</c:if>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</kul:tab>
