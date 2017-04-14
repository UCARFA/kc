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
<kul:tab tabTitle="Compliance" defaultOpen="true" tabErrorKey="document.subAwardList[0].subAwardTemplateInfo[0].fcio*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].fcioSubrecPolicyCd*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].animalFlag*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].animalPteSendCd*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].animalPteNrCd*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].humanFlag*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].humanPteSendCd*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].humanPteNrCd*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].humanDataExchangeAgreeCd*,
                                                               document.subAwardList[0].subAwardTemplateInfo[0].humanDataExchangeTermsCd*">
	<div class="tab-container" align="center">
   		<h3>
   			<span class="subhead-left">Compliance</span>
   			<span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.subaward.bo.SubAwardTemplateInfo"  altText="help"/></span>
        </h3>
        <table id="compliance-table" class="tab" cellpadding="4" cellspacing="0" summary="">
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.fcio}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].fcio" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.fcio}" />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.fcioSubrecPolicyCd}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].fcioSubrecPolicyCd" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.fcioSubrecPolicyCd}" />
                </td>
            </tr>
        </table>
        <kul:subtab width="100%" subTabTitle="Animals" noShowHideButton="true">
            <table id="animal-compliance-table" class="tab" cellpadding="4" cellspacing="0" summary="">
                <tr>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.animalFlag}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].animalFlag" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.animalFlag}" />
                    </td>
                    <th><div align="right">&nbsp;</div></th>
                    <td>
                        <div>&nbsp;</div>
                    </td>
                </tr>
                <tr>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.animalPteSendCd}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].animalPteSendCd" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.animalPteSendCd}" />
                    </td>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.animalPteNrCd}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].animalPteNrCd" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.animalPteNrCd}" />
                    </td>
                </tr>
            </table>
        </kul:subtab>
        <kul:subtab width="100%" subTabTitle="Humans" noShowHideButton="true">
            <table id="human-compliance-table" class="tab" cellpadding="4" cellspacing="0" summary="">
                <tr>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.humanFlag}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].humanFlag" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.humanFlag}" />
                    </td>
                    <th><div align="right">&nbsp;</div></th>
                    <td>
                        <div>&nbsp;</div>
                    </td>
                </tr>
                <tr>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.humanPteSendCd}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].humanPteSendCd" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.humanPteSendCd}" />
                    </td>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.humanPteNrCd}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].humanPteNrCd" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.humanPteNrCd}" />
                    </td>
                </tr>
                <tr>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.humanDataExchangeAgreeCd}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].humanDataExchangeAgreeCd" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.humanDataExchangeAgreeCd}" />
                    </td>
                    <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.humanDataExchangeTermsCd}" /></div></th>
                    <td>
                        <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].humanDataExchangeTermsCd" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.humanDataExchangeTermsCd}" />
                    </td>
                </tr>
            </table>
        </kul:subtab>
    </div>
</kul:tab>
	

