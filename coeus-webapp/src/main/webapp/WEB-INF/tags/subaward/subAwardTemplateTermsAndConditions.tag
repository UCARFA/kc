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
<kul:tabTop tabTitle="Terms and Conditions" defaultOpen="true" tabErrorKey="
                                                                document.subAwardList[0].subAwardTemplateInfo[0].copyRightType*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].automaticCarryForward*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].applicableProgramRegulations*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].treatmentPrgmIncomeAdditive*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].applicableProgramRegsDate*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].mpiLeadershipPlan*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].additionalTerms*,
                                                                document.subAwardList[0].subAwardTemplateInfo[0].treatmentOfIncome*">
    <div class="tab-container" align="center">
        <h3>
            <span class="subhead-left">Terms and Conditions</span>
            <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.subaward.bo.SubAwardTemplateInfo"  altText="help"/></span>
        </h3>
        <table id="template-table" class="tab" cellpadding="4" cellspacing="0" summary="">
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.applicableProgramRegulations}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].applicableProgramRegulations" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.applicableProgramRegulations}" />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.applicableProgramRegsDate}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].applicableProgramRegsDate" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.applicableProgramRegsDate}"  datePicker="true"  />
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.copyRightType}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].copyRightType" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.copyRightType}" />
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.automaticCarryForward}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].automaticCarryForward" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.automaticCarryForward}"  />
                </td>
                <th>
                    <div align="right">&nbsp;</div>
                </th>
                <td>
                    &nbsp;
                </td>
            </tr>
            <tr>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.mpiAward}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].mpiAward" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.mpiAward}"  />
                </td>
                <th><div align="right"><kul:htmlAttributeLabel attributeEntry="${subAwardTemplateInfoAttributes.mpiLeadershipPlan}" /></div></th>
                <td>
                    <kul:htmlControlAttribute property="document.subAwardList[0].subAwardTemplateInfo[0].mpiLeadershipPlan" readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.mpiLeadershipPlan}"  />
                </td>
            </tr>
            <tr>
                <th>
                    <div align="right"><kul:htmlAttributeLabel
                            attributeEntry="${subAwardTemplateInfoAttributes.treatmentPrgmIncomeAdditive}"/></div>
                </th>
                <td>
                    <kul:htmlControlAttribute
                            property="document.subAwardList[0].subAwardTemplateInfo[0].treatmentPrgmIncomeAdditive"
                            readOnly="${readOnly}"
                            attributeEntry="${subAwardTemplateInfoAttributes.treatmentPrgmIncomeAdditive}"/>
                </td>
                <th>
                    <div align="right"><kul:htmlAttributeLabel
                            attributeEntry="${subAwardTemplateInfoAttributes.treatmentOfIncome}"/></div>
                </th>
                <td>
                    <kul:htmlControlAttribute
                            property="document.subAwardList[0].subAwardTemplateInfo[0].treatmentOfIncome"
                            readOnly="${readOnly}"
                            attributeEntry="${subAwardTemplateInfoAttributes.treatmentOfIncome}"/>
                </td>
            </tr>
            <tr>
                <th>
                    <div align="right"><kul:htmlAttributeLabel
                            attributeEntry="${subAwardTemplateInfoAttributes.additionalTerms}"/></div>
                </th>
                <td>
                    <kul:htmlControlAttribute
                            property="document.subAwardList[0].subAwardTemplateInfo[0].additionalTerms"
                            readOnly="${readOnly}" attributeEntry="${subAwardTemplateInfoAttributes.additionalTerms}"/>
                </td>
                <th>
                    <div align="right">&nbsp;</div>
                </th>
                <td>
                    &nbsp;
                </td>
            </tr>
        </table>
    </div>
</kul:tabTop>


