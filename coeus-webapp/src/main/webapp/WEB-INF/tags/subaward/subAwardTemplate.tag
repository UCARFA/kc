<%--
   - Kuali Coeus, a comprehensive research administration system for higher education.
   - 
   - Copyright 2005-2016 Kuali, Inc.
   - 
   - This program is free software: you can redistribute it and/or modify
   - it under the terms of the GNU Affero General Public License as
   - published by the Free Software Foundation, either version 3 of the
   - License, or (at your option) any later version.
   - 
   - This program is distributed in the hope that it will be useful,
   - but WITHOUT ANY WARRANTY; without even the implied warranty of
   - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   - GNU Affero General Public License for more details.
   - 
   - You should have received a copy of the GNU Affero General Public License
   - along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
	

