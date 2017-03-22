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
<kul:tabTop tabTitle="Contacts" defaultOpen="true" tabErrorKey="document.subAwardList[0].subAwardTemplateInfo[0].invoiceOrPaymentContact*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].finalStmtOfCostscontact*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].changeRequestsContact*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].terminationContact*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].noCostExtensionContact*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].carryForwardRequestsSentTo*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].invoicesEmailed*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].invoiceEmailDifferent*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].invoiceAddressDifferent*">
    <div class="tab-container" align="center">
        <h3>
            <span class="subhead-left">Contacts</span>
            <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.subaward.bo.SubAwardTemplateInfo"  altText="help"/></span>
        </h3>
        <table id="template-table" class="tab" cellpadding="4" cellspacing="0" summary="">

            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.invoiceOrPaymentContact}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].invoiceOrPaymentContact" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.invoiceOrPaymentContact}" />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.finalStmtOfCostscontact}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].finalStmtOfCostscontact" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.finalStmtOfCostscontact}"  />
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.changeRequestsContact}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].changeRequestsContact" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.changeRequestsContact}" />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.terminationContact}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].terminationContact" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.terminationContact}"  />
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.noCostExtensionContact}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].noCostExtensionContact" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.noCostExtensionContact}" />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.carryForwardRequestsSentTo}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].carryForwardRequestsSentTo" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.carryForwardRequestsSentTo}" />
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.invoicesEmailed}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].invoicesEmailed" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.invoicesEmailed}"  />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.invoiceEmailDifferent}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].invoiceEmailDifferent" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.invoiceEmailDifferent}" />
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.invoiceAddressDifferent}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].invoiceAddressDifferent" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.invoiceAddressDifferent}"  />
                </td>
            </tr>
        </table>
    </div>
</kul:tabTop>


