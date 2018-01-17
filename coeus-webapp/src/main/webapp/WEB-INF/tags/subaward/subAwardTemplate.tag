<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="subAwardTemplateInfoAttributes" value="${DataDictionary.SubAwardTemplateInfo.attributes}" />
<c:set var="attachments" value="${KualiForm.document.subAwardList[0].subAwardTemplateInfo}"/>
<kul:tabTop tabTitle="Template" defaultOpen="true" tabErrorKey="document.subAwardList[0].subAwardTemplateInfo[0].perfSiteDiffFromOrgAddr*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].subRegisteredInCcr*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].parentCongressionalDistrict*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].parentDunsNumber*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].exemptFromRprtgExecComp*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].rAndD*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].includesCostSharing*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].finalStatementDueCd*">
    <div class="tab-container" align="center">
        <h3>
            <span class="subhead-left">Template</span>
            <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.subaward.bo.SubAwardTemplateInfo"  altText="help"/></span>
        </h3>
        <table id="template-table" class="tab" cellpadding="4" cellspacing="0" summary="">
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.parentDunsNumber}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].parentDunsNumber" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.parentDunsNumber}"  />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.parentCongressionalDistrict}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].parentCongressionalDistrict" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.parentCongressionalDistrict}" />
                </td>
            </tr>

            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.rAndD}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].rAndD" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.rAndD}"   />
                </td>
                <th>
                    <div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.finalStatementDueCd}"/></div>
                </th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].finalStatementDueCd" readOnly="${readOnly}"
                                              attributeEntry="${subAwardTemplateInfoAttributes.finalStatementDueCd}"/>
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.includesCostSharing}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].includesCostSharing" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.includesCostSharing}"  />
                </td>

                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.subRegisteredInCcr}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].subRegisteredInCcr" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.subRegisteredInCcr}"  />
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.exemptFromRprtgExecComp}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].exemptFromRprtgExecComp" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.exemptFromRprtgExecComp}"  />
                </td>
            </tr>

        </table>
    </div>
</kul:tabTop>
	

